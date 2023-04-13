package sample05buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedApp {

	public static void main(String[] args) throws IOException {
		
		/*
		 * BufferedInputStream, BufferedOutputStream
		 * 	다른 스트림의 읽기/쓰기 성능을 향상시키는 스트림이다.
		 * 	다른 스트림과 연결하여 사용하는 2차 스트림이다.
		 * 	주요 API
		 * 		생성자
		 * 			BufferedInputStream(InputStream in)
		 * 			BufferedOutputStream(OutputStream out)
		 */
		
		long startTime = System.currentTimeMillis();
		
		String src = "src/sample05buffered/sample.zip";
		String dest = "src/sample05buffered/sample_bak.zip";
		
		FileInputStream i = new FileInputStream(src);
		FileOutputStream o = new FileOutputStream(dest);
		BufferedInputStream in = new BufferedInputStream(i);
		BufferedOutputStream out = new BufferedOutputStream(o);
		
		int value;
		while ((value = in.read()) != -1) {
			out.write(value);
		}
		
		in.close();
		out.close();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("소요시간: " + (endTime - startTime) + "밀리초");
	}
}
