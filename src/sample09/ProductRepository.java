package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

	private List<Product> products = new ArrayList<>();

	public ProductRepository() {
		String path = "src/sample09/products.txt";
		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			String text;
			while ((text = in.readLine()) != null) {
				if (text.isBlank()) {
					break;
				}
				Product product = Product.createProduct(text);
				products.add(product);
			}
		} catch (IOException e) {
			throw new RuntimeException("products.txt 읽기 오류", e);
		}
	}
	
	/*
	 * 모든 상품정보를 반환한다.
	 * 	반환타입: List<Product>
	 * 	메서드명: getProducts
	 * 	매개변수: 없음
	 */
	public List<Product> getProducts() {
		return products;
	}
	
	/*
	 * 상품번호를 전달받아 상품번호와 일치하는 상품정보를 반홚한다.
	 * 	반환타입: Product
	 * 	메서드명: getProductByNo
	 * 	매개변수: int no
	 */
	public Product getProductByNo(int no) {
		for (Product product : products) {
			if (product.getNo() == no) {
				return product;
			}
		}
		return null;
	}
	
	public void save() {
		String path = "src/sample09/products.txt";
		try (PrintWriter out = new PrintWriter(path)) {
			for (Product product : products) {
				String text = product.generateText();
				out.println(text);
			}
		} catch (IOException e) {
			throw new RuntimeException("products.txt 파일 쓰기 오류", e);
		}
	}
}