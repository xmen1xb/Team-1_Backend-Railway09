package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Cart;
import com.vti.entity.CartDetail;
import com.vti.entity.Product;
import com.vti.repository.IAccountRepository;
import com.vti.repository.ICartDetailRepository;
import com.vti.repository.ICartRepository;
import com.vti.repository.IProductRepository;

@Service
public class CartDetailService implements ICartDetailService {

	@Autowired
	private ICartDetailRepository cartdetailRepo;

	@Autowired
	private IProductRepository productRepo;

	@Autowired
	private ICartRepository cartRepo;

	@Autowired
	private IAccountRepository accountRepo;

	@Override
	public Page<CartDetail> getAllCartDetail(Pageable pageable) {

		return cartdetailRepo.findAll(pageable);
	}

	@Override
	public void createCartDetail(int producId, int accountId) {

		Product product = productRepo.getById(producId);
		List<CartDetail> listCartDetail = product.getListCartDetail();
		for (CartDetail cartDetail : listCartDetail) {
			if (cartDetail.getProduct().getProduct_id() == product.getProduct_id()) {
				updateCartDetailUp(cartDetail.getCartdetail_id());
				return;
			} 		
		}	
		CartDetail cartDetail2 = new CartDetail();
		Account account = accountRepo.getById(accountId);
		int cartID = account.getCart().getCart_id();

		cartDetail2.setPrice(product.getPrice());
		cartDetail2.setQuantity(1);
		cartDetail2.setCart(cartRepo.getById(cartID));
		cartDetail2.setProduct(product);

		cartdetailRepo.save(cartDetail2);

		updateCartUp(cartID, cartDetail2);
	}

	@Override
	public void deleteCartDetail(int id) {
		CartDetail cartDetail = cartdetailRepo.getById(id);
		int cartID = cartDetail.getCart().getCart_id();

		updateCartDown(cartID, cartDetail);

		cartdetailRepo.deleteById(id);

	}

	@Override
	public void updateCartDetailUp(int id) {
		CartDetail cartDetail = cartdetailRepo.getById(id);
		int cartID = cartDetail.getCart().getCart_id();
		cartDetail.setQuantity(cartDetail.getQuantity() + 1);
		cartdetailRepo.save(cartDetail);
		updateCartUp(cartID, cartDetail);
	}

	@Override
	public void updateCartDetailDown(int id) {
		CartDetail cartDetail = cartdetailRepo.getById(id);
		int cartID = cartDetail.getCart().getCart_id();
		int quantity = cartDetail.getQuantity() - 1;
		cartDetail.setQuantity(quantity);

		if (quantity == 0) {
			deleteCartDetail(id);

		} else {
			cartdetailRepo.save(cartDetail);
			updateCartDown(cartID, cartDetail);
		}

	}

	public void updateCartUp(int cartID, CartDetail cartDetail) {
		Cart cart = cartRepo.getById(cartID);
		cart.setQuantity(cart.getQuantity() + 1);
		cart.setTotal_price(cart.getTotal_price() + cartDetail.getPrice());
		cartRepo.save(cart);
	}

	public void updateCartDown(int cartID, CartDetail cartDetail) {
		Cart cart = cartRepo.getById(cartID);
		cart.setQuantity(cart.getQuantity() - 1);
		cart.setTotal_price(cart.getTotal_price() - cartDetail.getPrice());
		cartRepo.save(cart);
	}
}
