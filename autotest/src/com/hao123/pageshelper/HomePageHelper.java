package com.hao123.pageshelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.demo.test.utils.SeleniumUtil;
import com.hao123.pages.HomePage;
import com.hao123.pages.LoginHaoPage;

/**
 * @author Young
 * @desciption 首页帮助类：专门提供在这个页面进行操作的方法封装*/
public class HomePageHelper {
	//提供本类中日志输出对象
	public static Logger logger = Logger.getLogger(HomePageHelper.class);
	
	/**
	 * @author Young
	 * @description 等待首页元素加载
	 * @param seleniumUtil selenium api封装引用对象
	 * @param timeOut 等待元素超时的时间
	 * */
	public static void waitHomePageLoad(SeleniumUtil seleniumUtil,int timeOut){
		logger.info("开始等待首页元素加载");
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_LOGIN);
//		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_CART);
//		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_WELCOME);
//		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_INPUT_SEARCH);
//		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_VIP);
//		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_LINK_CLASSIFY);
//		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_BUTTON_SEARCH);
		//这里其实还有很多可以等待的元素，在这里省略掉了，大家可以自行添加，这个只是演示思路
		logger.info("首页元素加载完毕");
		
	}
	
	/**@author Young
	 * @description 检查首页元素文本
	 * @param seleniumUtil selenium api封装引用对象
	 * 
	 * */
	public static void checkHomePageElementText(SeleniumUtil seleniumUtil){
		logger.info("开始检测首页元素的文本是不是正确的");
		seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_LINK_LOGIN).toLowerCase(), "登录".toLowerCase());
//		seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_LINK_CART).toLowerCase(), "CART".toLowerCase());
//		seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_TEXT_WELCOME).toLowerCase(), "WELCOME".toLowerCase());
//		seleniumUtil.isTextCorrect(seleniumUtil.getAttributeText(HomePage.HP_INPUT_SEARCH, "placeholder").toLowerCase(), "Search entire store here...".toLowerCase());
//		String classify[]={"Women","Men","Accessories","Home & Decor","Sale"};
//		for (int i = 0; i < classify.length; i++) {
//			seleniumUtil.isTextCorrect(seleniumUtil.findElementsBy(HomePage.HP_LINK_CLASSIFY).get(i).getText().trim().toLowerCase(), classify[i].toLowerCase());
//		}
		//seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_LINK_VIP), "VIP");
		logger.info("检查首页元素文本完成");
	}
	/**@author brook
	 * @description 检查登录元素文本
	 * @param seleniumUtil selenium api封装引用对象
	 * 
	 * */
	public static void checkLoginPageElementText(SeleniumUtil seleniumUtil){
		logger.info("开始检测 登录 页 元素的文本是不是正确的");
			
		String username=seleniumUtil.getAttributeText(LoginHaoPage.LP_INPUT_USERNAME, "placeholder");
		String password =seleniumUtil.getAttributeText(LoginHaoPage.LP_INPUT_PASSWORD, "placeholder");
		seleniumUtil.isTextCorrect(username, "手机/邮箱/用户名");
		seleniumUtil.isTextCorrect(password, "密码");
		
		logger.info("检查登录页 元素文本完成");
	}
	
	/**@author Young
	 * @description 首页上点击方法-只限点击首页上的内容
	 * @param selenium api封装引用对象
	 * @param byElement 要点的元素定位
	 * */
	public static void clickOnHomePage(SeleniumUtil seleniumUtil,By byElement ){
		
		seleniumUtil.click(byElement);
		logger.info("点击 登录  完成");
	}
	
	/**
	 * @author Young
	 * @description 验证用户名是不是正确的
	 * @param seleniumUtil api封装引用对象
	 * @param firstName 姓
	 * @param secondName 名
	 * */
	public static void checkUserName(SeleniumUtil seleniumUtil,String fullName,int timeOut){
		seleniumUtil.pause(1000);
		waitHomePageLoad(seleniumUtil, timeOut);
	//k	seleniumUtil.isTextCorrect(seleniumUtil.getText(HomePage.HP_TEXT_WELCOME), "WELCOME, "+fullName+"!");
	}
	
	/**输入关键字点击搜索按钮*/
	public static void keywordSearch(SeleniumUtil seleniumUtil,String keyword){
		logger.info("开始进行关键字搜索操作");
//		seleniumUtil.type(HomePage.HP_INPUT_SEARCH, keyword);
//		seleniumUtil.click(HomePage.HP_BUTTON_SEARCH);
	}

}
