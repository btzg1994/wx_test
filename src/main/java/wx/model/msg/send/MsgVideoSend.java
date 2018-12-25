package wx.model.msg.send;

import java.util.Date;

import wx.model.msg.send.base.BaseSend;

/**
 * 回复视频消息
 * @author btzg
 * @time 2018年12月25日 下午12:49:38
 */
public class MsgVideoSend extends BaseSend{
	
	/**
	 * 通过素材管理中的接口上传多媒体文件，得到的id。
	 */
	private String mediaId;
	
	/**
	 * 视频消息的标题
	 */
	private String title;
	
	/**
	 * 视频消息的描述
	 */
	private String description;

	
	
	public MsgVideoSend() {
		super();
	}
	
	public MsgVideoSend(String toUserName, String fromUserName, String createTime, String msgType, String mediaId, String title, String description) {
		super(toUserName, fromUserName, createTime, msgType);
		this.mediaId = mediaId;
		this.title = title;
		this.description = description;
	}



	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
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



	@Override
	public String toString() {
		String str = "<xml>"
				+ "<ToUserName>< ![CDATA[" + getToUserName() + "] ]></ToUserName>"
				+ "<FromUserName>< ![CDATA[" + getFromUserName() + "] ]></FromUserName>"
				+ "<CreateTime>" + new Date().getTime() + "</CreateTime>"
				+ "<MsgType>< ![CDATA[video] ]></MsgType>"
				+ "<Video>"
					+ "<MediaId>< ![CDATA[" + getMediaId() + "] ]></MediaId>"
					+ "<Title>< ![CDATA[" + getTitle() + "] ]></Title>"
					+ "<Description>< ![CDATA[" + getDescription() + "] ]></Description>"
				+ "</Video>"
				+ "</xml>";
		return str;
	}
	
	
	
}
