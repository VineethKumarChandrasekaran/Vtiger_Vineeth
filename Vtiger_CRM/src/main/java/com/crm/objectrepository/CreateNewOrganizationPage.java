package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverutilities.WebdriverUtility;

public class CreateNewOrganizationPage {
	
	WebdriverUtility webdriverutility = new WebdriverUtility();
	
	@FindBy(name = "accountname")
	private WebElement organizationname;
	
	@FindBy(name = "website")
	private WebElement website;
	
	@FindBy(name = "tickersymbol")
	private WebElement tickersymbol;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement member;
	
	@FindBy(name = "employees")
	private WebElement employees;
	
	@FindBy(name = "email2")
	private WebElement otheremail;
	
	@FindBy(name = "phone")
	private WebElement phone;
	
	@FindBy(id = "fax")
	private WebElement fax;
	
	@FindBy(id = "otherphone")
	private WebElement otherphone;
	
	@FindBy(id = "email1")
	private WebElement email;
	
	@FindBy(id = "ownership")
	private WebElement ownership;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industry;
	
	@FindBy(xpath = "//select[@name='rating']")
	private WebElement rating;
	
	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement accounttype;
	
	@FindBy(id = "siccode")
	private WebElement siccode;
	
	@FindBy(name = "annual_revenue")
	private WebElement annualrevenue;
	
	@FindBy(name = "emailoptout")
	private WebElement emailoptout;
	
	@FindBy(name = "notify_owner")
	private WebElement notifyowner;
	
	@FindBy(xpath = "//input[contains(text(),'User')]")
	private WebElement userradiobutton;
	
	@FindBy(xpath = "//select[@name='assigned_user_id']")
	private WebElement userdropdown;
	
	@FindBy(xpath = "//input[contains(text(),'Group')]")
	private WebElement groupradiobutton;
	
	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement groupdropdown;
	
	@FindBy(xpath = "//input[@onclick='return copyAddressLeft(EditView)']")
	private WebElement copyshippingaddress;
	
	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copybillingaddress;
	
	@FindBy(name = "bill_street")
	private WebElement billaddress;
	
	@FindBy(id = "bill_pobox")
	private WebElement billpobox;
	
	@FindBy(id = "bill_city")
	private WebElement billcity;
	
	@FindBy(id = "bill_state")
	private WebElement billstate;
	
	@FindBy(id = "bill_code")
	private WebElement billpostalcode;
	
	@FindBy(id = "bill_country")
	private WebElement billcountry;
	
	@FindBy(name = "ship_street")
	private WebElement shipaddress;
	
	@FindBy(id = "ship_pobox")
	private WebElement shippobox;
	
	@FindBy(id = "ship_city")
	private WebElement shipcity;
	
	@FindBy(id = "ship_state")
	private WebElement shipstate;
	
	@FindBy(id = "ship_code")
	private WebElement shippostalcode;
	
	@FindBy(id = "ship_country")
	private WebElement shipcountry;
	
	@FindBy(name = "description")
	private WebElement description;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancelbutton;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headertext;
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationname() {
		return organizationname;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getTickersymbol() {
		return tickersymbol;
	}

	public WebElement getMember() {
		return member;
	}

	public WebElement getEmployees() {
		return employees;
	}

	public WebElement getOtheremail() {
		return otheremail;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getFax() {
		return fax;
	}

	public WebElement getOtherphone() {
		return otherphone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getOwnership() {
		return ownership;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getRating() {
		return rating;
	}

	public WebElement getAccounttype() {
		return accounttype;
	}

	public WebElement getSiccode() {
		return siccode;
	}

	public WebElement getAnnualrevenue() {
		return annualrevenue;
	}

	public WebElement getEmailoptout() {
		return emailoptout;
	}

	public WebElement getNotifyowner() {
		return notifyowner;
	}

	public WebElement getUserradiobutton() {
		return userradiobutton;
	}

	public WebElement getUserdropdown() {
		return userdropdown;
	}

	public WebElement getGroupradiobutton() {
		return groupradiobutton;
	}

	public WebElement getGroupdropdown() {
		return groupdropdown;
	}

	public WebElement getCopyshippingaddress() {
		return copyshippingaddress;
	}

	public WebElement getCopybillingaddress() {
		return copybillingaddress;
	}

	public WebElement getBilladdress() {
		return billaddress;
	}

	public WebElement getBillpobox() {
		return billpobox;
	}

	public WebElement getBillcity() {
		return billcity;
	}

	public WebElement getBillstate() {
		return billstate;
	}

	public WebElement getBillpostalcode() {
		return billpostalcode;
	}

	public WebElement getBillcountry() {
		return billcountry;
	}

	public WebElement getShipaddress() {
		return shipaddress;
	}

	public WebElement getShippobox() {
		return shippobox;
	}

	public WebElement getShipcity() {
		return shipcity;
	}

	public WebElement getShipstate() {
		return shipstate;
	}

	public WebElement getShippostalcode() {
		return shippostalcode;
	}

	public WebElement getShipcountry() {
		return shipcountry;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getHeadertext() {
		return headertext;
	}

	public WebElement getCancelbutton() {
		return cancelbutton;
	}
   
	public void createorg(String orgname) {
		getOrganizationname().sendKeys(orgname);
		getSavebutton().click();
	}
	
	public void createorgWithIndustry(WebDriver driver, String orgname, String industry) {
		getOrganizationname().sendKeys(orgname);
		webdriverutility.selectDropdownByValue(driver, getIndustry(), industry);
		getSavebutton().click();
	}
	
	public void createorgWithIndustryAndPhoneNumber(WebDriver driver, String orgname, String industry,CharSequence mobile) {
		getOrganizationname().sendKeys(orgname);
		webdriverutility.selectDropdownByValue(driver, getIndustry(), industry);
		getPhone().sendKeys(mobile);
		getSavebutton().click();
	}
}
