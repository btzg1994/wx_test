package wx.model.msg.receive;

import wx.model.msg.receive.base.MsgRec;

/**
 * 小视频消息
 * @author btzg
 * @time 2018年12月25日 上午10:39:55
 */
public class MsgShortVideoRec extends MsgRec{
	
	/**
	 * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String mediaId;
	
	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String thumbMediaId;
	
	
	public MsgShortVideoRec() {
		super();
	}
	

	public MsgShortVideoRec(String toUserName, String fromUserName, String createTime, String msgType, String msgId, String mediaId, String thumbMediaId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		this.mediaId = mediaId;
		this.thumbMediaId = thumbMediaId;
	}



	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	
	
	
	

	
}
