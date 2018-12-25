package wx.model.msg.send;

import java.util.Date;

import wx.model.msg.send.base.BaseSend;

/**
 * 回复文本消息
 * @author btzg
 * @time 2018年12月25日 下午12:49:38
 */
public class MsgTextSend extends BaseSend{
	
	/**
	 * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */
	private String content;

	public MsgTextSend() {
		super();
	}
	
	public MsgTextSend(String toUserName, String fromUserName, String createTime, String msgType, String content) {
		super(toUserName, fromUserName, createTime, msgType);
		this.content = content;
	}




	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		String str = "<xml>"
				+ "<ToUserName>< ![CDATA[" + getToUserName() + "] ]></ToUserName>"
				+ "<FromUserName>< ![CDATA[" + getFromUserName() + "] ]></FromUserName>"
				+ "<CreateTime>" + new Date().getTime() + "</CreateTime>"
				+ "<MsgType>< ![CDATA[text] ]></MsgType>"
				+ "<Content>< ![CDATA[" + getContent() + "] ]></Content>"
				+ "</xml>";
		return str;
	}
	
	
	
}
