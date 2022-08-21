package com.fawry.API.angularAutomation.pages;

import com.fawry.API.angularAutomation.utils.Log;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fawry.API.angularAutomation.constants.GeneralConstants;
import com.fawry.API.angularAutomation.dataModels.LoginDM;


public class LoginPage extends MainPage {

	public LoginPage(WebDriver driver, NgWebDriver ngWebDriver)
	{
		super(driver, ngWebDriver);
	}

// Initialize page's web elements
	@FindBy(linkText="Login")
	WebElement loginLink;

	@FindBy(id="userId")
	WebElement userMailOrMobileText;

	@FindBy(id="loginPassInput")
	WebElement passwordText;

	@FindBy(css="button#loginBtnLink")
	WebElement loginButton;

	@FindBy(id="loginForgetLink")
	WebElement forgotPasswordLnk;
	



// list page's actions
	
	// login action
	public String login(LoginDM loginObj)
	{
		String errorsMessage = "";
		try
		{
			loginLink.click();
			userMailOrMobileText.sendKeys(loginObj.getUserMail());
			passwordText.sendKeys(loginObj.getPassword());
			Thread.sleep(500);
			loginButton.click();

			// find error message(s) only in the cases that are expected to fail such as invalid credentials
			if (!loginObj.getExpectedMessage().equalsIgnoreCase(GeneralConstants.SUCCESS))
			{
				errorsMessage = getAllErrorsMessage();
				//In case user didn't login successfully, return all displayed error messages in one string separated by #
				if(!errorsMessage.isEmpty())
					return errorsMessage;
			}
		}
		catch(Exception e)
		{
			Log.error("Error occured in " + new Object() {}
				.getClass()
				.getEnclosingMethod()
				.getName() + " for testcase *** " +  loginObj.getTestCaseTitle() + " ***", e);
			return GeneralConstants.FAILED;
		}

		// else it the case that user logged in successfully then return success
		return GeneralConstants.SUCCESS;
	
	}

	// login action
	public void loginSuccessfully(String userMail, String password)
	{
		try {
			loginLink.click();
			userMailOrMobileText.sendKeys(userMail);
			passwordText.sendKeys(password);
			loginButton.click();
		}
		catch(Exception e)
		{
			Log.error("Error occured While logging in " + new Object() {}
					.getClass()
					.getEnclosingMethod()
					.getName(), e);
		}
	}

	


}