package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
}
