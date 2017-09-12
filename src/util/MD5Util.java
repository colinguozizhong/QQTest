package util;

import java.security.MessageDigest;
import java.util.Locale;

public class MD5Util {
	public static String MD5(String inStr) {
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		return MD5(byteArray);
	}
	
	public static String MD5(byte[] byteArray) {
		
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = md5Bytes[i] & 0xFF;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return (hexValue.toString()).toUpperCase(Locale.getDefault());
	}
	
	public static void main(String[] args) {
		System.out.println(MD5("123456789abcdef"));
	}
}