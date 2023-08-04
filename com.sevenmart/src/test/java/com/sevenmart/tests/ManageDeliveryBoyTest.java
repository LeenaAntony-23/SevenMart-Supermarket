package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.DeliveryBoyDataProvider;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.ManageDeliveryBoyPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.utilities.GeneralUtility;
import com.sevenmart.utilities.PageUility;

public class ManageDeliveryBoyTest extends Base {
	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginpage;
	PageUility pageutility;
	ExcelUtility excelutility=new ExcelUtility();

	@Test(groups = "smoke")
	public void verify_ManageDeliveryBoyPageHeading() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.manageDeliveryBoyPageHeading();
		String actual = managedeliveryboypage.getHeadingOfManageDeliveryBoyPage();
		String expected = "List Delivery Boy";
		Assert.assertEquals(actual, expected, "Page heading mismatch");
	}

	@Test(dataProvider = "createNewDeliveryBoyExcel", dataProviderClass = DeliveryBoyDataProvider.class)
	public void verify_successAlertForNewDeliveryBoy(String name, String mail, String phone, String address,
			String username, String password) {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.createNewDeliveryBoy(name, mail, phone, address, username, password);
		String actual = managedeliveryboypage.getSuccessAlert();
		String actualAlert = actual.substring(9);
		String expectedAlert = "Delivery Boy Details Created Successfully";
		Assert.assertEquals(actualAlert, expectedAlert, "Incorrect Alert");
	}

	@Test(dataProvider = "existingDeliveryBoyExcel", dataProviderClass = DeliveryBoyDataProvider.class)
	public void verify_ExistingUserByName() {
		
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.searchExistingDeliveryBoy();
		excelutility.setExcelFile("DeliveryBoyData", "SearchExistingDeliveryBoy");
		String expectedname = excelutility.getCellData(1, 0);
		String actualname = managedeliveryboypage.checkSearchResultName();
		Assert.assertEquals(actualname, expectedname);
	}

	/*@Test(dataProvider = "ExistingDeliveryBoyNameAndEmail", dataProviderClass = DeliveryBoyDataProvider.class, groups = "regression")
	public void verify_SearchingExistingDeliveryBoy(String existingName, String existingEmail) {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.SearchingExistingDeliveryBoy(existingName, existingEmail);

	}*/

	@Test(dataProvider = "NonExistingDeliveryBoyNameAndEmail", dataProviderClass = DeliveryBoyDataProvider.class)
	public void verify_NonExistingDeliveryBoy(String existingName, String existingEmail) {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.searchNonExistingDeliveryBoy();
		excelutility.setExcelFile("DeliveryBoyData", "SearchNonExistingDeliveryBoy");
		String actualname = managedeliveryboypage.checkSearchResultNotFound();
		String expectedname =".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualname, expectedname);
	}
	@Test(dataProvider = "existingDeliveryBoyExcel", dataProviderClass = DeliveryBoyDataProvider.class)
	public void verify_editDeliveryBoyDetails() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.editDeliveryBoyName();
		String actual = managedeliveryboypage.getUpdatedAlert();
		String actualAlert=actual.substring(9);
		String expectedAlert ="Delivery Boy Informations Updated Successfully";
		Assert.assertEquals(actualAlert, expectedAlert);
	}
}
