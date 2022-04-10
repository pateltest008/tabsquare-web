package com.qa.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.BaseClass;
//import org.testng.Assert;

public class LoginPage extends BaseClass {
	
	@FindBy(css=".btn-login")
	public WebElement loginButton;
	
	@FindBy(css="span[id*=country_code]")
	public WebElement CountryCodeDropdown;
	
	@FindBy(css="input[class*=search__field]")
	public WebElement SearchCountryTextbox;
	
	@FindBy(css ="input[name=\"mobile_no\"]")
	public WebElement MobileNumberTextBox;
	
	//Initialize page Elements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	

	
	public void ClickOnLogin() {
		loginButton.click();
	}
	
	public void EnteruserNameAndPassword(List<Map<String, String>> table) {
		Click(CountryCodeDropdown);
		for(Map<String, String> map : table) {
			EnterValueInTextBox(SearchCountryTextbox, map.get("CountryCode"));
			Click(GetCountryCode(map.get("CountryCode")));
			EnterValueInTextBox(MobileNumberTextBox, map.get("Number"));
		}
		
	}
}
