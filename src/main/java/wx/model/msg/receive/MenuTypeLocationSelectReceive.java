package wx.model.msg.receive;

public class MenuTypeLocationSelectReceive extends EventReceive {

	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	private String eventKey;

	/**
	 * X坐标信息
	 */
	private String locationX;

	/**
	 * Y坐标信息
	 */
	private String locationY;

	/**
	 * 精度，可理解为精度或者比例尺、越精细的话 scale越高
	 */
	private String scale;

	/**
	 * 地理位置的字符串信息
	 */
	private String label;

	/**
	 * 朋友圈POI的名字，可能为空
	 */
	private String poiname;

	public MenuTypeLocationSelectReceive() {
		super();
	}

	public MenuTypeLocationSelectReceive( String toUserName, String fromUserName, String createTime, String msgType, String event,String eventKey, String locationX, String locationY, String scale,
			String label, String poiname) {
		super(toUserName, fromUserName, createTime, msgType, event);
		this.eventKey = eventKey;
		this.locationX = locationX;
		this.locationY = locationY;
		this.scale = scale;
		this.label = label;
		this.poiname = poiname;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
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

	public String getPoiname() {
		return poiname;
	}

	public void setPoiname(String poiname) {
		this.poiname = poiname;
	}

}
