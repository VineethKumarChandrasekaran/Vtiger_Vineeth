package com.crm.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crm.generic.listenerutilities.ListenerUtility.class)
public class Listener {

	@Test(priority = 0)
	public void userRegistration() {
		System.out.println("User Registation");
	}
	
	@Test(priority = 1)
	public void login() {
		String title = "login";
		String actualTitle = "Login";
		
		Assert.assertEquals(title, actualTitle);
	}
	
	@Test(priority = 2,dependsOnMethods = "login")
	public void homepage() {
		System.out.println("Home Page");
	}
}
