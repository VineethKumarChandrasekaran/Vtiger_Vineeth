package com.crm.generic.contact;

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

public class CreateContactWithOrganizationandDate {
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
		    driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
		    if(webdriverutility.getPageTitle(driver).equals(excelutility.getDataFromExcel("Contact", 1, 0))) {
				System.out.println("Contact Page got displayed");
			    driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
			    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(fileutility.getDataFromPropertyFile("lastname"));
			    driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
			    webdriverutility.switchWindow(driver, "Accounts");
			    driver.findElement(By.xpath("//a[contains(@id,'1')]")).click();
			    webdriverutility.switchWindow(driver, "Contacts");
			    driver.findElement(By.xpath("//input[@name='support_start_date']")).clear();
			    driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(javautility.getSystemDate());
			    driver.findElement(By.xpath("//input[@name='support_end_date']")).clear();
			    driver.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(javautility.getCalculatedDate(30));
			    driver.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
			    if(driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText().contains(fileutility.getDataFromPropertyFile("lastname"))) {
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
