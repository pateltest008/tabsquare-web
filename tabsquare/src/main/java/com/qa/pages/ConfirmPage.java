package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.BaseClass;

public class ConfirmPage extends BaseClass {
	
	@FindBy(css=".order-sent p")
	public WebElement OrderSuccessMessage;
	
	public ConfirmPage() {
		PageFactory.initElements(driver, this);
	}	

}
