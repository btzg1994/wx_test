package wx.model.msg.receive;

import wx.model.msg.receive.base.MsgRec;

/**
 * 地理位置消息
 * @author btzg
 * @time 2018年12月25日 上午10:39:55
 */
public class MsgLocationRec extends MsgRec{
	
	/**
	 * 	地理位置纬度
	 */
	private String locationX;
	
	/**
	 * 地理位置经度
	 */
	private String locationY;
	
	/**
	 * 地图缩放大小
	 */
	private String scale;
	
	/**
	 * 地理位置信息
	 */
	private String label;

	public MsgLocationRec() {
		super();
	}
	
	public MsgLocationRec(String toUserName, String fromUserName, String createTime, String msgType, String msgId, String locationX, String locationY, String scale, String label) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		this.locationX = locationX;
		this.locationY = locationY;
		this.scale = scale;
		this.label = label;
	}

	public String getLocationX() {
		return locationX;
	}

	public void setLocationX(String locationX) {
		this.locationX = locationX;
	}

	public String getLocationY() {
		return locationY;
	}

	public void setLocationY(String locationY) {
		this.locationY = locationY;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
}
