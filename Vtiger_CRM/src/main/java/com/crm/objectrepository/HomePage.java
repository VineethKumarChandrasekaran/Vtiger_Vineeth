package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverutilities.WebdriverUtility;

public class HomePage {
	
	WebdriverUtility webdriverutility = new WebdriverUtility();

	@FindBy(xpath = "//a[text()='Calendar']")
	private WebElement calendarLink;
	
	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leadsLink;
	
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement organizationsLink;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactsLink;
	
	@FindBy(xpath = "//a[text()='Opportunities']")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsLink;
	
	@FindBy(xpath = "//a[text()='Documents']")
	private WebElement documentsLink;
	
	@FindBy(xpath = "//a[text()='Email']")
	private WebElement emailLink;
	
	@FindBy(xpath = "//a[text()='Trouble Tickets']")
	private WebElement troubleticketsLink;
	
	@FindBy(xpath = "//a[text()='Dashboard']")
	private WebElement dashboardLink;
	
	@FindBy(xpath = "//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement profileLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/info.PNG]")
	private WebElement infoLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement settingsLink;
	
	@FindBy(xpath = "//input[@class='searchBox']")
	private WebElement searchTextBox;
	
	@FindBy(xpath = "//input[@class='searchBtn']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//img[@src='themes/images/arrow_down_black.png']")
	private WebElement searchdropdownButton;
	
	@FindBy(xpath = "//select[@id='qccombo']")
	private WebElement quickCreateDropDown;
	
	@FindBy(xpath = "//a[@id='_my_preferences_']")
	private WebElement mypreferenceLink;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}

	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getTroubleticketsLink() {
		return troubleticketsLink;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getProfileLink() {
		return profileLink;
	}

	public WebElement getInfoLink() {
		return infoLink;
	}

	public WebElement getSettingsLink() {
		return settingsLink;
	}

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchdropdownButton() {
		return searchdropdownButton;
	}

	public WebElement getQuickCreateDropDown() {
		return quickCreateDropDown;
	}

	public WebElement getMypreferenceLink() {
		return mypreferenceLink;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	public void logout(WebDriver driver) {
		webdriverutility.mouseHoverElement(driver, getProfileLink());
		getSignoutLink().click();
	}
}
