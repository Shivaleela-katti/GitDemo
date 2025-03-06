import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.CustomDataProvider;
import pages.LoginPage;

public class LoginTestWithPOM extends BaseClass{

	@Test(dataProvider = "Login",dataProviderClass = CustomDataProvider.class)
	public void login(String uname,String pass) 
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginAsAdmin(uname, pass);
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"URL pattern did not match");
	}
	@Test
	public void logOutApplication11()
	{
		System.out.println("String ");
		System.out.println("character ");
		System.out.println("Boolean");
	}
}
