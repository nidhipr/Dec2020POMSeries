package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterPage1;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Error;
import com.qa.opencart.utils.ExcelUtil1;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Story("US-401: Registartion page design for open cart application")
@Epic("Epic-400: Registter account feature")

public class RegisterPageTest1 extends BaseTest{

	
	@BeforeClass
	public void setupRegister() {
	registerPage1 = loginpage.navigateToRegisterPage();		
	}
	
	@DataProvider
	public Object[][] getRegisterData() {
		 Object data [][] = ExcelUtil1.getTestData(Constants.REGISTER_SHEET_NAME);
		 return data;
	}
	
    @Description("getting register data")
    @Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "getRegisterData")
	public void userRegisterTest(String firstName, String lastName, String email, String telephone,String password, String subscribe) {
		Assert.assertTrue(registerPage1.accountRegistration(firstName, lastName, email, telephone, password, subscribe), Error.REGISTER_FAILED_MESG);
				
		
	}

}
