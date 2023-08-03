package com.sevenmart.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUility {
	WebDriver driver;
	Select select;
	Actions actions;
	JavascriptExecutor javascriptexecutor;

	public PageUility(WebDriver driver) {
		this.driver = driver;
	}

	public void selectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);

	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void moveToElement(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	// alert accept,cancel,javascript nte gettext, drag and drop, click,context
	// click,double click
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextOfJavaScriptAlert() {
		return driver.switchTo().alert().getText();
	}

	public void dragAndDrop(WebElement source, WebElement destination) {
		actions = new Actions(driver);
		actions.dragAndDrop(source, destination).build().perform();

	}

	public void leftClick(WebElement element) {
		element.click();
	}

	public void rightClick(WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	public void doubleClick(WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void switchToWindow(String windowID) {
		driver.switchTo().window(windowID);
		
	}
	public void javaScriptExecutorClick(WebElement element) {
		javascriptexecutor=(JavascriptExecutor) driver;
		javascriptexecutor.executeScript("arguments[0].click();",element);
	}
	public void javaScriptExecutorScrollToElement(WebElement element) {
		javascriptexecutor=(JavascriptExecutor) driver;
		javascriptexecutor.executeScript("arguments[0].scrollIntoView();",element);
	}
	

}
