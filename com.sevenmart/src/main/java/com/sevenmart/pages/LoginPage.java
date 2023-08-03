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
	HomePage homepage;
	Properties properties = new Properties();// java inbuilt class for reading files in keyvalue pair.
	FileInputStream fileinputstream;// file read
	WaitUtility waitutility;
	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@class='form-control' and @placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement rememberMeCheckBox;
	@FindBy(xpath = "//div/h5")
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
//		waitutility=new WaitUtility(driver);
//		waitutility.waitForClickable(signInButton);
		signInButton.click();
	}

	public void login() {
		String userName = properties.getProperty("username");// getting username and password from config file
		String passWord = properties.getProperty("password");
		enterUserName(userName);// calling function
		enterPassWord(passWord);
		clickOnSignInButton();
	}

	public void login(String userName, String passWord) {
		enterUserName(userName);// calling function
		enterPassWord(passWord);
		clickOnSignInButton();
	}

	public String getErrorMessage() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(errorMessage);
	}
	public void AdminUserlogin() {
		login();
		
		
	}

}
