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
	
	@Override
	public void createOrder(int accountID, OrderRequest request) {
		Cart cart = cartRepo.getById(accountID);
		List<CartDetail> listCartDetail = cart.getListCartDetail();
		
		List<CartDetail> listCartDetail2 = new ArrayList<>();
		String check = "Order";
		short quantity = 0;
		Double totalPrice = 0.0;
		for (CartDetail cartDetail : listCartDetail) {
			if (cartDetail.getStatus().equals(check)) {
				listCartDetail2.add(cartDetail);
			}
		}
		
		for (CartDetail cartDetail : listCartDetail2) {
			quantity += cartDetail.getQuantity();
			totalPrice += cartDetail.getPrice();
		}
		
		Account account = accountRepo.getById(accountID);		
		Order order = new Order(quantity, totalPrice, 
				request.getCity(), request.getDistrict(), request.getStreet(), request.getWard(), account);
		orderRepo.save(order);
		
		for (CartDetail cartDetail : listCartDetail2) {
			Product product = cartDetail.getProduct();
			OrderDetail orderDetail = new OrderDetail(cartDetail.getPrice(), (short) cartDetail.getQuantity(),
					order, product);
			orderDetailRepo.save(orderDetail);
		}
	}

}
