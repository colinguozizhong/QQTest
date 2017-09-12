package test;

import Android.Pack;
import util.ByteUtil;
import util.CommUtil;
import fun.Android;

public class TestMain {
	public static void main(String [] args) throws Exception{
		Android android = new Android();
		//android.Fun_Login();
		
		Pack pack = new Pack();
		
		byte[] testb = {0,0,0,0};
		CommUtil.byteArrayToHexString(testb);
		
	//	pack.SetHex("00 09");
	//	pack.SetShort((short) 19);
		
	//	android.Pack_Login();
		
		android.Init("1512578004", "123456");
		
		int c = -127;
		System.out.println(Integer.toHexString(c));
		
		CommUtil.shortToBytes((short)19);
		
		CommUtil.longToByte(1504168514);
		
		ByteUtil.getBytes((short)19);
		
		ByteUtil.getBytes(1504168514);
	}
}
