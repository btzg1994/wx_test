package wx.model.msg.receive;

import wx.model.msg.receive.base.MsgRec;

/**
 * 链接消息
 * @author btzg
 * @time 2018年12月25日 上午10:39:55
 */
public class MsgLinkRec extends MsgRec{
	
	/**
	 * 	消息标题
	 */
	private String title; 
	
	/**
	 * 	消息描述
	 */
	private String description; 
	
	/**
	 * 	消息链接
	 */
	private String url;

	public MsgLinkRec() {
		super();
	}
	
	
	
	public MsgLinkRec(String toUserName, String fromUserName, String createTime, String msgType, String msgId, String title, String description, String url) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		this.title = title;
		this.description = description;
		this.url = url;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	} 
	
	

	
}
