package testsuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.LoginPage;
import pages.EndLinkApplication;

import utilities.Util;
import utilities.ExcelData;
import utilities.SQLServer;
import utilities.Values;

public class RegressionTestCases {

	public EndLinkApplication EndLinkApplication;

	@BeforeClass
	public void before() {

		Util.createOutputDirectory();
		Values.extent = new ExtentReports(Values.outputDirectory + "/Results.html", true);

	}

	@Test
	public void TC_EL_001() {
		System.out.println("___________");
		Util.start("EndLink", "ERT-40: Val. Login/Logout", "Validate Login & Logout Functionality");
		
		for (String testcase : Values.testcases) {
			try {
				Values.child = Values.extent.startTest(testcase);
				Values.testCaseDataRow = Util.returnIndex(testcase);

				// ====================================
				EndLinkApplication = new EndLinkApplication();
				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
				HomePage homepage = LoginPage.loginToApplication();
				Thread.sleep(3000);
				homepage.logout();
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
	}

//	@Test
//	public void TC_EL_002() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-41: Val. send msg to coworker", "Validate send message to a coworker");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.SendMessage();
//				Thread.sleep(5000);
//				homepage.logout();
//
//				homepage = LoginPage.loginToApplication(Util.get("RecipientMail"), Util.get("RecipientPassword"));
//				homepage.selectOrg();
//				homepage.validateMsg();
//
//				// ====================================
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}

//	@Test
//	public void TC_EL_003() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-42: Val. send msg to 2 coworkers", "Validate send message to TWO coworkers");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.SendMsgMultipleCoworkers();
//				Thread.sleep(5000);
//				homepage.logout();
//
//				homepage = LoginPage.loginToApplication(Util.get("RecipientMail"), Util.get("RecipientPassword"));
//				homepage.selectOrg();
//				Thread.sleep(5000);
//				homepage.validateMsg();
//				homepage.logout();
//
//////                  to validate for another User			
//////					homepage = LoginPage.loginToApplication(Util.get("RecipientMail2"), Util.get("RecipientPassword2"));
//////					homepage.selectOrg();
//////					homepage.validateMsg();
//////					homepage.logout();
//
//				// ====================================
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//
//	}
//
//	@Test
//	public void TC_EL_004() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-43: Val. send msg to group", "Validate send message to a group");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.SendGroupMessage();
//				Thread.sleep(5000);
//				homepage.logout();
//
//				homepage = LoginPage.loginToApplication(Util.get("RecipientMail"), Util.get("RecipientPassword"));
//				homepage.selectOrg();
//				homepage.validateMsg();
//
//				// ====================================
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}

//	@Test
//	public void TC_EL_005() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-44: Val. search a word in a msg", "Validate search for a word in a message");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.SearchMessage();
//				homepage.logout();
//
//				// ====================================
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
////////		
////////		
////////
//	@Test
//	public void TC_EL_006() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-45: Val. add profile img", "Validate add image in my profile");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.AddImage();
//				homepage.logout();
//
//				// ====================================
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_007() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-46: Val. send img to coworker", "Validate send image to one coworker");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.sendImage();
//				// some validation
//				homepage.logout();
//
//				// ====================================
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_008() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-47: Val. create ToDo", "Validate create to-do ");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.CreateToDo();
//				homepage.logout();
//
//				// ====================================
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_009() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-13: Val. unread ring to be invisible for ToDo",
//				"Validate unread ring should not be visible in ToDo category ");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				Thread.sleep(5000);
//				homepage.ToDoringStatus();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
////	@Test
////	public void TC_EL_010() throws ClassNotFoundException {
////
////		Util.start("EndLink", "TC_EL_010", "Validate tapping the ring toggles it between active and inactive states");
////
////		for (String testcase : Values.testcases) {
////			try {
////				Values.child = Values.extent.startTest(testcase);
////				Values.testCaseDataRow = Util.returnIndex(testcase);
////
////				// ====================================
////				EndLinkApplication = new EndLinkApplication();
////				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
////				HomePage homepage = LoginPage.loginToApplication();
////
////				homepage.selectOrg();
////				homepage.activeInactiveStates();
////				homepage.logout();
////
////			} catch (Exception e) {
////				Util.Failed("Exception caught" + e.getMessage());
////			} finally {
////				Values.parent.appendChild(Values.child);
////				Values.currentStep = 0;
////				EndLinkApplication.closeApp();
////			}
////		}
////		Values.extent.endTest(Values.parent);
////		Values.extent.flush();
////	}
//
//	@Test
//	public void TC_EL_011() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-11: Val. by default ring status = inactive",
//				"Validate the default state will be inactive state");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.defaultInactiveState();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_012() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-12: Val. in active state ring is ON",
//				"Validate that in active state ring is turned ON");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.RingActiveState();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_013() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-15: Val. stack msgs. vertically if both rings status = inactive",
//				"Validate that if both the rings are inactive,stack the messages vertically");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.messageStackInactiveRing();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_014() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-36: Val. ghost icon on msg", "Validate that ghost icon applied to message or not");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.SendMessage();
//				homepage.clickOnGhostIcon();
//				Thread.sleep(5000);
//				homepage.logout();
//
//				homepage = LoginPage.loginToApplication(Util.get("RecipientMail"), Util.get("RecipientPassword"));
//				homepage.selectOrg();
//				homepage.validateGhostIcon();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_015() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-35: Val. high priority icon on msg",
//				"Validate latest high priority message in message preview section");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.SendMessage();
//				homepage.clickOnHighPriorityIcon();
//				Thread.sleep(5000);
//				homepage.logout();
//
//				homepage = LoginPage.loginToApplication(Util.get("RecipientMail"), Util.get("RecipientPassword"));
//				homepage.selectOrg();
//				homepage.validateHighPriorityIcon();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//
//	}
//
//	@Test
//	public void TC_EL_016() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-37: Val. recalling a msg", "Validate message recall function");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.SendMessage();
//				Thread.sleep(5000);
//				homepage.logout();
//
//				homepage = LoginPage.loginToApplication(Util.get("RecipientMail"), Util.get("RecipientPassword"));
//				homepage.selectOrg();
//				homepage.validateMsg();
//				homepage.logout();
//
//				homepage = LoginPage.loginToApplication();
//				homepage.selectOrg();
//				homepage.validateMsg();
//				homepage.recallIcon();
//				homepage.logout();
//
//				homepage = LoginPage.loginToApplication(Util.get("RecipientMail"), Util.get("RecipientPassword"));
//				homepage.selectOrg();
//				homepage.recalledmsgAtReceiverSide();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_017() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-48: Val. deleting msg", "Validate message delete function");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.SendMessage();
//				Thread.sleep(5000);
//				homepage.deleteIcon();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_018() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-49: Val. changing theme", "Validate changing theme");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.themeChange();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_019() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-52: Val. create msg - ok button", "Validate creating new message - OK button");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.createOkButton();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_020() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-53: Val. create msg - cancel button",
//				"Validate creating new message - Cancel button");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.createCancelButton();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_021() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-54: Val. create msg - cross button", "Creating new message - Cross button");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.createMsgPopup();
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
////	@Test
////	public void TC_EL_022() throws ClassNotFoundException {
////
////		Util.start("EndLink", "TC_EL_022", "Validate Thumbs Up");
////
////		for (String testcase : Values.testcases) {
////			try {
////				Values.child = Values.extent.startTest(testcase);
////				Values.testCaseDataRow = Util.returnIndex(testcase);
////
////				// ====================================
////				EndLinkApplication = new EndLinkApplication();
////				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
////				HomePage homepage = LoginPage.loginToApplication();
////
////				homepage.selectOrg();
////				homepage.SendMessage();
////				Thread.sleep(5000);
////				homepage.logout();
////				
////				homepage = LoginPage.loginToApplication(Util.get("RecipientMail"), Util.get("RecipientPassword"));
////				homepage.selectOrg();
////				homepage.validateMsg();
////				homepage.thumbsUp();
////				homepage.logout();
////
////			} catch (Exception e) {
////				Util.Failed("Exception caught" + e.getMessage());
////			} finally {
////				Values.parent.appendChild(Values.child);
////				Values.currentStep = 0;
////				EndLinkApplication.closeApp();
////			}
////		}
////		Values.extent.endTest(Values.parent);
////		Values.extent.flush();
////	}
////	
////	@Test
////	public void TC_EL_023() throws ClassNotFoundException {
////
////		Util.start("EndLink", "TC_EL_023", "Sent message text should always be white in both themes");
////
////		for (String testcase : Values.testcases) {
////			try {
////				Values.child = Values.extent.startTest(testcase);
////				Values.testCaseDataRow = Util.returnIndex(testcase);
////
////				// ====================================
////				EndLinkApplication = new EndLinkApplication();
////				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
////				HomePage homepage = LoginPage.loginToApplication();
////
////				homepage.selectOrg();
////				homepage.SendMessage();
////				homepage.sentTextColor();
////				homepage.logout();
////
////			} catch (Exception e) {
////				Util.Failed("Exception caught" + e.getMessage());
////			} finally {
////				Values.parent.appendChild(Values.child);
////				Values.currentStep = 0;
////				EndLinkApplication.closeApp();
////			}
////		}
////		Values.extent.endTest(Values.parent);
////		Values.extent.flush();
////	}
//
//	@Test
//	public void TC_EL_024() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-38&39: Val. sentence libraries - user/system authored", "Validate sentence library user & system authored");
//
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.sentenceLibrary();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_025() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-8: Val. unread ring is saved between sessions",
//				"Validate the unread ring’s state is saved between sessions(if user switches from To Do filter to another");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				Thread.sleep(3000);
//				homepage.unreadRingTodosession();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_026() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-60: Val. update permissions settings", "Validate updating permissions in my profile");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				Thread.sleep(3000);
//				homepage.updatePermissions();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_027() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-59: Val. update privacy settings", "Validate updating privacy settings in my profile");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.updatePrivacySettings();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_028() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-58: Val. update personal info settings", "Validate updating personal info in my profile");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.updatePersonalinfo();
//				Thread.sleep(4000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_029() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-50: Val. blurr", "Validate blurr");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.blurr();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_030() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-8: Val. unread ring status is maintained if user logs out",
//				"Validate the unread ring’s state is saved between sessions(if user logs out)");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.unreadRingLogoutsession();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_031() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-66: Val. subjectless threads with group",
//				"Validate thread merging with adding groups - subjectless");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.subjectlessThreadwithGroup();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
////	@Test
////	public void TC_EL_032() throws ClassNotFoundException {
////
////		Util.start("EndLink", "TC_EL_032", "Validate thread merging with adding groups - subject");
////		for (String testcase : Values.testcases) {
////			try {
////				Values.child = Values.extent.startTest(testcase);
////				Values.testCaseDataRow = Util.returnIndex(testcase);
////
////				// ====================================
////				EndLinkApplication = new EndLinkApplication();
////				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
////				HomePage homepage = LoginPage.loginToApplication();
////
////				homepage.selectOrg();
////				homepage.subjectThreadwithGroup();
////				Thread.sleep(5000);
////				homepage.logout();
////
////			} catch (Exception e) {
////				Util.Failed("Exception caught" + e.getMessage());
////			} finally {
////				Values.parent.appendChild(Values.child);
////				Values.currentStep = 0;
////				EndLinkApplication.closeApp();
////			}
////		}
////		Values.extent.endTest(Values.parent);
////		Values.extent.flush();
////	}
//
//	@Test
//	public void TC_EL_033() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-63: Val. subjectless threads with coworker",
//				"Validate Threads with no subject - coworker");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.subjectlessThreadwithCoworker();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
////	@Test
////	public void TC_EL_034() throws ClassNotFoundException {
////
////		Util.start("EndLink", "TC_EL_034", "Validate Threads with subject - coworker");
////		for (String testcase : Values.testcases) {
////			try {
////				Values.child = Values.extent.startTest(testcase);
////				Values.testCaseDataRow = Util.returnIndex(testcase);
////
////				// ====================================
////				EndLinkApplication = new EndLinkApplication();
////				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
////				HomePage homepage = LoginPage.loginToApplication();
////
////				homepage.selectOrg();
////				homepage.subjectThreadwithCoworker();
////				Thread.sleep(5000);
////				homepage.logout();
////
////			} catch (Exception e) {
////				Util.Failed("Exception caught" + e.getMessage());
////			} finally {
////				Values.parent.appendChild(Values.child);
////				Values.currentStep = 0;
////				EndLinkApplication.closeApp();
////			}
////		}
////		Values.extent.endTest(Values.parent);
////		Values.extent.flush();
////	}
////	
//
//	@Test
//	public void TC_EL_035() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-24: Val. customer to be added as recipient",
//				"Validate adding customers as recipient");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.customerAsRecipient();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_036() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-26: Val. customer can be added/deleted as associate",
//				"Validate adding customers as associate customer");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.customerAsAssociate();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_037() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-27: Val. user shld have proper settings for adding customer in To bar",
//				"Validate if customer is added in To bar then user has permissions for it");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.customerPermissions();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_038() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-29: Val. if a customer is added no other customer shld be added",
//				"Validate user can't add more than one customer as recipient");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.singleCustomerToBar();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_039() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-31: Val. if a recipient other than customer is added no customers shld be added",
//				"Validate if user has added recipient other than customer,he should not be able to select customers.");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.validateRecipienttype();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
//
//	@Test
//	public void TC_EL_040() throws ClassNotFoundException {
//
//		Util.start("EndLink", "ERT-25: Val. customer icon",
//				"Validate customer icon is same at both places menu panel & To bar for dark theme");
//		for (String testcase : Values.testcases) {
//			try {
//				Values.child = Values.extent.startTest(testcase);
//				Values.testCaseDataRow = Util.returnIndex(testcase);
//
//				// ====================================
//				EndLinkApplication = new EndLinkApplication();
//				LoginPage LoginPage = EndLinkApplication.openEndLinkApplication();
//				HomePage homepage = LoginPage.loginToApplication();
//
//				homepage.selectOrg();
//				homepage.customerIconDarkTheme();
//				Thread.sleep(5000);
//				homepage.logout();
//
//			} catch (Exception e) {
//				Util.Failed("Exception caught" + e.getMessage());
//			} finally {
//				Values.parent.appendChild(Values.child);
//				Values.currentStep = 0;
//				EndLinkApplication.closeApp();
//			}
//		}
//		Values.extent.endTest(Values.parent);
//		Values.extent.flush();
//	}
}
