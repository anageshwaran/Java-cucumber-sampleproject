package com.jupiter.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public ShopPage clickStartShopping() {
		pathToClickElement(By.partialLinkText("Start Shopping"));
		return new ShopPage(driver);
	}

}
