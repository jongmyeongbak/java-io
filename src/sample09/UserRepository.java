package sample09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

	// users.txt 파일의 사용자 정보가 저장되는 객체다.
	private List<User> users = new ArrayList<>();

	public UserRepository() {
		String path = "src/sample09/users.txt";
		try (BufferedReader in = new BufferedReader(new FileReader(path))) {
			String text;
			while ((text = in.readLine()) != null) {
				if (text.isBlank()) {
					break;
				}
				User user = User.createUser(text);
				users.add(user);
			}
		} catch (IOException e) {
			throw new RuntimeException("users.txt 파일 읽기 오류", e);
		}
	}

	/*
	 * 아이디를 전달받아 아이디에 해당하는 사용자정보를 반환한다.
	 * 	반환타입: User
	 * 	메서드명: getUserById
	 * 	매개변수: String id
	 */
	public User getUserById(String id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	public void save() {
		String path = "src/sample09/users.txt";
		try (PrintWriter out = new PrintWriter(path)) {
			for (User user : users) {
				/*
				 * user.generateText()는 User객체의 사용자정보를
				 * "hong,zxcv1234,홍길동,1000"과 같은 문자열로 변환해 반환한다.
				 */
				String text = user.generateText();
				out.println(text);
			}
		} catch (IOException e) {
			throw new RuntimeException("users.txt 파일 쓰기 오류", e);
		}
	}
}
