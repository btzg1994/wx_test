package wx.model.msg.send;

import java.util.Date;
import java.util.List;

import wx.model.msg.send.base.BaseSend;

/**
 * 回复图文消息
 * @author btzg
 * @time 2018年12月25日 下午12:49:38
 */
public class MsgNewsSend extends BaseSend{
	
	/**
	 * 图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
	 */
	private Integer articleCount;
	
	/**
	 * 图文消息标题
	 */
	private List<String> title;
	
	/**
	 * 图文消息描述
	 */
	private List<String> description;

	/**
	 * 	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 */
	private List<String> picUrl;
	
	/**
	 * 点击图文消息跳转链接
	 */
	private List<String> url;
	
	
	public MsgNewsSend() {
		super();
	}
	
	public MsgNewsSend(String toUserName, String fromUserName, String createTime, String msgType, Integer articleCount, List<String> title, List<String> description, List<String> picUrl,
			List<String> url) {
		super(toUserName, fromUserName, createTime, msgType);
		this.articleCount = articleCount;
		this.title = title;
		this.description = description;
		this.picUrl = picUrl;
		this.url = url;
	}

	
	
	
	
	public Integer getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}

	public List<String> getTitle() {
		return title;
	}

	public void setTitle(List<String> title) {
		this.title = title;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public List<String> getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(List<String> picUrl) {
		this.picUrl = picUrl;
	}

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}

	
	
	@Override
	public String toString() {
		String items = "";
		for(int i = 0; i < getArticleCount(); i++){
			items = items + "<item>"
					+ "<Title>< ![CDATA[" + getTitle().get(i) + "] ]></Title>"
					+ "<Description>< ![CDATA[" + getDescription().get(i) + "] ]></Description>"
					+ "<PicUrl>< ![CDATA[" + getPicUrl().get(i) + "] ]></PicUrl>"
					+ "<Url>< ![CDATA[" + getUrl().get(i) + "] ]></Url>"
				+ "</item>";
		}
		
		
		String str = "<xml>"
				+ "<ToUserName>< ![CDATA[" + getToUserName() + "] ]></ToUserName>"
				+ "<FromUserName>< ![CDATA[" + getFromUserName() + "] ]></FromUserName>"
				+ "<CreateTime>" + new Date().getTime() + "</CreateTime>"
				+ "<MsgType>< ![CDATA[news] ]></MsgType>"
				+ "<ArticleCount>1</ArticleCount>"
				+ "<Articles>"
					+ items	
				+ "</Articles>"
				+ "</xml>";
		return str;
	}
	
	
	
}
