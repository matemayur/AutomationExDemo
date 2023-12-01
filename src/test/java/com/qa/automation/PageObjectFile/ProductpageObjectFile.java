package com.qa.automation.PageObjectFile;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;

public class ProductpageObjectFile {
	
		
		private WebDriver driver;
		
		public ProductpageObjectFile(WebDriver driver)
		{
			this.driver = driver;
		}
		
		
		
		//Methods
		public void validateProdPageTitle(String prodPageTitle)
		{
			Assert.assertEquals(true, driver.getTitle().contains(prodPageTitle));
		}
		
		
		
		
	
}
