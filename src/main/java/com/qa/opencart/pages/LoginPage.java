package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	private ElementUtil elementUtil;
	private WebDriver driver;
	
	//Page objects -By Locator -OR
	
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgotPassword = By.xpath("//div[@class='form-group']/a[text()='Forgotten Password']");
	private By registerLink = By.linkText("Register");
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Page feature or Page actions:
	@Step("getting login page tite")
	public String getLoginPageTitle() {
	return elementUtil.waitForTitleIs(10, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Step("checking forgotpassword link")
	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPassword);
	}
	
	@Step("loginwith username: {0} and password: {1}")
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " +un +" :"+pwd);
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountsPage(driver);
		
	}
	
	@Step("navigating to register page")
	public RegisterPage1 navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegisterPage1(driver);
	}

	

}
