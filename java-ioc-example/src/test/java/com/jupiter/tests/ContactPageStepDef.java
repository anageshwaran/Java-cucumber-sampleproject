package com.jupiter.tests;

import org.openqa.selenium.WebDriver;
import com.planittesting.ioc.ObjectContainer;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactPageStepDef {

	private ObjectContainer container;
	private ContactPage contactpage;
	protected WebDriver driver;

	public ContactPageStepDef(ObjectContainer container) {
		this.container = container;
	}

	@Given("^the user clicks the contact menu$")
	public void the_user_clicks_the_contact_menu() {
		driver = this.container.resolve(WebDriver.class);
		contactpage = new ContactPage(driver);
		contactpage.clickContactLink();
	}

	@And("^the user enters the valid contact details$")
	public void the_user_enters_the_valid_contact_details() {
		contactpage.setForename("jupiter");
		contactpage.setEmail("test@gmail.com");
		contactpage.setMessage("testing");
	}

	@When("^the user clicks the submit button$")
	public void the_user_clicks_the_submit_button() {
		contactpage.clickSubmit();
	}

	@Then("^the user should be prompted with thank you message$")
	public void the_user_should_be_prompted_with_thank_you_message() {
		contactpage.verifyThankMsg("jupiter");
	}

	@And("^the user enters the invalid contact details$")
	public void the_user_enters_the_invalid_contact_details() {
		driver = this.container.resolve(WebDriver.class);
		contactpage = new ContactPage(driver);
		contactpage.setForename("");
		contactpage.setEmail("test@gmail.com");
		contactpage.setMessage("testing");
	}

	@Then("^the user should be prompted with appropriate error message$")
	public void the_user_should_be_prompted_with_appropriate_error_message() {
		contactpage.verifyErrorMsg();
	}


}
