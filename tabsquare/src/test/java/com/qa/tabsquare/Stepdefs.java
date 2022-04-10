package com.qa.tabsquare;

import java.util.List;
import java.util.Map;

import com.qa.pages.CartPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.OrderTypesPage;
import com.qa.util.BaseClass;

import cucumber.api.java.en.Given;

public class Stepdefs extends BaseClass {

	LoginPage login = new LoginPage();
	OrderTypesPage orderType = new OrderTypesPage();
	HomePage home = new HomePage();
	CartPage cart = new CartPage();

	@Given("^I am on the \"([^\"]*)\" page$")
	public void loginpage(String page) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		login.AssertonPage(page);
	}
	
	@Given("^I logged in with below detail$")
	public void i_logged_in_with_below_detail(List<Map<String, String>> table) throws Throwable {
	    login.EnteruserNameAndPassword(table);
	}
	
	@Given("^I click on login button$")
	public void i_clicked_on_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    login.ClickOnLogin();
	}
	
	@Given("^I choose \"([^\"]*)\" order type$")
	public void i_choose_order_type(String orderTypeName) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    orderType.ClickOnOrderType(orderTypeName);
	}
	
	@Given("^I add (\\d+)st item into cart with (\\d+) quantity$")
	public void i_add_st_item_into_cart(int num, int qty) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    home.addItem(num, qty);
	}
	
	@Given("^I can see (\\d+) quantity in cart$")
	public void i_can_see_quantity_in_cart(int qty) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    home.verifyQuantity(Integer.toString(qty));
	}
	
	@Given("^I click on the checkout button$")
	public void i_click_on_the_checkout_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    home.clickOnCheckout();
	}
	
	@Given("^I select \"([^\"]*)\" button$")
	public void i_select_button(String name) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		clickOnFieldWithText(name);
	}
	
	@Given("^I can See order success message \"([^\"]*)\"$")
	public void i_can_See_order_success_message(String message) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    cart.VerifyOrderSuccessMessage(message);
	}
	
	@Given("^I can see generated oder Id$")
	public void check_OrderId() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    cart.checkOrderNumber();
	}
}
