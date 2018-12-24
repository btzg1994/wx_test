package wx.model.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 包含二级菜单的一级菜单
 * @author btzg
 * @time 2018年12月24日 上午10:47:24
 */
public class ButtonWithKids implements WxButton{
	
	private String name;
	
	/**
	 * 每个一级菜单最多包含5个二级菜单
	 */
	@JsonProperty("sub_button")
	List<Button> subButton;

	
	
	
	public ButtonWithKids() {
		super();
	}
	
	
	public ButtonWithKids(String name, List<Button> subButton) {
		super();
		this.name = name;
		this.subButton = subButton;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Button> getSubButton() {
		return subButton;
	}

	public void setSubButton(List<Button> subButton) {
		this.subButton = subButton;
	}
	
	
	
	
	
}
