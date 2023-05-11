package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.safari.SafariDriver;

import utilities.Util;
import utilities.Values;

public class EndLinkApplication {

	private WebDriver browser;
	
	public EndLinkApplication() {
		try {
			browser=getDriver(Values.frameworkProperty.getProperty("Browser"));
			Values.driver = browser;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoginPage openEndLinkApplication() {
		try {
			browser.get(Values.frameworkProperty.getProperty("URL"));
			browser.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new LoginPage(browser);
	}
	
	
	
	
	public  WebDriver getDriver(String browserName) {
		WebDriver driver = null;
		if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", 
					"/Users/surabhi/git/endLinkLatest/drivers/geckodriver");	
			
			FirefoxOptions option = new FirefoxOptions();
			option.addPreference("dom.webnotifications.enabled", false);
			driver=new FirefoxDriver(option);

		}
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", 
					"drivers/chromedriver");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver=new ChromeDriver(option);
		}
		if(browserName.equalsIgnoreCase("safari")){			
			driver=new SafariDriver();
		}
		return driver;
	}
	
	public void closeApp() {
		try {
			browser.quit();
		} catch (Exception e) {
			Util.Failed("Exception while closing browser "+e.getMessage());
		}
	}
}
