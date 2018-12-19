package util;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.codec.digest.DigestUtils;

public class BtzgWxUtil {
	
	/**
	 *  开发者服务器接入签名校验
	 * @param timestamp
	 * @param token
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String timestamp,String token,String nonce,String signature){
		ArrayList<String> list = new ArrayList<String>();
		list.add(nonce);
		list.add(token);
		list.add(timestamp);
		Collections.sort(list);
		String mySignature = DigestUtils.shaHex(list.get(0)+list.get(1)+list.get(2));
		if(signature.equals(mySignature)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
}
