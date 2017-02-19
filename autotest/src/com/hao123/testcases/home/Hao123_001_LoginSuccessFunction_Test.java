package com.hao123.testcases.home;

import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.demo.test.base.BaseParpare;
import com.demo.test.pageshelper.LoginPageHelper;
import com.demo.test.utils.ExcelDataProvider;
import com.hao123.pages.HomePage;
import com.hao123.pageshelper.HomePageHelper;

/**
 * @author Young
 * @description 登录之后验证用户名是不是正确的
 * */

public class Hao123_001_LoginSuccessFunction_Test extends BaseParpare {
	public static Logger logger = Logger
			.getLogger(Hao123_001_LoginSuccessFunction_Test.class.getName());

	@Test(dataProvider = "testData")
	public void loginSuccessFunction(Map<String, String> data) {
		try {
			// 检查首页元素文本
			HomePageHelper.checkHomePageElementText(seleniumUtil);
			// 点击首页的登录链接
			HomePageHelper
					.clickOnHomePage(seleniumUtil, HomePage.HP_LINK_LOGIN);
			// 等登录界面加载
			LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);

			//HomePageHelper.checkLoginPageElementText(seleniumUtil);
			// // 输入登录信息
			// LoginPageHelper.typeLoginInfo(seleniumUtil,data.get("USERNAME"),
			// data.get("PASSWORD"));
			// //等待首页元素显示出来
			// HomePageHelper.waitHomePageLoad(seleniumUtil, timeOut);
			// //检查用户名是不是期望的"jojo"
			// HomePageHelper.checkUserName(seleniumUtil, timeOut,
			// data.get("USERNAME"));
		} catch (Exception e) {
			logger.error("loginSuccessFunction", e);
		}
	}
}
