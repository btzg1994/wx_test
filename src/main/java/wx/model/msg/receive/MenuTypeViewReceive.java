package wx.model.msg.receive;

public class MenuTypeViewReceive extends EventReceive{
	
	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	private String eventKey;
	
	/**
	 * 指菜单ID，如果是个性化菜单，则可以通过这个字段，知道是哪个规则的菜单被点击了
	 */
	private String menuId;

	public MenuTypeViewReceive() {
		super();
	}
	
	public MenuTypeViewReceive(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey,String menuId) {
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
