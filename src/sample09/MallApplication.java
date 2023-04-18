package sample09;

import java.util.Date;
import java.util.List;
import java.util.Map;

import util.DateUtils;
import util.KeyboardReader;

public class MallApplication {

	// 키보드 입력을 읽어서 반환하는 객체
	private KeyboardReader reader = new KeyboardReader();
	// 쇼핑몰관련 서비스를 제공하는 서비스 객체
	// 로그인, 상품조회, 주문하기, 주문내역조회하기, 내정보 보기
	private MallService service = new MallService();
	
	// 인증된 사용자정보를 저장한다.(로그인된 사용자정보를 저장한다.)
	private User loginedUser;
	
	public void menu() {
		if (loginedUser == null) {
			System.out.println("------------------------------------------------------------------");
			System.out.println("1.상품조회  2.로그인  0.종료");
			System.out.println("------------------------------------------------------------------");
		} else {
			System.out.println("------------------------------------------------------------------");
			System.out.println("1.상품조회  2.주문하기  3.주문내역조회  4.내정보보기  5.로그아웃  0.종료");
			System.out.println("------------------------------------------------------------------");
			System.out.println("[" + loginedUser.getName() + "]님 환영합니다.");
		}
		System.out.println();
		
		System.out.print("### 메뉴선택: ");
		int menuNo = reader.readInt();
		System.out.println();
		
		try {
			if (menuNo == 1) {
				상품조회();
			} else if (menuNo == 0) {
				프로그램종료();
			}
			if (loginedUser == null) {
				// 비로그인 상태에서만 사용가능한 기능
				if (menuNo == 2) {
					로그인();
				}
			} else {
				// 로그인 상태에서만 사용가능한 기능
				if (menuNo == 2) {
					주문하기();
				} else if (menuNo == 3) {
					주문내역조회();
				} else if (menuNo == 4) {
					내정보보기();
				} else if (menuNo == 5) {
					로그아웃();
				}
			}
		} catch (RuntimeException e) {
			System.out.println("### 오류발생: " + e.getMessage());
		}
		
		System.out.println();
		System.out.println();
		menu();
	}

	private void 상품조회() {
		System.out.println("<< 모든 상품 조회 >>");
		System.out.println("### 모든 상품 목록을 확인하세요.");
		
		List<Product> products = service.getAllProducts();
		System.out.println("-------------------------------------------------------");
		System.out.println("번호\t상품이름\t제조사\t가격\t재고수량");
		System.out.println("-------------------------------------------------------");
		for (Product product : products) {
			System.out.println(product.getNo() + "\t"
					+ product.getName() + "\t"
					+ product.getMaker() + "\t"
					+ product.getPrice() + "\t"
					+ product.getStock());
		}
	}

	private void 로그인() {
		System.out.println("<< 로그인 >>");
		System.out.println("아이디와 비밀번호를 입력하세요.");
		
		System.out.print("### 아이디 입력:");
		String id = reader.readString();
		System.out.print("### 비밀번호 입력:");
		String password = reader.readString();
		
		User user = service.login(id, password);
		loginedUser = user;
		System.out.println("### 로그인이 완료되었습니다.");
	}

	private void 주문하기() {
		System.out.println("<< 주문하기 >>");
		System.out.println("상품번호, 구매수량을 입력하세요.");
		
		System.out.print("### 상품번호 입력: ");
		int no = reader.readInt();
		System.out.print("### 구매수량 입력: ");
		int quantity = reader.readInt();
		
		service.order(no, quantity, loginedUser.getId());
		
		System.out.println("### 주문이 완료되었습니다.");
	}

	private void 주문내역조회() {
		System.out.println("<< 주문내역 조회 >>");
		System.out.println("### 주문내역을 확인하세요.");
		
		List<Map<String, Object>> myOrders = service.getMyOrder(loginedUser.getId());
		if (myOrders.isEmpty()) {
			System.out.println("### 주문내역이 존재하지 않습니다.");
		} else {
			System.out.println("-----------------------------------------------------------");
			System.out.println("주문번호\t주문날짜\t\t상품이름\t구매수량\t구매금액\t적립포인트");
			System.out.println("-----------------------------------------------------------");
			for (Map<String, Object> item : myOrders) {
				int orderNo = (int) item.get("orderNo");
				Date orderDate = (Date) item.get("orderDate");
				String productName = (String) item.get("productName");
				int orderQuantity = (int) item.get("orderQuantity");
				int orderPrice = (int) item.get("orderPrice");
				int depositPoint = (int) item.get("depositPoint");
				
				System.out.println(orderNo
						+ "\t" + DateUtils.toText(orderDate)
						+ "\t" + productName
						+ "\t" + orderQuantity
						+ "\t" + orderPrice
						+ "\t" + depositPoint);
			}
			System.out.println("-----------------------------------------------------------");
		}
	}

	private void 내정보보기() {
		System.out.println("<< 내 정보 >>");
		System.out.println("### 내 정보를 확인하세요.");
		
		System.out.println("-------------------------------------------------------");
		System.out.println("사용자 아이디: " + loginedUser.getId());
		System.out.println("사용자 이름: " + loginedUser.getName());
		System.out.println("적립 포인트: " + loginedUser.getPoint());
		System.out.println("-------------------------------------------------------");
	}
	
	private void 로그아웃() {
		System.out.println("<< 로그아웃 >>");
		loginedUser = null;
		
		System.out.println("### 로그아웃이 완료되었습니다.");
	}

	private void 프로그램종료() {
		System.out.println("<< 프로그램 종료 >>");
		service.save();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		MallApplication app = new MallApplication();
		app.menu();
	}
}
