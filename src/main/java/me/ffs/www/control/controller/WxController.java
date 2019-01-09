package me.ffs.www.control.controller;



import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.ffs.www.service.PublicService;
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
import wx.model.msg.receive.base.EventRec;
import wx.util.ReceiveParser;
import wx.util.WxConstantUtil;

@Controller
public class WxController {
	private static final Logger logger =LoggerFactory.getLogger(WxController.class);
	
	
	@RequestMapping("receive")
	@ResponseBody
	public String receive(HttpServletRequest request) throws Exception{
		ServletInputStream is = request.getInputStream();
		String req = IOUtils.toString(is,"UTF-8");
		logger.info("请求体：\n{}",req);
		
		BaseRec receive = ReceiveParser.parse(req);
		
		String msgType = receive.getMsgType();
		
		if(WxConstantUtil.MSG_TYPE_EVENT.equals(msgType)){//收到事件消息
			EventRec eventReceive = (EventRec) receive;
			String event = eventReceive.getEvent();
			switch(event){
				case WxConstantUtil.EVENT_TYPE_CLICK:
					EventMenuClickRec clickReceive = (EventMenuClickRec)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_VIEW:
					EventMenuViewRec viewReceive = (EventMenuViewRec)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_SCANCODE_PUSH:
					EventMenuScanCodeRec scanCodePushReceive = (EventMenuScanCodeRec)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_SCANCODE_WAITMSG:
					EventMenuScanCodeRec scanCodeWaitmsgReceive = (EventMenuScanCodeRec)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_PIC_SYSPHOTO:
					EventMenuPicRec picSysphotoReceive = (EventMenuPicRec)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_PIC_PHOTO_OR_ALBUM:
					EventMenuPicRec picPhotoOrAlbumReceive = (EventMenuPicRec)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_PIC_WEIXIN:
					EventMenuPicRec picWeixinReceive = (EventMenuPicRec)receive;
					break;
				case WxConstantUtil.EVENT_TYPE_LOCATION_SELECT:
					EventMenuLocationSelectRec lsReceive = (EventMenuLocationSelectRec)receive;
					System.out.println(lsReceive.getLabel());
					break;
				default:
			}
			
		}else if(WxConstantUtil.MSG_TYPE_TEXT.equals(msgType)){//收到文本消息
			MsgTextRec textRec = (MsgTextRec)receive;
			System.out.println(textRec.getContent());
			
		}else if(WxConstantUtil.MSG_TYPE_IMAGE.equals(msgType)){//收到图片消息
			MsgImageRec imageRec = (MsgImageRec) receive;
			
		}else if(WxConstantUtil.MSG_TYPE_VOICE.equals(msgType)){//收到语音消息
			MsgVoiceRec voiceRec =  (MsgVoiceRec) receive;
			
		}else if(WxConstantUtil.MSG_TYPE_VIDEO.equals(msgType)){//收到视频消息
			MsgVideoRec videoRec =  (MsgVideoRec) receive;
			
		}else if(WxConstantUtil.MSG_TYPE_SHORTVIDEO.equals(msgType)){//收到小视频消息
			MsgShortVideoRec shortVideoRec =  (MsgShortVideoRec) receive;
			
		}else if(WxConstantUtil.MSG_TYPE_LOCATION.equals(msgType)){//收到地理位置消息
			MsgLocationRec locationRec =  (MsgLocationRec) receive;
			
		}else if(WxConstantUtil.MSG_TYPE_LINK.equals(msgType)){//收到链接消息
			MsgLinkRec  linkRec =  (MsgLinkRec) receive;
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
