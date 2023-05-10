package utilities;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Util {

	public static String OutputExcelPath = "";
	public static Logger logger;
	 public static Sheet s;

	 public static void readProperty() {
		try {
			FileReader reader=new FileReader("./src/test/resources/config.properties");  
			  
			Values.frameworkProperty=new Properties();  
			Values.frameworkProperty.load(reader);  
			  
		} catch (Exception e) {
			
		}  
	 }
	 
	public static void  start(String sheetName,String tcName,String Description) {
		Values.data.clear();		
		Values.data = ExcelData.GetExcelTableInto2DArrayListString("./src/test/resources/data.xlsx", sheetName);
		retrieveData(sheetName,tcName);
		readProperty();
		Values.parent = Values.extent.startTest(tcName,"<font size=4 color=black>" +Description+ "</font><br/>");
	}
	
	public static void Screenshot()
	{
		Values.screenshotNo += 1;		
		captureScreenShot("Screenshot" + Values.screenshotNo);					
		embedScreenshot("orange", "Screenshots" + "/Screenshot" + Values.screenshotNo);
	}
	
	public static void embedScreenshot(String colour, String pathAndFile)
	{   
		Values.child.log(LogStatus.INFO, "Manual Verification Point: " + Values.child.addScreenCapture(pathAndFile+ ".png"));    
	}
	
	public static void captureScreenShot(String filename)
	{		
		File scrFile = null;
		String scrPath = Values.outputDirectory + "/Screenshots";
		File file = new File(scrPath);
		file.mkdir();
		try{
			scrFile = (File)((RemoteWebDriver) Values.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(scrPath + "/" + filename + ".png"));
		}catch (Exception e){
			Reporter("Red", e.toString()); return;
		}
	}

	public static void Failed(String errMessage)
	{
		Values.testFailure = true;
		Values.failureNo += 1;
		writeToLogFile("Error", errMessage);
		Reporter("Red", errMessage);
		Screenshot();
	}

	public static void Passed(String errMessage)
	{
		writeToLogFile("Info", errMessage);
		Reporter("Green", errMessage);
	}
	
	
	

	
	public static enum colorTypes
	{
		green, 
		red, 
		blue, 
		orange,  white;
	}
	public static void Reporter(String color, String report)
	{
		colorTypes ct = colorTypes.valueOf(color.toLowerCase());
		if (!color.contains("white"))
		{
			Values.currentStep += 1;
		}

		switch (ct)
		{
		case green: 
			Values.child.log(LogStatus.PASS,"<font color=green>" + Values.currentStep + ". " + report + "</font><br/>");writeToLogFile("PASS", "Report step generation success : " + report);System.out.println("green" + Values.currentStep); break;
		case blue:  Values.child.log(LogStatus.INFO,"<font color=blue>" + Values.currentStep + ". " + report + "</font><br/>");writeToLogFile("INFO", "Report step generation success : " + report);System.out.println("blue" + Values.currentStep); break;
		case orange:  Values.child.log(LogStatus.WARNING,"<font color=orange>" + Values.currentStep + ". " + report + "</font><br/>");writeToLogFile("WARN", "Report step generation success : " + report); break;
		case red:  Values.child.log(LogStatus.FAIL,"<font color=red>" + Values.currentStep + ". " + report + "</font><br/>");writeToLogFile("ERROR", "Report step generation success : " + report);System.out.println("red" + Values.currentStep); break;
		case white:  Values.child.log(LogStatus.INFO,report);writeToLogFile("WARN", "Report step generation success : " + report);
		}

	}

	public static void Info(String errMessage) {
		writeToLogFile("Info", errMessage);
		Reporter("Blue", errMessage);
	}

	  public static void retrieveData(String sheetName,String testCaseName)
		{
		  Values.testcases.clear();
			String testCaseDataSet = null;
			String executionFlag = null;			
			Boolean flag = Boolean.valueOf(false);
			
			 for(int i=0;i<Values.data.size();i++) {
				 String name = "";
				 try {
					 name = Values.data.get(i).get(1).toString();
				 }catch(Exception e) {
					 
				 }
				 if(name.equals(testCaseName)) {
					 Values.testCaseRow = i;
					 for(int j=i+1;j<Values.data.size();j++) {	
						 if(Values.data.get(j).size()!=0) {
							testCaseDataSet = Values.data.get(j).get(0).toString();
							writeToLogFile("INFO", "Test case data set in sheet : " + testCaseDataSet);
							executionFlag = Values.data.get(j).get(1).toString();
							writeToLogFile("INFO", "Flag for the data set is : " + executionFlag);
							if ((testCaseDataSet.startsWith(testCaseName)) && (executionFlag.toUpperCase().equals("YES")))
							{
								Values.testcases.add(testCaseDataSet);
							} else if (testCaseDataSet.isEmpty())
							{
								flag = Boolean.valueOf(true);
								break;
							}
						 }else {
							 flag = Boolean.valueOf(true);
								break;
						 }
						
					 }
					 if (flag.booleanValue()) {
							break;
						}
				 }
				 
			 }
		}
	  



	public static void writeToLogFile(String type, String message)
	{		
		String t = type.toUpperCase();
		if (t.equalsIgnoreCase("DEBUG"))
		{
			Util.logger.debug(message);
		}
		if (t.equalsIgnoreCase("PASS"))
		{
			Util.logger.info(message);
		}
		else if (t.equalsIgnoreCase("INFO"))
		{
			Util.logger.info(message);
		}
		else if (t.equalsIgnoreCase("WARN"))
		{
			Util.logger.warn(message);
		}
		else if (t.equalsIgnoreCase("ERROR"))
		{
			Util.logger.error(message);
		}
		else if (t.equalsIgnoreCase("FATAL"))
		{
			Util.logger.fatal(message);
		}
		else {
			Util.logger.warn(message);
		}
	}

	public static void logInfo(String msg) {
		writeToLogFile("INFO",msg);
	}

	public static void logFail(String msg) {
		writeToLogFile("ERROR",msg);
	}


	public static void createLogFile()
	{
		
		Properties props = new Properties();
		String propsFileName = "./src/test/resources/log4j.properties";
		String path;

		try
		{
			String myStr = Values.outputDirectory.substring(Values.outputDirectory.length() - 22);
		      
		      //myStr = "./TestResults/" + myStr + "/LogFile.log";
			path = Values.outputDirectory+"/LogFile.log";
			java.io.FileInputStream configStream = new java.io.FileInputStream(propsFileName);
			props.load(configStream);

			props.setProperty("log4j.appender.FA.File", path);
			java.io.FileOutputStream output = new java.io.FileOutputStream(propsFileName);
			props.store(output, "Output Directory updated : " + path);


			output.close();
			configStream.close();


			org.apache.log4j.PropertyConfigurator.configure(propsFileName);

			Util.logger = org.apache.log4j.Logger.getLogger(path);
			Util.writeToLogFile("INFO", "Test script execution started...");

			Util.writeToLogFile("INFO", "Log File creation done : LogFile.log");
		}catch (IOException ex){
			System.out.println("There was an error creating the log file");
		}
	}

	public static String get(String Label)
	{
		for(int i=0;i<Values.data.get(Values.testCaseRow).size();i++) {
			String colName = Values.data.get(Values.testCaseRow).get(i).toString();
			if(colName.equals(Label)) {
				return Values.data.get(Values.testCaseDataRow).get(i-1).toString();
			}
		}
		return "";
	}
	
	  
	  public static String am_pm;
	  public static String min;
	  public static String hr;
	  public static String sec;
	  public static int yr;
	  public static String mon;
	  public static String day;
	  
	  public static void createOutputDirectory()
	  {
	    java.io.File curdir = new java.io.File(".");
	    
	    Calendar calendar = new java.util.GregorianCalendar();
	    

	    hr = "0" + calendar.get(10);
	    hr = hr.substring(hr.length() - 2);
	    
	    min = "0" + calendar.get(12);
	    min = min.substring(min.length() - 2);
	    

	    sec = "0" + calendar.get(13);
	    sec = sec.substring(sec.length() - 2);
	    
	    yr = calendar.get(1);
	    

	    mon = "0" + (calendar.get(2) + 1);
	    mon = mon.substring(mon.length() - 2);
	    
	    day = "0" + calendar.get(5);
	    day = day.substring(day.length() - 2);
	    
	    if (calendar.get(9) == 0) {
	      am_pm = "AM";
	    } else {
	      am_pm = "PM";
	    }    
	    Values.timeStamp = yr + "_" + mon + "_" + day + "_" + hr + "_" + min + "_" + sec + "_" + am_pm;    
	    try
	    {
	    	String strProjectPath = curdir.getCanonicalPath();
	    	Values.outputDirectory = curdir.getCanonicalPath() + "/TestResults/" + yr + "_" + mon + "_" + day + "_" + hr + "_" + min + "_" + sec + "_" + am_pm;
	    }
	    catch (IOException e)
	    {
	      System.out.println("IO Error while creating Output Directory : " + Values.outputDirectory);
	    }
	    
	    createLogFile();
	  }

	public static int returnIndex(String testDataSet) {
		 for(int i=0;i<Values.data.size();i++) {
			 if(Values.data.get(i).size()!=0) {
			 if(Values.data.get(i).get(0).toString().equals(testDataSet)) {
				 return i;
			 }
			 }
		 }
		return -1;
	}

	public static void start(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	  
}
