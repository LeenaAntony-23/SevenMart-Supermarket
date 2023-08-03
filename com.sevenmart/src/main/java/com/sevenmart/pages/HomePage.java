package com.sevenmart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmart.utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalutility;
	
	@FindBy (xpath="//div[@class='user-panel mt-3 pb-3 mb-3 d-flex']/div[@class='info']")
	private WebElement profileNameElement;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public String getProfileName() {
		generalutility=new GeneralUtility(driver);
		return generalutility.getTextOfElement(profileNameElement);
	}

}
