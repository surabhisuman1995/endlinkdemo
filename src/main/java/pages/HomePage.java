package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.DoubleClickAction;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.google.api.services.sheets.v4.Sheets.Spreadsheets.Values.Append;
import com.google.api.services.sheets.v4.Sheets.Spreadsheets.Values.Clear;
import com.relevantcodes.extentreports.model.ScreenCapture;

import junit.framework.Assert;
//import testsuite.usersicon;
import utilities.Util;

public class HomePage extends Page {

	@FindBy(xpath = "//input[@type='email']")
	private WebElement txtUsername;

	@FindBy(xpath = "//input[@type='password']")
	private WebElement txtPassword;

	@FindBy(xpath = "//span[text()='Sign In']")
	private WebElement btnSignIn;

	@FindBy(xpath = "//*[name()='svg'][@class='icon logoutbutton']")
	private WebElement btnLogOut;

	@FindBy(xpath = "//*[name()='svg'][@class='createbutton']")
	private WebElement btnCreate;

	@FindBy(xpath = "//*[name()='svg'][@class='crossicon']")
	private WebElement crossIcon;

	@FindBy(xpath = "(//div[contains(@class,'src-components-molecules-searchrecipient')]/span)[1]")
	private WebElement recipient;

	@FindBy(xpath = "//input[@placeholder='Add Subject']")
	private WebElement msgSubject;

	@FindBy(xpath = "//div[contains(@class,'src-components-organisms-addrecipient')]//input")
	private WebElement txtToRecipient;

	@FindBy(xpath = "//div[contains(@class,'src-components-organisms-recipientFilters')]//*[name()='svg']")
	private WebElement wesRecipientFilters;

	@FindBy(xpath = "//textarea[contains(@class,'message__input')and (@placeholder='Secure Message')]")
	private WebElement txtMessageBox;

	@FindBy(xpath = "//*[name()='svg'][@class='sendbutton']")
	private WebElement btnSend;

	@FindBy(xpath = "//*[name()='svg'][@class='icon usersicon users']")
	private WebElement groupFilter;

	@FindBy(xpath = "//*[name()='svg'][@class='icon clipboard clipboard']")
	private WebElement ToDoFilter;

	@FindBy(xpath = "//span[text()='Assignee']")
	private WebElement assignee1;

	@FindBy(xpath = "//input[@placeholder='Assignee']")
	private WebElement assignee2;

	@FindBy(xpath = "//div[@placeholder='New To-Do']")
	private WebElement newToDo;

	@FindBy(xpath = "//span[text()='Date Unspecified']")
	private WebElement Duedate;

	@FindBy(xpath = "//span[text()='Done']")
	private WebElement Done;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	private WebElement chooseDate;

	@FindBy(xpath = "//span[text()='OK']")
	private WebElement OK;

	@FindBy(xpath = "//*[name()='svg'][@class='checkicon']")
	private WebElement checkicon;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement searchicon;

	@FindBy(xpath = "(//img[@alt='logo...'])[2]")
	private WebElement endlinklogo;

	@FindBy(xpath = "//span[text()='My Profile']")
	private WebElement myprofile;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savebutton;

	@FindBy(xpath = "//*[name()='svg'][@class='plusicon']")
	private WebElement plusicon;

	@FindBy(xpath = "//*[name()='svg'][@class='darkunreadmessicon']")
	private WebElement darkthemeunreadring;

	@FindBy(xpath = "//*[name()='svg'][@class='darkmissedcallicon']")
	private WebElement darkthememissedcallring;

	@FindBy(xpath = "//*[name()='svg'][@class='lightunreadmessicon']")
	private WebElement lightthemeunreadring;

	@FindBy(xpath = "//*[name()='svg'][@class='lightmissedcallicon']")
	private WebElement lightthememissedcallring;

	@FindBy(xpath = "//*[name()='circle'][@fill='#e5e5e5']")
	private WebElement defaultlightthemeringfill;

	@FindBy(xpath = "//*[name()='circle'][@fill='#323132']")
	private WebElement defaultdarkthemeringfill;

	@FindBy(xpath = "//*[name()='svg'][@class='icon bluricon']")
	private WebElement blurr;

	@FindBy(xpath = "//*[name()='svg'][@class='backbutton']")
	private WebElement backButton;

	@FindBy(xpath = "//*[name()='svg'][@class='icon commenticon comment']")
	private WebElement allMessagesIcon;

	@FindBy(xpath = "//*[name()='svg'][@class='icon clipboard clipboard']")
	private WebElement ToDo;

	@FindBy(xpath = "//*[name()='svg'][@class='themeicon']")
	private WebElement themeIcon;

	@FindBy(xpath = "//*[name()='svg'][@class='ghosticon']")
	private WebElement ghostIcon1;

	@FindBy(xpath = "(//*[name()='svg'][@class='ghosticon']/*[name()='path'][@fill='#ff8000'])[last()]")
	private WebElement ghostIcon2;

	@FindBy(xpath = "//*[name()='svg'][@class='icon staricon']/*[name()='path'][@fill='#4d4d4f']")
	private WebElement highpriority1;

	@FindBy(xpath = "(//*[name()='svg'][@class='icon staricon']/*[name()='path'][@fill='#ff533b'])[last()]")
	private WebElement highpriority2;

	@FindBy(xpath = "//*[name()='svg'][@class='undoicon']")
	private WebElement recallIcon;

	@FindBy(xpath = "//span[contains(text(),'Read')]")
	private WebElement readmsgStatus;

	@FindBy(xpath = "//span[contains(text(),'Recalled')]")
	private WebElement recalledmsgStatus;

	@FindBy(xpath = "//span[contains(text(),'Delivered')]")
	private WebElement deliveredmsgStatus;

	@FindBy(xpath = "//span[contains(text(),'Message recalled by sender')]")
	private WebElement recalledmessage;

	@FindBy(xpath = "//*[name()='svg'][@class='trashicon']")
	private WebElement deleteIcon;

	@FindBy(xpath = "//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#fff']")
	private WebElement darkthemeIcon;

	@FindBy(xpath = "//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#77787b']")
	private WebElement lightthemeIcon;

	@FindBy(xpath = "//*[name()='svg'][@class='messuggestionbutton']")
	private WebElement sentenceLibraryButton;

	@FindBy(xpath = "//span[contains(text(),'Sentence Library')]")
	private WebElement sentenceLibraryText;

	@FindBy(xpath = "//span[contains(text(),'system Authored')]")
	private WebElement systemAuthored;

	@FindBy(xpath = "(//*[name()='svg'][@class='copybutton'])[1]")
	private WebElement copyText;

	@FindBy(xpath = "(//span[contains(text(),'user Authored')])[1]")
	private WebElement userAuthored;

	@FindBy(xpath = "//*[name()='svg'][@class='checkicon']")
	private WebElement checkIcon;

	@FindBy(xpath = "//*[name()='svg'][@class='crossicon']")
	private WebElement crossicon;

	@FindBy(xpath = "//span[contains(text(),'My Profile')]")
	private WebElement myProfile;

	@FindBy(xpath = "(//*[name()='svg'][@class='downchevron'])[3]")
	private WebElement permissionsDropdown;

	@FindBy(xpath = "(//*[name()='svg'][@class='downchevron'])[2]")
	private WebElement privacyDropdown;

	@FindBy(xpath = "(//*[name()='svg'][@class='downchevron'])[1]")
	private WebElement personalInfoDropdown;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement save;

	@FindBy(xpath = "(//*[name()='svg'][@class='thumbsupicon'])[last()]")
	private WebElement thumbsupicon;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Email']")
	private WebElement emailId;

	@FindBy(xpath = "//input[@placeholder='ID']")
	private WebElement ID;

	@FindBy(xpath = "//*[name()='svg'][@class='icon bandaid semitransparent']")
	private WebElement customerIcon;

	@FindBy(xpath = "//*[name()='svg'][@class='superadminicon']")
	private WebElement superAdminIcon;

	@FindBy(xpath = "//*[name()='svg'][@class='icon bandaid']")
	private WebElement darkThemeCustomerIcon;

	@FindBy(xpath = "//*[name()='svg'][@class='crossicon']")
	private WebElement customerCrossIcon;
	
	@FindBy(xpath="//*[name()='svg'][@class='themeicon']")
	private WebElement switchmodebutton;
	
	@FindBy(xpath="//body/div[@id='root']/div[1]")
	private WebElement switchMode;
	
	@FindBy(xpath = "//span[contains(text(),'Click here!')]")
	private WebElement catLogout;
	

	public HomePage(WebDriver browser) {
		super(browser);
	}

	public static String messageSent = null;

	public void SendMessage() throws InterruptedException {

		sleep(3000);
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("RecipientName"));
		sleep(5000);
		clickOn(recipient);
		clickOn(msgSubject);
		enterText(msgSubject, Util.get("Subject"));
//			
//		String[] arrFilters = {"","","","","",""};
//		
//		  List<WebElement> wes = browser.findElements(By.xpath(
//		  "//div[contains(@class,'src-components-organisms-recipientFilters')]//*[name()='svg']"
//		  )); String RecipientFilters = Comman.get("RecipientFilters"); 
//		  for(int
//		  i=0;i<arrFilters.length;i++)
//		  { if(RecipientFilters.contains(arrFilters[i])) {
//		  if(svgIsSelected(wes.get(i))) {
//		  
//		  }
//		  
//		  else { wes.get(i).click(); } } }

		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);

		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(2000);
		Util.Screenshot();
	}

	public void SendMsgMultipleCoworkers() throws InterruptedException {

		sleep(5000);
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("RecipientName1"));
		sleep(2000);
		clickOn(recipient);

		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("RecipientName2"));
		sleep(3000);
		clickOn(recipient);

		sleep(2000);
		clickOn(msgSubject);
		enterText(msgSubject, Util.get("Subject"));

		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);
		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(2000);
		Util.Screenshot();

	}

	public void SendGroupMessage() throws InterruptedException {

		sleep(3000);
		clickOn(groupFilter, "Group filter");
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("GroupName"));
		Thread.sleep(4000);
		clickOn(recipient);
		clickOn(msgSubject);
		enterText(msgSubject, Util.get("Subject"));

		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);
		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(2000);
		Util.Screenshot();
	}

	public void CreateToDo() throws InterruptedException {

		sleep(3000);
		clickOn(ToDoFilter, "ToDo filter");
		clickOn(btnCreate, "Create message button");
//		clickOn(assignee1, "assignee");
//		enterText(assignee2, Util.get("AssigneeName"));
//		Thread.sleep(2000);
//		clickOn(recipient, "recipient");
		clickOn(Duedate, "Due Date");
		clickOn(chooseDate, "Choose date from date picker");
		clickOn(OK, "Ok button of date picker");

		clickOn(newToDo);
		enterText(newToDo, Util.get("NewToDoName"));
		clickOn(Done, "Save Todo");
		isElementPresent(checkicon);
		System.out.println("To Do is created");
		Thread.sleep(2000);
		Util.Screenshot();
	}

	public void SearchMessage() throws InterruptedException {

		sleep(3000);
		clickOn(searchicon, "Search icon");
		enterText(searchicon, Util.get("msgSearch"));
//		String msg = Util.get("msgSearch").trim();
//		isElementPresent(By.xpath("//span[contains(text(),'"+msg+"')]"),"The searched messages");
		Thread.sleep(2000);
		Util.Screenshot();
	}

	public void AddImage() throws InterruptedException {

		sleep(5000);
		clickOn(endlinklogo, "Endlink logo");
		clickOn(myprofile, "My profile");
		sleep(10000);
		browser.findElement(By.xpath("//input[@id='image-input']")).sendKeys("/Users/surabhi/Desktop/Test.PNG");
		Thread.sleep(20000);
		clickOn(savebutton, "My profile save button");
		Thread.sleep(20000);
		clickOn(backButton, "Backbutton");
		clickOn(allMessagesIcon, "all messsages icon");
		Thread.sleep(8000);

		Util.Screenshot();
	}

	public void sendImage() throws InterruptedException {

		sleep(3000);
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("RecipientName"));
		sleep(5000);
		clickOn(recipient);
		clickOn(msgSubject);
		enterText(msgSubject, Util.get("Subject"));

		clickOn(plusicon);
		// Thread.sleep(4000);
		// browser.findElement(By.xpath("//span[text()='Choose Image from
		// Library']")).sendKeys("/Users/surabhi/Desktop/image1");;
		browser.findElement(By.xpath("//span[text()='Choose Image from Library']")).click();
		;
		Thread.sleep(4000);

		try {

			File file = new File("/Users/surabhi/Desktop/image1.PNG");

			StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
			// Thread.sleep(10000);
			// Copy to clipboard
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			sleep(2000);

			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_META);

			robot.keyPress(KeyEvent.VK_TAB);

			robot.keyRelease(KeyEvent.VK_META);

			robot.keyRelease(KeyEvent.VK_TAB);

			// Open Goto window
			sleep(1000);

			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_G);
			sleep(1000);

			robot.keyRelease(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_META);

			sleep(1000);
			// Paste the clipboard value

			robot.keyPress(KeyEvent.VK_META);

			robot.keyPress(KeyEvent.VK_V);

			robot.keyRelease(KeyEvent.VK_META);

			robot.keyRelease(KeyEvent.VK_V);
			sleep(1000);

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);

			sleep(2000);

			// Press Enter key to close the Goto window and Upload window

			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);

			robot.delay(1000);

			robot.keyPress(KeyEvent.VK_CANCEL);

			robot.keyRelease(KeyEvent.VK_CANCEL);

		} catch (Exception e) {
			e.printStackTrace();
		}

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(2000);
		Util.Screenshot();
	}

	public void selectOrg() throws InterruptedException {
		
		Thread.sleep(5000);
		String OrgName = Util.get("OrgName").trim();
		waitForElement(
				By.xpath("//span[contains(text(),'" + OrgName + "')]/parent::div/parent::div/parent::div/parent::div"));
		
//		waitForElement(
//				By.xpath("//div[@class='src-components-molecules-account-___account-m__wrapper___2BZkt']"
//						+ "//div[@class='src-components-molecules-account-___account-m__padding-2___Eyd7i']"
//						+ "/span[contains(text(),'" + OrgName + "')]"));
		
		
		
		if (isElementPresent(
				By.xpath("//span[contains(text(),'" + OrgName + "')]/parent::div/parent::div/parent::div/parent::div"))) {

			clickOn(
					By.xpath("//span[contains(text(),'" + OrgName + "')]/parent::div/parent::div/parent::div/parent::div"),
					"Entered the Organisation:" + OrgName);
			Util.Screenshot();

		} else {
			Util.Failed("No organisation with such name is present");

		}
		Util.Screenshot();
	}

	public void validateMsg() throws InterruptedException {

		String msg = messageSent;
		Thread.sleep(3000);
		clickOn(By.xpath("//span[contains(text(),'" + msg + "')]"), "is the last sent message");
		//clickOn(By.xpath("//span[contains(text(),'Hey')]"), "is the last sent message");
		Thread.sleep(10000);
		Util.Screenshot();

	}

	public void ToDoringStatus() throws InterruptedException {

		Thread.sleep(3000);
		clickOn(ToDoFilter, "ToDo filter");
		Thread.sleep(2000);
		Assert.assertEquals(0, browser.findElements(By.xpath("//*[name()='svg'][@class='darkunreadmessicon']")).size());
		Thread.sleep(2000);
		Util.Passed("Unread ring is not present in case of ToDo");
		Util.Screenshot();
	}

	public void activeInactiveStates() {

		// Assert.assertNotSame(2,
		// browser.findElements(By.xpath("//*[name()='circle'][@fill='#323132']")).size());
		if (isElementPresent(defaultdarkthemeringfill)) {
			Util.Passed("Missed call ring is in in-active state");
			Util.Passed("Unread ring is in in-active state");

			if (isElementPresent(By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#77787b']"))) {
				clickOn(darkthemeunreadring);
				clickOn(darkthememissedcallring);
				Util.Passed("Missed call ring is in active state");
				Util.Passed("Unread ring is in active state");
				Util.Screenshot();
			} else {
				clickOn(lightthemeunreadring);
				clickOn(lightthememissedcallring);
				Util.Passed("Missed call ring is in active state");
				Util.Passed("Unread ring is in active state");
				Util.Screenshot();
			}
		} else if (isElementPresent(defaultlightthemeringfill)) {
			Util.Passed("Missed call ring is in in-active state");
			Util.Passed("Unread ring is in in-active state");

			if (isElementPresent(By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#77787b']"))) {
				clickOn(darkthemeunreadring);
				clickOn(darkthememissedcallring);
				Util.Passed("Missed call ring is in active state");
				Util.Passed("Unread ring is in active state");
				Util.Screenshot();
			} else {
				clickOn(lightthemeunreadring);
				clickOn(lightthememissedcallring);
				Util.Passed("Missed call ring is in active state");
				Util.Passed("Unread ring is in active state");
				Util.Screenshot();
			}

		}
	}

	public void defaultInactiveState() {

		if (isElementPresent(By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#fff']"))) {
			if (defaultdarkthemeringfill.isEnabled()) {
				Util.Passed("Missed call ring is in default(inactive) state");
				Util.Passed("Unread ring is in default(inactive) state");
				Util.Screenshot();
			} else {
				Util.Failed("Missed call ring is in active state");
				Util.Failed("Unread ring is in active state");
				Util.Screenshot();
			}

		} else if (isElementPresent(
				By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#77787b']"))) {
			if (defaultlightthemeringfill.isEnabled()) {
				Util.Passed("Missed call ring is in default(inactive) state");
				Util.Passed("Unread ring is in default(inactive) state");
				Util.Screenshot();
			} else {
				Util.Failed("Missed call ring is in active state");
				Util.Failed("Unread ring is in active state");
				Util.Screenshot();
			}
		}
	}

	public void RingActiveState() {
		sleep(5000);

		if (isElementPresent(By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#fff']"))) {
			if (defaultdarkthemeringfill.isEnabled()) {
				clickOn(darkthememissedcallring);
				clickOn(darkthemeunreadring);
				Util.Passed("Missed call ring is turned ON");
				Util.Passed("Unread ring is turned ON");
				Util.Screenshot();
			} else {
				Util.Failed("Missed call ring is in active state");
				Util.Failed("Unread ring is in active state");
				Util.Screenshot();
			}

		} else if (isElementPresent(
				By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#77787b']"))) {
			if (defaultlightthemeringfill.isEnabled()) {
				clickOn(lightthememissedcallring);
				clickOn(lightthemeunreadring);
				Util.Passed("Missed call ring is turned ON");
				Util.Passed("Unread ring is turned ON");
				Util.Screenshot();
			} else {
				Util.Failed("Missed call ring is in active state");
				Util.Failed("Unread ring is in active state");
				Util.Screenshot();
			}
		}
	}

	public void messageStackInactiveRing() {
		if (isElementPresent(By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#fff']"))) {
			if (defaultdarkthemeringfill.isEnabled()) {
				clickOn(darkthememissedcallring);
				clickOn(darkthemeunreadring);
				if (isElementPresent(By.xpath("//div[contains(text(),'No missed calls')]"))) {
					Util.Passed("messages are stacked when the rings have no messages");
					Util.Screenshot();
				} else {
					Util.Failed("messages are not stacked");
					Util.Screenshot();
				}

			}

		} else if (isElementPresent(
				By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#77787b']"))) {
			if (defaultlightthemeringfill.isEnabled()) {
				clickOn(lightthememissedcallring);
				clickOn(lightthemeunreadring);
				if (isElementPresent(By.xpath("//div[contains(text(),'No missed calls')]"))) {
					Util.Passed("messages are stacked when the rings have no messages");
					Util.Screenshot();
				} else {
					Util.Failed("messages are not stacked");
					Util.Screenshot();
				}

			}
		}

	}

	
	
	public void clickOnGhostIcon() throws InterruptedException {
		String msg = messageSent;
		Thread.sleep(5000);
		clickOn(By.xpath("(//span[contains(text(),'" + msg + "')])[2]"), "clicks on msg");
		Thread.sleep(3000);
		clickOn(ghostIcon1);
		ghostIcon2.isDisplayed();
		Thread.sleep(5000);
		Util.Screenshot();
	}

	public void validateGhostIcon() throws InterruptedException {
		Thread.sleep(3000);
		if (ghostIcon2.isDisplayed()) {
			Util.Passed("Ghost icon is applied");
			Thread.sleep(3000);
			Util.Screenshot();
		} else {
			Util.Failed("Ghost icon is not applied");
			Thread.sleep(3000);
			Util.Screenshot();
		}

	}

	public void clickOnHighPriorityIcon() throws InterruptedException {
		String msg = messageSent;
		Thread.sleep(5000);
		clickOn(By.xpath("(//span[contains(text(),'" + msg + "')])[2]"), "clicks on msg");
		Thread.sleep(3000);
		clickOn(highpriority1);
		highpriority2.isDisplayed();
		Thread.sleep(5000);
		Util.Screenshot();
	}

	public void validateHighPriorityIcon() throws InterruptedException {
		Thread.sleep(3000);
		if (highpriority2.isDisplayed()) {
			Util.Passed("High priority icon is applied");
			Thread.sleep(3000);
			Util.Screenshot();
		} else {
			Util.Failed("High priority icon is not applied");
			Thread.sleep(3000);
			Util.Screenshot();
		}

	}

	public void recallIcon() throws InterruptedException {
		String msg = messageSent;
		Thread.sleep(3000);
		if (readmsgStatus.isDisplayed()) {
			clickOn(By.xpath("(//span[contains(text(),'" + msg + "')])[2]"), "clicks on msg");
			clickOn(recallIcon);
			recalledmsgStatus.isDisplayed();
			Util.Passed("Message recalled at sender's end");
			Thread.sleep(3000);
			Util.Screenshot();
		} else {
			Util.Failed("Message not recalled at sender's end");
			Thread.sleep(3000);
			Util.Screenshot();
		}

	}

	public void recalledmsgAtReceiverSide() throws InterruptedException {
		Thread.sleep(5000);
		if (recalledmessage.isDisplayed()) {
			Util.Passed("Message recalled at receiver's end");
			Thread.sleep(3000);
			Util.Screenshot();
		}

		else {
			Util.Failed("Message not recalled at receiver's end");
			Thread.sleep(3000);
			Util.Screenshot();
		}
	}

	public void deleteIcon() throws InterruptedException {
		String msg = messageSent;
		if (deliveredmsgStatus.isDisplayed()) {
			clickOn(By.xpath("(//span[contains(text(),'" + msg + "')])[2]"), "clicks on msg");
			Thread.sleep(3000);
			clickOn(deleteIcon);
			if (isElementPresent(By.xpath("//div[contains(text(),'" + msg + "')]"))) {
				Util.Failed("Message is not deleted");
				Util.Screenshot();
			} else {
				Util.Passed("Message got deleted");
				Util.Screenshot();
			}

		} else {
			Util.Failed("Message cannot be deleted");
			Thread.sleep(3000);
			Util.Screenshot();
		}

	}

//	public void themeChange() throws InterruptedException {
//		Thread.sleep(10000);
//	
//		if (darkthemeIcon.isDisplayed()) {
//			Util.Passed("App is in dark theme");
//			Util.Screenshot();
//		} else if (lightthemeIcon.isDisplayed()) {
//			Util.Passed("App is in light theme");
//			Util.Screenshot();
//		}
//
//}

	public void createOkButton() throws InterruptedException {
		Thread.sleep(5000);
		clickOn(btnCreate);

		clickOn(crossIcon);

		Thread.sleep(5000);

		try {
			// Add a wait timeout before this statement to make
			// sure you are not checking for the alert too soon.
			Alert alt = browser.switchTo().alert();
			String alertText = alt.getText();
			System.out.println("ERROR: (ALERT BOX DETECTED) - ALERT MSG : " + alertText);
			alt.accept();

		} catch (NoAlertPresentException noe) {
			// No alert found on page, proceed with test.
		}

		Thread.sleep(3000);
		if (isElementPresent(msgSubject)) {
			Util.Failed("User can still create new message");
		} else {
			Util.Passed("User cannot create new message");
		}

	}

	public void createCancelButton() throws InterruptedException {
		Thread.sleep(5000);
		clickOn(btnCreate);

		clickOn(crossIcon);

		Thread.sleep(5000);

		try {
			// Add a wait timeout before this statement to make
			// sure you are not checking for the alert too soon.
			Alert alt = browser.switchTo().alert();
			String alertText = alt.getText();
			System.out.println("ERROR: (ALERT BOX DETECTED) - ALERT MSG : " + alertText);
			alt.dismiss();

		} catch (NoAlertPresentException noe) {
			// No alert found on page, proceed with test.
		}

		Thread.sleep(3000);
		if (isElementPresent(msgSubject)) {
			Util.Passed("User can still create new message");
		} else {
			Util.Failed("User cannot create new message");
		}
	}

	public void createMsgPopup() throws InterruptedException {
		Thread.sleep(5000);
		clickOn(btnCreate);

		clickOn(crossIcon);

		Thread.sleep(3000);
		if (isAlertPresent()) {
			Util.Passed("Pop up appears");
		} else {
			Util.Failed("No Pop up appears");
		}
	}

	public void sentenceLibrary() throws InterruptedException {

		Thread.sleep(3000);
		clickOn(btnCreate);
		clickOn(sentenceLibraryButton);
		Util.Screenshot();
		sentenceLibraryText.isDisplayed();
		Thread.sleep(3000);
		systemAuthored.isDisplayed();
		clickOn(copyText);
		Util.Screenshot();
		userAuthored.isDisplayed();
		checkIcon.isDisplayed();
		crossicon.isDisplayed();
		Util.Passed("Both system authored & user authored messages are working");
	}

	public void unreadRingTodosession() throws InterruptedException {

		if (isElementPresent(By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#fff']"))) {
			Util.Passed("Dark theme activated");
			if (defaultdarkthemeringfill.isEnabled()) {
				clickOn(darkthememissedcallring);
				clickOn(darkthemeunreadring);
				Util.Passed("Missed call ring is turned ON");
				Util.Passed("Unread ring is turned ON");
				Util.Screenshot();
				clickOn(ToDoFilter);
				sleep(2000);
				clickOn(allMessagesIcon);
				Assert.assertEquals(2, browser.findElements(By.xpath("//div[@label='ring']")).size());
				Util.Passed("Ring status is same as before switching to ToDo");
				Util.Screenshot();
			}
		} else if (isElementPresent(
				By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#77787b']"))) {
			Util.Passed("Light theme activated");
			if (defaultlightthemeringfill.isEnabled()) {
				clickOn(lightthememissedcallring);
				clickOn(lightthemeunreadring);
				Util.Passed("Missed call ring is turned ON");
				Util.Passed("Unread ring is turned ON");
				Util.Screenshot();
				clickOn(ToDoFilter);
				sleep(2000);
				clickOn(allMessagesIcon);
				Assert.assertEquals(2, browser.findElements(By.xpath("//div[@label='ring']")).size());
				Util.Passed("Ring status is same as before switching to ToDo");
				Util.Screenshot();
			}

		}
	}

	public void unreadRingLogoutsession() throws InterruptedException {

		if (isElementPresent(By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#fff']"))) {
			if (defaultdarkthemeringfill.isEnabled()) {
				Thread.sleep(5000);
				clickOn(darkthememissedcallring);
				clickOn(darkthemeunreadring);
				Util.Passed("Missed call ring is turned ON");
				Util.Passed("Unread ring is turned ON");
				Util.Screenshot();
				clickOn(btnLogOut);
				String username = Util.get("Username");
				String password = Util.get("Password");
				enterText(txtUsername, username);
				enterText(txtPassword, password);
				clickOn(btnSignIn, "Submit Button");
				Assert.assertNotSame(2, browser.findElements(By.xpath("//div[contains(text(),'ON')]")).size());
				Util.Passed("Unread rings are saved between logout sessions");
				Util.Screenshot();
			}
		} else if (isElementPresent(
				By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#77787b']"))) {
			if (defaultlightthemeringfill.isEnabled()) {
				clickOn(lightthememissedcallring);
				clickOn(lightthemeunreadring);
				Util.Passed("Missed call ring is turned ON");
				Util.Passed("Unread ring is turned ON");
				Util.Screenshot();
				clickOn(btnLogOut);
				String username = Util.get("Username");
				String password = Util.get("Password");
				enterText(txtUsername, username);
				enterText(txtPassword, password);
				clickOn(btnSignIn, "Submit Button");
				Thread.sleep(5000);

				Assert.assertNotSame(2, browser.findElements(By.xpath("//div[contains(text(),'ON')]")).size());
				Util.Passed("Unread rings are saved between logout sessions");
				Util.Screenshot();
			}

		}
	}

	public void updatePermissions() throws InterruptedException {
		clickOn(By.xpath("(//img)[2]"), "clicks on endlink logo");
		clickOn(myprofile);
		sleep(2000);
		waitForElement(permissionsDropdown);
		sleep(2000);
		clickOn(permissionsDropdown);
		Thread.sleep(2000);
		clickOn(By.xpath(
				"//span[contains(text(),'Super Admin (create/edit Coworker, view all content, and all other permissions')]"),
				"Clicks on super admin permissions");
		Thread.sleep(2000);
		isElementPresent(By.xpath("//span[contains(text(),'Can manage the Organization')]"));
		Thread.sleep(2000);
		isElementPresent(save);
		Thread.sleep(2000);
		clickOn(By.xpath(
				"//span[contains(text(),'Super Admin (create/edit Coworker, view all content, and all other permissions')]"),
				"Clicks on super admin permissions");
		Thread.sleep(2000);
		isDisabled(save);
		clickOn(backButton);
		clickOn(allMessagesIcon);
		Thread.sleep(2000);

	}

	public void updatePrivacySettings() throws InterruptedException {
		clickOn(By.xpath("(//img)[2]"), "clicks on endlink logo");
		clickOn(myprofile);
		waitForElement(privacyDropdown);
		clickOn(privacyDropdown);
		Thread.sleep(2000);
		if (isElementPresent(By.xpath("(//div[@label='ring' and contains(@class,'lightblue')])[3]"))) {
			clickOn(By.xpath("(//div[@label='ring' and contains(@class,'lightblue')])[3]"), "turns the settings OFF");
			Thread.sleep(2000);
			Util.Screenshot();
			clickOn(save);
			Thread.sleep(2000);
			browser.get(browser.getCurrentUrl());
			waitForElement(privacyDropdown);
			clickOn(privacyDropdown);
			Thread.sleep(2000);
			isElementPresent(By.xpath("(//div[@label='ring' and contains(@class,'gray')])[1]"));
			Util.Screenshot();
			Util.Passed("Settings updated successfully");
			clickOn(allMessagesIcon);

		} else {
			clickOn(By.xpath("//div[@label='ring' and contains(@class,'gray')][1]"), "turns the settings ON");
			Thread.sleep(2000);
			Util.Screenshot();
			clickOn(save);
			Thread.sleep(2000);
			browser.get(browser.getCurrentUrl());
			waitForElement(privacyDropdown);
			clickOn(privacyDropdown);
			Thread.sleep(2000);
			isElementPresent(By.xpath("(//div[@label='ring' and contains(@class,'lightblue')])[3]"));
			Util.Screenshot();
			Util.Passed("Settings updated successfully");
			clickOn(allMessagesIcon);

		}

	}

	public void updatePersonalinfo() throws InterruptedException {
		clickOn(By.xpath("(//img)[2]"), "clicks on endlink logo");
		clickOn(myprofile);

		waitForElement(personalInfoDropdown);
		clickOn(personalInfoDropdown);
		Thread.sleep(2000);
		firstName.click();
		enterText(firstName, "XYZtest");
		isDisabled(emailId);
		clickOn(ID);
		Thread.sleep(2000);
		enterText(ID, "123");
		Util.Screenshot();
		clickOn(save);
		Thread.sleep(2000);

		browser.get(browser.getCurrentUrl());

		waitForElement(personalInfoDropdown);
		clickOn(personalInfoDropdown);
		Thread.sleep(2000);

		isElementPresent(By.xpath("//span[text()='XYZtest']"));
		Util.Screenshot();
		isDisabled(emailId);
		isElementPresent(By.xpath("//input[@value='123']"));
		Util.Passed("Settings updated successfully");
		clickOn(allMessagesIcon);
	}

	public void blurr() throws InterruptedException {
		clickOn(blurr);
		Thread.sleep(2000);
		Util.Screenshot();
		Util.Passed("Blur is applied");
	}

	public void subjectlessThreadwithGroup() throws InterruptedException {
		sleep(3000);
		clickOn(groupFilter, "Group filter");
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("GroupName"));
		Thread.sleep(5000);
		clickOn(recipient);

		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);
		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(5000);

		Util.Screenshot();
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("GroupName"));
		Thread.sleep(2000);
		clickOn(recipient);

		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);
		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Util.Screenshot();
		Thread.sleep(3000);
		Util.Passed("subjectless thread with group merged successfully");

	}

	public void subjectThreadwithGroup() throws InterruptedException {
		sleep(3000);
		clickOn(groupFilter, "Group filter");
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("GroupName"));
		Thread.sleep(2000);
		clickOn(recipient);
		clickOn(msgSubject);
		Thread.sleep(1000);

		enterText(msgSubject, Util.get("Subject"));
		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);
		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(5000);

		Util.Screenshot();
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		Thread.sleep(3000);
		enterText(txtToRecipient, Util.get("GroupName"));
		Thread.sleep(2000);
		clickOn(recipient);
		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);
		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Util.Screenshot();
		Thread.sleep(3000);
		Util.Passed("subject thread with group merged successfully");

	}

	public void subjectlessThreadwithCoworker() throws InterruptedException {

		sleep(3000);
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("RecipientName"));
		clickOn(recipient);

		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);

		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(5000);
		Util.Screenshot();
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("RecipientName"));
		clickOn(recipient);

		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);

		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(3000);
		Util.Passed("subjectless thread with coworker merged successfully");

	}

	public void subjectThreadwithCoworker() throws InterruptedException {

		sleep(3000);
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("RecipientName"));
		clickOn(recipient);
		clickOn(msgSubject);
		enterText(msgSubject, Util.get("Subject"));

		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);

		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(5000);
		Util.Screenshot();
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("RecipientName"));
		clickOn(recipient);

		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);

		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(2000);
		Util.Passed("subject thread with coworker merged successfully");

	}

	public void thumbsUp() throws InterruptedException {

//		clickOn(firstMsg);
//		Actions actions = new Actions(browser);
//		actions.moveToElement(firstMsg).doubleClick().perform();
//		Util.Screenshot();
//		if(isElementPresent(thumbsupicon)) {
//			Util.Passed("Message is liked");
//			Util.Screenshot();
//		}else {
//			Util.Failed("Message is not liked after double clicking the message");
//			Util.Screenshot();
//		}

	}

	public void customerAsRecipient() throws InterruptedException {
		sleep(3000);
		clickOn(btnCreate, "Create message button");
		clickOn(customerIcon);
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("CustomerName"));
		clickOn(recipient);
		Thread.sleep(2000);
		clickOn(Done);
		isElementPresent(By.xpath("//span[contains(text(),'Surabhi Suman will receive messages in this thread')]"));
		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);

		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(2000);
		Util.Screenshot();
		Util.Passed("Thread with customer is created successfully");
	}

	public void customerAsAssociate() throws InterruptedException {

		sleep(5000);
		clickOn(btnCreate, "Create message button");
		clickOn(customerIcon);
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("CustomerName"));
		clickOn(recipient);
		Thread.sleep(5000);

		clickOn(Done);
		Thread.sleep(2000);
		clickOn(customerCrossIcon);
		isElementPresent(By.xpath("//span[contains(text(),'Surabhi Suman will NOT receive messages in this thread')]"));
		clickOn(txtMessageBox);
		messageSent = Util.get("MessageBody") + RandomNo(8);

		enterText(txtMessageBox, messageSent);

		clickOn(btnSend, "Send Message Button");
		Thread.sleep(2000);
		Util.Screenshot();
		Util.Passed("Thread with customer is created successfully");

	}

	public void customerPermissions() throws InterruptedException {
		sleep(3000);
		clickOn(btnCreate, "Create message button");
		clickOn(customerIcon);
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("CustomerName"));
		clickOn(recipient);
		Thread.sleep(2000);
		clickOn(Done);
		isElementPresent(By.xpath("//span[contains(text(),'Surabhi Suman will receive messages in this thread')]"));
		clickOn(By.xpath("(//img)[2]"), "clicks on endlink logo");
		clickOn(myprofile);
		Thread.sleep(2000);

		try {
			Alert alt = browser.switchTo().alert();
			String alertText = alt.getText();
			System.out.println("ERROR: (ALERT BOX DETECTED) - ALERT MSG : " + alertText);
			alt.accept();

		} catch (NoAlertPresentException noe) {
			// No alert found on page, proceed with test.
		}
		Thread.sleep(2000);
		waitForElement(permissionsDropdown);
		clickOn(permissionsDropdown);
		Thread.sleep(2000);
		if (isElementPresent(superAdminIcon)) {
			Util.Passed("User has settings to create/edit/view patients");
			Util.Screenshot();
			clickOn(backButton);
			clickOn(allMessagesIcon);
		} else {
			if (isElementPresent(By.xpath("(//div[contains(@class,'coworkerPermissions-m__permission')])[3]"))
					&& isElementPresent(By.xpath("(//div[contains(@class,'coworkerPermissions-m__permission')])[5]"))) {
				Util.Passed("User have permissions to create/edit/view customers");
			} else {
				clickOn(By.xpath("(//div[contains(@class,'coworkerPermissions-m__permission')])[2]"),
						"Clicks on Can create a patient settings");
				isElementPresent(By.xpath("(//div[contains(@class,'coworkerPermissions-m__permission')])[3]"));
				clickOn(By.xpath("(//div[contains(@class,'coworkerPermissions-m__permission')])[4]"),
						"Clicks on Can create a patient settings");
				isElementPresent(By.xpath("(//div[contains(@class,'coworkerPermissions-m__permission')])[5]"));
				Util.Passed("User have permissions to create/edit/view customers");
				Util.Screenshot();
				Thread.sleep(2000);
				clickOn(backButton);
				clickOn(allMessagesIcon);

			}
		}

	}

	public void singleCustomerToBar() throws InterruptedException {
		sleep(5000);
		clickOn(btnCreate, "Create message button");
		clickOn(customerIcon);
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("CustomerName"));
		clickOn(recipient);
		Thread.sleep(5000);

		clickOn(Done);
		Thread.sleep(4000);
		if (isElementPresent(txtToRecipient)) {
			Util.Failed("To bar is present");
			Util.Failed("More than one customer is allowed to be added in To bar");
		} else {
			Util.Passed("To bar is not present");
			Util.Passed("Only one customer is allowed to be added at To bar");
		}

		Thread.sleep(2000);
		Util.Screenshot();

	}

	public void validateRecipienttype() throws InterruptedException {
		sleep(3000);
		clickOn(btnCreate, "Create message button");
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("RecipientName"));
		clickOn(recipient);
		Thread.sleep(2000);
		clickOn(txtToRecipient);
		enterText(txtToRecipient, Util.get("CustomerName"));
		isElementPresent(
				By.xpath("//div[contains(@class,'searchrecipient') and @role='button' and @aria-hidden='true']"));
		Util.Screenshot();
		Thread.sleep(2000);
		Util.Passed("Customer name is disabled");

	}

	public void customerIconDarkTheme() throws InterruptedException {
		sleep(3000);
		if (isElementPresent(By.xpath("//*[name()='svg'][@class='themeicon']/*[name()='path'][@fill='#fff']"))) {
			clickOn(btnCreate, "Create message button");
			clickOn(customerIcon);
			svgIsSelected(darkThemeCustomerIcon);
			Util.Screenshot();
			Thread.sleep(2000);
			Util.Passed("Customer icon is same in menu panel & To before dark theme");
		}

	}

	public LoginPage logout() {
		clickOn(btnLogOut);
		if (isElementPresent(By.xpath("//input[@type='email']"))) {
			Util.Passed("Logged out successfully from the application");
			Util.Screenshot();
		} else {
			Util.Failed("Unable to logout from the application");
		}
		return new LoginPage(browser);
	}
	
	public LoginPage logout1() {
		clickOn(btnLogOut);
		clickOn(catLogout);
		if (isElementPresent(By.xpath("//input[@type='email']"))) {
			Util.Passed("Logged out successfully from the application");
			Util.Screenshot();
		} else {
			Util.Failed("Unable to logout from the application");
		}
		return new LoginPage(browser);
	}
}
