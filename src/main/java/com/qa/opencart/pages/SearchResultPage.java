package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class SearchResultPage {
	
	ElementUtil elementUtil;
	private WebDriver driver;
	
	By searchItemResult = By.cssSelector("div.product-layout div.product-thumb ");
	By resultItems = By.cssSelector("div.product-thumb h4 a");
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
	@Step("getting product result count")
	public int getProductResultsCount() {
		return elementUtil.getElements(searchItemResult).size();
		
	}
	
	@Step("select product from the result")
	public ProductInfoPage selectProductFromResults(String productName) {
		List<WebElement> resultItemsList=elementUtil.getElements(resultItems);
		System.out.println("total number of Items displayed : " + 
		productName  + ":" + resultItemsList.size());
		for(WebElement e: resultItemsList ) {
			if(e.getText().equalsIgnoreCase(productName)) {
				e.click();
				break;
			}
		}
		
		return new ProductInfoPage(driver);
	}

}
