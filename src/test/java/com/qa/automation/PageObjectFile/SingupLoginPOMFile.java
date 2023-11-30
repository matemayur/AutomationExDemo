package com.qa.automation.PageObjectFile;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class SingupLoginPOMFile {
	
		
		private WebDriver driver;
		Scenario scn;
		
		public SingupLoginPOMFile(WebDriver driver)
		{
			this.driver = driver;
		}
		
		
		//Methods
		public void verifySignUpPageTitle(String signUpPageTitle)
		{
			Assert.assertEquals(true, driver.getTitle().contains(signUpPageTitle));
		}

	

}
