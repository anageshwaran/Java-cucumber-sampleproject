package com.jupiter.tests;

import org.openqa.selenium.WebDriver;

import com.planittesting.ioc.ObjectContainer;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPopupStepDef {

	private ObjectContainer container;
	private LoginPopup loginpopup;
	protected WebDriver driver;

	public LoginPopupStepDef(ObjectContainer container) {
		this.container = container;
	}

	@Given("^the user clicks the loginlink$")
	public void the_user_clicks_the_loginlink() {
		driver = this.container.resolve(WebDriver.class);
		loginpopup = new LoginPopup(driver);
		loginpopup.clickLoginLink();
	}

	@And("^the user enters the valid login details$")
	public void the_user_enters_the_valid_login_details() {
		loginpopup.setUsername("jupiter");
		loginpopup.setPassword("letmein");
	}

	@When("^the user clicks the login button$")
	public void the_user_clicks_the_login_button() {
		loginpopup.clickLogin();
	}

	@Then("^the username should be displayed on successfull login$")
	public void the_username_should_be_displayed_on_successfull_login()  {
		loginpopup.verifySuccessfullLogin();
	}

	@And("^the user enters the invalid login details$")
	public void the_user_enters_the_invalid_login_details() {
		loginpopup.setUsername("jupiter");
		loginpopup.setPassword("let");
	}

	@Then ("^the user should be prompted with proper error message$")
	public void the_user_should_be_prompted_with_proper_error_message() {
		loginpopup.verifyInvalidLoginMsg();
		loginpopup.clickCancel();
	}




}
