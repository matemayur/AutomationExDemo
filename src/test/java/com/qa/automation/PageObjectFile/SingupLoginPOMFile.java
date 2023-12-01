package com.qa.automation.PageObjectFile;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import io.cucumber.java.Scenario;

public class SingupLoginPOMFile {
	
		
		private WebDriver driver;
		Scenario scn;
		
		public SingupLoginPOMFile(WebDriver driver)
		{
			this.driver = driver;
		}
		
		
		// private locators
		private By LogToAcText = By.xpath("//h2[text()='Login to your account']");
		private By EmailId = By.xpath("//input[@placeholder='Email Address']");
		private By Password = By.xpath("//input[@placeholder='Password']");
		private By LoginBtn = By.xpath("//button[text()='Login']");
		private By ErrorMsg = By.xpath("//p[text()='Your email or password is incorrect!']");
		private By LogAcctxt = By.xpath("//h2[text()='Login to your account']");
		private By EmailIdEnter = By.xpath("//input[@placeholder='Email Address']");
		private By PasswordforLogin = By.xpath("//input[@placeholder='Password']");
		
		
		
		
		//Methods
		public void verifySignUpPageTitle(String signUpPageTitle)
		{
			Assert.assertEquals(true, driver.getTitle().contains(signUpPageTitle));
		}
		
		
		
		public void verifySigLogPageTitle(String signupLogPagetitle)
		{
			Assert.assertEquals(true, driver.getTitle().contains(signupLogPagetitle));
		}
		
		
		
		public void verifyLoginToYourAcText(String LoginToYourAccount)
		 {
				WebElement LoginToYourAccountText = driver.findElement(LogToAcText);////h2[text()='Login to your account']
				Assert.assertEquals(LoginToYourAccount,LoginToYourAccountText.getText());
		 }
		
		
		
		public void verifyEmailIdLogin(String emailIdLogin)
		 {
				WebElement emailIdEle = driver.findElement(EmailId);
				emailIdEle.sendKeys(emailIdLogin);
		 }
		
		
		 public void verifyPassLogin(String PasswordLogin)
		 {
				WebElement PasswordEle = driver.findElement(Password);
				PasswordEle.sendKeys(PasswordLogin);
		 }
		 
		 
		 public void verifyClickOnLoginBtn()
		 {
				WebElement clickOnLoginBtnEle = driver.findElement(LoginBtn);
				clickOnLoginBtnEle.click();	
		 }
		 
		 
		 
		 public void ValidateErrorMsgVisible(String ErrorMsgVisible)
		 {
				WebElement ErrorMsgEle = driver.findElement(ErrorMsg); 
				Assert.assertEquals(true,ErrorMsgEle.getText().contains(ErrorMsgVisible));
		 }
		 
		 
		 public void VerifySingLoginPageTitle(String SignLoginPageTitle)
		 {
				Assert.assertEquals(true,driver.getTitle().contains(SignLoginPageTitle));
		 }
		 
		 
		 
		 public void verifyLoginToYourAccountText(String LoginToYourAccount)
		 {
				WebElement LoginToYourAccountText = driver.findElement(LogAcctxt);
				Assert.assertEquals(LoginToYourAccount,LoginToYourAccountText.getText());

		 }
		 
		 
		 
		 public void verifyEmail(String EmailIdforLogin)
		 {
				WebElement EmailIdEle = driver.findElement(EmailIdEnter);
				EmailIdEle.sendKeys(EmailIdforLogin);
		 }
		 
		 
		 public void verifyPassword(String PasswordForLoginPurpose)
		 {
				WebElement PasswordEle = driver.findElement(PasswordforLogin);
				PasswordEle.sendKeys(PasswordForLoginPurpose);
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		




	

}
