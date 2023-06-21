package playwrightdemo.pages;

import com.microsoft.playwright.Page.LocatorOptions;
import com.microsoft.playwright.Page;

public class MainPage {
	
	private Page page;
	
	private String profilepic = "profile picture";
	private String menuDropDown = "ul.oxd-dropdown-menu > li";
	private String adminlink = "//span[text()='Admin']";
	
	public MainPage(Page page)
	{
		this.page = page;
	}
	
	public void Logout()
	{
		page.getByAltText(profilepic).click();
		page.locator(menuDropDown, new LocatorOptions().setHasText("Logout")).click();
	}
	
	public AdminPage clickOnAdminLink()
	{
		page.locator(adminlink).click();
		return new AdminPage(page);
	}

}
