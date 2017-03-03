package com.jupiter.tests;

import org.openqa.selenium.WebDriver;

import com.planittesting.ioc.ObjectContainer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CartPageStepDef {
	private ObjectContainer container;
	protected WebDriver driver;
	private CartPage cartpage;

	public CartPageStepDef(ObjectContainer container) {
		this.container = container;
	}

	@And("^the user clicks the cartmenu$")
	public void the_user_clicks_the_cartmenu() {
		
		driver = this.container.resolve(WebDriver.class);
		
		cartpage = new CartPage(driver);
		cartpage.clickCartLink();
	}

	@Then("^verify the sum of subtotal of items in the cart equals the total$")
	public void verify_the_sum_of_subtotal_of_items_in_the_cart_equals_the_total() {
		cartpage.verifyTotal();	
	}

	@And("^the user deletes an item from the cart$")
	public void the_user_deletes_an_item_from_the_cart() {
		cartpage.delete("Stuffed Frog");
	}

	@And("^the user confirms to delete an item$")
	public void the_user_confirms_to_delete_an_item() {
		cartpage.deleteConfirmation(true);
	}

	@And("^the user confirms not to delete an item$")
	public void the_user_confirms_not_to_delete_an_item() {
		cartpage.deleteConfirmation(false);
	}

	@Then ("^verify the sum of quantity of items in the cart equals the quantity in cartmenu$")
	public void verify_the_sum_of_quantity_of_items_in_the_cart_equals_the_quantity_in_cartmenu() {
		cartpage.verifyQuantity();
	}
}
