package wx.model.msg.receive.base;

/**
 *  消息推送
 * @author btzg
 * @time 2018年12月25日 上午10:48:23
 */
public class MsgRec extends BaseRec{
	
	/**
	 * 消息id，64位整型
	 */
	private String msgId;

	public MsgRec() {
		super();
	}
	
	public MsgRec( String toUserName, String fromUserName, String createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType);
		this.msgId = msgId;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	
}
