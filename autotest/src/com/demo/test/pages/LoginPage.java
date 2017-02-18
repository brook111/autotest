package com.demo.test.pages;

import org.openqa.selenium.By;
/**
 * @author Young
 * @description 登录页面元素定位声明
 * */
public class LoginPage {
	/**用户名输入框*/
	public static final By LP_INPUT_USERNAME = By.name("username");
	
	/**密码输入框*/
	public static final By LP_INPUT_PASSWORD = By.name("password");
	
	/**登录按钮*/
	public static final By LP_BUTTON_LOGIN = By.name("login");
	
	/**登录错误信息*/
	public static final By LP_TEXT_ERROR= By.xpath("//*[@color='red']");

	
	
}
