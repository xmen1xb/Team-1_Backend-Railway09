package com.vti.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Cart;
import com.vti.entity.CartDetail;
import com.vti.entity.Order;
import com.vti.entity.OrderDetail;
import com.vti.entity.Product;
import com.vti.enumerate.CartDetailStatus;
import com.vti.enumerate.OrderStatusEnum;
import com.vti.event.OnSendOrderConfirmEndViaEmailEvent;
import com.vti.event.OnSendOrderConfirmViaEmailEvent;
import com.vti.exception.CustomerException;
import com.vti.exception.NotFoundException;
import com.vti.repository.IAccountRepository;
import com.vti.repository.ICartDetailRepository;
import com.vti.repository.ICartRepository;
import com.vti.repository.IOrderDetailRepository;
import com.vti.repository.IOrderRepository;
import com.vti.repository.IProductRepository;
import com.vti.request.OrderRequest;

@Service
public class OrderService implements IOrderService{

	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private IAccountRepository accountRepo;
	
	@Autowired
	private ICartRepository cartRepo;
	
	@Autowired
	private IOrderDetailRepository orderDetailRepo;
	
	@Autowired
	private ICartDetailRepository cartDetailRepo;
	
	@Autowired
	private IProductRepository productRepo;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Override
	public Order getOrderByID(int orderID) {
		Order order = orderRepo.getById(orderID);
		return order;
	}
	
	@Override
	@Transactional
	public void createOrder(int accountID, OrderRequest request) {
		Cart cart = cartRepo.getById(accountID);
		List<CartDetail> listCartDetail = cart.getListCartDetail();
		
		List<CartDetail> listCartDetail2 = new ArrayList<>();
		String check = "Order";
		
		for (CartDetail cartDetail : listCartDetail) {
			if (cartDetail.getStatus().toString().equals(check)) {
				listCartDetail2.add(cartDetail);
			}
		}
		int quantity = 0;
		Double totalPrice = 0.0;
		for (CartDetail cartDetail : listCartDetail2) {
			 quantity = quantity + cartDetail.getQuantity();
			 totalPrice = totalPrice + (cartDetail.getPrice()*cartDetail.getQuantity());
		}
		Account account = accountRepo.getById(accountID);		
		Order order = new Order((short) quantity, totalPrice, request.getAddress(),request.getPhone() ,account);
		orderRepo.save(order);
		
		for (CartDetail cartDetail : listCartDetail2) {
			Product product = cartDetail.getProduct();
			OrderDetail orderDetail = new OrderDetail(cartDetail.getPrice(), (short) cartDetail.getQuantity(),
					order, product);
			orderDetailRepo.save(orderDetail);
			int cartID = cartDetail.getCart().getCart_id();
			
			updateCartDown(cartID, cartDetail);	
			product.setQuantity((short) (product.getQuantity() - cartDetail.getQuantity()));
			productRepo.save(product);
		}
		cartDetailRepo.deleteCartDetailbyCartAndStatus(CartDetailStatus.Order, cart.getCart_id());
	}

	public void updateCartDown(int cartID, CartDetail cartDetail) {
		Cart cart = cartRepo.getById(cartID);
		cart.setQuantity(cart.getQuantity() - cartDetail.getQuantity());
		cart.setTotal_price(cart.getTotal_price() - (cartDetail.getPrice()*cartDetail.getQuantity()));
		cartRepo.save(cart);
	}

	@Override
	public Page<Order> getAllOrder(Pageable pageable) {
		
		return orderRepo.findAll(pageable);
	}

	@Override
	public void updateOrder(int orderID) {
		Order order = orderRepo.getById(orderID);
		Account account = order.getAccount();
		if (order.getStatus().toString() == "Not_Active") {
			order.setStatus(OrderStatusEnum.Active);
			orderRepo.save(order);
			sendConfirmOrderViaEmail(account.getEmail());
		}else if (order.getStatus().toString() == "Active") {
			order.setStatus(OrderStatusEnum.End);
			orderRepo.save(order);
		}	
	}

	@Override
	public void endOrder(int orderID, OrderRequest request) throws CustomerException {
		Order order = orderRepo.getById(orderID);
		if (order == null) {
			throw new NotFoundException("Đơn hàng không tồn tại");		
		}
		Account account = order.getAccount();
		for (OrderDetail orderDetail : order.getListOrderDetail()) {
			Product product = orderDetail.getProduct();
			product.setQuantity((short) (product.getQuantity() + orderDetail.getQuantity()));
			productRepo.save(product);
		}
		order.setDescription(request.getDescription());
		order.setStatus(OrderStatusEnum.Delete);
		if (order.getDescription() == null) {
			throw new CustomerException("Lý do hủy đơn hàng không thể để trống");
		}
		orderRepo.save(order);
		
		sendConfirmEndOrderViaEmail(account.getEmail());
	}

	@Override
	public void deleteOrder(int orderID) {
		orderRepo.deleteById(orderID);
		
	}
	
	@Override
	public void sendConfirmOrderViaEmail(String email) {
		eventPublisher.publishEvent(new OnSendOrderConfirmViaEmailEvent(email));
		
	}
	
	@Override
	public void sendConfirmEndOrderViaEmail(String email) {
		eventPublisher.publishEvent(new OnSendOrderConfirmEndViaEmailEvent(email));
		
	}

	@Override
	public Page<Order> findByUserId(int accountID, Pageable pageable) {
		
		return orderRepo.findByUserId(accountID, pageable);
	}
}
