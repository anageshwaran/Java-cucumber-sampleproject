package com.jupiter.tests;

import org.openqa.selenium.WebDriver;
import com.planittesting.ioc.ObjectContainer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDef {
	private ObjectContainer container;
	protected WebDriver driver;
	private HomePage homepage;
	private ShopPage shoppg;

	public HomePageStepDef(ObjectContainer container) {
		this.container = container;
	}

	@Given("^the user is at the homepage$")
	public void the_user_is_at_the_homepage() {
		driver = this.container.resolve(WebDriver.class);
		homepage = new HomePage(driver);
		homepage.clickHomeMenu();
	}

	@When("^the user clicks the start shopping button$")
	public void the_user_clicks_the_start_shopping_button() {
		homepage.clickStartShopping();
	}

	@Then("^the user should be navigated to the shoppage$")
	public void the_user_should_be_navigated_to_the_shoppage() {
//		shoppage = new ShopPage(driver);
//		shoppage.verifyShopPage("http://jupiter.cloud.planittesting.com/#/shop");
		shoppg = new ShopPage(driver);
		shoppg.verifyShopPage("http://jupiter.cloud.planittesting.com/#/shop");
	}

	@And ("^the user is not logged in$") 
	public boolean the_user_is_not_logged_in() {
		boolean check = homepage.verifyIfLoggedIn();
		if(check)
		{
			homepage.clickLogoutLink();
			LogoutPopup logoutpopup = new LogoutPopup(driver);
			logoutpopup.confirmLogout();
			return true;
		}
		return false;
	}


}
