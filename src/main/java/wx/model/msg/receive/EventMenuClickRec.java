package wx.model.msg.receive;

import wx.model.msg.receive.base.EventRec;

/**
 *  click类型菜单的推送体
 * @author btzg
 * @time 2018年12月25日 上午10:37:20
 */
public class EventMenuClickRec extends EventRec{
	
	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	private String eventKey;

	public EventMenuClickRec() {
		super();
	}
	
	public EventMenuClickRec(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey) {
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
