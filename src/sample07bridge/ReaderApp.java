package sample07bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderApp {

	public static void main(String[] args) throws IOException {
		/*
		 * InputStreamReader
		 * 	브리지 스트림이다.
		 * 	문자전용 스트림이다.
		 * 	바이트스트림과 연결 가능한 캐릭터스트림 객체다.
		 * 	바이트스트림으로 읽어온 데이터를 다른 캐릭터스트림과 연결한다.
		 * 	생성자
		 * 		InputStreamReader(InputStream in)
		 * 		InputStreamReader(InputStream in, String charsetName)
		 * 			* 이 스트림과 연결되는 바이트스트림 객체를 전달받아 스트림객체를 초기화한다.
		 * 			* 문자전용스트림이지만, 바이트스트림 객체를 전달받아 그 스트림과 연결된다.
		 */
		
		// 키보드 입력을 한 줄씩 읽어오기
		
		// 1. 키보드와 연결된 스트림객체를 획득하기
		InputStream inputStream = System.in;
		
		// 2. 키보드와 연결된 스트림을 Reader와 연결하기
		InputStreamReader isr = new InputStreamReader(inputStream);
		
		// 3. BufferedReader와 연결하기
		BufferedReader br = new BufferedReader(isr);
		
		// 4. 키보드 입력을 읽어오기
		System.out.print("내용을 입력하세요: ");
		String text = br.readLine();
		
		// 5. 키보드 입력내용을 출력해보기
		System.out.println("입력내용: " + text);
	}
}
