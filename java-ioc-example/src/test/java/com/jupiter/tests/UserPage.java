package com.jupiter.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage{

	public UserPage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyWelcomeMessage() {
		String actual = driver.findElement(By.cssSelector(".span12 h1")).getText();
//		boolean check = actual.trim().equalsIgnoreCase(("Welcome Jupiter").trim());
//		System.out.println("value is: " +check);
		Assert.assertTrue("Welcome message is not displayed", actual.trim().equalsIgnoreCase(("Welcome Jupiter").trim()));
	}

}
