package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Story("US-301: Design the product Info page for product deatils & add to cart design")
@Epic("Epic-100: Design product info page feature")
public class ProductInfoPageTest  extends BaseTest{
	SoftAssert softAssert = new SoftAssert();
	//Constants const = new Constants();
	
	@BeforeClass
	public void AccsetUp() {
		accPage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Description("Product info data test")
    @Severity(SeverityLevel.CRITICAL)
	@Test(priority =1)
	public void productInfoDataTest() {
		searchResultPage=accPage.doSearch("Macbook");
		productInfoPage=searchResultPage.selectProductFromResults("MacBook Pro");
		Map<String,String> actualProductInfoMap=productInfoPage.getProductInformation();
		
		softAssert.assertTrue(actualProductInfoMap.get("name").equals("MacBook Pro"));
		softAssert.assertTrue(actualProductInfoMap.get("Brand").equals("Apple"));
		softAssert.assertTrue(actualProductInfoMap.get("price").equals("$2,000.00"));
		softAssert.assertAll();
	}
	
	@Description("Product added in the cart")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=2)
	public void productAddedInCart() {
//		searchResultPage=accPage.doSearch("Macbook");
//		productInfoPage=searchResultPage.selectProductFromResults("MacBook Pro");
		productInfoPage.selectQuantity("2");
		productInfoPage.selectAddtoCartBtn();
		System.out.println(productInfoPage.getSuccessMessage());
		//Assert.assertEquals(productInfoPage.getSuccessMessage(), Constants.PRODUCT_ADDTOCART_SUCCESS_MESSAGE);
		
		
	}
}
