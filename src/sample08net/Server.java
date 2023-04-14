package sample08net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		// 클라이언트의 연결요청을 청취하는 ServerSocket객체를 생성함
		// ServerSocket객체 생성 시 자신이 사용할 포트번호를 지정함
		System.out.println("서버 프로그램이 시작되었음...");
		ServerSocket serverSocket = new ServerSocket(3000);
		
		// ServerSocket의 accept() 메서드는 클라이언트의 연결요청을 기다린다.
		// 클라이언트의 요청이 접수되면 accept() 메서드가 실행되고, 해당 클라이언트와 통신을 담당하는 Socket객체를 생성해 반환한다.
		System.out.println("서버가 클라이언트의 접속을 기다리고 있음...");
		Socket socket = serverSocket.accept();
		System.out.println("클라이언트의 접속이 수락되었음...");
		
		// Socket객체의 getInputStream(), getOutputStream() 메서드를 실행해
		// 이 Socket객체와 연결된 클라이언트의 Socket객체와 데이터를 송수신할(읽고 쓸) 수 있는 스트림을 획득한다.
		// 획득한 스트림을 텍스트 송수신에 편리한 BufferedReader 및 PrintWriter와 연결한다.
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		System.out.println("클라이언트와 데이터를 주고받을 준비가 완료되었음");
		
		// BufferedReader의 readLine() 메서드는 클라이언트가 보내는 메시지가 수신될 때까지 대기한다.
		// 클라이언트가 보내는 메시지가 수신되면 메시지를 읽어서 반환한다.
		String text;
		while((text = in.readLine()) != null) {
			System.out.println("클라이언트가 보낸 메시지: " + text);
			
			// PrintWriter의 println() 메서드를 사용해 클라이언트에게 메시지를 송수신한다.
			out.println("메시지를 정상적으로 수신하였습니다. 수신된 메시지: [" + text + "]");
		}
		
		serverSocket.close();
		System.out.println("서버 프로그램이 종료되었음...");
	}
}
