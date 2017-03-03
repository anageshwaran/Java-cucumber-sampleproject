package com.jupiter.tests;

import org.openqa.selenium.WebDriver;
import com.planittesting.ioc.ObjectContainer;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class LogoutPopupStepDef {
	private ObjectContainer container;
	protected WebDriver driver;
	private LogoutPopup logoutpopup;

	public LogoutPopupStepDef(ObjectContainer container) {
		this.container = container;
	}

	@And("^the user clicks the logoutlink$")
	public void the_user_clicks_the_logoutlink() {
		driver = this.container.resolve(WebDriver.class);
		logoutpopup = new LogoutPopup(driver);
		logoutpopup.clickLogoutLink();
	}

	@And("^the user confirms the logout$")
	public void the_user_confirms_the_logout()  {
		logoutpopup.confirmLogout();
	}

	@Then("^verify the user is taken to homepage and usermenu is changed to loginmenu$")
	public void verify_the_user_is_taken_to_homepage_and_usermenu_is_changed_to_loginmenu() {
		logoutpopup.verifySuccessfullLogout();
	}

}
