package com.jupiter.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPopup extends BasePage {

	public LoginPopup(WebDriver driver) {
		super(driver);
	}

	public void setUsername(String sendkeys) {
		setTextToElement(By.id("loginUserName"), sendkeys);
	}
	public void setPassword(String sendkeys) {
		setTextToElement(By.id("loginPassword"), sendkeys);
	}

	public void clickLogin() {
		pathToClickElement(By.cssSelector(".popup .btn-primary"));
	}

	public void clickCancel() {
		pathToClickElement(By.cssSelector(".btn-cancel"));
	}

	public void verifyInvalidLoginMsg() {
		String actual = driver.findElement(By.cssSelector(".popup .alert strong")).getText();
		Assert.assertTrue("Appropriate error message not displayed for invalid login", actual.trim().equalsIgnoreCase(("Your login details are incorrect").trim()));
	}

	public void verifySuccessfullLogin() {
		String actual = driver.findElement(By.id("nav-user")).getText();
		Assert.assertTrue("Username is wrong", actual.trim().equalsIgnoreCase(("jupiter").trim()));
	}



}
