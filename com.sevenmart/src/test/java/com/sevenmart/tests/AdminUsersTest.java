package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.AdminUserDataProviderExcel;
import com.sevenmart.pages.AdminUsersPage;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	AdminUsersPage adminUsersPage;
	ExcelUtility excelutility;
	LoginPage loginpage;

	@Test(priority = 1)
	public void verify_AdminUsersPageHeading() {
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.adminUserPageHeading();
		String actual = adminUsersPage.getAdminUsersPageHeading();
		String expected = "Admin Users";
		Assert.assertEquals(actual, expected, "Heading missmatch");

	}

	@Test(dataProvider = "NewAdminUserDataProvider", dataProviderClass = AdminUserDataProviderExcel.class)
	public void verify_NewAdminCreation(String username, String password, String userType) {
		adminUsersPage = new AdminUsersPage(driver);
		ExcelUtility excelutility = new ExcelUtility();
		excelutility.setExcelFile("AdminUserData", "CreateAdminUser");
		adminUsersPage.createAdminUser(username, password, userType);
		String actual = adminUsersPage.getSuccesAlert();
		String actualAlert = actual.substring(9);
		String expected = "User Created Successfully";
		Assert.assertEquals(actualAlert, expected, "User is not Created");
	}

	@Test(dataProvider = "NewStaffUserDataProvider", dataProviderClass = AdminUserDataProviderExcel.class)
	public void verifyNewStaffCreation(String username, String password, String userType) {
		ExcelUtility excelutility = new ExcelUtility();
		adminUsersPage = new AdminUsersPage(driver);
		excelutility.setExcelFile("AdminUserData", "CreateStaff");
		adminUsersPage.createAdminUser(username, password, userType);
		String actual = adminUsersPage.getSuccesAlert();
		String actualAlert = actual.substring(9);
		String expected = "User Created Successfully";
		Assert.assertEquals(actualAlert, expected, "User is not Created");

	}

	@Test(dataProvider = "NewPartnerUserDataProvider", dataProviderClass = AdminUserDataProviderExcel.class)
	public void verifyNewPartnerCreation(String username, String password, String userType) {
		ExcelUtility excelutility = new ExcelUtility();
		adminUsersPage = new AdminUsersPage(driver);
		excelutility.setExcelFile("AdminUserData", "CreatePartner");
		adminUsersPage.createAdminUser(username, password, userType);
		String actual = adminUsersPage.getSuccesAlert();
		String actualAlert = actual.substring(9);
		String expected = "User Created Successfully";
		Assert.assertEquals(actualAlert, expected, "User is not Created");
	}

	@Test(dataProvider = "NewDeliveryBoyUserDataProvider", dataProviderClass = AdminUserDataProviderExcel.class)
	public void verifyNewDeliveryBoyCreation(String username, String password, String userType) {
		ExcelUtility excelutility = new ExcelUtility();
		adminUsersPage = new AdminUsersPage(driver);
		excelutility.setExcelFile("AdminUserData", "CreateDeliveryBoy");
		adminUsersPage.createAdminUser(username, password, userType);
		String actual = adminUsersPage.getSuccesAlert();
		String actualAlert = actual.substring(9);
		String expected = "User Created Successfully";
		Assert.assertEquals(actualAlert, expected, "User is not Created");

	}

	@Test(dataProvider = "Existinguser", dataProviderClass = AdminUserDataProviderExcel.class)
	public void verify_ExistingUser(String username) {
		ExcelUtility excelutility = new ExcelUtility();
		adminUsersPage = new AdminUsersPage(driver);
		excelutility.setExcelFile("AdminUserData", "ExistingUser");
		adminUsersPage.searchExistingUser(username);
		String actual = adminUsersPage.checkSearchResultName();
		String expected = excelutility.getCellData(0, 0);
		Assert.assertEquals(actual, expected, "User is not existing");

	}

	@Test
	public void verify_nonExistingUser() {
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.searchNonExistingUser("kiyh");
		String actual = adminUsersPage.checkSearchResultName();
		String expected = ".........RESULT NOT FOUND.......";
		Assert.assertEquals(actual, expected, "User is not Created");

	}

	@Test
	public void verify_DeleteUser() {
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.searchExistingUser("Shiju23aa");
		adminUsersPage.deleteUser();
		String actual = adminUsersPage.getDeleteAlert();
		String actualAlert = actual.substring(9);
		String expectedAlert = "User Deleted Successfully";
		Assert.assertEquals(actualAlert, expectedAlert, "User not deleted");
	}

}
