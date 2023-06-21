package playwrightdemo.utilities;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class BrowserConfigurations {

	Playwright playwright;
	Browser browser;
	BrowserContext browserContext;
	private final String configFile = System.getProperty("user.dir")+"\\resources\\properties\\config.properties";

	public Page initializeBrowser(String browsername, boolean isHeadless, String appUrl) throws Exception {
		playwright = Playwright.create();

		switch (browsername.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
			break;
		case "chrome":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(isHeadless));
			break;
		case "msedge":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(isHeadless));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(isHeadless));
			break;
			default:
				throw new Exception("Invalid Browser");
				
		}
		int width = Integer.parseInt(ConfigProperties.readConfigProperties(configFile, "width"));
		int height = Integer.parseInt(ConfigProperties.readConfigProperties(configFile, "height"));
		browserContext = browser.newContext(new NewContextOptions().setViewportSize(width, height));
		Page page = browserContext.newPage();
		page.navigate(appUrl);
		return page;
	}

}
