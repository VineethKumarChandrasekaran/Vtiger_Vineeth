package com.crm.base.organization;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.generic.baseclassutility.BaseClass;
import com.crm.generic.listenerutilities.UtilityObject;
import com.crm.objectrepository.CreateNewOrganizationPage;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.OrganizationPage;
@Listeners(com.crm.generic.listenerutilities.ListenerUtility.class)
public class OrganizationTest extends BaseClass {
	public HomePage homepage;
	public OrganizationPage organization;
	public CreateNewOrganizationPage createneworganization;

	@Test(groups = "smoke")
	public void createOrg() throws IOException {
		homepage = new HomePage(driver);
		organization = new OrganizationPage(driver);
		createneworganization = new CreateNewOrganizationPage(driver);
		String orgname = fileutility.getDataFromPropertyFile("organizationname") + javautility.getRandomNumber();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Home", 1, 0));
		homepage.getOrganizationsLink().click();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Organization", 1, 0));
		organization.getCreateOrganization().click();
		createneworganization.createorg(orgname);
		boolean header = createneworganization.getHeadertext().getText().contains(orgname);
		Assert.assertTrue(header);
		UtilityObject.getTest().log(Status.INFO, orgname + " got Created");

	}

	@Test(groups = "regression")
	public void createOrgWithIndustry() throws IOException {
		homepage = new HomePage(driver);
		organization = new OrganizationPage(driver);
		createneworganization = new CreateNewOrganizationPage(driver);
		String orgname = fileutility.getDataFromPropertyFile("organizationname") + javautility.getRandomNumber();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Home", 1, 0));
		Reporter.log("Home Page got displayed",true);
		homepage.getOrganizationsLink().click();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Organization", 1, 0));
		Reporter.log("Organization Page got displayed",true);
		organization.getCreateOrganization().click();
		createneworganization.createorgWithIndustry(driver, orgname, "Energy");
		boolean header = createneworganization.getHeadertext().getText().contains(orgname);
		Assert.assertTrue(header);
		UtilityObject.getTest().log(Status.INFO, orgname + " got Created");
	}

	@Test(groups = "regression")
	public void createOrgWithPhoneNumber() throws IOException {
		homepage = new HomePage(driver);
		organization = new OrganizationPage(driver);
		createneworganization = new CreateNewOrganizationPage(driver);
		String orgname = fileutility.getDataFromPropertyFile("organizationname") + javautility.getRandomNumber();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Home", 1, 0));
		homepage.getOrganizationsLink().click();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Organization", 1, 0));
		organization.getCreateOrganization().click();
		createneworganization.createorgWithIndustryAndPhoneNumber(driver, orgname, "Energy",
				javautility.getRandomPhoneNumber());
		boolean header = createneworganization.getHeadertext().getText().contains(orgname);
		Assert.assertTrue(header);
		UtilityObject.getTest().log(Status.INFO, orgname + " got Created");
	}
}
