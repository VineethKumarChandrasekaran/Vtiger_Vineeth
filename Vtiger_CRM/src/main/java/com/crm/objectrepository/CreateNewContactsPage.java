package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverutilities.WebdriverUtility;

public class CreateNewContactsPage {

	WebdriverUtility webdriverutility = new WebdriverUtility();
	
	@FindBy(xpath = "//select[@name='salutationtype']")
	private WebElement firstnamedropdown;
	
	@FindBy(name = "firstname")
	private WebElement firstnametextbox;
	
	@FindBy(name = "lastname")
	private WebElement lastnametextbox;
	
	@FindBy(xpath = "(//img[@title='Select'])[1]")
	private WebElement organizationlookupbutton;
	
	@FindBy(xpath = "//select[@name='leadsource']")
	private WebElement leadsourcedropdown;
	
	@FindBy(id = "title")
	private WebElement titletextbox;
	
	@FindBy(id = "department")
	private WebElement departmenttextbox;
	
	@FindBy(id = "email")
	private WebElement emailtextbox;
	
	@FindBy(id = "assistant")
	private WebElement assistanttextbox;
	
	@FindBy(id = "assistantphone")
	private WebElement assistantphonetextbox;
	
	@FindBy(id = "phone")
	private WebElement officephonetextbox;
	
	@FindBy(id = "mobile")
	private WebElement mobiletextbox;
	
	@FindBy(id = "homephone")
	private WebElement homephonetextbox;
	
	@FindBy(id = "otherphone")
	private WebElement otherphonetextbox;
	
	@FindBy(id = "fax")
	private WebElement faxtextbox;
	
	@FindBy(id = "jscal_trigger_birthday")
	private WebElement birthdaycalendar;
	
	@FindBy(id = "jscal_field_birthday")
	private WebElement birthdaytextbox;
	
	@FindBy(id = "secondaryemail")
	private WebElement secondaryemailtextbox;
	
	@FindBy(xpath = "(//img[@title='Select'])[2]")
	private WebElement reportslookupbutton;
	
	@FindBy(name = "emailoptout")
	private WebElement emailoptoutcheckbox;
	
	@FindBy(name = "reference")
	private WebElement referencecheckbox;
	
	@FindBy(name = "notify_owner")
	private WebElement notifyownercheckbox;
	
	@FindBy(name = "donotcall")
	private WebElement donotcallcheckbox;
	
	@FindBy(xpath = "//input[contains(text(),'User')]")
	private WebElement userradiobutton;
	
	@FindBy(xpath = "//select[@name='assigned_user_id']")
	private WebElement userdropdown;
	
	@FindBy(xpath = "//input[contains(text(),'Group')]")
	private WebElement groupradiobutton;
	
	@FindBy(xpath = "//select[@name='assigned_group_id']")
	private WebElement groupdropdown;
	
	@FindBy(name = "portal")
	private WebElement portalusercheckbox;
	
	@FindBy(id = "jscal_trigger_support_start_date")
	private WebElement supportstartdatecalendar;
	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement supportstartdatetextbox;
	
	@FindBy(id = "jscal_trigger_support_end_date")
	private WebElement supportenddatecalendar;
	
	@FindBy(id = "jscal_field_support_end_date")
	private WebElement supportenddatetextbox;
	
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
	
	@FindBy(name = "imagename")
	private WebElement contactimage;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	
	@FindBy(xpath = "//input[@title='Cancel [Alt+X]']")
	private WebElement cancelbutton;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headertext;
	
	@FindBy(xpath = "//a[contains(@id,'1')]")
	private WebElement orgname;
	
	public CreateNewContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstnamedropdown() {
		return firstnamedropdown;
	}

	public WebElement getFirstnametextbox() {
		return firstnametextbox;
	}

	public WebElement getLastnametextbox() {
		return lastnametextbox;
	}

	public WebElement getOrganizationlookupbutton() {
		return organizationlookupbutton;
	}

	public WebElement getLeadsourcedropdown() {
		return leadsourcedropdown;
	}

	public WebElement getTitletextbox() {
		return titletextbox;
	}

	public WebElement getDepartmenttextbox() {
		return departmenttextbox;
	}

	public WebElement getEmailtextbox() {
		return emailtextbox;
	}

	public WebElement getAssistanttextbox() {
		return assistanttextbox;
	}

	public WebElement getAssistantphonetextbox() {
		return assistantphonetextbox;
	}

	public WebElement getOfficephonetextbox() {
		return officephonetextbox;
	}

	public WebElement getMobiletextbox() {
		return mobiletextbox;
	}

	public WebElement getHomephonetextbox() {
		return homephonetextbox;
	}

	public WebElement getOtherphonetextbox() {
		return otherphonetextbox;
	}

	public WebElement getFaxtextbox() {
		return faxtextbox;
	}

	public WebElement getBirthdaycalendar() {
		return birthdaycalendar;
	}

	public WebElement getBirthdaytextbox() {
		return birthdaytextbox;
	}

	public WebElement getSecondaryemailtextbox() {
		return secondaryemailtextbox;
	}

	public WebElement getReportslookupbutton() {
		return reportslookupbutton;
	}

	public WebElement getEmailoptoutcheckbox() {
		return emailoptoutcheckbox;
	}

	public WebElement getReferencecheckbox() {
		return referencecheckbox;
	}

	public WebElement getNotifyownercheckbox() {
		return notifyownercheckbox;
	}

	public WebElement getDonotcallcheckbox() {
		return donotcallcheckbox;
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

	public WebElement getPortalusercheckbox() {
		return portalusercheckbox;
	}

	public WebElement getSupportstartdatecalendar() {
		return supportstartdatecalendar;
	}

	public WebElement getSupportstartdatetextbox() {
		return supportstartdatetextbox;
	}

	public WebElement getSupportenddatecalendar() {
		return supportenddatecalendar;
	}

	public WebElement getSupportenddatetextbox() {
		return supportenddatetextbox;
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

	public WebElement getContactimage() {
		return contactimage;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}

	public WebElement getCancelbutton() {
		return cancelbutton;
	}

	public WebElement getHeadertext() {
		return headertext;
	}

	public WebElement getOrgname() {
		return orgname;
	}
	
	public void createcontact(String lastname) {
		getLastnametextbox().sendKeys(lastname);
		getSavebutton().click();
	}
	
	public void createContactWithOrg(WebDriver driver, String lastname) {
		getLastnametextbox().sendKeys(lastname);
		getOrganizationlookupbutton().click();
		webdriverutility.switchWindow(driver, "Accounts");
		getOrgname().click();
		webdriverutility.switchWindow(driver, "Contacts");
		getSavebutton().click();
	}
	
	public void createContactWithOrgAndDate(WebDriver driver, String lastname, String startdate,String enddate) {
		getLastnametextbox().sendKeys(lastname);
	    getOrganizationlookupbutton().click();
	    webdriverutility.switchWindow(driver, "Accounts");
	    getOrgname().click();
	    webdriverutility.switchWindow(driver, "Contacts");
	    getSupportstartdatetextbox().clear();
	    getSupportstartdatetextbox().sendKeys(startdate);
	    getSupportenddatetextbox().clear();
	    getSupportenddatetextbox().sendKeys(enddate);	    
		getSavebutton().click();
	}
}
