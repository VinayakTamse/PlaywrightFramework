package playwrightdemo.pages;

import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page;

public class AdminPage {
	
	private Page page;
	
	private String dropDownMenu = "p.oxd-userdropdown-name";
	private String adminAddBtn = "button:text('Add')";
	private String selectRole = "div.oxd-select-wrapper";
	private String dropDownSel = "div.oxd-select-dropdown div";
	private String employeenamehints = "Type for hints...";
	private String usernamefield = "input.oxd-input:below(:text('Username'))";
	private String employeefiedDropdown = "div.oxd-autocomplete-option>span";
	private String passwordfield = "input.oxd-input:below(:text('Password'))";
	private String confirmpasswordfield = "input.oxd-input:below(:text('Confirm Password'))";
	private String saveBtn = "button:text('Save')";
	private String selectUserRole = "div.oxd-select-text:below(:text('User Role'))";
	private String serachBtn = "button:has-text('Search')";
	private String selectUserCheckbox = "span.oxd-checkbox-input:left-of(div:text('Raghavan'))";
	private String deleteSelected = "button:text-is('Delete Selected')";
	private String confirmYes = "button:text-is('Yes, Delete')";
	private String verifyMessage = "//p[text()='Successfully Deleted']";
	private String verifyAddMessage = "//p[text()='Successfully Saved']";
	private String isRecordFound = "//span[text()='(1) Record Found']";
	
	public AdminPage(Page page)
	{
		this.page = page;
	}
	
	public String getEmployeeName()
	{
		return page.locator(dropDownMenu).textContent();
	}
	
	public boolean addUser(String username, String role, String status, String password)
	{
		page.click(adminAddBtn);
		page.locator(selectRole).first().click();
		page.locator(dropDownSel)
		.filter(new FilterOptions().setHasText(role)).click();
		page.getByPlaceholder(employeenamehints).fill("John  Smith");
		page.locator(employeefiedDropdown).filter(new FilterOptions().setHasText("John Smith")).click();
		page.locator(selectRole).last().click();
		page.locator(dropDownSel)
		.filter(new FilterOptions().setHasText(status)).click();
		page.locator(usernamefield).first().fill(username);
		page.locator(passwordfield).first().fill(password);
		page.locator(confirmpasswordfield).first().fill(password);
		page.locator(saveBtn).click();
		page.locator(verifyAddMessage).waitFor();
		return page.locator(verifyAddMessage).isVisible();
	}
	
	public boolean searchUser(String username, String role)
	{
		try {
		page.locator(usernamefield).first().fill(username);
		page.locator(selectUserRole).first().click();
		page.locator(dropDownSel)
		.filter(new FilterOptions().setHasText(role)).click();
		page.locator(serachBtn).click();
		
		page.locator(isRecordFound).waitFor();
		return page.locator(isRecordFound).isVisible();
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public boolean deleteUser()
	{
		page.locator(selectUserCheckbox).first().click();
		page.click(deleteSelected);
		page.click(confirmYes);
		page.locator(verifyMessage).waitFor();
		return page.locator(verifyMessage).isVisible();
	}

}
