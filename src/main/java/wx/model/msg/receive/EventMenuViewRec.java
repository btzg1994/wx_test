package wx.model.msg.receive;

import wx.model.msg.receive.base.EventRec;

/**
 * view类型菜单的推送体
 * @author btzg
 * @time 2018年12月25日 上午10:39:25
 */
public class EventMenuViewRec extends EventRec{
	
	/**
	 * 事件KEY值，设置的跳转URL
	 */
	private String eventKey;
	
	/**
	 * 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了
	 */
	private String menuId;

	public EventMenuViewRec() {
		super();
	}
	
	public EventMenuViewRec(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey,String menuId) {
		super(toUserName, fromUserName, createTime, msgType, event);
		this.eventKey = eventKey;
		this.menuId = menuId;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
	
	
}
