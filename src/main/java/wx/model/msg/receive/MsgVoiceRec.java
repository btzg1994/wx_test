package wx.model.msg.receive;

import wx.model.msg.receive.base.MsgRec;

/**
 * 语音消息
 * @author btzg
 * @time 2018年12月25日 上午10:39:55
 */
public class MsgVoiceRec extends MsgRec{
	
	/**
	 * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String mediaId;
	
	/**
	 * 语音格式，如amr，speex等
	 */
	private String format;

	
	public MsgVoiceRec() {
		super();
	}
	
	
	public MsgVoiceRec(String toUserName, String fromUserName, String createTime, String msgType, String msgId, String mediaId, String format) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		this.mediaId = mediaId;
		this.format = format;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	
	
	
	

	
}
