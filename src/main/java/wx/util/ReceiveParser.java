package wx.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import wx.model.msg.receive.BaseReceive;
import wx.model.msg.receive.MenuTypeClickReceive;
import wx.model.msg.receive.MenuTypeLocationSelectReceive;
import wx.model.msg.receive.MenuTypePicReceive;
import wx.model.msg.receive.MenuTypeScanCodeReceive;
import wx.model.msg.receive.MenuTypeViewReceive;

public class ReceiveParser {
	public static BaseReceive parse(InputStream is) throws Exception{
		
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(is);
		
		String toUserName = document.selectSingleNode("//xml/ToUserName").getText();
		String fromUserName = document.selectSingleNode("//xml/FromUserName").getText();
		String createTime = document.selectSingleNode("//xml/CreateTime").getText();
		String msgType = document.selectSingleNode("//xml/MsgType").getText();
		
		if(WxConstantUtil.MSG_TYPE_EVENT.equals(msgType)){//event类型的消息
			String eventKey;
			String menuId;
			String scanType;
			String scanResult;
			String count;
			ArrayList<String> picMd5Sums = new ArrayList<String>();
			String locationX;
			String locationY;
			String label;
			String scale;
			String poiname;
			
			String event = document.selectSingleNode("//xml/Event").getText();
			switch(event){
				case WxConstantUtil.EVENT_TYPE_CLICK:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					return new MenuTypeClickReceive(toUserName, fromUserName, createTime, msgType, event, eventKey);
					
				case WxConstantUtil.EVENT_TYPE_VIEW:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					menuId = document.selectSingleNode("//xml/MenuID").getText();
					return new MenuTypeViewReceive(toUserName, fromUserName, createTime, msgType, event, eventKey, menuId);
					
				case WxConstantUtil.EVENT_TYPE_SCANCODE_PUSH:
				case WxConstantUtil.EVENT_TYPE_SCANCODE_WAITMSG:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					scanType = document.selectSingleNode("//xml/ScanCodeInfo/ScanType").getText();
					scanResult = document.selectSingleNode("//xml/ScanCodeInfo/ScanResult").getText();
					return new MenuTypeScanCodeReceive(toUserName, fromUserName, createTime, msgType, event, eventKey, scanType, scanResult);
					
				case WxConstantUtil.EVENT_TYPE_PIC_SYSPHOTO:
				case WxConstantUtil.EVENT_TYPE_PIC_PHOTO_OR_ALBUM:
				case WxConstantUtil.EVENT_TYPE_PIC_WEIXIN:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					count = document.selectSingleNode("//xml/SendPicsInfo/Count").getText();
					List<Node> selectNodes = document.selectNodes("//xml/SendPicsInfo/PicList/item/PicMd5Sum");
					for (Node node : selectNodes) {
						picMd5Sums.add(node.getText());
					}
					return new MenuTypePicReceive(toUserName, fromUserName, createTime, msgType, event, eventKey, count, picMd5Sums);
					
				case WxConstantUtil.EVENT_TYPE_LOCATION_SELECT:
					eventKey = document.selectSingleNode("//xml/EventKey").getText();
					locationX = document.selectSingleNode("//xml/SendLocationInfo/Location_X").getText();
					locationY = document.selectSingleNode("//xml/SendLocationInfo/Location_Y").getText();
					scale = document.selectSingleNode("//xml/SendLocationInfo/Scale").getText();
					label = document.selectSingleNode("//xml/SendLocationInfo/Label").getText();
					poiname = document.selectSingleNode("//xml/SendLocationInfo/Poiname").getText();
					return new MenuTypeLocationSelectReceive(toUserName, fromUserName, createTime, msgType, event, eventKey, locationX, locationY, scale, label, poiname);
				default:
					return new BaseReceive(toUserName, fromUserName, createTime, msgType);
			}
		}else{
			return new BaseReceive(toUserName, fromUserName, createTime, msgType);
		}
		
		
		
		
		
	}
}
