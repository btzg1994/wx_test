package wx.model.msg.receive;

import wx.model.msg.receive.base.MsgRec;

/**
 * 图片消息
 * @author btzg
 * @time 2018年12月25日 上午10:39:55
 */
public class MsgImageRec extends MsgRec{
	
	/**
	 * 图片链接（由系统生成）
	 */
	private String picUrl;
	
	/**
	 * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
	 */
	private String mediaId;
	

	
	
	public MsgImageRec() {
		super();
	}
	
	public MsgImageRec(String toUserName, String fromUserName, String createTime, String msgType, String msgId, String picUrl, String mediaId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		this.picUrl = picUrl;
		this.mediaId = mediaId;
	}
	

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	
	
}
