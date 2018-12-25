package wx.model.msg.receive;

import wx.model.msg.receive.base.EventRec;

public class EventLocationRec extends EventRec{
	
	/**
	 * 	地理位置纬度
	 */
	private String latitude;
	
	/**
	 * 	地理位置经度
	 */
	private String longitude;
	
	/**
	 * 	地理位置精度
	 */
	private String precision;

	
	public EventLocationRec() {
		super();
	}
	
	
	public EventLocationRec(String toUserName, String fromUserName, String createTime, String msgType, String event, String latitude, String longitude, String precision) {
		super(toUserName, fromUserName, createTime, msgType, event);
		this.latitude = latitude;
		this.longitude = longitude;
		this.precision = precision;
	}




	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getPrecision() {
		return precision;
	}

	public void setPrecision(String precision) {
		this.precision = precision;
	}
	
	
	
}
