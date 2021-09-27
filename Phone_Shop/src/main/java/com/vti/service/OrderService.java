package com.vti.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Cart;
import com.vti.entity.CartDetail;
import com.vti.entity.Order;
import com.vti.entity.OrderDetail;
import com.vti.entity.Product;
import com.vti.repository.IAccountRepository;
import com.vti.repository.ICartDetailRepository;
import com.vti.repository.ICartRepository;
import com.vti.repository.IOrderDetailRepository;
import com.vti.repository.IOrderRepository;
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
		Order order = new Order((short) quantity, totalPrice, request.getAddress(), account);
		orderRepo.save(order);
		
		for (CartDetail cartDetail : listCartDetail2) {
			Product product = cartDetail.getProduct();
			OrderDetail orderDetail = new OrderDetail(cartDetail.getPrice(), (short) cartDetail.getQuantity(),
					order, product);
			orderDetailRepo.save(orderDetail);
			int cartID = cartDetail.getCart().getCart_id();
			
			updateCartDown(cartID, cartDetail);	
//			cartDetail.setStatus(CartDetailStatus.Not_Order);
			cartDetailRepo.delete(cartDetail);
//			cartDetailRepo.save(cartDetail);
			
		}
	}

	public void updateCartDown(int cartID, CartDetail cartDetail) {
		Cart cart = cartRepo.getById(cartID);
		cart.setQuantity(cart.getQuantity() - cartDetail.getQuantity());
		cart.setTotal_price(cart.getTotal_price() - cartDetail.getPrice());
		cartRepo.save(cart);
	}
}
