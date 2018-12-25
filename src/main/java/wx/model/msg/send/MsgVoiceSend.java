package wx.model.msg.send;

import java.util.Date;

import wx.model.msg.send.base.BaseSend;

/**
 * 回复语音消息
 * @author btzg
 * @time 2018年12月25日 下午12:49:38
 */
public class MsgVoiceSend extends BaseSend{
	
	/**
	 * 通过素材管理中的接口上传多媒体文件，得到的id。
	 */
	private String mediaId;

	public MsgVoiceSend() {
		super();
	}
	
	public MsgVoiceSend(String toUserName, String fromUserName, String createTime, String msgType, String mediaId) {
		super(toUserName, fromUserName, createTime, msgType);
		this.mediaId = mediaId;
	}

	
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toString() {
		String str = "<xml>"
				+ "<ToUserName>< ![CDATA[" + getToUserName() + "] ]></ToUserName>"
				+ "<FromUserName>< ![CDATA[" + getFromUserName() + "] ]></FromUserName>"
				+ "<CreateTime>" + new Date().getTime() + "</CreateTime>"
				+ "<MsgType>< ![CDATA[voice] ]></MsgType>"
				+ "<Voice><MediaId>< ![CDATA[" + getMediaId() + "] ]></MediaId></Voice>"
				+ "</xml>";
		return str;
	}
	
	
	
}
