package com.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	@FindBy(xpath = "//img[contains(@title,'Create')]")
	private WebElement createcontactbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Search')]")
	private WebElement searchcontactbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Calendar')]")
	private WebElement opencalendarbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Show')]")
	private WebElement showworldclockbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Calculator')]")
	private WebElement opencalculatorbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Chat')]")
	private WebElement chatbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Viewed')]")
	private WebElement lastviewedbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Import')]")
	private WebElement importcontactbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Export')]")
	private WebElement exportcontactbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Duplicates')]")
	private WebElement findduplicatesbutton;
	
	@FindBy(xpath = "//img[contains(@title,'Settings')]")
	private WebElement contactssettingbutton;
	
	@FindBy(name = "search_text")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//select[@id='bas_searchfield']")
	private WebElement searchbydropdown;
	
	@FindBy(name = "submit")
	private WebElement searchnowbutton;
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deletebutton;
	
	@FindBy(xpath = "//input[@value='Mass Edit']")
	private WebElement masseditbutton;
	
	@FindBy(xpath = "//input[@value='Send Mail']")
	private WebElement sendmailbutton;
	
	@FindBy(xpath = "//input[@value='Send SMS']")
	private WebElement sendsmsbutton;

	@FindBy(xpath = "//select[@id='viewname']")
	private WebElement filterdropdown;
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecontactbutton() {
		return createcontactbutton;
	}

	public WebElement getSearchcontactbutton() {
		return searchcontactbutton;
	}

	public WebElement getOpencalendarbutton() {
		return opencalendarbutton;
	}

	public WebElement getShowworldclockbutton() {
		return showworldclockbutton;
	}

	public WebElement getOpencalculatorbutton() {
		return opencalculatorbutton;
	}

	public WebElement getChatbutton() {
		return chatbutton;
	}

	public WebElement getLastviewedbutton() {
		return lastviewedbutton;
	}

	public WebElement getImportcontactbutton() {
		return importcontactbutton;
	}

	public WebElement getExportcontactbutton() {
		return exportcontactbutton;
	}

	public WebElement getFindduplicatesbutton() {
		return findduplicatesbutton;
	}

	public WebElement getContactssettingbutton() {
		return contactssettingbutton;
	}

	public WebElement getSearchtextfield() {
		return searchtextfield;
	}

	public WebElement getSearchbydropdown() {
		return searchbydropdown;
	}

	public WebElement getSearchnowbutton() {
		return searchnowbutton;
	}

	public WebElement getDeletebutton() {
		return deletebutton;
	}

	public WebElement getMasseditbutton() {
		return masseditbutton;
	}

	public WebElement getSendmailbutton() {
		return sendmailbutton;
	}

	public WebElement getSendsmsbutton() {
		return sendsmsbutton;
	}

	public WebElement getFilterdropdown() {
		return filterdropdown;
	}
	
}
