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
	@FindBy(xpath = "//i[@class='nav-icon fas fa-fas fa-bell']")
	WebElement PushNotification;
	@FindBy(xpath="//input[@id='description']")
	WebElement description;
	@FindBy(xpath="//input[@id='title']")
	WebElement title;

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void hitOnPushNotificationLink() {

		PushNotification.click();

	}
	public void passValuesOnTitleAndDescription(String titleText,String descriptionText) {
		title.sendKeys(titleText);
		description.sendKeys(descriptionText);
	}

}
