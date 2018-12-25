package wx.model.msg.send.base;

public class BaseSend {
	
	/**
	 * 接收方帐号（收到的OpenID）
	 */
	private String toUserName;
	
	/**
	 * 开发者微信号
	 */
	private String fromUserName;
	
	/**
	 * 	消息创建时间 （整型）
	 */
	private String createTime;
	
	/**
	 * 消息类型
	 */
	private String msgType;
	
	
	public BaseSend() {
		super();
	}

	public BaseSend(String toUserName, String fromUserName, String createTime, String msgType) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	
	
}
