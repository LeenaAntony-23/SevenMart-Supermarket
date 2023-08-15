package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;
import com.sevenmart.utilities.ExcelUtility;

public class AdminUserDataProviderExcel {
	ExcelUtility excelutility=new ExcelUtility();
	
	@DataProvider(name="NewAdminUserDataProvider")
	public Object[][] AdminUsersDataProvider()
	{
		excelutility.setExcelFile("AdminUserData", "CreateAdminUser");
		Object data[][] = excelutility.getMultiDimensionalData(1, 3);
		return data;
	}
	
	@DataProvider(name="NewStaffUserDataProvider")
	public Object[][] StaffUserDataProvide()
	{
		excelutility.setExcelFile("AdminUserData", "CreateStaff");
		Object data[][] = excelutility.getMultiDimensionalData(1, 3);
		return data;
	}
	
	@DataProvider(name="NewPartnerUserDataProvider")
	public Object[][] PartnerUserDataProvide()
	{
		excelutility.setExcelFile("AdminUserData", "CreatePartner");
		Object data[][] = excelutility.getMultiDimensionalData(1, 3);
		return data;
	}
	
	@DataProvider(name="NewDeliveryBoyUserDataProvider")
	public Object[][] DeliveryBoyUserDataProvide()
	{
		excelutility.setExcelFile("AdminUserData", "CreateDeliveryBoy");
		Object data[][] = excelutility.getMultiDimensionalData(1, 3);
		return data;
	}
	
	@DataProvider(name="Existinguser")
	public Object[][] Existingusers()
	{
		excelutility.setExcelFile("AdminUserData", "ExistingUser");
		Object data[][] = excelutility.getMultiDimensionalData(1, 1);
		return data;
	}
	
}
