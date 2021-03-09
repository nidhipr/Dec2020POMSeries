package com.qa.opencart.tests;

import java.util.List;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Error;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Story("US-201: Design the account page for opencart application to check account page design & search feature")
@Epic("Epic-200:Design account page feature")

public class AccountPageTest extends BaseTest{
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void acctSetUp() {
		//link the object with account page reference.
		//now the reference is pointing to this object.
		accPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Description("Account page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void acctPageTitleTest() {
		String title = accPage.getAcctPageTitle();
		System.out.println("home page title: " +title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);	
	}
	@Description("Account page logo test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void acctPagelogoTest() {
		Assert.assertTrue(accPage.isLogoExist());
		
	}
	@Description("Account page section count test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3)
	public void acctPageSectionCountTest() {
		Assert.assertEquals(accPage.getAcctPageHeaderCount(), Constants.ACCOUNT_HEADER_COUNT);
	}

	@Test(priority = 4)
	public void  acctPageSectionTest() {
		List<String> actualAcctSectionList = accPage.getAcctPageHeaderList();
		System.out.println(actualAcctSectionList);
		Assert.assertEquals(actualAcctSectionList, Constants.getExpectedAcctSectionList());	
	}
	@Description("Search test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 5)
	public void searchTest() {
	//accPage =loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    searchResultPage = accPage.doSearch("macbook");
    Assert.assertTrue(searchResultPage.getProductResultsCount()>0, Error.SEARCH_NOTSUCCESSFUl);
}
	@Description("Select product test")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 6)
	public void selectProductTest() {
		//searchResultPage = accPage.doSearch("macbook");
		productInfoPage = searchResultPage.selectProductFromResults("MacBook Pro");
		String actualHeader = productInfoPage.getProductHeaderText();
	/*
	 * soft Assertion is when in same method we have more than one assertion.
	 * It is not good practice to have multiple assertion in same method.
	 * good progammer write single assertion assertion in one test.
	 */
		softAssert.assertEquals(actualHeader, "MacBook Pro", Error.PRODUCT_HEADER_NOT_FOUND);
		softAssert.assertEquals(productInfoPage.getProductThumbnailImagesCount(), Constants.PRODUCT_THUMBNAIL_IMAGE_COUNT);
	    softAssert.assertAll();
		
		}
	
}
