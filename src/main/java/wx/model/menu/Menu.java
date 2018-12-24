package wx.model.menu;

import java.util.List;

/**
 * 微信菜单
 * 1、自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
 * 2、一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。
 * 3、创建自定义菜单后，菜单的刷新策略是，在用户进入公众号会话页或公众号profile页时，如果发现上一次拉取菜单的请求在5分钟以前，就会拉取一下菜单，如果菜单有更新，就会刷新客户端的菜单。测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
 * @author btzg
 * @time 2018年12月24日 上午10:53:55
 */
public class Menu {
	
	/**
	 * 自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。
	 */
	private List<WxButton> button;

	public List<WxButton> getButton() {
		return button;
	}

	public void setButton(List<WxButton> button) {
		this.button = button;
	}

	
}
