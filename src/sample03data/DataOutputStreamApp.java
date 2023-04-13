package sample03data;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamApp {

	public static void main(String[] args) throws IOException {

		String name = "홍길동";
		int grade = 3;
		int kor = 100;
		int eng = 100;
		int math = 80;
		boolean passed = true;
		
		/*
		 * DataOutputStream
		 * 	변수의 값을 그대로 출력하는 스트림이다.
		 * 	주요 API
		 * 		생성자
		 * 			DataOutputStream(OutputStream out)
		 * 				이 스트림과 연결되는 1차 스트림 객체를 전달받아 객체를 초기화한다.
		 * 		주요 메서드
		 * 			void writeUTF(String text)
		 * 			void writeInt(int value)
		 * 			void writeLong(long value)
		 * 			void writeDouble(double value)
		 * 			void writeBoolean(boolean value)
		 * 				위의 메서드는 전달받는 값을 타입과 함께 출력시킨다.
		 */
		String path = "src/sample03data/sample.sav";
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		
		out.writeUTF(name);
		out.writeInt(grade);
		out.writeInt(kor);
		out.writeInt(eng);
		out.writeInt(math);
		out.writeBoolean(passed);
		
		out.close();
	}
}
