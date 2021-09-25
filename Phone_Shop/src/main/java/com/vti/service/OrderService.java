package com.vti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Cart;
import com.vti.entity.CartDetail;
import com.vti.entity.Order;
import com.vti.entity.OrderDetail;
import com.vti.entity.Product;
import com.vti.repository.IAccountRepository;
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
	private ICartDetailService cartDetailService;
	
	@Override
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
			 totalPrice = totalPrice + cartDetail.getPrice();
		}

		System.out.println(quantity);
		System.out.println(totalPrice);
		Account account = accountRepo.getById(accountID);		
		Order order = new Order((short) quantity, totalPrice, 
				request.getCity(), request.getDistrict(), request.getStreet(), request.getWard(), account);
		orderRepo.save(order);
		
		int cartDetailID = 0;
		for (CartDetail cartDetail : listCartDetail2) {
			Product product = cartDetail.getProduct();
			cartDetailID = cartDetail.getCartdetail_id();
			OrderDetail orderDetail = new OrderDetail(cartDetail.getPrice(), (short) cartDetail.getQuantity(),
					order, product);
			orderDetailRepo.save(orderDetail);
			cartDetailService.deleteCartDetail(cartDetailID);
			System.out.println(cartDetailID);
		}
	}

}
