package playwrightdemo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForLoadStateOptions;
import com.microsoft.playwright.options.LoadState;

import playwrightdemo.base.BaseTest;
import playwrightdemo.pages.LoginPage;
import playwrightdemo.pages.MainPage;
import playwrightdemo.utilities.BrowserConfigurations;

public class OrangeHRMLoginTest extends BaseTest {
	
	
	
	
	
	@Test(priority=0)
	public void verifyForgotPassword()
	{
		
		Assert.assertEquals(loginpage.checkForgotPasswordLink(), true);
	}
	
	@Test(priority=1)
	public void LoginTest()
	{
		mainpage = loginpage.login("Admin", "admin123");
		
	}
	
	@Test(priority=2)
	public void LogoutTest()
	{
		mainpage.Logout();
	}
	
	
}
