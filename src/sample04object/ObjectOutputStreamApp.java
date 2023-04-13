package sample04object;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamApp {

	public static void main(String[] args) throws IOException {
		Score score = new Score();
		score.setName("홍길동");
		score.setPassword("zxcv1234");
		score.setGrade(3);
		score.setKor(100);
		score.setEng(80);
		score.setMath(70);
		score.setPassed(true);
		
		/*
		 * ObjectOutputStream
		 * 	객체를 직렬화해서 연결된 스트림으로 출력할 수 있게 하는 스트림이다.
		 * 	주요 API
		 * 		생성자
		 * 			ObjectOutputStream(OutputStream out)
		 * 				이 스트림과 연결되는 1차 스트림 객체를 전달받아 객체를 초기화한다.
		 * 		주요 메서드
		 * 			void writeObject(Object obj)
		 * 				전달받은 객체를 직렬화하여 스트림으로 전송시킨다.
		 */
		String path = "src/sample04object/obj.sav";
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
		
		out.writeObject(score);
		
		out.close();
	}
}
