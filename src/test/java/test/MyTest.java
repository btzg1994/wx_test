package test;

import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.junit.Test;

import com.github.gserv.serv.commons.util.JsonMapper;

import wx.model.menu.Button;
import wx.model.menu.ButtonWithKids;
import wx.model.menu.Menu;
import wx.model.menu.WxButton;
import wx.util.WxConstantUtil;

public class MyTest {
	
	@Test
	public void createMenu(){
		
		Button btn1 = new Button(WxConstantUtil.MENU_TYPE_CLICK, "click", "click", null, null, null, null);
		
		Button btn2 = new Button(WxConstantUtil.MENU_TYPE_VIEW, "view", null, "http://www.baidu.com", null, null, null);
	
		Button btn3 = new Button(WxConstantUtil.MENU_TYPE_SCANCODE_PUSH, "scancode_push", "scancode_push", null, null, null, null);

		Button btn4 = new Button(WxConstantUtil.MENU_TYPE_SCANCODE_WAITMSG, "scancode_waitmsg", "scancode_waitmsg", null, null, null, null);
	
		Button btn5 = new Button(WxConstantUtil.MENU_TYPE_VIEW, "系统拍照发图", null, "http://www.tmall.com", null, null, null);
	
		Button btn6 = new Button(WxConstantUtil.MENU_TYPE_PIC_PHOTO_OR_ALBUM, "pic_photo_or_album", "pic_photo_or_album", null, null, null, null);

		Button btn7 = new Button(WxConstantUtil.MENU_TYPE_VIEW, "pic_weixin_name", null, "http://www.jd.com", null, null, null);
	
		Button btn8 = new Button(WxConstantUtil.MENU_TYPE_LOCATION_SELECT, "location_select", "location_select", null, null, null, null);

		ArrayList<Button> btns1 = new ArrayList<Button>();
		btns1.add(btn1);
		btns1.add(btn2);
		btns1.add(btn3);
		btns1.add(btn4);
		btns1.add(btn5);
		
		ArrayList<Button> btns2 = new ArrayList<Button>();
		btns2.add(btn6);
		btns2.add(btn7);
		
		ButtonWithKids bwk1 = new ButtonWithKids("bwk1", btns1);

		ButtonWithKids bwk2 = new ButtonWithKids("bwk2", btns2);
		
		Menu menu = new Menu();
		ArrayList<WxButton> button = new ArrayList<WxButton>();
		button.add(bwk1);
		button.add(bwk2);
		button.add(btn8);
		menu.setButton(button);
		
		String json = JsonMapper.toJsonString(menu);
		System.out.println(json);
	}
	
	@Test
	public void parseXml(){
		String text = "<xml><ToUserName><![CDATA[gh_a5f35afc5aad]]></ToUserName>"
						+"<FromUserName><![CDATA[oxcwi1igZSF6N9xrj_mv2GEBAmVg]]></FromUserName>"
						+"<CreateTime>1545627672</CreateTime>"
						+"<MsgType><![CDATA[event]]></MsgType>"
						+"<Event><![CDATA[pic_photo_or_album]]></Event>"
						+"<EventKey><![CDATA[pic_photo_or_album]]></EventKey>"
						+"<SendPicsInfo><Count>1</Count>"
						+"<PicList><item><PicMd5Sum><![CDATA[2ba09658f2785b609e0ca913cb5a6860]]></PicMd5Sum>"
						+"</item>"
						+"</PicList>"
						+"</SendPicsInfo>"
						+"</xml>";
		try {
			Document document = DocumentHelper.parseText(text);
			Node node = document.selectSingleNode("//xml/ToUserName");
			System.out.println(node.getText());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("hah");
	}
}
