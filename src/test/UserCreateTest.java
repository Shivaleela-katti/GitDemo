
public class UserCreateTest extends BaseClass
{
	LoginPage login;
	HomePage home;
	AdminPage admin;
	public WebDriver driver;
	
	@BeforeMethod
	public void setupDriver()
	{
		driver=getDriver();
	}
	
	@Test(dataProvider = "Login",dataProviderClass = CustomDataProvider.class,priority = 0)
	public void login(String uname,String pass) 
	{
		login=PageFactory.initElements(driver, LoginPage.class);
		
		System.out.println("Current URL before "+driver.getCurrentUrl());
		
		home= login.loginAsAdmin(uname, pass);
		
		System.out.println("Current URL after "+driver.getCurrentUrl());
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"URL pattern did not match");
	}
	

	@Test(dependsOnMethods = "login",dataProviderClass = CustomDataProvider.class,dataProvider = "User")
	public void createUser(String role,String empName,String userName,String pass)
	{
		admin=home.clickOnAdmin();
		
		admin.createUser(role,empName,userName,pass);
		
		boolean status=admin.isSuccessMsgDisplayed();
		
		Assert.assertTrue(status);
	}
	
	@Test(priority = 2,dependsOnMethods = "login")
	public void logOutApplication()
	{
		home.logOutFromApplication();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

}
