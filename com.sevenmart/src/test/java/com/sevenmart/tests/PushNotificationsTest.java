package com.sevenmart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmart.base.Base;
import com.sevenmart.pages.LoginPage;
import com.sevenmart.pages.PushNotificationsPage;
import com.sevenmart.utilities.ExcelUtility;

public class PushNotificationsTest extends Base {
	PushNotificationsPage pushnotificationpage;
	LoginPage loginpage;
	ExcelUtility excelutility = new ExcelUtility();

	@Test(priority = 1)
	public void verifyPushNotificationInformationHeading() {
		loginpage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationsPage(driver);
		loginpage.login();
		pushnotificationpage.clickOnPushNotificationLink();
		String actual = pushnotificationpage.pageHeading();
		String expected = "Push Notifications";
		Assert.assertEquals(actual, expected, "Heading mismatch");
	}

	@Test
	public void verify_EnterTitleAndDescription() {
		loginpage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationsPage(driver);
		loginpage.login();
		excelutility.setExcelFile("PushNotificationData", "TitleAndDescription");
		String titleText = excelutility.getCellData(1, 0);
		String descriptionText = excelutility.getCellData(1, 1);
		pushnotificationpage.enterTitleAndDescription(titleText, descriptionText);
		String actual = pushnotificationpage.getAlertMessage();
		String actualErrorMessage = actual.substring(9);
		String expectedErrorMessage = "Message send successfully";
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Alert message mismatch");
	}

	@Test
	public void verify_ResetButton() {
		loginpage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationsPage(driver);
		loginpage.login();
		excelutility.setExcelFile("PushNotificationData", "TitleAndDescription");
		String titleText = excelutility.getCellData(1, 0);
		String descriptionText = excelutility.getCellData(1, 1);
		pushnotificationpage.checkResetButton(titleText, descriptionText);
		String actual = pushnotificationpage.checkTitleAndDescriptionAfterClickOnReset();
		String expectedErrorMessage = "";
		Assert.assertEquals(actual, expectedErrorMessage, "Reset Button is not working");
	}
}
