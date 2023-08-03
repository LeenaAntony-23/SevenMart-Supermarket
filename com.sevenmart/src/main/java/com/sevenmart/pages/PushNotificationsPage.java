package com.sevenmart.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmart.utilities.GeneralUtility;

public class PushNotificationsPage {
	WebDriver driver;
	Properties properties = new Properties();
	GeneralUtility generalutility;
	
	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	private WebElement PushNotification;
	@FindBy(xpath="//input[@id='title']")
	private WebElement titleField;
	@FindBy(xpath="//input[@id='description']")
	private WebElement descriptionField;
	@FindBy(xpath="//button[@name='create']")
	private WebElement saveButton;
	@FindBy(xpath="//h1")
	private WebElement heading;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement AlertMessage;
	
	
	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnPushNotificationLink() {
		PushNotification.click();
	}
	
	public void enterTitle(String titleText) {
		titleField.sendKeys(titleText);
	}
	
	public void enterDescription(String descriptionText) {
		descriptionField.sendKeys(descriptionText);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public String pageHeading()
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.getTextOfElement(heading);
	}
	
	public String getAlertMessage()
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.getTextOfElement(AlertMessage);
	}
	
	public void enterTitleAndDescription(String titleText,String descriptionText) {
		clickOnPushNotificationLink();
		enterTitle(titleText);
		enterDescription(descriptionText);
		clickOnSaveButton();
	}

}
