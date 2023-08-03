package com.sevenmart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUility;
import com.sevenmart.utilities.WaitUtility;

public class AdminUsersPage {
	PageUility pageutility;
	WaitUtility waitutility;
	LoginPage loginpage;
	GeneralUtility generalutility;
	WebDriver driver;
	
	
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class=' nav-link']")
	private WebElement adminUsersButton;
	@CacheLookup
	@FindBy(xpath="//input[@id='username']")
	private WebElement userNameField;
	@CacheLookup
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement createNewButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath="//select[@class='form-control' and @id='user_type']")
	private WebElement selectUserType;
	@FindBy(xpath="//button[@type='submit' and @name='Create']")
	private WebElement saveButton;
	@FindBy(xpath="//li[@class='breadcrumb-item active']")
	private WebElement adminUsersConfirmationLabel;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible' and contains(.,'User Created Successfully')]")
	WebElement success;
	
	public void hitOnAdminUsersPage() {
		adminUsersButton.click();
	}
	public String adminUsersPageVerification() {
		generalutility=new GeneralUtility(driver);
		return generalutility.getTextOfElement(adminUsersConfirmationLabel);
	}
	public void clickOnCreateButton() {
		createNewButton.click();
	}
	public void enterUserName(String username) {
		userNameField.sendKeys(username);
	}
	public void enterPassWord(String password) {
		passwordField.sendKeys(password);
	}
	public void selectStaffUserType() {
		pageutility=new PageUility(driver);
		pageutility.selectByVisibleText(selectUserType,"Staff");
	}
	public void selectAdminUserType() {
		pageutility=new PageUility(driver);
		pageutility.selectByVisibleText(selectUserType,"Admin");
	}
	public void selectPartnerUserType() {
		pageutility=new PageUility(driver);
		pageutility.selectByVisibleText(selectUserType,"Partner");
	}
	public void selectDeliveryBoyUserType() {
		pageutility=new PageUility(driver);
		pageutility.selectByVisibleText(selectUserType,"Delivery Boy");
	}
	public void clickOnSaveButton() {
		saveButton.click();
	}
	public void selectUserType(String userType) {
		pageutility=new PageUility(driver);
		if (userType.equals("Staff")) {
			pageutility.selectByVisibleText(selectUserType,"Staff");
		}
		else if(userType.equals("Staff")) {
			// fill up
		}
	}
	public String getSuccesMessage() {
		generalutility=new GeneralUtility(driver);
		pageutility=new PageUility(driver);
		return generalutility.getTextOfElement(success);
	}
	
	
	

}
