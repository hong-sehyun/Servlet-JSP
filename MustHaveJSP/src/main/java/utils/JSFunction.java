package utils;

import javax.servlet.jsp.JspWriter;

public class JSFunction {
	public static void alertLocation(String msg, String url, JspWriter out) {
		try {
			String script = ""
					+ "<script>"
					+ "		alert('" + msg + "');"
					+ "		location.herf='" + url + "';"
					+ "</script>";
			out.print(script);
		}
		catch (Exception e) {	}
	}
	public static void alertBack(String msg, JspWriter out) {
		try {
			String script = ""
					+ "<script>"
					+ "		alert('" + msg + "');"
					+ "		history.back();"
					+ "</script>";
			out.print(script);
		}
		catch (Exception e) {	}
	}

}