package com.sevenmart.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenmart.constants.Constants;

public class ScreenShotsUtility {
// capturing screenshot is an interface
	
	TakesScreenshot takescreenshot;
	public void takeScreenShot(WebDriver driver,String imageName) {
		try {
			takescreenshot=(TakesScreenshot) driver;// driver and takescreenshot both are interface so upcasting to equate.Like float to int.
			File screenShot=takescreenshot.getScreenshotAs(OutputType.FILE);//capture screenshot
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String destination=Constants.SCREENSHOT_PATH+imageName+timeStamp+".png";
			File finalDestination=new File(destination);// string to file object
			FileHandler.copy(screenShot, finalDestination);// paste to location from clipboard same as prtdscrn.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
