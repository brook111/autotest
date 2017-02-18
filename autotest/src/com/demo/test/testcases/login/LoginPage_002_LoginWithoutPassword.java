package com.demo.test.testcases.login;
import java.util.Map;

import org.testng.annotations.Test;

import com.demo.test.base.BaseParpare;
import com.demo.test.pageshelper.LoginPageHelper;
/**
 * @author Young
 * @description 登录的时候不输入密码，只输入用户名，点击登录提示：Web Tours Error - Incorrect Password
 * */

public class LoginPage_002_LoginWithoutPassword extends BaseParpare{
  @Test(dataProvider="testData")
  public void loginWithoutPassword(Map<String, String> data) {
	  //等待登录页面加载
	  LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
	  // 输入登录信息
	  LoginPageHelper.typeLoginInfo(seleniumUtil,data.get("USERNAME"), data.get("PASSWORD"));
	  //验证登录失败信息
	  LoginPageHelper.checkLoginErrorInfo(seleniumUtil, data.get("ERROR"));

  }
}
