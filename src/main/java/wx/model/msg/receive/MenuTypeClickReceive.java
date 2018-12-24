package wx.model.msg.receive;

public class MenuTypeClickReceive extends EventReceive{
	
	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	private String eventKey;

	public MenuTypeClickReceive() {
		super();
	}
	
	public MenuTypeClickReceive(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey) {
		super(toUserName, fromUserName, createTime, msgType, event);
		this.eventKey = eventKey;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
	
}
