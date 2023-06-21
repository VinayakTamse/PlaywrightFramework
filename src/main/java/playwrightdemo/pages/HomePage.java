package playwrightdemo.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	
	private Page page;
	private String searchField = "input[name=search]";
	private String searchButton = "button.btn.btn-lg"; 
	
	public HomePage(Page page)
	{
		this.page = page;
	}
	
	public String url() {
		return page.url();
	}
	
	public String title() {
		return page.title();
	}
	
	public void performSearch(String searchValue)
	{
		page.locator(searchField).fill(searchValue);
		page.locator(searchButton).click();
	}

}
