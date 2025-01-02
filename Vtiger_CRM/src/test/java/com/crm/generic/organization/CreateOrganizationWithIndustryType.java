package com.crm.generic.organization;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.generic.fileutilities.ExcelUtility;
import com.crm.generic.fileutilities.FileUtility;
import com.crm.generic.webdriverutilities.JavaUtility;
import com.crm.generic.webdriverutilities.WebdriverUtility;

public class CreateOrganizationWithIndustryType {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
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
		String orgname = fileutility.getDataFromPropertyFile("organizationname")+javautility.getRandomNumber();
		webdriverutility.maximizeWindow(driver);
		webdriverutility.implicitwait(driver,10);
		webdriverutility.launchURL(driver, fileutility.getDataFromPropertyFile("url"));
		driver.findElement(By.xpath("//input[@name='user_name']")).clear();
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(fileutility.getDataFromPropertyFile("username"));
		driver.findElement(By.xpath("//input[@name='user_password']")).clear();
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(fileutility.getDataFromPropertyFile("password"));
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		if(webdriverutility.getPageTitle(driver).equals(excelutility.getDataFromExcel("Home", 1, 0))) {
			System.out.println("Home Page got displayed");
		    driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		    if(webdriverutility.getPageTitle(driver).equals(excelutility.getDataFromExcel("Organization", 1, 0))) {
				System.out.println("Organization Page got displayed");
			    driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
			    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
			    webdriverutility.selectDropdownByValue(driver, driver.findElement(By.xpath("//select[@name='industry']")), "Energy");
			    driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
			    if(driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText().contains(orgname)) {
			    	System.out.println(orgname+" got Created");
			    }else {
			    	System.out.println(orgname+" got not Created");
			    }
			}
		}
		webdriverutility.minimizeWindow(driver);
		webdriverutility.quitBrowser(driver);

	}

}
