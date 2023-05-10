package testsuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.LoginPage;
import pages.EndLinkApplication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.Util;

import utilities.Values;

public class Demo {
	private WebDriver browser;

	public EndLinkApplication EndLinkApplication;

	@BeforeClass
	public void before() {

		Util.createOutputDirectory();
		Values.extent = new ExtentReports(Values.outputDirectory + "/Results.html", true);

	}

	@Test
	public void TC_EL_001() throws InterruptedException {
		Util.start("EndLink", "ERT-40: Val. Search", "Validate Searching a User");
		try {

			EndLinkApplication = new EndLinkApplication();
			LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
			HomePage homepage = LoginPage.login();
			Thread.sleep(2000);
			homepage.logout1();

		} catch (Exception e) {
			Util.Failed("Exception caught" + e.getMessage());
		} finally {
			Values.parent.appendChild(Values.child);
			Values.currentStep = 0;
			EndLinkApplication.closeApp();
		}
		Values.extent.endTest(Values.parent);
		Values.extent.flush();

	}
}
