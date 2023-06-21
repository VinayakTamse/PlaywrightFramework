package playwrightdemo.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForLoadStateOptions;
import com.microsoft.playwright.options.LoadState;

import playwrightdemo.pages.AdminPage;
import playwrightdemo.pages.LoginPage;
import playwrightdemo.pages.MainPage;
import playwrightdemo.utilities.BrowserConfigurations;

public class BaseTest {

	protected Page page;
	protected LoginPage loginpage;
	protected MainPage mainpage;
	protected AdminPage adminpage;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		BrowserConfigurations config = new BrowserConfigurations();
		page = config.initializeBrowser("chrome", false, "https://opensource-demo.orangehrmlive.com/");
		loginpage = new LoginPage(page);
		mainpage = new MainPage(page);
		
		page.waitForLoadState(LoadState.DOMCONTENTLOADED, new WaitForLoadStateOptions().setTimeout(60000));
	}
	
	@AfterMethod
	public void tearDown()
	{
		page.context().browser().close();
	}

}
