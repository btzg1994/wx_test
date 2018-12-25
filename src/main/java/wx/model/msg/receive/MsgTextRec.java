package wx.model.msg.receive;

import wx.model.msg.receive.base.MsgRec;

/**
 * 文本消息
 * @author btzg
 * @time 2018年12月25日 上午10:39:55
 */
public class MsgTextRec extends MsgRec{
	
	/**
	 * 	文本消息内容
	 */
	private String content; 
	
	
	public MsgTextRec() {
		super();
	}
	
	
	public MsgTextRec(String toUserName, String fromUserName, String createTime, String msgType, String msgId, String content) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
