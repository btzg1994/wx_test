package wx.model.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * type:
 * 1.click
 * 2.view
 * 3.miniprogram
 * 4.scancode_push
 * 5.scancode_waitmsg
 * 6.pic_sysphoto
 * 7.pic_photo_or_album
 * 8.pic_weixin
 * 9.location_select
 * 10.media_id
 * 11.view_limited
 * @author btzg
 * @time 2018年12月24日 上午10:22:25
 */
public class Button implements WxButton{
	/**
	 *  必须，菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
	 */
	private String type;
	
	/**
	 * 必须，菜单标题，不超过16个字节，子菜单不超过60个字节,一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替
	 */
	private String name;
	
	/**
	 * click等点击类型必须，菜单KEY值，用于消息接口推送，不超过128字节
	 */
	private String key;
	
	/**
	 * view、miniprogram类型必须，网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。
	 */
	private String url;
	
	/**
	 * media_id类型和view_limited类型必须，调用新增永久素材接口返回的合法media_id
	 */
	@JsonProperty("media_id")
	private String mediaId;
	
	/**
	 * miniprogram类型必须，小程序的appid（仅认证公众号可配置）
	 */
	private String appid;
	
	/**
	 * miniprogram类型必须，小程序的页面路径
	 */
	private String pagepath;
	
	
	
	public Button() {
		super();
	}
	

	public Button(String type, String name, String key, String url, String mediaId, String appid, String pagepath) {
		super();
		this.type = type;
		this.name = name;
		this.key = key;
		this.url = url;
		this.mediaId = mediaId;
		this.appid = appid;
		this.pagepath = pagepath;
	}









	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPagepath() {
		return pagepath;
	}

	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	
	
}
