package com.jupiter.tests;

import org.openqa.selenium.WebDriver;

import com.planittesting.ioc.ObjectContainer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShopPageStepDef { 

	private ObjectContainer container;
	private ShopPage shoppg;
	protected WebDriver driver;

	public ShopPageStepDef(ObjectContainer container) {
		this.container = container;
	}

	@Given("^the user clicks the shopmenu$")
	public void the_user_clicks_the_shopmenu() {
		driver = this.container.resolve(WebDriver.class);
		shoppg = new ShopPage(driver);
		shoppg.clickShopMenu();
	}

	@When("^the user adds product (.*) to the cart multiple times (.*)$")
	public void the_user_adds_product_to_the_cart_multiple_times(String productToClick, String count) {
		driver = this.container.resolve(WebDriver.class);
//		shoppg = new ShopPage(driver);
		shoppg.clickBuy(Integer.parseInt(count), productToClick);
	}

	@Then("^verify the cart count updated to quantity (.*)$")
	public void verify_the_cart_count_update_to_correct_quantity(String quantity) {
		shoppg.verifyQuantityInCartMenu(quantity);
	}


	@When("^the user adds multiple product to the cart (.*)$")
	public void the_user_adds_multiple_product_to_the_cart(String products) {
		String[] productsToClick = products.split(",");
		shoppg.clickBuy(productsToClick);
	}


	@When("^the user adds product to the cart (.*)$")
	public void the_user_adds_product_to_the_cart(String product) {
		shoppg.clickBuy(product);
	}

	@When("^verifies the price (.*) for the product (.*)$")
	public void the_user_find_the_product(String price, String product) {
		shoppg.verifyProductPrice(price, product);

	}

	@And ("^the cart is empty$")
	public void the_cart_is_empty() {
		driver = this.container.resolve(WebDriver.class);
		CartPage cartpage = new CartPage(driver);
		cartpage.emptyCart();
	}
}

