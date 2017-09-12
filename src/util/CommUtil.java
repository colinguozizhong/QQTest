package util;

import java.util.Arrays;
import java.util.Locale;

public class CommUtil {
	public static final int login_state_logining = 0;
	
	
	/**
	 * 16进制表示的字符串转换为字节数组
	 *
	 * @param s 16进制表示的字符串
	 * @return byte[] 字节数组
	 */
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] b = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
	        b[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character
	                .digit(s.charAt(i + 1), 16));
	    }
	    return b;
	}
	
	/**
	 * 16进制的字符串表示转成字节数组
	 *
	 * @param hexString 16进制格式的字符串            
	 * @return 转换后的字节数组
	 **/
	public static byte[] toByteArray(String hexString) {
	    if (hexString == null || hexString.length() < 1)
	        throw new IllegalArgumentException("this hexString must not be empty");

	    hexString = hexString.toLowerCase();
	    final byte[] byteArray = new byte[hexString.length() / 2];
	    int k = 0;
	    for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
	        byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
	        byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
	        byteArray[i] = (byte) (high << 4 | low);
	        k += 2;
	    }
	    return byteArray;
	}
	
	/**
	 * byte[]数组转换为16进制的字符串
	 *
	 * @param bytes 要转换的字节数组
	 * @return 转换后的结果
	 */
	private static String bytesToHexString(byte[] bytes) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < bytes.length; i++) {
	        String hex = Integer.toHexString(0xFF & bytes[i]);
	        if (hex.length() == 1) {
	            sb.append('0');
	        }
	        sb.append(hex);
	    }
	    return sb.toString();
	}
	
	/**
	 * byte[]数组转换为16进制的字符串
	 *
	 * @param data 要转换的字节数组
	 * @return 转换后的结果
	 */
	public static final String byteArrayToHexString(byte[] data) {
	    StringBuilder sb = new StringBuilder(data.length * 2);
	    for (byte b : data) {
	        int v = b & 0xff;
	        if (v < 16) {
	            sb.append('0');
	        }
	        sb.append(Integer.toHexString(v));
	    }
	    return sb.toString().toUpperCase(Locale.getDefault());
	}
	
	/**
	 * 字节数组转成16进制表示格式的字符串
	 *
	 * @param byteArray 要转换的字节数组
	 * @return 16进制表示格式的字符串
	 **/
	public static String toHexString(byte[] byteArray) {
	    if (byteArray == null || byteArray.length < 1)
	        throw new IllegalArgumentException("this byteArray must not be null or empty");

	    final StringBuilder hexString = new StringBuilder();
	    for (int i = 0; i < byteArray.length; i++) {
	        if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
	            hexString.append("0");
	        hexString.append(Integer.toHexString(0xFF & byteArray[i]));
	    }
	    return hexString.toString().toLowerCase();
	}
	
	public static byte[] shortToBytes(short number){
		byte[] bytes = new byte[2];
		// 先转Hex
		String hex=Integer.toHexString(number);
		// 再转byte
		bytes = hexStringToByteArray(hex);
		return bytes;
	}
	
	/**
	 * long to byte[]
	 * 
	 * @param s
	 *            long
	 * @return byte[]
	 * */
	public static byte[] longToByte(long number) { 
        long temp = number; 
        byte[] b = new byte[8]; 
        for (int i = 0; i < b.length; i++) { 
            b[i] = new Long(temp & 0xff).byteValue();// 将最低位保存在最低位 
            temp = temp >> 8; // 向右移8位 
        } 
        return b; 
    } 
	
	public static String trimAllBlank(String text){
		if(text != null){
			return text.replaceAll(" ", "");
		}else{
			return "";
		}
	}
	
	public static byte[] subByteArray(byte[] b,int len){
		
		byte [] a = new byte [len];
		
		if(len < b.length){
			for(int i=0;i<len;i++){
				a[i] = b[i];
			}
			return a;
		}else if(len > b.length){
			for(int i=0;i<len;i++){
				if(i<b.length){
					a[i] = b[i];
				}else{
					a[i] = (byte)0;
				}
			}
			return a;
		}else{
			return b;
		}
	}
	
	/**
	 * 合并数组
	 * @param first
	 * @param second
	 * @return
	 */
	public static <T> T[] concat(T[] first, T[] second) {  
		T[] result = Arrays.copyOf(first, first.length + second.length);  
		System.arraycopy(second, 0, result, first.length, second.length);  
		return result;  
	} 
	
	public static byte[] concat(byte[] first, byte[] second) {  
		byte[] result = Arrays.copyOf(first, first.length + second.length);  
		System.arraycopy(second, 0, result, first.length, second.length);  
		return result;  
	} 
	
	/**
	 * 合并多个数组
	 * @param first
	 * @param rest
	 * @return
	 */
	public static <T> T[] concatAll(T[] first, T[]... rest) {
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		return result;
	}

	
	
	public static void main(String[] args) {
		byte[] array = toByteArray("957C3AAFBF6FAF1D2C2F19A5EA04E51C"); 
		System.out.println(array);
	}
}
