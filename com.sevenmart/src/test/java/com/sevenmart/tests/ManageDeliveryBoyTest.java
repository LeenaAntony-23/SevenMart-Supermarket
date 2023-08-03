package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.DeliveryBoyCreationDataProvider;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.ManageDeliveryBoyPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUility;

public class ManageDeliveryBoyTest extends Base {
	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginpage;
	PageUility pageutility;
	ExcelUtility excelutility;
	
	

	@Test(groups = "smoke")
	public void verify_HitOnManageDeliveryBoyPage() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.HitOnManageDeliveryBoyPage();
		String actual = managedeliveryboypage.validatingDeliveryBoyPage();
		String expected = "List Delivery Boy";
		Assert.assertEquals(actual, expected);
	}

	@Test(dataProvider = "DeliveryBoyDataProvider", dataProviderClass = DeliveryBoyCreationDataProvider.class)
	public void verify_CreateNewDeliveryBoy(String name, String mail, String phone, String address, String username,
			String password) {

		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.CreateNewDeliveryBoys(name, mail, phone, address,
				username + GeneralUtility.getRandomName(), password);
		System.out.println(managedeliveryboypage.getSuccesAlertText());


	}

	@Test(dataProvider = "deliveryBoyProfileDetailsExcel", dataProviderClass = DeliveryBoyCreationDataProvider.class)
	public void verify_CreateNewDeliveryBoys(String name, String mail, String phone, String address, String username,
			String password) {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.CreateNewDeliveryBoys(name, mail, phone, address,
				username + GeneralUtility.getRandomName(), password);

	}

	@Test(dataProvider = "deliveryBoyProfileDetailsExcel", dataProviderClass = DeliveryBoyCreationDataProvider.class)
	public void verify_AlreadyExistingUserNameAlertTest(String name, String mail, String phone, String address,
			String username, String password) {
		ExcelUtility excelutility=new ExcelUtility();
		String expectedUserName=excelutility.getCellData(1,6);
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.AlreadyExistingUserNameAlert(name, mail, phone, address, username, password);
		String actual=managedeliveryboypage.searchNewlyAddedDeliveryBoyInTableByUserName(expectedUserName);
		Assert.assertEquals(actual,expectedUserName);
		
	}

	@Test(dataProvider = "ExistingDeliveryBoyNameAndEmail", dataProviderClass = DeliveryBoyCreationDataProvider.class,groups = "regression")
	public void verify_SearchingExistingDeliveryBoy(String existingName, String existingEmail) {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.SearchingExistingDeliveryBoy(existingName, existingEmail);
		
	}

	@Test(dataProvider = "NonExistingDeliveryBoyNameAndEmail", dataProviderClass = DeliveryBoyCreationDataProvider.class)
	public void verify_ResultNotFoundForNonExistingDeliveryBoy(String existingName, String existingEmail) {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.ResultNotFoundForNonExistingDeliveryBoy(existingName, existingEmail);
	}

}
