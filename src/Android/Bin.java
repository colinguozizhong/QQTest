package Android;

import java.util.Random;

import util.ByteUtil;
import util.CommUtil;

public class Bin {
	
	public static byte[] GetRandomBin(int len){
		if(len<1){
			return new byte[0];
		}
		byte [] randomBin =  new byte [len];
		Random rand = new Random();
		for(int i=0;i<len;i++){
			int r = rand.nextInt(256);//取随机数 (0, 255)
			System.out.print(Integer.toHexString(r));
			randomBin[i] = (byte)r;
		}
		System.out.println();
		return randomBin;
	}
	
	public static byte[] Hex2Bin(String Hex){
		return CommUtil.hexStringToByteArray(Hex);
	}
	
	public static byte[] Short2Bin(short num){
		return ByteUtil.getBytes(num);
	}
	
	public static byte[] Int2Bin(int num){
		return ByteUtil.getBytes(num);
	}
	
	public static void main(String[] args) {
		byte[] array = GetRandomBin(3); 
		System.out.println((byte)128);
	}
}
