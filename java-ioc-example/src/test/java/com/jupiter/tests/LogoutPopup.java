package com.jupiter.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogoutPopup extends BasePage {

	public LogoutPopup(WebDriver driver) {
		super(driver);
	}

	public void confirmLogout() {
		pathToClickElement(By.cssSelector(".popup .btn-success"));
	}

	public void verifySuccessfullLogout() {
		String actualpage = driver.getCurrentUrl();
		boolean actualmenu = driver.findElement(By.id("nav-login")).isDisplayed();
		Assert.assertTrue("Not returned to homepage after successfull logout", actualpage.trim().equalsIgnoreCase(("http://jupiter.cloud.planittesting.com/#/home").trim()));
		Assert.assertTrue("Usermenu not changed to loginmenu", actualmenu);

	}
}
