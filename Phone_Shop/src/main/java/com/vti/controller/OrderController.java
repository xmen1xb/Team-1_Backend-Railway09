package com.vti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Order;
import com.vti.entity.OrderDetail;
import com.vti.entity.Product;
import com.vti.exception.CustomerException;
import com.vti.exception.NotFoundException;
import com.vti.request.OrderRequest;
import com.vti.response.OrderDetailResponse;
import com.vti.response.OrderResponse;
import com.vti.response.ProductResponse;
import com.vti.service.IOrderService;

@RestController
@RequestMapping(value = "api/v5/orders")
@CrossOrigin("*")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
		
	/**
	 * API getAll Order for Admin							
	 */
	
	@GetMapping
	public ResponseEntity<?> getAllOrder(Pageable pageable){
		Page<Order> pageOrder = orderService.getAllOrder(pageable);
		
		Page<OrderResponse> response = pageOrder.map(new Function<Order, OrderResponse>() {

			@Override
			public OrderResponse apply(Order order) {
				OrderResponse response = new OrderResponse(order.getDescription(), order.getTotal_price(), 
						order.getOrder_date(), order.getStatus());
				return response;
			}
		});
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * API getAll Order for Admin							
	 */
	
	@GetMapping(value = "/{accountId}")
	public ResponseEntity<?> findByUserId(@PathVariable(name = "accountId") int accountId, Pageable pageable){
		Page<Order> pageOrder = orderService.findByUserId(accountId, pageable);
		
		Page<OrderResponse> response = pageOrder.map(new Function<Order, OrderResponse>() {

			@Override
			public OrderResponse apply(Order order) {
				
				OrderResponse response = new OrderResponse(order.getDescription(), order.getTotal_price(), order.getOrder_date(),
						order.getStatus());
				return response;
			}
		});
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * API create Order Not_Active -> Active
	 * Sau khi tạo order sẽ đồng bộ : 	
	 * 		tạo các orderDetail tương ứng CartDetail đã đặt									
	 * 		xóa CartDetail đã order									
	 * 		fix lại giá trong Cart
	 */
	
	@PostMapping(value = "/{accountId}")
	public ResponseEntity<?> createOrder(@PathVariable(name = "accountId") int accountID, @RequestBody OrderRequest request){
		orderService.createOrder(accountID, request);
		return new ResponseEntity<String>("Đặt hàng thành công!!",  HttpStatus.CREATED);
	}
	
	/**
	 * API update Order Not_Active -> Active
	 * Sau khi update sẽ chuyển trạng thái của order sang Active 	
	 * 1 thư sẽ được gửi về email của khách đặt hàng
	 * gọi lần 2 sẽ chuyển từ Active -> End
	 * gọi lần 3 sẽ chuyển từ End -> Not_Active									
	 */
	
	@PutMapping(value = "/{orderID}")
	public ResponseEntity<?> updateOrder(@PathVariable (name = "orderID") int orderID){
		orderService.updateOrder(orderID);
		return new ResponseEntity<String>("Chúng tôi đã gửi 1 thư về hòm thư của bạn. Xin hãy kiểm tra hòm thư "
				+ "để xác nhận!", HttpStatus.OK );
		
	}
	
	/**
	 * API update Order -> Delete
	 * Sau khi update sẽ chuyển trạng thái của order sang Delete 	
	 * 1 thư sẽ được gửi về email của khách đặt hàng									
	 * @throws CustomerException 
	 */
	
	@PutMapping()
	public ResponseEntity<?> endOrder(@RequestParam (name = "orderID") int orderID,@RequestBody OrderRequest request) throws CustomerException{
		orderService.endOrder(orderID, request);
		return new ResponseEntity<String>("Chúng tôi đã gửi 1 thư về hòm thư của bạn. Xin hãy kiểm tra hòm thư "
				+ "để xác nhận!", HttpStatus.OK );
		
	}
	
	/**
	 * API lấy ListOrderDetail = OrderID
	 */
	
	@GetMapping(value = "/{id}/orderDetails")
	public ResponseEntity<?> getListOrderDetail(@PathVariable(name = "id") int id){
		Order order = orderService.getOrderByID(id);
		if (order == null) {
			throw new NotFoundException("Đơn hàng không tồn tại");	
		}
		List<OrderDetail> listOrderDetail = order.getListOrderDetail();
		List<OrderDetailResponse> showOrderDetail = new ArrayList<>();
		
		for (OrderDetail orderDetail : listOrderDetail) {
			OrderDetailResponse response = new OrderDetailResponse();
			response.setId(orderDetail.getorderdetail_id());
			response.setPrice(orderDetail.getPrice());
			response.setQuantity(orderDetail.getQuantity());
			
			Product product = orderDetail.getProduct();
			ProductResponse productResponse = new ProductResponse(product.getProductId(), product.getProductName(),
					product.getDescription(), product.getPrice(), product.getRam().getRamName(), product.getMemory().getMemoryName(),
					product.getBrand().getBrandName(), product.getCategory(), product.getQuantity(),product.getCamera(),product.getColor(),
					product.getScreenSize(),product.getOperatingSystem(), product.getChip(),product.getBattery(),
					product.getSim() ,product.getPathImage(),product.getDiscount() ,product.getEnterDate());
			
			response.setProduct(productResponse);
			showOrderDetail.add(response);
		}
		
		return new ResponseEntity<>(showOrderDetail, HttpStatus.OK);
		
	}
}
