package com.sevenmart.tests;

import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.PushNotificationsPage;
import com.sevenmart.utilities.ExcelUtility;



public class PushNotificationsTest extends Base {
	PushNotificationsPage pushnotificationpage;
	LoginPage loginpage;
	ExcelUtility excelutility = new ExcelUtility();

	@Test
	public void verifyPushNotificationLinkHit() {
		loginpage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationsPage(driver);
		loginpage.login();
		pushnotificationpage.hitOnPushNotificationLink();
	}
	@Test
	public void verify_EnterStringOnTitleAndDescription() {
		loginpage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationsPage(driver);
		verifyPushNotificationLinkHit();
		excelutility.setExcelFile("LoginData","InvalidLoginCredentials");
		String titleMessage=excelutility.getCellData(0, 0);
		String descriptionMessage=excelutility.getCellData(0, 1);
		pushnotificationpage.passValuesOnTitleAndDescription(titleMessage, descriptionMessage);
		
	}
	

}
