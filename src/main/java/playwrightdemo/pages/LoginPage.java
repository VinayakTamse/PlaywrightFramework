package playwrightdemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	private Page page;
	private String username = "Username";
	private String pass_word = "Password";
	private String loginButton = "button:has-text('Login')";
	private String forgotPass = "p:text('Forgot your password?')";
	
	public LoginPage(Page page)
	{
		this.page = page;
	}
	
	public boolean checkForgotPasswordLink()
	
	{
		page.locator(forgotPass).waitFor();
		return page.locator(forgotPass).isVisible();
	}
	
	public MainPage login(String user, String password)
	{
		page.getByPlaceholder(username).fill(user);
		page.getByPlaceholder(pass_word).fill(password);
		page.locator(loginButton).click();
		return new MainPage(page);
	}

}
