package com.qa.opencart.tests;



import static org.testng.Assert.assertEquals;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Story("US-101: Design the login page for demo opencart application with login , title & forward link")
@Epic("Epic-100: Design login page feature")

public class LoginPageTest extends BaseTest {
   @Description("Login page title test")
   @Severity(SeverityLevel.NORMAL)
   @Test(priority = 1)
	public void loginPageTitleTest() {
	  String title =loginpage.getLoginPageTitle();
	  System.out.println("title of the page: " +title);
	  Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
   }
   @Description("Forward password link test")
   @Severity(SeverityLevel.CRITICAL)
   @Test(priority = 2)
   public void forgotPasswordLinkTest() {
	   Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	   
   }
   @Description("login test with correct credentials")
   @Severity(SeverityLevel.BLOCKER)
   @Test(priority = 3)
   public void loginTest() {
	  accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	  Assert.assertEquals(accPage.getAcctPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
   }
   
  
		
		
		
		
	

}
