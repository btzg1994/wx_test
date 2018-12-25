package wx.model.msg.receive;

import wx.model.msg.receive.base.EventRec;

/**
 * 扫码带参数二维码，用户未关注时，进行关注后的事件推送
 * @author btzg
 * @time 2018年12月25日 下午12:37:56
 */
public class EventScanRec extends EventRec{
	
	/**
	 * 事件KEY值，qrscene_为前缀，后面为二维码的参数值
	 */
	private String eventKey;
	
	/**
	 * 二维码的ticket，可用来换取二维码图片
	 */
	private String ticket;

	public EventScanRec() {
		super();
	}
	
	
	public EventScanRec(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey, String ticket) {
		super(toUserName, fromUserName, createTime, msgType, eventKey);
		this.eventKey = eventKey;
		this.ticket = ticket;
	}



	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	
	
}
