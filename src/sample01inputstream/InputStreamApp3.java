package sample01inputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class InputStreamApp3 {

	public static void main(String[] args) throws IOException {
		
		String path = "https://ticketimage.interpark.com/Play/image/large/23/23003674_p.gif";
		String dest = "src/sample01inputstream/suyoung.gif";
		URL url = new URL(path);
		InputStream in = url.openStream();
//		System.out.println(in.getClass());
		FileOutputStream out = new FileOutputStream(dest);
		
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
		
		in.close();
		out.close();
	}
}
