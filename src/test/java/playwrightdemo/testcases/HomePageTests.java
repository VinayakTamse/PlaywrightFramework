package playwrightdemo.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import playwrightdemo.pages.HomePage;
import playwrightdemo.utilities.BrowserConfigurations;

public class HomePageTests {
	
	BrowserConfigurations config;
	Page page;
	HomePage homepage;

	
	@BeforeMethod
	public void setUp() throws Exception
	{
		config = new BrowserConfigurations();
	
		page = config.initializeBrowser("chromium", false, "https://demo.opencart.com/");
		homepage = new HomePage(page);
	}
	
	@Test
	public void urlTest()
	{
		String urlOfApp = homepage.url();
		System.out.println("Application url is : "+urlOfApp);
		Assert.assertEquals(urlOfApp, "https://demo.opencart.com/");
	}
	
	@Test
	public void titleTest()
	{
		String titleOfApp = homepage.title();
		System.out.println("Title of Page is : "+titleOfApp);
		Assert.assertEquals(titleOfApp, "Your Store");
	}
	
	@Test
	public void searchTest()
	{
		homepage.performSearch("Mac Book");
		try {
		Thread.sleep(5000);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		page.context().browser().close();
	}

}
