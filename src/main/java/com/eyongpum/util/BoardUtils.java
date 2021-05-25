package com.eyongpum.util;

import java.io.UnsupportedEncodingException;

import com.eyongpum.board.Board;

public class BoardUtils {
	public static String convertHtmlBr(String comment) {
		
		if (comment == null) {
			return "";
		}
		int length = comment.length();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length; i++) {
			String tmp = comment.substring(i, i+1);
			if ("\r".compareTo(tmp) == 0) {
				tmp = comment.substring(++i, i+1);
				if ("\n".compareTo(tmp) == 0) {
					buffer.append("<br>\b");
				} else {
					buffer.append("\r");
				}
			}
			buffer.append(tmp);
		}
		return buffer.toString();
	}
	
	public static String ascToksc(String str, boolean isEncode) throws UnsupportedEncodingException {
		String result = str;
		if (result == null || result == "") {
			return null;
		}
		return new String(result.getBytes("8859_1"),"KSC5601");
	}
	
	public static String kscToasc(String str) throws UnsupportedEncodingException {
		if (str == null || str == "") {
			return null;
		}
		return new String(str.getBytes("KSC5601"),"8859_1");
	}
	
	public String getTitleString (Board board) {
		StringBuilder title = new StringBuilder(128);
		String t = board.getTitle();
		if (t.length() > 15) {
			t = String.format("%s...", t.substring(0, 15));
		}
		
		for (int i = 0; i < board.getDepth(); i++) {
			title.append("&nbsp;&nbsp;");
		}
		
		if (board.getDepth() > 0) {
			title.append("<img board='0' src='image/re.gif'/>");
		}
		
		title.append(t.replace(" ", "&nbsp;"));
		
		return title.toString();
	}

}
