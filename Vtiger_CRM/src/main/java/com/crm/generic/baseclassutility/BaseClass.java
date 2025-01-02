package com.crm.generic.baseclassutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.generic.databaseutilities.DatabaseUtility;
import com.crm.generic.fileutilities.ExcelUtility;
import com.crm.generic.fileutilities.FileUtility;
import com.crm.generic.listenerutilities.UtilityObject;
import com.crm.generic.webdriverutilities.JavaUtility;
import com.crm.generic.webdriverutilities.WebdriverUtility;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;

public class BaseClass {
	public FileUtility fileutility = new FileUtility();
	public ExcelUtility excelutility = new ExcelUtility();
	public WebdriverUtility webdriverutility = new WebdriverUtility();
	public JavaUtility javautility = new JavaUtility();
	public DatabaseUtility databaseutility = new DatabaseUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"regression","smoke"})
	public void beforeSuite() throws SQLException {
	   databaseutility.getDBConnection(null, null, null);
	}
     @Parameters("browser")
	@BeforeClass(groups = {"regression","smoke"})
	public void beforeClass(@Optional("chrome") String browser) throws IOException {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		webdriverutility.maximizeWindow(driver);
		webdriverutility.implicitwait(driver,10);
		webdriverutility.launchURL(driver, fileutility.getDataFromPropertyFile("url"));
		sdriver = driver;
		UtilityObject.setDriver(driver);
	}
	
	@BeforeMethod(groups = {"regression","smoke"})
	public void beforeMethod() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(fileutility.getDataFromPropertyFile("username"), fileutility.getDataFromPropertyFile("password"));  
	}
	
	@AfterMethod(groups = {"regression","smoke"})
	public void afterMethod() {
		HomePage homepage = new HomePage(driver);
		homepage.logout(driver);
	}
	
	@AfterClass(groups = {"regression","smoke"})
	public void afterClass() {
		webdriverutility.minimizeWindow(driver);
		webdriverutility.quitBrowser(driver);
	}
	
	@AfterSuite(groups = {"regression","smoke"})
	public void afterSuite() {
		databaseutility.closeDBConnection();
	}
}
