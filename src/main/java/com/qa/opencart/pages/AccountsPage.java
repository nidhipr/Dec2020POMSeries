package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class AccountsPage {
	private WebDriver driver;
	
	ElementUtil elementUtil;
	private By logo = By.id("logo");
	private By acctHeader = By.xpath("//div[@id='content']/h2");
	private By searchField = By.name("search");
	private By searchBtn = By.xpath("//span[@class='input-group-btn']/button");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	@Step("getting account page title")
	public String getAcctPageTitle() {
		return elementUtil.waitForTitleIs(10, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Step("checking logo in the page")
	public boolean isLogoExist() {
		return elementUtil.doIsDisplayed(logo);
	}
	
	@Step("getting account page header count")
	public int getAcctPageHeaderCount() {
		return elementUtil.getElements(acctHeader).size();
	}
	@Step("getting account page header name")
	public List<String> getAcctPageHeaderList() {
		List<WebElement> accList=elementUtil.getElements(acctHeader);
		List<String> accSectionList = new ArrayList<String>();
		for(WebElement e : accList) {
			accSectionList.add(e.getText());
			
		}
		return accSectionList;
	}
	
	@Step("search the product")
	public SearchResultPage doSearch(String productName) {
		System.out.println("Searching for the product: " +productName);
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchBtn);
		return new SearchResultPage(driver);
	}
	
	

}
