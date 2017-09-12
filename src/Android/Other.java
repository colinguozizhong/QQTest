package Android;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Other {
	
	/**
	 * GetUnixTime
	 * @param toMs
	 * @return
	 */
	public static long TimeStamp(boolean toMs){
		Date now=new Date(); 
		long ret = now.getTime();
		if(!toMs){
			ret = ret/1000;
		}
		return ret;
	}
	
	/**
	 * GetUnixTime
	 * @return
	 */
	public static long TimeStamp(){
		return TimeStamp(false);
	}
	
	public static void main(String[] args) throws Exception {
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		//1361325960  
		long epoch = df.parse("2013-02-20 10:06:00").getTime();  
		System.out.println("should be 1361325960 ："+epoch);  
		
		
		Date d=new Date(); 
		String t=df.format(d);  
		System.out.println("t is ："+t+",unix stamp is "+df.parse(t).getTime()); 
		epoch=df.parse(t).getTime()/1000;  
		System.out.println("t is ："+t+",unix stamp is "+epoch); 

	}
}
