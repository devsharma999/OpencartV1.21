package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseTest;

import com.aventstack.extentreports.Status;

public class ExtentManagerUtility implements ITestListener {

	public static ExtentSparkReporter sparkReporter; // UI of the Report
	private static ExtentReports extent; // Populate common info on the report
	private static ExtentTest test; // creating test case entries in the report and update status of the method

	String repName;

	public void onStart(ITestContext testcontext) {

//    	SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.HH.mm.ss");
//    	Date dt = new Date();
//    	String currentDatetimestamp = df.format(dt);

		String timestamp = new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timestamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
		sparkReporter.config().setDocumentTitle("OpenCart Automation Report"); // Title Of the Report
		sparkReporter.config().setReportName("OpenCart Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		// Set system/environment info
		extent.setSystemInfo("Tester Name", "DevSharma");
		extent.setSystemInfo("OpreatingSystem", System.getProperty("os.name"));
		extent.setSystemInfo("User", System.getProperty("user.name"));
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customer");
		extent.setSystemInfo("Enviorment", "QA");

		String os = testcontext.getCurrentXmlTest().getParameter("OS");
		extent.setSystemInfo("OS", os);
		String br = testcontext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", br);

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test passed successfully");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL, "Test failed: " + result.getThrowable());
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgpath = new BaseTest().captureScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgpath);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "Got Skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext context) {
		extent.flush(); // Write everything to the report
		
		String pathofExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
