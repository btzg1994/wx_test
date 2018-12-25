package wx.model.msg.receive;

import wx.model.msg.receive.base.EventRec;

/**
 * 扫码类型菜单的推送体
 * @author btzg
 * @time 2018年12月25日 上午10:39:03
 */
public class EventMenuScanCodeRec extends EventRec{
	
	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	private String eventKey;
	
	/**
	 * 扫描类型，一般是qrcode
	 */
	private String scanType;
	
	/**
	 * 扫描结果，即二维码对应的字符串信息
	 */
	private String scanResult;

	public EventMenuScanCodeRec() {
		super();
	}
	
	public EventMenuScanCodeRec(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey,String scanType,String scanResult) {
		super(toUserName, fromUserName, createTime, msgType, event);
		this.eventKey = eventKey;
		this.scanType = scanType;
		this.scanResult = scanResult;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getScanType() {
		return scanType;
	}

	public void setScanType(String scanType) {
		this.scanType = scanType;
	}

	public String getScanResult() {
		return scanResult;
	}

	public void setScanResult(String scanResult) {
		this.scanResult = scanResult;
	}
	
	
	
	
}
