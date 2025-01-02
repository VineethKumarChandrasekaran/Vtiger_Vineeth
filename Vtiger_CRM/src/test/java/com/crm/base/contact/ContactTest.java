package com.crm.base.contact;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseclassutility.BaseClass;
import com.crm.generic.listenerutilities.UtilityObject;
import com.crm.objectrepository.ContactPage;
import com.crm.objectrepository.CreateNewContactsPage;
import com.crm.objectrepository.HomePage;
@Listeners(com.crm.generic.listenerutilities.ListenerUtility.class)
public class ContactTest extends BaseClass {
	public HomePage homepage;
	public ContactPage contactpage;
	public CreateNewContactsPage createnewcontactspage;

	@Test(groups = "smoke")
	public void createCon() throws IOException {
		homepage = new HomePage(driver);
		contactpage = new ContactPage(driver);
		createnewcontactspage = new CreateNewContactsPage(driver);
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Home", 1, 0));
		homepage.getContactsLink().click();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Contact", 1, 0));
		contactpage.getCreatecontactbutton().click();
		createnewcontactspage.createcontact(fileutility.getDataFromPropertyFile("lastname"));
		boolean header = createnewcontactspage.getHeadertext().getText()
				.contains(fileutility.getDataFromPropertyFile("lastname"));
		Assert.assertTrue(header);
		UtilityObject.getTest().log(Status.INFO, fileutility.getDataFromPropertyFile("lastname") + " Contact got Created");
	}

	@Test(groups = "regression")
	public void createConWithOrg() throws IOException {
		homepage = new HomePage(driver);
		contactpage = new ContactPage(driver);
		createnewcontactspage = new CreateNewContactsPage(driver);
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Home", 1, 0));
		homepage.getContactsLink().click();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Contact", 1, 0));
		contactpage.getCreatecontactbutton().click();
		createnewcontactspage.createContactWithOrg(driver, fileutility.getDataFromPropertyFile("lastname"));
		boolean header = createnewcontactspage.getHeadertext().getText()
				.contains(fileutility.getDataFromPropertyFile("lastname"));
		Assert.assertTrue(header);
		UtilityObject.getTest().log(Status.INFO, fileutility.getDataFromPropertyFile("lastname") + " Contact got Created");
	}

	@Test(groups = "regression")
	public void createConWithOrgAndDate() throws IOException {
		homepage = new HomePage(driver);
		contactpage = new ContactPage(driver);
		createnewcontactspage = new CreateNewContactsPage(driver);
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Home", 1, 0));
		homepage.getContactsLink().click();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Contact", 1, 0));
		contactpage.getCreatecontactbutton().click();
		createnewcontactspage.createContactWithOrgAndDate(driver, fileutility.getDataFromPropertyFile("lastname"),
				javautility.getSystemDate(), javautility.getCalculatedDate(30));
		boolean header = createnewcontactspage.getHeadertext().getText()
				.contains(fileutility.getDataFromPropertyFile("lastname"));
		Assert.assertTrue(header);
		UtilityObject.getTest().log(Status.INFO, fileutility.getDataFromPropertyFile("lastname") + " Contact got Created");
	}
}
