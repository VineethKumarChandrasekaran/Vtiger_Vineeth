package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganization;
	
	@FindBy(xpath = "//img[@title='Search in Organizations...']")
	private WebElement searchInOrganization;
	
	@FindBy(xpath = "//img[@title='Open Calendar...']")
	private WebElement openCalendar;
	
	@FindBy(xpath = "//img[@title='Show World Clock...']")
	private WebElement showWorldClock;
	
	@FindBy(xpath = "//img[@title='Open Calculator...']")
	private WebElement openCalculator;
	
	@FindBy(xpath = "//img[@title='Chat...']")
	private WebElement chat;
	
	@FindBy(xpath = "//img[@title='Last Viewed']")
	private WebElement lastViewed;
	
	@FindBy(xpath = "//img[@title='Import Organizations']")
	private WebElement importOrganization;
	
	@FindBy(xpath = "//img[@title='Export Organizations']")
	private WebElement exportOrganization;
	
	@FindBy(xpath = "//img[@title='Find Duplicates']")
	private WebElement findDuplicates;
	
	@FindBy(xpath = "//img[@title='Organizations Settings']")
	private WebElement organizationsSettings;
	
	@FindBy(xpath = "//a[text()='Go to Advanced Search']")
	private WebElement advancedSearch;
	
	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searchTextBox;
	
	@FindBy(xpath = "//select[@id='bas_searchfield']")
	private WebElement searchColumn;
	
	@FindBy(xpath = "//input[@class='crmbutton small create']")
	private WebElement searchNow;
	
	@FindBy(xpath = "//select[@id='viewname']")
	private WebElement filters;
	
	@FindBy(xpath = "//a[text()='Create Filter']")
	private WebElement createFilter;
	
	@FindBy(xpath = "//span[text()='Edit']")
	private WebElement editFilter;
	
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement deleteFilter;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//input[@value='Mass Edit']")
	private WebElement massEditButton;
	
	@FindBy(xpath = "//input[@value='Send Mail']")
	private WebElement sendMailButton;
	
	@FindBy(xpath = "//input[@value='Mailer Export']")
	private WebElement mailerExportButton;
	
	@FindBy(xpath = "//input[@value='Send SMS']")
	private WebElement sendSmsButton;
	
	@FindBy(xpath = "//a[contains(text(),'Create an')]")
	private WebElement createOrganizationLink;
	
	@FindBy(xpath = "//a[contains(text(),'Import')]")
	private WebElement importOrganizationLink;
	
	@FindBy(xpath = "//a[contains(text(),'Create Mail Merge templates ')]")
	private WebElement createMailMergeTemplatesLink;
	
	@FindBy(xpath = "//a[contains(text(),'vtiger.com')]")
	private WebElement vtigerLink;
	
	@FindBy(xpath = "//a[contains(text(),'Read License')]")
	private WebElement readLicenseLink;
	
	@FindBy(xpath = "//a[contains(text(),'Privacy Policy')]")
	private WebElement privacyPolicyLink;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrganization() {
		return createOrganization;
	}

	public WebElement getSearchInOrganization() {
		return searchInOrganization;
	}

	public WebElement getOpenCalendar() {
		return openCalendar;
	}

	public WebElement getShowWorldClock() {
		return showWorldClock;
	}

	public WebElement getOpenCalculator() {
		return openCalculator;
	}

	public WebElement getChat() {
		return chat;
	}

	public WebElement getLastViewed() {
		return lastViewed;
	}

	public WebElement getImportOrganization() {
		return importOrganization;
	}

	public WebElement getExportOrganization() {
		return exportOrganization;
	}

	public WebElement getFindDuplicates() {
		return findDuplicates;
	}

	public WebElement getOrganizationsSettings() {
		return organizationsSettings;
	}

	public WebElement getAdvancedSearch() {
		return advancedSearch;
	}

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getSearchColumn() {
		return searchColumn;
	}

	public WebElement getSearchNow() {
		return searchNow;
	}

	public WebElement getFilters() {
		return filters;
	}

	public WebElement getCreateFilter() {
		return createFilter;
	}

	public WebElement getEditFilter() {
		return editFilter;
	}

	public WebElement getDeleteFilter() {
		return deleteFilter;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getMassEditButton() {
		return massEditButton;
	}

	public WebElement getSendMailButton() {
		return sendMailButton;
	}

	public WebElement getMailerExportButton() {
		return mailerExportButton;
	}

	public WebElement getSendSmsButton() {
		return sendSmsButton;
	}

	public WebElement getCreateOrganizationLink() {
		return createOrganizationLink;
	}

	public WebElement getImportOrganizationLink() {
		return importOrganizationLink;
	}

	public WebElement getCreateMailMergeTemplatesLink() {
		return createMailMergeTemplatesLink;
	}

	public WebElement getVtigerLink() {
		return vtigerLink;
	}

	public WebElement getReadLicenseLink() {
		return readLicenseLink;
	}

	public WebElement getPrivacyPolicyLink() {
		return privacyPolicyLink;
	}

}
