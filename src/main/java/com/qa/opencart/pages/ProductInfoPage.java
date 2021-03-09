package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class ProductInfoPage {
	
	ElementUtil elementUtil;
	private By productName = By.cssSelector("div#content h1");
	private By productThumbnailsImage = By.cssSelector("li.image-additional");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By productQuantity = By.id("input-quantity");
	private By productAddToCartBtn = By.id("button-cart");
	private By successMessage = By.xpath("//div[@id='product-product']/div[position()=1]");
	
	public ProductInfoPage(WebDriver driver) {
		elementUtil = new ElementUtil(driver);
	}
	@Step("getting product header text")
	public String getProductHeaderText() {
		return elementUtil.doGetText(productName).trim();
	}
	@Step("getting product thumbnailImagesCount ")
	public int getProductThumbnailImagesCount() {
		return elementUtil.getElements(productThumbnailsImage).size();
	}
	@Step("getting product information")
	public Map<String, String> getProductInformation() {
		Map<String,String> productInfoMap = new HashMap<String,String>();
		productInfoMap.put("name", getProductHeaderText());
		List<WebElement> productMetaDataList = elementUtil.getElements(productMetaData);
		System.out.println("total productMetaData displayed:" +productMetaDataList.size());
		
		for(WebElement e: productMetaDataList) {
			String meta[] = e.getText().split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
		
		List<WebElement> productPriceList = elementUtil.getElements(productPriceData);
		productInfoMap.put("price", productPriceList.get(0).getText().trim());
		productInfoMap.put("exPriceTax", productPriceList.get(1).getText().split(":")[1].trim());
		
		return productInfoMap;
			
		}
	@Step("select product Quantity")
	public void selectQuantity(String Qty) {
		elementUtil.doSendKeys(productQuantity, Qty);
	}
	
	@Step("select button to add products")
	public void selectAddtoCartBtn() {
		elementUtil.doClick(productAddToCartBtn);
	}
	
	@Step("Success message displayed after product added in the cart")
	public String getSuccessMessage() {
		return elementUtil.doGetText(successMessage);
		
		
	}

}
