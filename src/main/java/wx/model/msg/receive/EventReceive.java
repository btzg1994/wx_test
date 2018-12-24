package wx.model.msg.receive;

public class EventReceive extends BaseReceive{
	
	/**
	 * 事件类型
	 */
	private String event;

	
	public EventReceive() {
		super();
	}
	
	public EventReceive( String toUserName, String fromUserName, String createTime, String msgType,String event) {
		super(toUserName, fromUserName, createTime, msgType);
		this.event = event;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	
}
