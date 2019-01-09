package wx.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;

import wx.model.msg.receive.EventMenuClickRec;
import wx.model.msg.receive.EventMenuLocationSelectRec;
import wx.model.msg.receive.EventMenuPicRec;
import wx.model.msg.receive.EventMenuScanCodeRec;
import wx.model.msg.receive.EventMenuViewRec;
import wx.model.msg.receive.MsgImageRec;
import wx.model.msg.receive.MsgLinkRec;
import wx.model.msg.receive.MsgLocationRec;
import wx.model.msg.receive.MsgShortVideoRec;
import wx.model.msg.receive.MsgTextRec;
import wx.model.msg.receive.MsgVideoRec;
import wx.model.msg.receive.MsgVoiceRec;
import wx.model.msg.receive.base.BaseRec;

public class ReceiveParser {
	public static BaseRec parse(InputStream is) throws Exception{
		String text = IOUtils.toString(is,"UTF-8");
		return parse(text);
	}
	
	public static BaseRec parse(String text) throws Exception{
		
		Document document = DocumentHelper.parseText(text);
		
		String toUserName = document.selectSingleNode("//xml/ToUserName").getText();
		String fromUserName = document.selectSingleNode("//xml/FromUserName").getText();
		String createTime = document.selectSingleNode("//xml/CreateTime").getText();
		String msgType = document.selectSingleNode("//xml/MsgType").getText();
		String eventKey,menuId,scanType,scanResult,count,locationX,locationY,label,scale,poiname,content,msgId,picUrl,mediaId,format,recognition,thumbMediaId,title,description,url;
		
		
		
		if(WxConstantUtil.MSG_TYPE_EVENT.equals(msgType)){//event类型的消息
			ArrayList<String> picMd5Sums = new ArrayList<String>();
			
			String event = document.selectSingleNode("//xml/Event").getText();
			switch(event){
				case WxConstantUtil.EVENT_TYPE_CLICK:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					return new EventMenuClickRec(toUserName, fromUserName, createTime, msgType, event, eventKey);
					
				case WxConstantUtil.EVENT_TYPE_VIEW:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					menuId = document.selectSingleNode("//xml/MenuId").getText();
					return new EventMenuViewRec(toUserName, fromUserName, createTime, msgType, event, eventKey, menuId);
					
				case WxConstantUtil.EVENT_TYPE_SCANCODE_PUSH:
				case WxConstantUtil.EVENT_TYPE_SCANCODE_WAITMSG:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					scanType = document.selectSingleNode("//xml/ScanCodeInfo/ScanType").getText();
					scanResult = document.selectSingleNode("//xml/ScanCodeInfo/ScanResult").getText();
					return new EventMenuScanCodeRec(toUserName, fromUserName, createTime, msgType, event, eventKey, scanType, scanResult);
					
				case WxConstantUtil.EVENT_TYPE_PIC_SYSPHOTO:
				case WxConstantUtil.EVENT_TYPE_PIC_PHOTO_OR_ALBUM:
				case WxConstantUtil.EVENT_TYPE_PIC_WEIXIN:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					count = document.selectSingleNode("//xml/SendPicsInfo/Count").getText();
					List<Node> selectNodes = document.selectNodes("//xml/SendPicsInfo/PicList/item/PicMd5Sum");
					for (Node node : selectNodes) {
						picMd5Sums.add(node.getText());
					}
					return new EventMenuPicRec(toUserName, fromUserName, createTime, msgType, event, eventKey, count, picMd5Sums);
					
				case WxConstantUtil.EVENT_TYPE_LOCATION_SELECT:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					locationX = document.selectSingleNode("//xml/SendLocationInfo/Location_X").getText();
					locationY = document.selectSingleNode("//xml/SendLocationInfo/Location_Y").getText();
					scale = document.selectSingleNode("//xml/SendLocationInfo/Scale").getText();
					label = document.selectSingleNode("//xml/SendLocationInfo/Label").getText();
					poiname = document.selectSingleNode("//xml/SendLocationInfo/Poiname").getText();
					return new EventMenuLocationSelectRec(toUserName, fromUserName, createTime, msgType, event, eventKey, locationX, locationY, scale, label, poiname);
				default:
					return new BaseRec(toUserName, fromUserName, createTime, msgType);
			}
		}else if(WxConstantUtil.MSG_TYPE_TEXT.equals(msgType)){//文本消息
			content = document.selectSingleNode("//xml/Content").getText();
			msgId = document.selectSingleNode("//xml/MsgId").getText();
			return new MsgTextRec(toUserName, fromUserName, createTime, msgType, msgId, content);
			
		}else if(WxConstantUtil.MSG_TYPE_IMAGE.equals(msgType)){//图片消息
			picUrl = document.selectSingleNode("//xml/PicUrl").getText();
			mediaId = document.selectSingleNode("//xml/MediaId").getText();
			msgId = document.selectSingleNode("//xml/MsgId").getText();
			return new MsgImageRec(toUserName, fromUserName, createTime, msgType, msgId, picUrl, mediaId);
			
		}else if(WxConstantUtil.MSG_TYPE_VOICE.equals(msgType)){//语音消息
			mediaId = document.selectSingleNode("//xml/MediaId").getText();
			msgId = document.selectSingleNode("//xml/MsgId").getText();
			format = document.selectSingleNode("//xml/Format").getText();
			recognition =  document.selectSingleNode("//xml/Recognition") == null ? "" : document.selectSingleNode("//xml/Recognition").getText();
			return new MsgVoiceRec(toUserName, fromUserName, createTime, msgType, msgId, mediaId, format, recognition);
			
		}else if(WxConstantUtil.MSG_TYPE_VIDEO.equals(msgType)){//视频消息
			mediaId = document.selectSingleNode("//xml/MediaId").getText();
			msgId = document.selectSingleNode("//xml/MsgId").getText();
			thumbMediaId = document.selectSingleNode("//xml/ThumbMediaId").getText();
			return new MsgVideoRec(toUserName, fromUserName, createTime, msgType, msgId, mediaId, thumbMediaId);
			
		}else if(WxConstantUtil.MSG_TYPE_SHORTVIDEO.equals(msgType)){//小视频消息
			mediaId = document.selectSingleNode("//xml/MediaId").getText();
			msgId = document.selectSingleNode("//xml/MsgId").getText();
			thumbMediaId = document.selectSingleNode("//xml/ThumbMediaId").getText();
			return new MsgShortVideoRec(toUserName, fromUserName, createTime, msgType, msgId, mediaId, thumbMediaId);
			
		}else if(WxConstantUtil.MSG_TYPE_LOCATION.equals(msgType)){//地理位置消息
			locationX = document.selectSingleNode("//xml/Location_X").getText();
			locationY = document.selectSingleNode("//xml/Location_Y").getText();
			scale = document.selectSingleNode("//xml/Scale").getText();
			label = document.selectSingleNode("//xml/Label").getText();
			msgId = document.selectSingleNode("//xml/MsgId").getText();
			return new MsgLocationRec(toUserName, fromUserName, createTime, msgType, msgId, locationX, locationY, scale, label);
			
		}else if(WxConstantUtil.MSG_TYPE_SHORTVIDEO.equals(msgType)){//链接消息
			title = document.selectSingleNode("//xml/Title").getText();
			description = document.selectSingleNode("//xml/Description").getText();
			url = document.selectSingleNode("//xml/Url").getText();
			msgId = document.selectSingleNode("//xml/MsgId").getText();
			return new MsgLinkRec(toUserName, fromUserName, createTime, msgType, msgId, title, description, url);	
			
		}else {
			return new BaseRec(toUserName, fromUserName, createTime, msgType);
		}
		
		
		
		
	}
	
	
	
	
}
