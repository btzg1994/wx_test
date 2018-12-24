package me.ffs.www.control.controller;


import java.util.List;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.SAXParser;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.ffs.www.service.PublicService;
import wx.model.msg.receive.BaseReceive;
import wx.model.msg.receive.EventReceive;
import wx.model.msg.receive.MenuTypeClickReceive;
import wx.model.msg.receive.MenuTypeLocationSelectReceive;
import wx.model.msg.receive.MenuTypePicReceive;
import wx.model.msg.receive.MenuTypeScanCodeReceive;
import wx.model.msg.receive.MenuTypeViewReceive;
import wx.util.ReceiveParser;
import wx.util.WxConstantUtil;

@Controller
public class GlobalController {
	
	@RequestMapping("receive")
	@ResponseBody
	public String receive(HttpServletRequest request) throws Exception{
		ServletInputStream is = request.getInputStream();
		BaseReceive receive = ReceiveParser.parse(is);
		String msgType = receive.getMsgType();
		
		if(WxConstantUtil.MSG_TYPE_EVENT.equals(msgType)){
			EventReceive eventReceive = (EventReceive) receive;
			String event = eventReceive.getEvent();
			switch(event){
				case WxConstantUtil.EVENT_TYPE_CLICK:
					MenuTypeClickReceive clickReceive = (MenuTypeClickReceive)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_VIEW:
					MenuTypeViewReceive viewReceive = (MenuTypeViewReceive)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_SCANCODE_PUSH:
					MenuTypeScanCodeReceive scanCodePushReceive = (MenuTypeScanCodeReceive)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_SCANCODE_WAITMSG:
					MenuTypeScanCodeReceive scanCodeWaitmsgReceive = (MenuTypeScanCodeReceive)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_PIC_SYSPHOTO:
					MenuTypePicReceive picSysphotoReceive = (MenuTypePicReceive)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_PIC_PHOTO_OR_ALBUM:
					MenuTypePicReceive picPhotoOrAlbumReceive = (MenuTypePicReceive)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_PIC_WEIXIN:
					MenuTypePicReceive picWeixinReceive = (MenuTypePicReceive)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_LOCATION_SELECT:
					MenuTypeLocationSelectReceive lsReceive = (MenuTypeLocationSelectReceive)receive;
					System.out.println(lsReceive.getLabel());
					break;
				default:
			}
		}
		return "success";
	}
	
	
	@RequestMapping("getToken")
	@ResponseBody
	public String getToken(){
		return PublicService.access_token;
	}
	
	@RequestMapping("contact")
	public String contact(){
		return "contact";
	}
}
