package com.crm.practice;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.generic.fileutilities.ExcelUtility;
import com.crm.generic.fileutilities.FileUtility;
import com.crm.generic.webdriverutilities.JavaUtility;
import com.crm.generic.webdriverutilities.WebdriverUtility;
import com.crm.objectrepository.ContactPage;
import com.crm.objectrepository.CreateNewContactsPage;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;

public class CreateContact_DataProvider {
	public static WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public ContactPage contactpage;
	public CreateNewContactsPage createnewcontactspage;
	public FileUtility fileutility;
	public ExcelUtility excelutility;
	public WebdriverUtility webdriverutility;
	public JavaUtility javautility;
	@Test(dataProvider = "testscriptdata")
	public void createCon(String lastname) throws IOException {
		fileutility = new FileUtility();
		excelutility = new ExcelUtility();
		webdriverutility = new WebdriverUtility();
		javautility = new JavaUtility();
		if (fileutility.getDataFromPropertyFile("browser").equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (fileutility.getDataFromPropertyFile("browser").equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		} 
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		contactpage = new ContactPage(driver);
		createnewcontactspage = new CreateNewContactsPage(driver);
		webdriverutility.maximizeWindow(driver);
		webdriverutility.implicitwait(driver,10);
		webdriverutility.launchURL(driver, fileutility.getDataFromPropertyFile("url"));
		loginpage.getUsernameTextField().clear();
		loginpage.getUsernameTextField().sendKeys(fileutility.getDataFromPropertyFile("username"));
		loginpage.getPasswordTextField().clear();
		loginpage.getPasswordTextField().sendKeys(fileutility.getDataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		if(webdriverutility.getPageTitle(driver).equals(excelutility.getDataFromExcel("Home", 1, 0))) {
			System.out.println("Home Page got displayed");
		    homepage.getContactsLink().click();
		    if(webdriverutility.getPageTitle(driver).equals(excelutility.getDataFromExcel("Contact", 1, 0))) {
				System.out.println("Contact Page got displayed");
			    contactpage.getCreatecontactbutton().click();
			    createnewcontactspage.getLastnametextbox().sendKeys(lastname);
			    createnewcontactspage.getSavebutton().click();
			    if(createnewcontactspage.getHeadertext().getText().contains(fileutility.getDataFromPropertyFile("lastname"))) {
			    	System.out.println(lastname+" Contact got Created");
			    }else {
			    	System.out.println(lastname+" Contact got not Created");
			    }
			}
		}
		webdriverutility.minimizeWindow(driver);
		webdriverutility.quitBrowser(driver);
	}
	
	@DataProvider(name = "testscriptdata")
	public Object[][] data() throws EncryptedDocumentException, IOException{
		excelutility = new ExcelUtility();
		int rowcount = excelutility.getRowCount("Contact_Data");
		Object[][] object = new Object[rowcount][1];
		for (int i=0; i<rowcount; i++) {
			object[i][0] = excelutility.getDataFromExcel("Contact_Data", i+1, 0);
		}
		return object;
	}
}
