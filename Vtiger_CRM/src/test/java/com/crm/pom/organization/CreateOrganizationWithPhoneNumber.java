package com.crm.pom.organization;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.generic.fileutilities.ExcelUtility;
import com.crm.generic.fileutilities.FileUtility;
import com.crm.generic.webdriverutilities.JavaUtility;
import com.crm.generic.webdriverutilities.WebdriverUtility;
import com.crm.objectrepository.CreateNewOrganizationPage;
import com.crm.objectrepository.HomePage;
import com.crm.objectrepository.LoginPage;
import com.crm.objectrepository.OrganizationPage;

public class CreateOrganizationWithPhoneNumber {
	public static WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public OrganizationPage organization;
	public CreateNewOrganizationPage createneworganization;

	@Test
	public void createOrg() throws IOException {

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
		organization = new OrganizationPage(driver);
		createneworganization = new CreateNewOrganizationPage(driver);
		String orgname = fileutility.getDataFromPropertyFile("organizationname") + javautility.getRandomNumber();
		webdriverutility.maximizeWindow(driver);
		webdriverutility.implicitwait(driver,10);
		webdriverutility.launchURL(driver, fileutility.getDataFromPropertyFile("url"));
		loginpage.getUsernameTextField().clear();
		loginpage.getUsernameTextField().sendKeys(fileutility.getDataFromPropertyFile("username"));
		loginpage.getPasswordTextField().clear();
		loginpage.getPasswordTextField().sendKeys(fileutility.getDataFromPropertyFile("password"));
		loginpage.getLoginButton().click();
		if (webdriverutility.getPageTitle(driver).equals(excelutility.getDataFromExcel("Home", 1, 0))) {
			System.out.println("Home Page got displayed");
			homepage.getOrganizationsLink().click();
			if (webdriverutility.getPageTitle(driver).equals(excelutility.getDataFromExcel("Organization", 1, 0))) {
				System.out.println("Organization Page got displayed");
				organization.getCreateOrganization().click();
				createneworganization.getOrganizationname().sendKeys(orgname);
				webdriverutility.selectDropdownByValue(driver, createneworganization.getIndustry(), "Energy");
				createneworganization.getPhone().sendKeys(javautility.getRandomPhoneNumber());
				createneworganization.getSavebutton().click();
				if (createneworganization.getHeadertext().getText().contains(orgname)) {
					System.out.println(orgname + " got Created");
				} else {
					System.out.println(orgname + " got not Created");
				}
			}
		}
		webdriverutility.minimizeWindow(driver);
		webdriverutility.quitBrowser(driver);
	}
}
