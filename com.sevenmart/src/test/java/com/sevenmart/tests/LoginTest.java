package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.pages.HomePage;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.utilities.ExcelUtility;
import com.sevenmart.dataproviders.*;

public class LoginTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	ExcelUtility excelutility=new ExcelUtility();
	
	@Test(priority=1)
	public void verify_AdminUserlogin() {
		loginpage =new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.login();
		String actualProfileName=homepage.getProfileName();
		String expectedProfileName="admin";
		Assert.assertEquals(actualProfileName,expectedProfileName,"error");
		
	}
	@Test
	public void verify_loginUsingWrongCredentialsAlertMessage() {
		loginpage =new LoginPage(driver);
		excelutility.setExcelFile("LoginData","InvalidLoginCredentials");
		String invalidUserName=excelutility.getCellData(0, 0);
		String invalidPassword=excelutility.getCellData(0, 1);
		loginpage.login(invalidUserName,invalidPassword);
		String actualerror=loginpage.getErrorMessage();
		String expectedErrorMessage="Alert!";
		Assert.assertEquals(actualerror,expectedErrorMessage);
		
		
	}
	@Test(dataProvider = "InvalidCredentials",dataProviderClass =TestDataProviders.class)
	public void verify_InvalidCredentialsAlertMessage(String invalidUserName,String invalidPassword ) {
		loginpage =new LoginPage(driver);
		loginpage.login(invalidUserName,invalidPassword);
		
		
	}
	

}