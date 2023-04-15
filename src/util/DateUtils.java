package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 날짜를 'yyyy-MM-dd'형식의 텍스트로 변환해 반환한다.
	 * @param date
	 * @return 지정된 포맷의 문자열
	 */
	public static String toText(Date date) {
		if (date == null) {
			return "";
		}
		return YYYYMMDD.format(date);
	}
	
	/**
	 * 날짜 형식의 문자열을 {@code java.util.Date}로 변환하여 반환한다.
	 * @param text 문자열
	 * @return 날짜
	 */
	public static Date toDate(String text) {
		if (text == null) {
			return null;
		}
		try {
			return YYYYMMDD.parse(text);
		} catch (ParseException e) {
			throw new RuntimeException("[" + text + "]", e);
		}
	}
}
