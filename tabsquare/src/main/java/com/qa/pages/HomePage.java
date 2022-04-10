package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.qa.util.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(css =".tab-sec section .list-item")
	public WebElement Menupanel;
	
	@FindBy(css =".add-sku-btn")
	public WebElement AddItem;
	
	@FindBy(id ="checkoutButton")
	public WebElement GoToCheckoutButton;
	
	@FindBy(css =".to-plus.btn-primary.test")
	public WebElement Plusbutton;
	
	@FindBy(css ="#checkoutButton .text-primary")
	public WebElement CheckoutQty;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void addItem(int number, int qty) throws InterruptedException {
		waitForElementVisibility(Menupanel);
		String itemNumberSelector = ".list-item li:nth-child(%d) .add-btn";
		Click(driver.findElement(By.cssSelector(String.format(itemNumberSelector, number))));
		waitForElementVisibility(AddItem);
		Click(AddItem);
		waitForElementVisibility(GoToCheckoutButton);
		ScrollDownPage();
		for(int i=2; i<=qty; i++) {
			Click(Plusbutton);
			String value = "(//div[@class=\"add-val\" and contains(text(), %d)])[4]";
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(value, i))));
		}
	}
	
	public void verifyQuantity(String qty) {
		Assert.assertEquals(CheckoutQty.getAttribute("innerText"), qty);
	}
	
	public void clickOnCheckout() {
		Click(GoToCheckoutButton);
	}
	
}
