package wx.model.msg.receive;

import java.util.List;

public class MenuTypePicReceive extends EventReceive{
	
	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	private String eventKey;
	
	/**
	 * 发送的图片数量
	 */
	private String count;
	
	/**
	 * 图片的MD5值，开发者若需要，可用于验证接收到图片
	 */
	private List<String> picMd5Sums;  

	public MenuTypePicReceive() {
		super();
	}
	
	public MenuTypePicReceive(String toUserName, String fromUserName, String createTime, String msgType, String event, String eventKey,String count,List<String> picMd5Sums) {
		super(toUserName, fromUserName, createTime, msgType, event);
		this.eventKey = eventKey;
		this.count = count;
		this.picMd5Sums = picMd5Sums;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<String> getPicMd5Sums() {
		return picMd5Sums;
	}

	public void setPicMd5Sums(List<String> picMd5Sums) {
		this.picMd5Sums = picMd5Sums;
	}
	
	
	
}
