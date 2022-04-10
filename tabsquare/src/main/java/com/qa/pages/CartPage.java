package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.util.BaseClass;

public class CartPage extends BaseClass {
	
	@FindBy(css=".bottom-link.mkPayment")
	public WebElement PayByCashButoon;
	
	@FindBy(css=".order-sent p")
	public WebElement OrderSucessMessage;
	
	@FindBy(xpath ="//td[contains(text(), \"Order ID\")]/span")
	public WebElement OrderId;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void VerifyOrderSuccessMessage(String message) {
		waitForElementVisibility(OrderSucessMessage);
		Assert.assertEquals(OrderSucessMessage.getText(), message);
	}

	public void checkOrderNumber() {
		waitForElementVisibility(OrderId);
		Assert.assertTrue(OrderId.getText().matches("^[0-9]{9}$"));
	}
}
