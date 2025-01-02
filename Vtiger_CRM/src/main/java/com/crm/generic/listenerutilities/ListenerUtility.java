package com.crm.generic.listenerutilities;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.crm.generic.baseclassutility.BaseClass;
import com.crm.generic.webdriverutilities.JavaUtility;
import com.crm.generic.webdriverutilities.WebdriverUtility;

/**
 * @author Vineeth Kumar C
 */
public class ListenerUtility implements ITestListener, ISuiteListener, IRetryAnalyzer {
	
	WebdriverUtility webdriverutility = new WebdriverUtility();
	JavaUtility javautility = new JavaUtility();
	public ExtentReports extentreports;
	public ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/"+suite.getName()+"_"+javautility.getLocalDateTime());
		spark.config().setDocumentTitle("V_Tiger Execution Reports");
		spark.config().setReportName("V_Tiger Module Report");
		extentreports = new ExtentReports();
		extentreports.attachReporter(spark);
		extentreports.setSystemInfo(null, null);
	}
	
	@Override
	public void onFinish(ISuite suite) {
		extentreports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
	test = extentreports.createTest(result.getName());
	UtilityObject.setTest(test);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64),result.getName()+"_"+javautility.getLocalDateTime());
		try {
			webdriverutility.takeScreenshot(BaseClass.sdriver, javautility.getLocalDateTime(), result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName()+" is Success");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getName()+" is Skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public boolean retry(ITestResult result) {
		int count = 0, limitcount =5;
		if(count<limitcount) {
			count++;
			return true;
		}
		return false;
	}
}
