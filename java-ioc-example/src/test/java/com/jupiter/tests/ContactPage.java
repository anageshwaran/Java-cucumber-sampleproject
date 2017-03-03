package com.jupiter.tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	public void setForename(String forename) {
		setTextToElement(By.id("forename"), forename);
	}

	public void setEmail(String email) {
		setTextToElement(By.id("email"), email);
	}

	public void setMessage(String message) {
		setTextToElement(By.id("message"), message);
	}

	public void clickSubmit() {
		pathToClickElement(By.partialLinkText("Submit"));
	}

	public void verifyThankMsg(String forename) {
		String expected = String.format("Thanks %s, we appreciate your feedback.",forename);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-backdrop")));
		String actual = driver.findElement(By.cssSelector(".alert-success")).getText();
		Assert.assertTrue("User is not prompted with thank you message", 
				actual.trim().equalsIgnoreCase(expected.trim()));
	}

	public void verifyErrorMsg() {
		String expected = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
		String actual = driver.findElement(By.cssSelector(".alert-error")).getText();
		Assert.assertTrue("User is not prompted with appropriate error message", 
				actual.trim().equalsIgnoreCase(expected.trim()));
	}
}
