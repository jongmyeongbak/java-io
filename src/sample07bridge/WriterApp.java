package sample07bridge;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class WriterApp {

	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * OutputStreamWriter
		 * 	캐릭터 전용 스트림이다.
		 * 	브리지 스트림이다.
		 * 	바이트스트림과 연결 가능한 캐릭터 스트림이다.
		 * 
		 * 	생성자
		 * 		OutputStreamWriter(OutputStream out)
		 * 		OutputStreamWriter(OutputStream out, String charsetName)
		 * 			* 이 스트림과 연결되는 바이트스트림 객체를 전달받아 스트림객체를 초기화한다.
		 * 			* 문자전용스트림이지만, 바이트스트림 객체를 전달받아 그 스트림과 연결된다.
		 */
		
		String path = "src/sample07bridge/sample.txt";
		
		FileOutputStream fos = new FileOutputStream(path);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		PrintWriter writer = new PrintWriter(osw);
		
		writer.println("브리지 스트림 연습");
		
		writer.close();
	}
}
