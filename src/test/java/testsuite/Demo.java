package testsuite;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

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
	// private WebDriver browser;

	public EndLinkApplication EndLinkApplication;
	

	@BeforeClass
	public void before() {

		Util.createOutputDirectory();
		Values.extent = new ExtentReports(Values.outputDirectory + "/Results.html", true);

	}
	
	@Test
	public void TC_EL_001() {
		Util.start("EndLink", "Val. User Search", "Validate User Search");
		Allure.step("Test Starts");
		
		for (String testcase : Values.testcases) {
			try {
				Values.child = Values.extent.startTest(testcase);
				Values.testCaseDataRow = Util.returnIndex(testcase);

				// ====================================
				EndLinkApplication = new EndLinkApplication();
				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
				HomePage homepage = LoginPage.login();
				homepage.logout1();
				
				
				// ====================================


			} catch (Exception e) {
				Util.Failed("Exception caught" + e.getMessage());
			} finally {
				Values.parent.appendChild(Values.child);
				Values.currentStep = 0;
				EndLinkApplication.closeApp();
			}
		}
		Values.extent.endTest(Values.parent);
		Values.extent.flush();
		Allure.step("Test Ends");
	}
}