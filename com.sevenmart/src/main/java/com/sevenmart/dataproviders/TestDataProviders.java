package com.sevenmart.dataproviders;
import org.testng.annotations.DataProvider;

public class TestDataProviders {
	@DataProvider(name="InvalidCredentials")
		public Object[][] invalidCredentials()
		{
			return new Object [][] {{"gopi","87456"}};
		}
	@DataProvider(name="ValidCredentials")
	public Object[][] validCredentials()
	{//username,password,expectedusername
		return new Object [][] {{"malu","ammu","malu"},{"edmundo.mosciski","mcdz5k1jan1pm6s","edmundo.mosciski"}};
	}
	
}
