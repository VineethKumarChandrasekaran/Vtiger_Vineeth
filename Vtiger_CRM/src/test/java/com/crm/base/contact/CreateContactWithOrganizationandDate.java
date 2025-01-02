package com.crm.base.contact;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.generic.baseclassutility.BaseClass;
import com.crm.generic.fileutilities.ExcelUtility;
import com.crm.generic.fileutilities.FileUtility;
import com.crm.generic.webdriverutilities.JavaUtility;
import com.crm.generic.webdriverutilities.WebdriverUtility;
import com.crm.objectrepository.ContactPage;
import com.crm.objectrepository.CreateNewContactsPage;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;

public class CreateContactWithOrganizationandDate extends BaseClass {
	public LoginPage loginpage;
	public HomePage homepage;
	public ContactPage contactpage;
	public CreateNewContactsPage createnewcontactspage;

	@Test(groups = "regression")
	public void createCon() throws IOException {
		homepage = new HomePage(driver);
		contactpage = new ContactPage(driver);
		createnewcontactspage = new CreateNewContactsPage(driver);
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Home", 1, 0));
		System.out.println("Home Page got displayed");
		homepage.getContactsLink().click();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Contact", 1, 0));
		System.out.println("Contact Page got displayed");
		contactpage.getCreatecontactbutton().click();
		createnewcontactspage.createContactWithOrgAndDate(driver,fileutility.getDataFromPropertyFile("lastname"), javautility.getSystemDate(),javautility.getCalculatedDate(30));
		if (createnewcontactspage.getHeadertext().getText().contains(fileutility.getDataFromPropertyFile("lastname"))) {
			System.out.println(fileutility.getDataFromPropertyFile("lastname") + " Contact got Created");
		} else {
			System.out.println(fileutility.getDataFromPropertyFile("lastname") + " Contact got not Created");
		}
	}
}
