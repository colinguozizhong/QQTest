package vo;

import java.io.Serializable;

public class QQglobal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2735974791294838646L;
	
	private String imei;
	private byte[] imei_;
	private byte[] ver;
	private int appId;
	private String pc_ver;
	private String os_type;
	private String os_version;
	private int _network_type;
	private String _apn;
	private String device;
	private String _apk_id;
	private String _apk_v;
	private byte[] _apk_sig;
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public byte[] getImei_() {
		return imei_;
	}
	public void setImei_(byte[] imei_) {
		this.imei_ = imei_;
	}
	public byte[] getVer() {
		return ver;
	}
	public void setVer(byte[] ver) {
		this.ver = ver;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getPc_ver() {
		return pc_ver;
	}
	public void setPc_ver(String pc_ver) {
		this.pc_ver = pc_ver;
	}
	public String getOs_type() {
		return os_type;
	}
	public void setOs_type(String os_type) {
		this.os_type = os_type;
	}
	public String getOs_version() {
		return os_version;
	}
	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}
	public int get_network_type() {
		return _network_type;
	}
	public void set_network_type(int _network_type) {
		this._network_type = _network_type;
	}
	public String get_apn() {
		return _apn;
	}
	public void set_apn(String _apn) {
		this._apn = _apn;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String get_apk_id() {
		return _apk_id;
	}
	public void set_apk_id(String _apk_id) {
		this._apk_id = _apk_id;
	}
	public String get_apk_v() {
		return _apk_v;
	}
	public void set_apk_v(String _apk_v) {
		this._apk_v = _apk_v;
	}
	public byte[] get_apk_sig() {
		return _apk_sig;
	}
	public void set_apk_sig(byte[] _apk_sig) {
		this._apk_sig = _apk_sig;
	}

	

}
