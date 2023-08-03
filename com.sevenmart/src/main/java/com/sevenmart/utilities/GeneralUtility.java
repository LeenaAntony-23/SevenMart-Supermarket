package com.sevenmart.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	WebDriver driver;
	
	
	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextOfElement(WebElement element) {
	
		return element.getText();
	}
	
	public List<String> getTextOfElements(String xpath) {// method for storing and iterating webelements

		List<String> data = new ArrayList<String>();// for storing
		List<WebElement> elements = driver.findElements(By.xpath(xpath));// for getting elements in a list
		for (WebElement iterator : elements) {
			data.add(iterator.getText());

		}
		return data;

	}

	public List<String> getTextOfElements(List<WebElement> element) {// method for storing and iterating webelements
																		// hardcoding
		List<String> data = new ArrayList<String>();// for storing

		for (WebElement iterator : element) {
			data.add(iterator.getText());

		}
		return data;

	}

	public String get_Attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);

	}

	public String get_CssValue(WebElement element, String cssValue) {
		return element.getCssValue(cssValue);

	}

	public Boolean is_Displayed(WebElement element) {
		return element.isDisplayed();
	}

	public Boolean is_Enabled(WebElement element) {
		return element.isEnabled();
	}

	public Boolean is_Selected(WebElement element) {
		return element.isSelected();
	}
	public static String getRandomName() {
		
		 Faker faker=new Faker();
		 String firstName = faker.name().firstName();
		 return firstName;
		
	}
	public static String getTimeStamp() {
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}
	

}
