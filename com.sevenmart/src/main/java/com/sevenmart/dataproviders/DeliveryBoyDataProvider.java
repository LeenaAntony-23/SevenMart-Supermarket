package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmart.utilities.ExcelUtility;

public class DeliveryBoyDataProvider {
	ExcelUtility excelutility=new ExcelUtility();
	
	@DataProvider(name = "createNewDeliveryBoyExcel")
	public Object[][] newDeliveryBoyProfile() {
		excelutility.setExcelFile("DeliveryBoyData", "NewDeliveryBoy");
		Object data[][] = excelutility.getMultiDimensionalData(1, 6);
		return data;
	}
	
	@DataProvider(name = "existingDeliveryBoyExcel")
	public Object[][] existingDeliveryBoyProfile() {
		excelutility.setExcelFile("DeliveryBoyData", "SearchExistingDeliveryBoy");
		Object data[][] = excelutility.getMultiDimensionalData(1, 1);
		return data;
	}
	
	@DataProvider(name = "nonExistingDeliveryBoyExcel")
	public Object[][] nonExistingDeliveryBoyProfile() {
		excelutility.setExcelFile("DeliveryBoyData", "SearchNonExistingDeliveryBoy");
		Object data[][] = excelutility.getMultiDimensionalData(1, 1);
		return data;
	}

}
