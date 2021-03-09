package com.qa.opencart.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.pages.ProductInfoPage;

public class Constants {
	
    public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final int  ACCOUNT_HEADER_COUNT = 4 ;
	public static final int  PRODUCT_THUMBNAIL_IMAGE_COUNT = 3 ;
	public static final String ACCOUNT_CREATION_SUCCESS_MESG = "Your Account Has Been Created!";
	
	// ************************SheetName************************************
	public static final String REGISTER_SHEET_NAME = "register";
	
	
	public static  List<String> getExpectedAcctSectionList() {
		List<String> exeAcctList = new ArrayList<String>();
		exeAcctList.add("My Account");
		exeAcctList.add("My Orders");
		exeAcctList.add("My Affiliate Account");
		exeAcctList.add("Newsletter");
		return exeAcctList;
		
	}
}
