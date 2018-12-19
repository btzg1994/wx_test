package me.ffs.www.service;

import org.springframework.stereotype.Service;

@Service
public class PublicService {
	
	public static final String TOKEN = "AN6qSTWERySAhOdWSwZeXUCA7nScoEMa";
	
	public static String access_token;
	
	public static final String WX_URL_GET_ACCESS_TOKEN= "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
	
	public static final String APP_ID = "wx8f441e35a45bdd04";
	
	public static final String APP_SECRET = "614d5ad7f50c4a993ab57df462a03804";
}
