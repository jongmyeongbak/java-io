package sample09;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	/*
	 * 	반환타입: 
	 * 	메서드명: 
	 * 	매개변수: 
	 */

	/*
	 * 	반환타입: 
	 * 	메서드명: 
	 * 	매개변수: 
	 */

	/*
	 * 	반환타입: 
	 * 	메서드명: 
	 * 	매개변수: 
	 */
}
