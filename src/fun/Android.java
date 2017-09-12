package fun;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import Android.Bin;
import Android.Other;
import Android.Pack;
import Android.Tlv;
import util.ByteUtil;
import util.CommUtil;
import util.MD5Util;
import vo.QQInfo;
import vo.QQglobal;

public class Android {
	
	public QQglobal global = new QQglobal();
	
	private QQInfo qq = new QQInfo();
	
	private int RequestId;
	
	private String last_error = "";
	
	public void Init(String user,String pass){
		qq.setAccount(user);
		long luin = Long.valueOf(user);
		int iuin;
		if(luin > 2147483647L){
			qq.setUser(CommUtil.subByteArray(ByteUtil.getBytes(luin),4));
		}else{
			iuin = (int)luin;
			qq.setUser(ByteUtil.getBytes(iuin));
		}
		qq.setQq(Long.valueOf(user));
		qq.setCaption(ByteUtil.getBytes(user));
		qq.setPass(pass);
		qq.setMd5(CommUtil.hexStringToByteArray(MD5Util.MD5(pass)));
		byte[] md52Byte = CommUtil.concat(CommUtil.concat(qq.getMd5(), new byte[]{0,0,0,0}), qq.getUser());
		qq.setMd52(CommUtil.hexStringToByteArray(MD5Util.MD5(md52Byte)));
		qq.set_ksid(CommUtil.hexStringToByteArray(CommUtil.trimAllBlank("93 AC 68 93 96 D5 7E 5F 94 96 B8 15 36 AA FE 91")));
		
		global.setImei("866819027236658");
		global.setVer(ByteUtil.getBytes("5.8.0.157158"));
		global.setAppId(537042771);
		global.setPc_ver("1F 41");
		global.setOs_type("android");
		global.setOs_version("4.4.4");
		global.set_network_type(2);
		global.set_apn("wifi");
		global.setDevice("vivo X5Max+");
		global.set_apk_id("com.tencent.mobileqq");
		global.set_apk_v("5.8.0.157158");
		global.set_apk_sig(CommUtil.hexStringToByteArray(CommUtil.trimAllBlank("A6 B7 45 BF 24 A2 C2 77 52 77 16 F6 F3 6E B6 8D")));
		global.setImei_(CommUtil.hexStringToByteArray(CommUtil.trimAllBlank("38 36 36 38 31 39 30 32 37 32 33 36 36 35 38")));
		
		RequestId = 10000;
		
		qq.setToken002C(new byte[]{});
		qq.setToken004C(new byte[]{});
		qq.setToken004C(new byte[]{});
		qq.setKey(new byte[]{0,0,0,0,
				0,0,0,0,
				0,0,0,0,
				0,0,0,0});

	}
	
	public int Fun_Login(){
		
		Socket client = null;
		
		byte[] bin = null;
		
		qq.setLoginState(CommUtil.login_state_logining);
		
		try {
			client = new Socket("msfwifi.3g.qq.com", 8080);
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
			this.last_error = "无法连接服务器";
			return qq.getLoginState();
		} catch (IOException e) {
			e.printStackTrace();
			
			this.last_error = "无法连接服务器";
			return qq.getLoginState();
		}		
		
		bin = this.Fun_send(this.Pack_Login(), 3000);
		if(null == bin || bin.length == 0){
			this.last_error = "登陆返回包为空";
			return qq.getLoginState();
		}else{
			this.Fun_recv(bin);
		}
		
		
		
		return qq.getLoginState();
	}
	
	public byte[] Pack_Login(){
		
		Pack pack = new Pack();
		byte[] bin;
		byte[] tmp;
		byte[] wupBuffer;
		byte[] tlv109;
		byte[] tlv124;
		byte[] tlv128;
		byte[] tlv16e;

		qq.setShareKey(CommUtil.hexStringToByteArray(CommUtil.trimAllBlank("957C3AAFBF6FAF1D2C2F19A5EA04E51C")));
		qq.setPub_key(CommUtil.hexStringToByteArray(CommUtil.trimAllBlank("02244B79F2239755E73C73FF583D4EC5625C19BF8095446DE1")));
		qq.setTgtKey(Bin.GetRandomBin(16));
		qq.setTime(CommUtil.subByteArray(ByteUtil.getBytes(Other.TimeStamp()),4));
		//qq.setTime(CommUtil.subByteArray(CommUtil.longToByte(Other.TimeStamp()),4));
		qq.setRandKey(Bin.GetRandomBin(16));
		
		System.out.println("TGTKey:"+CommUtil.byteArrayToHexString(qq.getTgtKey()));
		System.out.println("randKey:"+CommUtil.byteArrayToHexString(qq.getRandKey()));
		
		pack.Empty();
		pack.SetHex("00 09");
		pack.SetShort((short) 19);
		
		pack.SetBin(Tlv.tlv18(qq.getUser()));
		pack.SetBin(Tlv.tlv1(qq.getUser(), qq.getTime()));
		return null;
	}
	
	public byte[] Fun_send(byte[] bin, int wait){
		return null;
	}
	
	public void Fun_recv(byte[] data){
		
	}
}
