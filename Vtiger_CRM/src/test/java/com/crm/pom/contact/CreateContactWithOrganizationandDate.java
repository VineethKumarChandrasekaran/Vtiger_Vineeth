package com.crm.pom.contact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.generic.fileutilities.ExcelUtility;
import com.crm.generic.fileutilities.FileUtility;
import com.crm.generic.webdriverutilities.JavaUtility;
import com.crm.generic.webdriverutilities.WebdriverUtility;
import com.crm.objectrepository.ContactPage;
import com.crm.objectrepository.CreateNewContactsPage;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;

public class CreateContactWithOrganizationandDate {
	public static WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public ContactPage contactpage;
	public CreateNewContactsPage createnewcontactspage;
	@Test
	public void createCon() throws IOException {
		FileUtility fileutility = new FileUtility();
		ExcelUtility excelutility = new ExcelUtility();
		WebdriverUtility webdriverutility = new WebdriverUtility();
		JavaUtility javautility = new JavaUtility();
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
			    createnewcontactspage.getLastnametextbox().sendKeys(fileutility.getDataFromPropertyFile("lastname"));
			    createnewcontactspage.getOrganizationlookupbutton().click();
			    webdriverutility.switchWindow(driver, "Accounts");
			    createnewcontactspage.getOrgname().click();
			    webdriverutility.switchWindow(driver, "Contacts");
			    createnewcontactspage.getSupportstartdatetextbox().clear();
			    createnewcontactspage.getSupportstartdatetextbox().sendKeys(javautility.getSystemDate());
			    createnewcontactspage.getSupportenddatetextbox().clear();
			    createnewcontactspage.getSupportenddatetextbox().sendKeys(javautility.getCalculatedDate(30));	    
			    createnewcontactspage.getSavebutton().click();
			    if(createnewcontactspage.getHeadertext().getText().contains(fileutility.getDataFromPropertyFile("lastname"))) {
			    	System.out.println(fileutility.getDataFromPropertyFile("lastname")+" Contact got Created");
			    }else {
			    	System.out.println(fileutility.getDataFromPropertyFile("lastname")+" Contact got not Created");
			    }
			}
		}
		webdriverutility.minimizeWindow(driver);
		webdriverutility.quitBrowser(driver);
	}


}
