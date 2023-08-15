package com.sevenmart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUility;
import com.sevenmart.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	WaitUtility waitutility;
	LoginPage loginpage;
	GeneralUtility generalutility;
	PageUility pageutility;
	JavascriptExecutor javascriptexecutor;
	ExcelUtility excelutility = new ExcelUtility();

	@FindBy(xpath = "//i[@class='nav-icon fas fa-user-plus']")
	private WebElement manageDeliveryBoyLink;
	@FindBy(xpath = "//div[@class='col-sm-12']/a[1]")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNumberField;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressField;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveButton;
	@FindBy(xpath = "//h1")
	private WebElement deliveryBoyPageHeading;
	@FindBy(xpath = "//div[contains(@class,'alert-success ')]")
	private WebElement successAlert;
	@FindBy(xpath = "//div[@class='col-sm-12']/a[2]")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchByNameField;
	@FindBy(xpath = "//button[@name='Search']")
	private WebElement searchListSearchButton;
	@FindBy(xpath = "//table/tbody/tr[1]/td[1]")
	private WebElement searchResultName;
	@FindBy(xpath = "//table/tbody")
	private WebElement searchResultNotFound;
	@FindBy(xpath = "//table/tbody/tr/td[8]/a[1]")
	private WebElement editDeliveryBoyDetailsLink;
	@FindBy(xpath = "//button[@name='update']")
	private WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement updatedAlert;
	@FindBy(xpath = "//table/tbody/tr/td[8]/a[2]")
	private WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteAlert;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnManageDeliveryBoyLink() {
		manageDeliveryBoyLink.click();
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void enterName(String name) {
		nameField.sendKeys(name);
	}

	public void enterEmailID(String email) {
		emailField.sendKeys(email);
	}

	public void enterPhoneNumber(String phone) {
		phoneNumberField.sendKeys(phone);
	}

	public void enterAddress(String address) {
		addressField.sendKeys(address);
	}

	public void enterUserName(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSaveButton() {
		saveButton.submit();
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void clickOnSearchListSearchButton() {
		searchListSearchButton.click();
	}

	public void searchByName(String searchName) {
		searchByNameField.sendKeys(searchName);
	}

	public void clickOnEditDeliveryBoyButton() {
		pageutility = new PageUility(driver);
		pageutility.javaScriptExecutorScrollToElement(editDeliveryBoyDetailsLink);
		pageutility.javaScriptScrollandclick(editDeliveryBoyDetailsLink);

	}

	public void clickOnDeleteDeliveryBoyButton() {
		pageutility = new PageUility(driver);
		pageutility.javaScriptExecutorScrollToElement(deleteButton);
		pageutility.javaScriptScrollandclick(deleteButton);
	}

	public void clickOnUpdateButton() {
		pageutility = new PageUility(driver);
		pageutility.javaScriptExecutorScrollToElement(updateButton);
		updateButton.submit();
	}

	public String getUpdatedAlert() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(updatedAlert);
	}

	public String getDeletedAlert() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(deleteAlert);
	}

	public String checkSearchResultName() {
		pageutility = new PageUility(driver);
		pageutility.javaScriptExecutorScrollToElement(searchResultName);
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(searchResultName);
	}

	public String checkSearchResultNotFound() {
		pageutility = new PageUility(driver);
		pageutility.javaScriptExecutorScrollToElement(searchResultNotFound);
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(searchResultNotFound);
	}

	public String getSuccessAlert() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(successAlert);
	}

	public String getHeadingOfManageDeliveryBoyPage() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(deliveryBoyPageHeading);
	}

	public void manageDeliveryBoyPageHeading() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		clickOnManageDeliveryBoyLink();
	}

	public void createNewDeliveryBoy(String name, String email, String phoneNumber, String address, String userName,
			String passsword) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		clickOnManageDeliveryBoyLink();
		clickOnNewButton();
		enterName(name);
		enterEmailID(email);
		enterPhoneNumber(phoneNumber);
		enterAddress(address);
		enterUserName(userName + " " + GeneralUtility.getRandomName());
		enterPassword(passsword);
		clickOnSaveButton();
	}

	public void searchExistingDeliveryBoy(String searchName) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		clickOnManageDeliveryBoyLink();
		clickOnSearchButton();
		searchByName(searchName);
		clickOnSearchListSearchButton();
	}

	public void searchNonExistingDeliveryBoy(String name) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		clickOnManageDeliveryBoyLink();
		clickOnSearchButton();
		searchByName(name);
		clickOnSearchListSearchButton();

	}

	public void editDeliveryBoyName() {
		clickOnEditDeliveryBoyButton();
		enterName(" " + GeneralUtility.getRandomName());
		clickOnUpdateButton();
	}

	public void deleteDeliveryBoyName() {
		clickOnDeleteDeliveryBoyButton();
		pageutility.acceptAlert();
	}

}
