package com.jupiter.tests;

import org.openqa.selenium.WebDriver;
import com.planittesting.ioc.ObjectContainer;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class UserPageStepDef {
	private ObjectContainer container;
	private UserPage userpage;
	protected WebDriver driver;

	public UserPageStepDef(ObjectContainer container) {
		this.container = container;
	}

	@And("^the user clicks the userlink$")
	public void the_user_clicks_the_userlink() {
		driver = this.container.resolve(WebDriver.class);
		userpage = new UserPage(driver);
		userpage.clickUserLink();
	}

	@Then("^verify the welcome message$")
	public void verify_the_welcome_message() {
		userpage.verifyWelcomeMessage();
	}

}
