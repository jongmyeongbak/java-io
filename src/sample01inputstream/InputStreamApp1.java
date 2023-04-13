package sample01inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class InputStreamApp1 {

	public static void main(String[] args) throws IOException {
		
//		FileInputStream in = new FileInputStream("src/sample02outputstream/sample.txt");
		FileInputStream in = new FileInputStream("src/sample01inputstream/sample.jpg");
//		FileInputStream in = new FileInputStream("src/sample01inputstream/sample03.txt");
		// int read() 메서드를 사용해 1byte씩 읽어오기
//		FileInputStream in = new FileInputStream("src/sample01inputstream/InputStreamApp1.java");
//		int value = 0, count = 0;
//		while ((value = in.read()) != -1) {
////			if (count++ >10) {
////				break;
////			}
//			System.out.printf("%x\n", value);
//		}
		
		// int read(byte[] buf) 메서드를 사용해 배열의 크기만큼 한번에 읽어오기
		byte[] buf = new byte[1024];
		int len, count = 0;
		while ((len = in.read(buf)) != -1) {
//			if (count++ > 10) {
//				break;
//			}
			System.out.println(len);
			System.out.println(Arrays.toString(buf));
//			System.out.println(new String(buf, 0, len));
		}
//		System.out.printf("%x %x", buf[0], buf[1]);
//		System.out.printf("%x %x %x %x %x %x", buf[0], buf[1], buf[2], buf[3], buf[4], buf[5]);
		
	}
}
