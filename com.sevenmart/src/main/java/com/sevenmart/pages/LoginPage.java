package com.sevenmart.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sevenmart.constants.Constants;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	GeneralUtility generalutility;
	WaitUtility waitutility;
	Properties properties = new Properties();

	HomePage homepage;
	FileInputStream fileinputstream;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInButton;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement rememberMeCheckBox;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		try {
			fileinputstream = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fileinputstream);
		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}

	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassWord(String passWord) {
		passwordField.sendKeys(passWord);
	}

	public void checkRememberMeCheckBox() {
		rememberMeCheckBox.click();
	}

	public void clickOnSignInButton() {
		signInButton.click();
	}

	public String getErrorMessage() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(errorMessage);
	}

	public void login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassWord(password);
		clickOnSignInButton();
	}

	public void login(String userName, String passWord) {
		enterUserName(userName);
		enterPassWord(passWord);
		clickOnSignInButton();
	}
}
