package com.sevenmart.pages;

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

	@FindBy(xpath = "//i[@class='nav-icon fas fa-users']")
	private WebElement adminUsersLink;
	@CacheLookup
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@CacheLookup
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchuserNameField;
	@FindBy(xpath = "//select[@id='ut']")
	private WebElement searchUserTypeField;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//div[@class='card-body']/button[@class='btn btn-block-sm btn-danger']")
	private WebElement searchButtonForSearchResult;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement selectUserType;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successAlert;
	@FindBy(xpath = "//h1")
	private WebElement adminUsersHeading;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	private WebElement searchResultName;
	@FindBy(xpath = "//table/tbody/tr/td[5]/a[3]")
	private WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlert;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAdminUsersPageLink() {
		adminUsersLink.click();
	}

	public String getAdminUsersPageHeading() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(adminUsersHeading);
	}

	public void clickOnCreateButton() {
		newButton.click();
	}

	public void enterUserName(String username) {
		userNameField.sendKeys(username);
	}

	public void searchUserName(String username) {
		searchuserNameField.sendKeys(username);
	}

	public void enterPassWord(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void clickOnSearchResult() {
		searchButtonForSearchResult.click();
	}

	public void clickOnDeleteButton() {
		pageutility = new PageUility(driver);
		pageutility.javaScriptExecutorScrollToElement(deleteButton);
		pageutility.javaScriptScrollandclick(deleteButton);
	}

	public String getDeleteAlert() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(deleteAlert);
	}

	public void selectUserType(String userType) {
		pageutility = new PageUility(driver);
		if (userType.equals("Staff")) {
			pageutility.selectByVisibleText(selectUserType, "Staff");
		} else if (userType.equals("Admin")) {
			pageutility.selectByVisibleText(selectUserType, "Admin");
		} else if (userType.equals("Partner")) {
			pageutility.selectByVisibleText(selectUserType, "Partner");
		} else if (userType.equals("Delivery Boy")) {
			pageutility.selectByVisibleText(selectUserType, "Delivery Boy");
		}
	}

	public String getSuccesAlert() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(successAlert);
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public String checkSearchResultName() {
		pageutility = new PageUility(driver);
		pageutility.javaScriptExecutorScrollToElement(searchResultName);
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(searchResultName);
	}

	public void adminUserPageHeading() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		clickOnAdminUsersPageLink();
	}

	public void createAdminUser(String username, String password, String userType) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		clickOnAdminUsersPageLink();
		clickOnCreateButton();
		enterUserName(username+" "+GeneralUtility.getRandomName());
		enterPassWord(password);
		selectUserType(userType);
		clickOnSaveButton();
	}

	public void searchExistingUser(String userName) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		clickOnAdminUsersPageLink();
		clickOnSearchButton();
		searchUserName(userName);
		clickOnSearchResult();
	}

	public void searchNonExistingUser(String userName) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		clickOnAdminUsersPageLink();
		clickOnSearchButton();
		searchUserName(userName);
		clickOnSearchResult();
	}

	public void deleteUser() {
		pageutility = new PageUility(driver);
		clickOnDeleteButton();
		pageutility.acceptAlert();
	}
}
