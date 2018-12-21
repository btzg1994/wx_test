package me.ffs.www.control.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.ffs.www.service.PublicService;
import util.BtzgWxUtil;

@Controller
public class GlobalController {
	
	@RequestMapping("receive")
	@ResponseBody
	public String receive(HttpServletRequest request){
		
		String signature = request.getParameter("signature") != null ? request.getParameter("signature") : "";
		String timestamp = request.getParameter("timestamp") != null ? request.getParameter("timestamp") : "";
		String nonce = request.getParameter("nonce") != null ? request.getParameter("nonce") : "";
		String echostr = request.getParameter("echostr") != null ? request.getParameter("echostr") : "";
		String token = PublicService.TOKEN;
		
		boolean signatureIsRight = BtzgWxUtil.checkSignature(timestamp, token, nonce, signature);
		if(signatureIsRight){
			return echostr;
		}else{
			return "";
		}
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
