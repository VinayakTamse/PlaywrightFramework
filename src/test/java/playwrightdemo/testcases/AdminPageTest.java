package playwrightdemo.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import playwrightdemo.base.BaseTest;

public class AdminPageTest extends BaseTest {
	
	@Test(priority=1,enabled=true)
	public void addUserTest()
	{
		mainpage = loginpage.login("Admin", "admin123");
		adminpage = mainpage.clickOnAdminLink();
		boolean isAdded = adminpage.addUser("Raghavan", "ESS", "Enabled", "Abcd1234");
		Assert.assertTrue(isAdded);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		mainpage.Logout();
	}
	
	@Test(priority=2,enabled=true)
	public void searchUserTest()
	{
		mainpage = loginpage.login("Admin", "admin123");
		adminpage = mainpage.clickOnAdminLink();
		boolean found = adminpage.searchUser("Raghavan", "ESS");
		System.out.println("Element size : "+ found);
		if (found==false)
		{
			System.out.println("No Records Found");
			
		}
		else {
			System.out.println("Found Records");
			Assert.assertTrue(true);
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		mainpage.Logout();
		
	}
	
	@Test(priority=3, enabled=true)
	public void deleteUserTest()
	{
		mainpage = loginpage.login("Admin", "admin123");
		adminpage = mainpage.clickOnAdminLink();
		boolean found = adminpage.searchUser("Raghavan", "ESS");
		if (found)
		{
			Assert.assertTrue(adminpage.deleteUser());
			
		}
		else {
			System.out.println("No Records To delete");
		}
		mainpage.Logout();
		
	}

}
