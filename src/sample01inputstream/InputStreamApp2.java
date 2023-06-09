package sample01inputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamApp2 {

	public static void main(String[] args) throws IOException {
		/*
		 * InputStream과 OutputStream
		 * 	- InputStream과 OutputStream은 바이너리 데이터를 읽고 쓰는 스트림이다.
		 * 	- 바이너리 데이터: 그림, 영상, 압축파일, 워드파일, 아래아한글파일 등
		 * 	- InputStream과 OutputStream은 바이너리 데이터를
		 * 		 읽어서 분석하는 용도로 사용하기보다는 바이너리 데이터 그 자체를 전송하는 것이 목적이다.
		 *  - 예시
		 *  	1. 파일을 읽어서 다른 곳에 복사하기
		 *  	2. 사용자가 업로드한 파일을 서버의 특정 폴더에 저장하기
		 *  	3. 사용자가 다운로드를 요청한 파일을 읽어서 브라우저로 내려보내기
		 */
		
		// 원본파일을 읽어 백업파일을 생성하기
		String src = "src/sample01inputstream/sample.jpg";
		String dest = "src/sample01inputstream/sample_bak.jpg";
		FileInputStream in = new FileInputStream(src);
		FileOutputStream out = new FileOutputStream(dest);
		
		long startTime = System.currentTimeMillis();
		
		// 1byte씩 읽고 기록하기
//		int value;
//		while ((value = in.read()) != -1) {
//			out.write(value);
//		}
		
		// byte[] 배열을 이용해 읽고 기록하기
		byte[] buf = new byte[1024 * 8];
		int length;
		while ((length = in.read(buf)) != -1) {
			out.write(buf, 0, length);
		}
		
		in.close();
		out.close();
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("소요시간: " + (endTime - startTime) + "밀리초");
	}
}
