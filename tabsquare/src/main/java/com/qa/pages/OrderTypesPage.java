package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.BaseClass;

public class OrderTypesPage extends BaseClass{

	@FindBy(css ="a[data-text=\"Dine In\"]")
	public WebElement DineInOption;
	
	//Initialize page Elements
	public OrderTypesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnOrderType(String orderType) {
		String OrderName = "a[data-text=\"%s\"]";
		WebElement element =  driver.findElement(By.cssSelector(String.format(OrderName, orderType)));
		Click(element);
	}
}
