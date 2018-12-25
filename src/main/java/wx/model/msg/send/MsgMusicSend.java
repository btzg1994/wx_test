package wx.model.msg.send;

import java.util.Date;

import wx.model.msg.send.base.BaseSend;

/**
 * 回复音乐消息
 * @author btzg
 * @time 2018年12月25日 下午12:49:38
 */
public class MsgMusicSend extends BaseSend{
	
	
	/**
	 * 音乐标题
	 */
	private String title;
	
	/**
	 * 音乐描述
	 */
	private String description;

	/**
	 * 音乐链接
	 */
	private String musicURL;
	
	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	private String hqMusicUrl;
	
	/**
	 * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	 */
	private String thumbMediaId;
	
	
	
	public MsgMusicSend() {
		super();
	}
	
	
	public MsgMusicSend(String toUserName, String fromUserName, String createTime, String msgType, String title, String description, String musicURL, String hqMusicUrl, String thumbMediaId) {
		super(toUserName, fromUserName, createTime, msgType);
		this.title = title;
		this.description = description;
		this.musicURL = musicURL;
		this.hqMusicUrl = hqMusicUrl;
		this.thumbMediaId = thumbMediaId;
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

	public String getMusicURL() {
		return musicURL;
	}

	public void setMusicURL(String musicURL) {
		this.musicURL = musicURL;
	}

	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}





	@Override
	public String toString() {
		String str = "<xml>"
				+ "<ToUserName>< ![CDATA[" + getToUserName() + "] ]></ToUserName>"
				+ "<FromUserName>< ![CDATA[" + getFromUserName() + "] ]></FromUserName>"
				+ "<CreateTime>" + new Date().getTime() + "</CreateTime>"
				+ "<MsgType>< ![CDATA[music] ]></MsgType>"
				+ "<Music>"
					+ "<Title>< ![CDATA[" + getTitle() + "] ]></Title>"
					+ "<Description>< ![CDATA[" + getDescription() + "] ]></Description>"
					+ "<MusicUrl>< ![CDATA[" + getMusicURL() + "] ]></MusicUrl>"
					+ "<HQMusicUrl>< ![CDATA[" + getHqMusicUrl() + "] ]></HQMusicUrl>"
					+ "<ThumbMediaId>< ![CDATA[" + getThumbMediaId() + "] ]></ThumbMediaId>"
				+ "</Music>"
				+ "</xml>";
		return str;
	}
	
	
	
}
