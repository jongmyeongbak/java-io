package sample06character;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.StringJoiner;

import sample04object.Score;

public class WriterApp {

	public static void main(String[] args) throws FileNotFoundException {
		String path = "src/sample06character/score.txt";
		PrintWriter out = new PrintWriter(path);
		
		Score score = new Score();
		score.setName("홍길동");
		score.setPassword("zxcv1234");
		score.setGrade(3);
		score.setKor(100);
		score.setEng(80);
		score.setMath(70);
		score.setPassed(true);
		
		StringJoiner joiner = new StringJoiner(",");
		joiner.add(score.getName())
				.add(score.getPassword())
				.add(String.valueOf(score.getGrade()))
				.add(String.valueOf(score.getKor()))
				.add(String.valueOf(score.getEng()))
				.add(String.valueOf(score.getMath()))
				.add(String.valueOf(score.isPassed()));
		
		String text = joiner.toString();
//		System.out.println(text);
		out.println(text);
		out.println(text);
		out.println(text);
		out.println(text);
		
		out.close();
	}
}
