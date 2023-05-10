package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Util;

public class LoginPage extends Page {



	@FindBy(xpath="//input[@type='email']")
	private WebElement txtUsername;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement btnSignIn;

	@FindBy(xpath="//*[name()='svg'][@class='icon logoutbutton']")
	private WebElement btnLogOut;
	
	
	
	
	public LoginPage(WebDriver browser) {
		super(browser);
	}


	public HomePage loginToApplication() {
		String username= Util.get("Username");
		String password =  Util.get("Password");
		enterText(txtUsername, username);
		enterText(txtPassword, password);
		clickOn(btnSignIn, "Submit Button");
		waitForIsClickable(btnLogOut);
		Util.Screenshot();
		return new HomePage(browser);
	}
	
	public HomePage loginToApplication(String username,String password) {
		enterText(txtUsername, username);
		enterText(txtPassword, password);
		clickOn(btnSignIn, "Submit Button");
		waitForIsClickable(btnLogOut);
		Util.Screenshot();
		isElementPresent(txtUsername);
		return new HomePage(browser);
	}
	
	public HomePage login() throws InterruptedException {
		browser.findElement(By.xpath("//input[@type='email']")).sendKeys("surabhis+0989@geekyants.com");
		browser.findElement(By.xpath("//input[@type='password']")).sendKeys("Endlink@2020");
		Util.Screenshot();
		browser.findElement(By.xpath("//span[text()='Sign In']")).click();
		Thread.sleep(5000);
		browser.findElement(By.xpath("//span[text()='Demo_Company']")).click();
		Util.Screenshot();
		Thread.sleep(2000);
		browser.findElement(By.xpath("//*[name()='svg'][@class='createbutton']")).click();
		Thread.sleep(2000);
		browser.findElement(By.xpath("//div[contains(@class,'src-components-organisms-addrecipient')]//input"))
				.sendKeys("Doctor");
		WebElement s1 = browser.findElement(By.xpath("//span[text()='Doctor Demo Last1 Name']"));
		if (s1.isDisplayed()) {
			Util.Screenshot();
			Util.Passed("The user is displayed within time limit");

		} else {
			Util.Failed("The user is displayed beyond time");
		}
		return new HomePage(browser);
	}
}
