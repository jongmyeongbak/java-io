package sample02outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class HangeulOutputStreamApp {

	public static void main(String[] args) throws IOException {
		FileOutputStream out = new FileOutputStream("src/sample02outputstream/sample.txt");
		
//		out.write(65); // 'A'
//		out.write(66); // 'B'
//		out.write(67); // 'C'
//		out.write('a');
//		out.write('b');
//		out.write('c');
//		out.write('d');
//		out.write('가'); // 글자가 제대로 기록되지 않는다.
//		out.write('나'); // 글자가 제대로 기록되지 않는다.
//		out.write('다'); // 글자가 제대로 기록되지 않는다.
		
		String text = "가각";
		byte[] bytes = text.getBytes();
		System.out.printf("%x %x %x %x %x %x", bytes[0], bytes[1], bytes[2], bytes[3], bytes[4], bytes[5]);
		out.write(bytes);
		
		out.close();
	}
}
