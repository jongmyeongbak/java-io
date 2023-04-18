package sample09;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallService {

	// 사용자 정보를 제공하는 저장소 객체
	private UserRepository userRepo = new UserRepository();
	// 상품 정보를 제공하는 저장소 객체
	private ProductRepository productRepo = new ProductRepository();
	// 주문 정보를 제공하는 저장소 객체
	private OrderRepository orderRepo = new OrderRepository();
	
	/*
	 * 모든 상품정보 목록을 반환한다.
	 * 	반환타입: List<Product>
	 * 	메서드명: getAllProducts
	 * 	매개변수: 없음
	 */
	public List<Product> getAllProducts() {
		return productRepo.getProducts();
	}
	
	/*
	 * 아이디, 비밀번호를 전달받아 사용자를 인증하고, 인증된 사용자정보를 반환한다.
	 * 	반환타입: User
	 * 	메서드명: login
	 * 	매개변수: String id, String password
	 * 	예외: RuntimeException, 사용자정보가 없거나 비밀번호가 일치하지 않는 경우
	 */
	public User login(String id, String password) {
		User user = userRepo.getUserById(id);
		if (user == null) {
			throw new RuntimeException("[" + id + "] 사용자 정보가 존재하지 않습니다.");
		}
		if (!user.getPassword().equals(password)) {
			throw new RuntimeException("비밀번호가 일치하지 않습니다.");
		}
		
		return user;
	}
	
	/*
	 * 상품번호, 구매수량, 사용자아이디를 전달받아 주문정보를 저장하기
	 * 	반환타입: void
	 * 	메서드명: order
	 * 	매개변수: int productNo, int quantity, String id
	 * 	예외: RuntimeException, 상품정보가 없거나 재고수량이 부족한 경우
	 */
	public void order(int productNo, int quantity, String id) {
		Product product = productRepo.getProductByNo(productNo);
		if (product == null) {
			throw new RuntimeException("[" + productNo + "] 상품정보가 존재하지 않습니다.");
		}
		int stock = product.getStock();
		if (stock < quantity) {
			throw new RuntimeException("재고가 부족하여 주문할 수 없습니다. [잔여 수량: " + stock + "]");
		}

		int productPrice = product.getPrice();
		int orderPrice = productPrice * quantity;
		product.setStock(stock - quantity);
		int bonusPoint = (int) (orderPrice * .001);
		
		User user = userRepo.getUserById(id);
		user.setPoint(user.getPoint() + bonusPoint);
		
		int orderNo = orderRepo.getOrderNo();
		Date orderDate = new Date();
		Order order = new Order(orderNo, orderDate, id, productNo, quantity, orderPrice, bonusPoint);
		// 14. 주문정보를 저장한다.
		orderRepo.insertOrder(order);
	}
	
	public List<Map<String, Object>> getMyOrder(String userId) {
		List<Map<String, Object>> result = new ArrayList<>();
		
		// 지정된 사용자 아이디로 등록된 모든 주문정보를 조회한다.
		List<Order> orders = orderRepo.getOrdersByUserId(userId);
		for (Order order : orders) {
			// 주문정봅와 주문상품정보를 저장하는 Map객체를 생성한다.
			Map<String, Object> item = new HashMap<>();
			// Map객체에 주문정보(주문번호,주문날짜,주문수량,주문가격,적립포인트)를 저장한다.
			item.put("orderNo", order.getNo());
			item.put("orderDate", order.getDate());
			item.put("orderQuantity", order.getQuantity());
			item.put("orderPrice", order.getOrderPrice());
			item.put("depositPoint", order.getDepositPoint());
			// Map객체에 주문상품정보(상품이름,상품가격)를 저장한다.
			Product product = productRepo.getProductByNo(order.getProductNo());
			item.put("productName", product.getName());
			item.put("productPrice", product.getPrice());
			
			result.add(item);
		}
		return result;
	}
	
	public void save() {
		userRepo.save();
		productRepo.save();
		orderRepo.save();
	}
	
	/*
	 * 	반환타입: 
	 * 	메서드명: 
	 * 	매개변수: 
	 */
}
