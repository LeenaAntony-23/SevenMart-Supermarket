package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.dataproviders.AdminUserDataProvider;
import com.sevenmart.pages.AdminUsersPage;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.utilities.GeneralUtility;

public class AdminUsersTest extends Base{
	AdminUsersPage adminUsersPage;
	LoginPage loginpage;
	@Test(priority=1)
	public void verify_HitOnAdminUsersPage() {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		String actual=adminUsersPage.adminUsersPageVerification();
		String expected="Admin Users";
		System.out.println(GeneralUtility.getRandomName());
		Assert.assertEquals(actual,expected);
		
	}
	@Test(dataProvider = "NewAdminUserDataProvider",dataProviderClass = AdminUserDataProvider.class)
	public void verifyNewAdminCreation(String username,String password) {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectAdminUserType();
		adminUsersPage.clickOnSaveButton();
	}
	@Test(dataProvider = "NewStaffUserDataProvider",dataProviderClass = AdminUserDataProvider.class)
	public void verifyNewStaffCreation(String username,String password) {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		username= username+" "+GeneralUtility.getRandomName();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectStaffUserType();
		adminUsersPage.clickOnSaveButton();
		
	}
	@Test(dataProvider = "NewPartnerUserDataProvider",dataProviderClass = AdminUserDataProvider.class)
	public void verifyNewPartnerCreation(String username,String password) {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectPartnerUserType();
		adminUsersPage.clickOnSaveButton();
	}
	@Test(dataProvider = "deliveryBoyProfileDetails",dataProviderClass = AdminUserDataProvider.class)
	public void verifyNewDeliveryBoyCreation(String username,String password) {
		loginpage=new LoginPage(driver);
		adminUsersPage=new AdminUsersPage(driver);
		loginpage.login();
		adminUsersPage.hitOnAdminUsersPage();
		adminUsersPage.clickOnCreateButton();
		adminUsersPage.enterUserName(username);
		adminUsersPage.enterPassWord(password);
		adminUsersPage.selectDeliveryBoyUserType();
		adminUsersPage.clickOnSaveButton();
		String msg=adminUsersPage.getSuccesMessage();
		System.out.println(msg);
	
	}

}
