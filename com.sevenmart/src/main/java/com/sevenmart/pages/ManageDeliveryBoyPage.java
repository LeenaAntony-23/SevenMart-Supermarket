package com.sevenmart.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.ArrayList;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUility;
import com.sevenmart.utilities.WaitUtility;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	WaitUtility waitutility;
	LoginPage loginpage;
	GeneralUtility generalutility;
	PageUility pageutility;
	@FindBy(xpath = "//i[@class='nav-icon fas fa-user-plus']")
	private WebElement manageDeliveryBoy_Link;
	@FindBy(xpath = "//li[@class='breadcrumb-item active']")
	private WebElement deliveryBoyPageConfirmElement;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newDeliveryBoyCreateButton;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement namefield;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailfield;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phone;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement address;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement savebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success ')]")
	private WebElement successAlert;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5")
	private WebElement userNameAlreadyExistAlert;
	@FindBy(xpath = "//a[@href='htts://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @type='button']")
	private WebElement cancelButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	private WebElement searchButton;
	@FindBy(xpath = "//input[@id='un']")
	private WebElement searchWithName;
	@FindBy(xpath = "//input[@id='ut']")
	private WebElement searchWithEmail;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement tableSearchButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;
	@FindBy(xpath = "//tbody/tr[1]/td[2]")
	private WebElement searchedDeliveryBoyEmailFromTable;
	@FindBy(xpath = "//tbody/tr/td/span[@id='res']/center")
	private WebElement resultNotFound;
	@FindBy(xpath="//tbody/tr/td[5]")
	private List<WebElement> userNamesFromTable;

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void hit_ManageDeliveryBoyLink() {
		manageDeliveryBoy_Link.click();
	}

	public void clickOnCreateNewDeliveryBoyButton() {
		newDeliveryBoyCreateButton.click();
	}

	public String validatingDeliveryBoyPage() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(deliveryBoyPageConfirmElement);
	}

	public void enterName(String name) {
		namefield.sendKeys(name);

	}

	public void enterEmail(String email) {
		emailfield.sendKeys(email);
	}

	public void enterPhoneNumber(String number) {
		phone.sendKeys(number);
	}

	public void enterAddress(String addressdetails) {
		address.sendKeys(addressdetails);
	}

	public void enterUsername(String userName) {
		username.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void scrollToSaveButtonElement() {
		pageutility = new PageUility(driver);
		pageutility.javaScriptExecutorClick(savebutton);
	}

	public void saveNewDeliveryBoyDetails() {

		savebutton.click();
	}

	public String succesAlertMessage() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(successAlert);

	}

	public String userNameAlreadyExistAlertMessage() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(userNameAlreadyExistAlert);

	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	public void searchByName(String existingName) {
		searchWithName.sendKeys(existingName);
	}

	public void searchByEmail(String existingEmail) {
		searchWithEmail.sendKeys(existingEmail);
	}

	public void searchButtonClickOnFindingExistingDeliveryBoy() {
		tableSearchButton.click();
	}

	public String getEmailOfSearchedDeliveryBoyFromTable() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(searchedDeliveryBoyEmailFromTable);
	}

	public String noResultFoundGetText() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(resultNotFound);
	}
	public void HitOnManageDeliveryBoyPage() {
		loginpage = new LoginPage(driver);
		loginpage.login();
		hit_ManageDeliveryBoyLink();
		

	}
	public void test() {
		hit_ManageDeliveryBoyLink();
		
	}
	public String getSuccesAlertText() {
		generalutility = new GeneralUtility(driver);
		return generalutility.getTextOfElement(successAlert);
	}
	public String searchNewlyAddedDeliveryBoyInTableByUserName(String expectedUserName) {
		for(WebElement iter:userNamesFromTable) {
			ArrayList<String> userNameValues=new ArrayList<String>();
			String actualUsername=iter.getText();
			userNameValues.add(actualUsername);
			if(actualUsername.contains(expectedUserName)) {
				System.out.println("The searched user is found");
			}
			}
		return expectedUserName;
	}

	public void AlreadyExistingUserNameAlert(String name, String mail, String phone, String address, String username,
			String password) {
		loginpage = new LoginPage(driver);

		loginpage.login();
		hit_ManageDeliveryBoyLink();
		clickOnCreateNewDeliveryBoyButton();
		enterName(name);
		enterEmail(mail);
		enterPhoneNumber(phone);
		enterAddress(address);
		enterUsername(username);
		enterPassword(password);
		scrollToSaveButtonElement();

	}

	public void CreateNewDeliveryBoys(String name, String mail, String phone, String address, String username,
			String password) {
		loginpage = new LoginPage(driver);

		loginpage.login();
		hit_ManageDeliveryBoyLink();
		clickOnCreateNewDeliveryBoyButton();
		enterName(name);
		enterEmail(mail);
		enterPhoneNumber(phone);
		enterAddress(address);
		enterUsername(username);
		enterPassword(password);
		scrollToSaveButtonElement();
		getSuccesAlertText();
	}

	public void SearchingExistingDeliveryBoy(String existingName, String existingEmail) {
		loginpage = new LoginPage(driver);

		loginpage.login();
		hit_ManageDeliveryBoyLink();
		clickOnSearchButton();
		searchByName(existingName);
		searchByEmail(existingEmail);
		searchButtonClickOnFindingExistingDeliveryBoy();

	}
	public void ResultNotFoundForNonExistingDeliveryBoy(String existingName, String existingEmail) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		hit_ManageDeliveryBoyLink();
		clickOnSearchButton();
		searchByName(existingName);
		searchByEmail(existingEmail);
		searchButtonClickOnFindingExistingDeliveryBoy();
		
	}
}
