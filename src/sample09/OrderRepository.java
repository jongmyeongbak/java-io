package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

	private List<Order> orders = new ArrayList<>();

	public OrderRepository() {
		String path = "src/sample09/orders.txt";
		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			String text;
			while ((text = in.readLine()) != null) {
				if (text.isBlank()) {
					break;
				}
				Order order = Order.createOrder(text);
				orders.add(order);
			}
		} catch (IOException e) {
			throw new RuntimeException("orders.txt 파일 읽기 오류", e);
		}
	}
	
	public int getOrderNo() {
		// orders(List객체)의 마지막(orders.size() - 1) Order 객체의 주문번호보다 1 큰 값
		return orders.get(orders.size() - 1).getNo() + 1;
	}
	
	public void insertOrder(Order order) {
		orders.add(order);
	}
	
	public List<Order> getOrdersByUserId(String userId) {
		List<Order> result = new ArrayList<>();
		
		for (Order order : orders) {
			if (order.getUserId().equals(userId)) {
				result.add(order);
			}
		}
		return result;
	}
	
	public void save() {
		String path = "src/sample09/orders.txt";
		try (PrintWriter out = new PrintWriter(path)) {
			for (Order order : orders) {
				String text = order.generateText();
				out.println(text);
			}
		} catch (IOException e) {
			throw new RuntimeException("orders.txt 쓰기 오류", e);
		}
	}
}
