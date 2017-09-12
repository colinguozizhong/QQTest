package Android;

public class Tlv {
	
	public static byte[] tlv18(byte[] user){
		Pack pack = new Pack();
		
		//00 18 //tlv18
		//00 16 //tlv长度22 如果太长不是tlv包
		//00 01 //_ping_version=1
		//00 00 06 00 //_sso_version=1536
		//00 00 00 10 //_appid
		//00 00 00 00 //_app_client_version
		//18 B4 A1 BC [QQ号码：414491068]
		//00 00 //0
		//00 00 //0
	
		pack.Empty();
		pack.SetHex("00 01");
		pack.SetHex("00 00 06 00");
		pack.SetHex("00 00 00 10");
		pack.SetHex("00 00 00 00");
		pack.SetBin(user);
		pack.SetHex("00 00");
		pack.SetHex("00 00");

		return Tlv.tlv_pack("00 18", pack.GetAll());
	}
	
	public static byte[] tlv1(byte[] user, byte[] time){
		// 00 01 //tlv1
		// 00 14 //长度20
		// 00 01 //ip_ver=1
		// 3F AA 67 F9 //get_rand_32()
		// 18 B4 A1 BC [QQ号码：414491068]
		// 54 09 99 7F //get_server_cur_time
		// 00 00 00 00//_ip_addr
		// 00 00 //0
		// time ＝Xbin.Flip" 取字节集左边 (到字节集 (Other.TimeStamp ()), 4))

		Pack pack = new Pack();
		pack.Empty();
		pack.SetHex("00 01");
		pack.SetBin(Bin.GetRandomBin(4));
		pack.SetBin(user);
		pack.SetBin(time);
		pack.SetHex("00 00 00 00");
		pack.SetHex("00 00");
		
		return Tlv.tlv_pack("00 01", pack.GetAll());
	}
	
	public static byte[] tlv106(byte [] user,byte [] md5pass,byte [] md52pass, byte[] _TGTKey, byte[] imei_, byte[] time, int appId){
		// 01 06
		// 00 70 [md5(md5(pass)+0 0 0 0+hexQQ)E8 FD 5B 08 BF 42 3C B9 F8 D4 23 30 F2 E2 E3 59 ]
		// 67 A4 4D 1D 59 08 97 15 92 03 BB E3 E8 7F 49 CC 65 A2 F6 E3 4F 68 DA 9E A2 E9 DA 90 DB 26 2D F5 A4 BD C0 52 51 F0 40 77 B5 50 25 42 AC 68 1B 57 35 61 97 65 36 6B AA 35 C5 E1 E6 C8 91 3B 3E 30 84 AA 6F 6C 32 29 97 FB DF 53 CA 3C B5 F8 F3 13 E4 FF AA 58 39 75 81 45 38 4A A2 BE CA 43 E0 7E 0A 83 71 17 5C 88 7C DE DE ED B8 12 E4 D5 C4 22
		// [
		// 00 03 //TGTGTVer=3
		// 29 A5 69 34 rand32
		// 00 00 00 05
		// 00 00 00 10
		// 00 00 00 00
		// 00 00 00 00
		// 18 B4 A1 BC [QQ:414491068]
		// 4D 1F C3 AC //时间
		// 00 00 00 00
		// 01
		// EB E0 80 63 34 8C 9E E1 FD 6B 5E 05 9A 72 84 C6 //MD5PASS
		// C5 2E 0F 5D A6 20 B5 EE 0B 94 F2 6F C3 05 4A 02 //TGTKey
		// 00 00 00
		// 00 01
		// 46 60 1E D3 C6 24 16 BF CA A2 9E 9E B8 9A D2 4E //imei_
		// 20 02 93 92 _sub_appid
		// 00 00 00 01 00 00
		// ]
		// time ＝Xbin.Flip 取字节集左边 (到字节集 (Other.TimeStamp ()), 4))

		Pack pack = new Pack();
		pack.SetHex("00 03");
		pack.SetBin(Bin.GetRandomBin(4));
		pack.SetHex("00 00 00 05");
		pack.SetHex("00 00 00 10");
		pack.SetHex("00 00 00 00");
		pack.SetHex("00 00 00 00");
		pack.SetBin(user);
		pack.SetBin(time);
		pack.SetHex("00 00 00 00 01");
		pack.SetBin(md5pass);
		pack.SetBin(_TGTKey);
		pack.SetHex("00 00 00 00");
		pack.SetHex("01");
		pack.SetBin(imei_);
		pack.SetInt(appId);
		pack.SetHex("00 00 00 01");
		pack.SetHex("00 00");


	}
	
	public static byte[] tlv_pack(String cmd,byte [] bin){
		Pack pack = new Pack();
		pack.Empty();
		pack.SetHex(cmd);
		pack.SetShort((short)bin.length);
		pack.SetBin(bin);
		return pack.GetAll();
	}
}
