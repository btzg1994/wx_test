package me.ffs.www.service;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.gserv.serv.commons.restclient.RestClient;
import com.github.gserv.serv.commons.restclient.RestClientException;

import util.BtzgStringUtil;


@Component
public class GetAccessTokenTimer {
	private static Logger logger = LoggerFactory.getLogger(GetAccessTokenTimer.class);
	
	@Scheduled(cron = "0 0 0/1 * * ?")
	public void getAccessToken(){
		try {
			// 构造链接
			String url = PublicService.WX_URL_GET_ACCESS_TOKEN;
			String appid = PublicService.APP_ID;
			String secret = PublicService.APP_SECRET;
			url = url + "&appid=" + appid + "&secret=" + secret;
			
			// 发送请求
			logger.info("发起获取access_token的请求:[{}]",url);
			String rsp = RestClient.exchange(url, HttpMethod.GET, String.class);
			logger.info("响应结果:[{}]",rsp);
			
			// 处理响应
			HashMap<String,String> map = new HashMap<String, String>();
			BtzgStringUtil.Json2SimpleMap(map, rsp, null);
			
			//存入access_token
			String access_token = map.get("access_token");
			PublicService.access_token = access_token;
		} catch (RestClientException e) {
			logger.warn("获取access_token异常：{}",e);
		}
	}
	
	@PostConstruct
	public void init(){
		getAccessToken();
	}
	
}
