package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	
	 private By cartBtn = By.id("cartbutton");
	public CartPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public void cartBtn() {
		System.out.println("cart button displayed");
	}

}
