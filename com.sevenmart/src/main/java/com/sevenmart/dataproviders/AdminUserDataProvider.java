package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

public class AdminUserDataProvider {
	@DataProvider(name="NewAdminUserDataProvider")
	public Object[][] NewAdminUserDataProvider()
	{
		return new Object [][] {{"gkadmin","1223"}};
	}
	@DataProvider(name="NewStaffUserDataProvider")
	public Object[][] StaffUserDataProvide()
	{
		return new Object [][] {{"gkstaff","1223"}};
	}
	@DataProvider(name="NewPartnerUserDataProvider")
	public Object[][] PartnerUserDataProvider()
	{
		return new Object [][] {{"gkpardastner","125423"}};
	}
	@DataProvider(name="NewDeliveryUserDataProvider")
	public Object[][] DeliveryUserDataProvider()
	{
		return new Object [][] {{"fffasdasdsdfscssdf","1sagsdsddasd223"}};
	}

}
