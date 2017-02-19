package com.hao123.pages;

import org.openqa.selenium.By;

/**
 * @author Young
 * @description 首页面元素定位声明
 * */
public class HomePage {
	
//	/**首页-登录  链接*/
	public static final By HP_LINK_ACCOUNT = By.xpath("//*[@class='g_icon login s-wea' and text()='登录']");  //Account
//	
//	
//	
//	/**首页-购物车链接*/
//	public static final By HP_LINK_CART = By.xpath("//*[@class='label' and text()='Cart']");
//	
//	/**欢迎信息*/
//	public static final By HP_TEXT_WELCOME = By.className("welcome-msg");
//	/**搜索框*/
//	public static final By HP_INPUT_SEARCH = By.id("search");
//	/**分类*/
//	public static final By HP_LINK_CLASSIFY = By.cssSelector("a.level0.has-children");
//
//	/**VIP链接*/
//	public static final By HP_LINK_VIP = By.linkText("VIP");
//	/**搜索按钮*/
//	public static final By HP_BUTTON_SEARCH = By.xpath("//*[@id='search_mini_form']//button");
//	
//	
	
	//以下元素是点击了account元素才显示出来的
	
	/**首页-账户下的登录链接*/
	public static final By HP_LINK_LOGIN = By.linkText("登录");
	
	
	//以下元素是点击了account元素才显示出来的
	
	
}
