package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenmart.base.Base;
import com.sevenmart.pages.HomePage;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.dataproviders.*;

public class LoginTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ExcelUtility excelutility = new ExcelUtility();

	@Test(priority = 1)
	public void verify_AdminUserProfileName() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.login();
		String actualProfileName = homepage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName, "Profile Name Mismatch");
	}

	@Test(groups = "smoke")
	public void verify_invalidLoginAlertMessageUsingExcel() {
		loginpage = new LoginPage(driver);
		excelutility.setExcelFile("LoginData", "InvalidLoginCredentials");
		String invalidUserName = excelutility.getCellData(1, 0);
		String invalidPassword = excelutility.getCellData(1, 1);
		loginpage.login(invalidUserName, invalidPassword);
		String actual = loginpage.getErrorMessage();
		String actualErrorMessage = actual.substring(9);
		String expectedErrorMessage = "Invalid Username/Password";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Incorrect alert message");
	}

	@Test( groups = "smoke")
	public void verify_CheckboxwithoutLogin() {
		loginpage = new LoginPage(driver);
		loginpage.checkboxWithoutLogin();
		Assert.assertFalse(loginpage.selectCheckbox(), "Checkbox is checked by default");
	}
}