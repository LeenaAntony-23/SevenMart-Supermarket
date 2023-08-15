package com.sevenmart.dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProviders {
	@DataProvider(name = "InvalidCredentials")
	public Object[][] invalidCredentials() {
		return new Object[][] { { "akku", "4587" }, { "Appu", "4785" } };
	}

	@DataProvider(name = "ValidCredentials")
	public Object[][] validCredentials() {
		return new Object[][] { { "malu", "ammu", "malu" },
				{ "edmundo.mosciski", "mcdz5k1jan1pm6s", "edmundo.mosciski" } };
	}

}
