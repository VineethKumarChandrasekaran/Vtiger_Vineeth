package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.fileutilities.FileUtility;

public class LoginPage {

	FileUtility fileutility = new FileUtility();
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement usernameTextField;
	
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		//System.out.println(driver instanceof ChromeDriver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void login(String username, String password) {
		getUsernameTextField().clear();
		getUsernameTextField().sendKeys(username);
		getPasswordTextField().clear();
		getPasswordTextField().sendKeys(password);
		getLoginButton().click();
	}
}
