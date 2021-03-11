package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewsLetterPage {
	WebDriver driver;
	
	 private By newsLetter = By.id("newsLetter");
	public NewsLetterPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public void newsLetter() {
		System.out.println("News letter page  displayed");
	}

}
