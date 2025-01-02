package com.crm.base.organization;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.generic.baseclassutility.BaseClass;
import com.crm.objectrepository.CreateNewOrganizationPage;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.OrganizationPage;

public class CreateOrganizationWithIndustryType extends BaseClass {
	public HomePage homepage;
	public OrganizationPage organization;
	public CreateNewOrganizationPage createneworganization;

	@Test(groups = "regression")
	public void createOrg() throws IOException {
		homepage = new HomePage(driver);
		organization = new OrganizationPage(driver);
		createneworganization = new CreateNewOrganizationPage(driver);
		String orgname = fileutility.getDataFromPropertyFile("organizationname") + javautility.getRandomNumber();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Home", 1, 0));
		System.out.println("Home Page got displayed");
		homepage.getOrganizationsLink().click();
		Assert.assertEquals(webdriverutility.getPageTitle(driver), excelutility.getDataFromExcel("Organization", 1, 0));
		System.out.println("Organization Page got displayed");
		organization.getCreateOrganization().click();
		createneworganization.createorgWithIndustry(driver, orgname, "Energy");
		if (createneworganization.getHeadertext().getText().contains(orgname)) {
			System.out.println(orgname + " got Created");
		} else {
			System.out.println(orgname + " got not Created");
		}	
	}
}
