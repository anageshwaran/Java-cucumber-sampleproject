package com.jupiter.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void pathToClickElement(By selector) {
		driver.findElement(selector).click();	
	}

	public HomePage clickHomeMenu() {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-home")));
		
		pathToClickElement(By.id("nav-home"));
		return new HomePage(driver);
	}

	public ShopPage clickShopMenu() {
		pathToClickElement(By.id("nav-shop"));
		return new ShopPage(driver);
	}

	public ContactPage clickContactLink() {
		pathToClickElement(By.id("nav-contact"));
		return new ContactPage(driver);
	}

	public CartPage clickCartLink() {
		pathToClickElement(By.id("nav-cart"));
		return new CartPage(driver);
	}

	public LoginPopup clickLoginLink() {
		pathToClickElement(By.id("nav-login"));
		return new LoginPopup(driver);
	}

	public UserPage clickUserLink() {
		pathToClickElement(By.id("nav-user"));
		return new UserPage(driver);
	}

	public LogoutPopup clickLogoutLink() {
		pathToClickElement(By.id("nav-logout"));
		return new LogoutPopup(driver);
	}

	public void setTextToElement(By selector, String sendvalue) {
		driver.findElement(selector).click();
		driver.findElement(selector).clear();
		driver.findElement(selector).sendKeys(sendvalue);
	}

	public boolean verifyIfLoggedIn() {
		if(driver.findElement(By.id("nav-logout")).isDisplayed()) {
			return true;
		}
		return false;
	}
}
