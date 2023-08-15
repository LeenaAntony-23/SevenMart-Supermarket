package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.DeliveryBoyDataProvider;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.ManageDeliveryBoyPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.utilities.PageUility;

public class ManageDeliveryBoyTest extends Base {
	ManageDeliveryBoyPage managedeliveryboypage;
	LoginPage loginpage;
	PageUility pageutility;
	ExcelUtility excelutility = new ExcelUtility();

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
		excelutility.setExcelFile("DeliveryBoyData", "NewDeliveryBoy");
		managedeliveryboypage.createNewDeliveryBoy(name, mail, phone, address, username, password);
		String actual = managedeliveryboypage.getSuccessAlert();
		String actualAlert = actual.substring(9);
		String expectedAlert = "Delivery Boy Details Created Successfully";
		Assert.assertEquals(actualAlert, expectedAlert, "Incorrect Alert");
	}

	@Test(dataProvider = "existingDeliveryBoyExcel", dataProviderClass = DeliveryBoyDataProvider.class)
	public void verify_ExistingUserByName(String name) {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		excelutility.setExcelFile("DeliveryBoyData", "SearchExistingDeliveryBoy");
		managedeliveryboypage.searchExistingDeliveryBoy(name);
		String actualname = managedeliveryboypage.checkSearchResultName();
		String expectedname = excelutility.getCellData(0, 0);
		Assert.assertEquals(actualname, expectedname, "Delivery Boy is not found");
	}

	@Test
	public void verify_NonExistingDeliveryBoy() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.searchNonExistingDeliveryBoy("jugtr");
		excelutility.setExcelFile("DeliveryBoyData", "SearchNonExistingDeliveryBoy");
		String actualname = managedeliveryboypage.checkSearchResultNotFound();
		String expectedname = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actualname, expectedname, "Delivery Boy is found");
	}

	@Test
	public void verify_editDeliveryBoyDetails() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.searchExistingDeliveryBoy("user1");
		managedeliveryboypage.editDeliveryBoyName();
		String actual = managedeliveryboypage.getUpdatedAlert();
		String actualAlert = actual.substring(9);
		String expectedAlert = "Delivery Boy Informations Updated Successfully";
		Assert.assertEquals(actualAlert, expectedAlert, "Delivery Boy Informations not Updated");
	}

	@Test
	public void verify_deleteDeliveryBoyDetails() {
		managedeliveryboypage = new ManageDeliveryBoyPage(driver);
		managedeliveryboypage.searchExistingDeliveryBoy("user1");
		managedeliveryboypage.deleteDeliveryBoyName();
		String actual = managedeliveryboypage.getDeletedAlert();
		String actualAlert = actual.substring(9);
		String expectedAlert = "Delivery Boy Informations Deleted Successfully";
		Assert.assertEquals(actualAlert, expectedAlert, "Delivery Boy Informations not Deleted");
	}
}
