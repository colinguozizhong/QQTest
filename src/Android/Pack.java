package Android;

import java.io.Serializable;

import util.CommUtil;

public class Pack implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2719450943156066107L;

	public byte[] m_bin;
	
	public void Empty(){
		m_bin = new byte[]{};
	}
	
	public byte[] GetAll(){
		return m_bin;
	}
	
	public void SetHex(String Hex){
		Hex = CommUtil.trimAllBlank(Hex);
		byte[] hexbyteArray =  Bin.Hex2Bin(Hex);
		m_bin = CommUtil.concat(m_bin, hexbyteArray);
	}
	
	public void SetShort(short number){
		byte[] hexbyteArray =  Bin.Short2Bin(number);
		m_bin = CommUtil.concat(m_bin, hexbyteArray);
	}
	
	public void SetInt(int number){
		byte[] hexbyteArray =  Bin.Int2Bin(number);
		m_bin = CommUtil.concat(m_bin, hexbyteArray);
	}
	
	public void SetBin(byte[] t){
		m_bin = CommUtil.concat(m_bin, t);
	}
	
}
