package dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name="Login")
	public static Object[][] getLoginData()
	{
		return ExcelUtility.getDataFromSheet("login");
	}
	
	@DataProvider(name="User")
	public static Object[][] getUserData()
	{
		return ExcelUtility.getDataFromSheet("User");
	}
	
}
