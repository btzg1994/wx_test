package wx.model.msg.receive.base;

/**
 * 事件推送
 * @author btzg
 * @time 2018年12月25日 上午10:48:01
 */
public class EventRec extends BaseRec{
	
	/**
	 * 事件类型
	 */
	private String event;

	
	public EventRec() {
		super();
	}
	
	public EventRec( String toUserName, String fromUserName, String createTime, String msgType,String event) {
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
