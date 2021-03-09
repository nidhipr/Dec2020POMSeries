package com.qa.opencart.utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class ElementUtil {
	
	private WebDriver driver;
	//private Actions act;
	private JavaScriptUtil JsUtil;
	

	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	//	act = new Actions(this.driver);
		JsUtil = new JavaScriptUtil(this.driver);
	}
	
	public WebElement getElement(By locator) {
		
		WebElement ele = driver.findElement(locator);
		if(Boolean.parseBoolean(DriverFactory.highlight)) {
			JsUtil.flash(ele);
			
		}
		return ele;
	}
	
	public List<WebElement> getElements(By locator) {
		return	driver.findElements(locator);
		}

	public void doSendKeys(By locator, String value) {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
		
	}
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	//*******************dropdownselect**************
	
	public void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public void doSelectByVisibleText(By locator,String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	public void doSelectByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public  List<String> getDropDownOptionList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> option=select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		System.out.println(option.size());
		for(WebElement e: option) {
			optionsTextList.add(e.getText());
	}
			return optionsTextList;
	}
	
	public  void doSelectByTextOption(By locator,String text) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionList=select.getOptions();
		
		for(WebElement e: optionList) {
			if(e.getText().equals(text));
			e.click();
			break;	
	}
	}
	
	   public void doSelectDropDownWithoutSelectClass(By locator ,String value)	{
		   List<WebElement> optionList = getElements(locator);
		   for(WebElement e: optionList) {
			   if(e.getText().equals(value)) {
				   e.click();
				   break;
				   
			   }
	   }

	}
	   //************************Actions Class Utils***************************
	   
	   public void doMoveToElement(By locator) {
		     Actions act = new Actions(driver);
			act.moveToElement(getElement(locator)).perform();
			act.moveToElement(getElement(locator)).perform();
	 }
	   public void doMoveToElement(By locator1, By locator2) {
		     Actions act = new Actions(driver);
			act.moveToElement(getElement(locator1)).perform();
			act.moveToElement(getElement(locator2)).perform();
	 }
       public void doMoveToElement(By locator1, By locator2,By locator3) {
		    Actions act = new Actions(driver);
			act.moveToElement(getElement(locator1)).perform();
			act.moveToElement(getElement(locator2)).perform();
			doClick(locator3);
	 }
       
      // **************************Calendar Util*******************************************
       
       public void selectDate(String day,String tagName) {
    	   String xpath = "//"+tagName+"[text()='"+day+"']";
    	   doClick(By.xpath(xpath));
       }
   	
   	
   	
   	public void selectDate(By locator,String day ) {
   		boolean flag = false;
          List<WebElement> daysList = getElements(locator);
          for(WebElement e: daysList) {
   			if(e.getText().equals(day)) {
   				e.click();
   				flag= true;
   				break;
   	}
   					
          }
          if(!flag) {
       	   System.out.println("wrong date...."+day);
          }
   	}
   	
   	//**************************Wait Util*************************
   	public WebElement waitForPresenceOfElement(By locator, long timeOut) {
		 WebDriverWait wait = new WebDriverWait(driver,timeOut);
	     return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
   	
   	public String waitForTitleContains(int timeOut, String title ) {
   	 WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.titleContains(title));
   	return driver.getTitle(); 
    }
    
    public String waitForTitleIs(int timeOut, String title) {
   	 WebDriverWait wait = new WebDriverWait(driver,timeOut);
	 	 wait.until(ExpectedConditions.titleIs(title)); 
	 	return driver.getTitle();
    }
    
    public Boolean waitForTitle(int timeOut, String title) {
   	 WebDriverWait wait = new WebDriverWait(driver,timeOut);
	 	return wait.until(ExpectedConditions.titleIs(title)); 
	 	
    }
    
    /**
	 * An expectation for  checkig that an element known to be present on DOM of the page is visible.
	 * visiblity means that element is not only displayed but also has height & width greater than zero.
     * @return 
	 *
	 */
	
	public WebElement waitVisibilityOfElement(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	public List<WebElement> waitForVisiblityOfElements(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public WebElement waitForElementToBeClickable(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
    
	public boolean waitForElementTextToBe(By locator ,int timeOut, String text) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.textToBe(locator, text));
	}
	
	
	public void printElementsText(int timeOut, By locator) {
		waitForVisiblityOfElements(timeOut,locator)
		                .stream()
		                        .forEach(ele -> System.out.println(ele.getText()));
	}
	public boolean waitForUrlToBe(int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.urlContains(urlValue));
		
	}
	
	public boolean waitForExactUrlToBe(int timeOut, String url) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlToBe(url));
	}
	
	/**
	 * An expectation of checking if the given element to be selected.
	 * @param timeOut
	 * @param locator
	 * @return
	 */
	
	public boolean waitForElementToBeSelected(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	
	public void waitForFrameToBeAvailable(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public void waitForFrameToBeAvailable(int timeOut, String nameOrId) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
	}
	
	public void waitForFrameToBeAvailable(int timeOut, int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
}
