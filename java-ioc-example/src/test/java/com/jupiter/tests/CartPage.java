package com.jupiter.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

	private CartTable carttable;

	public CartPage(WebDriver driver) {
		super(driver);
		carttable = new CartTable(driver);
	}


	public void verifyTotal() {
		String actualTotalPath = driver.findElement(By.cssSelector(".total")).getText().substring(6);
		Double actualTotal = Double.parseDouble(actualTotalPath);
		Double expectedTotal = carttable.getTotal("Subtotal");
		Assert.assertEquals("Total is wrong", actualTotal, expectedTotal);
	}


	public void delete(String product) {
		carttable.deleteItem(product);
	}

	public void deleteConfirmation(boolean delete) {
		if(delete) {
			pathToClickElement(By.cssSelector(".popup .btn-success"));
		}
		else {
			pathToClickElement(By.cssSelector(".popup .btn-cancel"));
		}
	}

	public void verifyQuantity() {
		int totalQuantityInCart = carttable.getCartQuantity("Quantity");
		int totalQuantityInCartMenu =carttable.getCartMenuQuantity();
		Assert.assertTrue("Quantity in cart and cartmenu are not equals", totalQuantityInCart==totalQuantityInCartMenu);

	}


	public void emptyCart() {
		if(carttable.getCartMenuQuantity()>0) {
			clickCartLink();
			pathToClickElement(By.linkText("Empty Cart"));
			pathToClickElement(By.cssSelector(".popup .btn-success"));
		}
	}

}
