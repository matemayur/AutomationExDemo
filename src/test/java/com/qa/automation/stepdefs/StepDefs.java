package com.qa.automation.stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.qa.automation.PageObjectFile.HeaderSectionPageObjectFile;

import com.qa.automation.PageObjectFile.LandingPageObjectFile;
import com.qa.automation.PageObjectFile.SingupLoginPOMFile;
import com.qa.automation.core.WebDriverfactory.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepDefs {
	
private static final Logger logger = LogManager.getLogger(StepDefs.class);
	
	private WebDriver driver;
	Scenario scn;
	String baseUrl = "https://automationexercise.com/";
	int implictlyWaitTimeoutSec = 20;
	
	
	LandingPageObjectFile landingPageObjectFile;
	HeaderSectionPageObjectFile headerSectionPageObjectFile;
	SingupLoginPOMFile singupLoginPOMFile;
	
	
	
	
	@Before
	public void setUp(Scenario scn) throws Exception
	{
		this.scn = scn;
		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.setUpBrowser(browserName);
		scn.log("browser get invoked");
		landingPageObjectFile = new LandingPageObjectFile(driver);
//		productPageObjectFile = new ProductpageObjectFile(driver);
		headerSectionPageObjectFile = new HeaderSectionPageObjectFile(driver);
		singupLoginPOMFile = new SingupLoginPOMFile(driver);
		
		
	}
	
	
	@After(order=1)
	public void cleanUp()
	{
		WebDriverFactory.quitDriver();
		scn.log("browser get closed");
	}
	
	
	
	@After(order=2)
	public void takescreenshot()
	{
		WebDriverFactory.failedScnScreenshot(scn);	
	}
	
	
	@Given("user navigate to the home application url {string}")
	public void user_navigate_to_the_home_application_url(String url)
	{
	   WebDriverFactory.setURL(url);
	}



	@Given("user verify the home page is visible successfully")
	public void user_verify_the_home_page_is_visible_successfully() {
		
		landingPageObjectFile.homePageTitle();
		logger.info("user verify the home page title");
		
	}
	
	@Given("user is able to click on Product button")
	public void user_is_able_to_click_on_product_button() {
		
		   landingPageObjectFile.clickProductsBtn();
		   logger.info("user click on product button");
	}
	
	@When("user is redirected to the product page title as {string}")
	public void user_is_redirected_to_the_product_page_title_as(String ProdPageTitle) {
		
		landingPageObjectFile.validateProdPageTitle(ProdPageTitle);
		 logger.info("user verify the product page title");
	}
	
	
	@Then("user is able to click on Cart button")
	public void user_is_able_to_click_on_cart_button() {
		
		landingPageObjectFile.clickCartBtn();
	    logger.info("user click on cart button");  
	}
	
	@Then("user able on cart page title as {string}")
	public void user_able_on_cart_page_title_as(String CartPageTitle) {
		
		headerSectionPageObjectFile.verifycartPageTitle(CartPageTitle);
		logger.info("user verify the cart page title");
	}
	
	@Then("user is able to click on signup\\/login button")
	public void user_is_able_to_click_on_signup_login_button() {
		
		 landingPageObjectFile.clickSignUpOrLoginBtn();
		 logger.info("user click on signup/login button");
	}
	
	@Then("user over the signup\\/login page with title as {string}")
	public void user_over_the_signup_login_page_with_title_as(String signUpPageTitle) {
		
		singupLoginPOMFile.verifySignUpPageTitle(signUpPageTitle);
	    logger.info("user verify the signup page title");
	}
	
	@Then("user is able to Click on test cases button")
	public void user_is_able_to_click_on_test_cases_button() {
		
		landingPageObjectFile.clickTestCasesBtn();
	    logger.info("user click on test cases button");
	}
	
	@Then("user is able over the test cases title as {string}")
	public void user_is_able_over_the_test_cases_title_as(String TCasesPageTitle) {
		
		headerSectionPageObjectFile.verifyTestCasesPage(TCasesPageTitle);
	    logger.info("user verify the test cases page title");
	}
	
	@When("user click on API Testing button")
	public void user_click_on_api_testing_button() {
		
		  landingPageObjectFile.clickAPITestingBtn();
		  logger.info("user click on API testing button");
	}
	
	
	@Then("User verify the {string} text is visible")
	public void user_verify_the_text_is_visible(String apiTestingList) {
		headerSectionPageObjectFile.verifyAPITestingPage(apiTestingList);
	    logger.info("user verify" + apiTestingList + "text is available");
		
	}
	
	
	@Then("user is click on contact us button")
	public void user_is_click_on_contact_us_button() {
		
		landingPageObjectFile.clickContactUsBtn();
		logger.info("user click on contact us button");
	}
	
	
	@Then("user able to see contact us page title as {string}")
	public void user_able_to_see_contact_us_page_title_as(String ContactUsPageTitle) {
		
		headerSectionPageObjectFile.verifycontactUsPageTitle(ContactUsPageTitle);
		logger.info("user verify contact us page title");
		
	}
	
	
	
	
	// Test cases for subscription fields
	
	@Given("User Scroll down to footer of the page")
	public void user_scroll_down_to_footer_of_the_page() {
	    
		landingPageObjectFile.userscrollDownPage();
		logger.info("user scroll down the page");
	}



	@When("After scrooling down user is able to see {string} keyword")
	public void after_scrooling_down_user_is_able_to_see_keyword(String SUBSCRIPTION) {
		 landingPageObjectFile.verifySubscriptionTxt(SUBSCRIPTION);
	      logger.info("user verify the SUBSCRIPTION text");
	      
	}
	
	
	@When("user enter email address as {string} in box")
	public void user_enter_email_address_as_in_box(String emailForSubscription) {
		landingPageObjectFile.enterEmailForSubscription(emailForSubscription);
	    logger.info("user enter email for subscription");
	   
	}
	
	
	@When("user click on arrow button")
	public void user_click_on_arrow_button() {
		  landingPageObjectFile.clickArrowBtn();
		  logger.info("user click on arrow button");
		
	}
	
	
	@Then("user Verify success message {string} is visible on Display")
	public void user_verify_success_message_is_visible_on_display(String SubscriptionsuccessMsg) {
	    
		landingPageObjectFile.verifySubscriptionSuccessMsg(SubscriptionsuccessMsg);

		   logger.info("user verify the subscription success msg");
	}
	
	
	
	// for error email and password section
	
	@Given("user click on signup\\/Login button")
	public void user_click_on_signup_login_button() {
		
		landingPageObjectFile.clickSignUpOrLoginBtn();
		logger.info("user click on signup/Login button");
	}


	@When("user redirected to signup\\/login page title as {string}")
	public void user_redirected_to_signup_login_page_title_as(String signupLogPagetitle) {
		
		singupLoginPOMFile.verifySigLogPageTitle(signupLogPagetitle);
	    logger.info("user verify signupLogin page title");
	}
	
	
	@Then("user able to visible text as {string}")
	public void user_able_to_visible_text_as(String LoginToYourAccount) {
		
		singupLoginPOMFile.verifyLoginToYourAcText(LoginToYourAccount);
		 logger.info("user able to visible Login to your acc txt");
	}
	
	
	@Then("user enter emailId {string}")
	public void user_enter_email_id(String emailIdLogin) {
		
		singupLoginPOMFile.verifyEmailIdLogin(emailIdLogin);
		logger.info("user put invalid EmailID");
	}
	
	
	@Then("user enter password {string}")
	public void user_enter_password(String PasswordLogin) {
		
		singupLoginPOMFile.verifyPassLogin(PasswordLogin);
		 logger.info("user put invalid password");
	}
	
	
	@Then("user click on login button")
	public void user_click_on_login_button() {
		
		singupLoginPOMFile.verifyClickOnLoginBtn();
		logger.info("user click on login button");
	}
	
	
	@Then("emailId and password is invalid the user able to see error message as {string}")
	public void email_id_and_password_is_invalid_the_user_able_to_see_error_message_as(String ErrorMsgVisible) {
		
		singupLoginPOMFile.ValidateErrorMsgVisible(ErrorMsgVisible);
		logger.info("user able to visible error message");
	}
	
	
	
	// test cases on valid emailID n password users
	
	
	@Given("user click to signup\\/login button")
	public void user_click_to_signup_login_button() {
		
		landingPageObjectFile.verifySinupLoginButton();
		logger.info("user able to click on signup/login btn");
	}


	@When("user redirected to login page with title as {string}")
	public void user_redirected_to_login_page_with_title_as(String SignLoginPageTitle) {
		
		singupLoginPOMFile.VerifySingLoginPageTitle(SignLoginPageTitle);
		logger.info("user verify the signup/login page title");
	}
	
	
	@Then("user able to see the text {string}")
	public void user_able_to_see_the_text(String LoginToYourAccount) {
		
		singupLoginPOMFile.verifyLoginToYourAccountText(LoginToYourAccount);
		logger.info("user able to visible login acc text");
	}
	
	
	@Then("user enter email id as {string}")
	public void user_enter_email_id_as(String EmailIdforLogin) {
		
		singupLoginPOMFile.verifyEmail(EmailIdforLogin);
		logger.info("user enter the valid emailID");
	}
	
	
	@Then("user enter password as {string}")
	public void user_enter_password_as(String PasswordForLoginPurpose) {
		
		singupLoginPOMFile.verifyPassword(PasswordForLoginPurpose);
		logger.info("user enter the valid Password");
	}
	
	
	@Then("user verify with {string} just after Logged in as button")
	public void user_verify_with_just_after_logged_in_as_button(String username) {
		
		 landingPageObjectFile.userNameAfterLoggedIn(username);
		 logger.info("user verify username after logged in - "+ username);
	}



	@Then("user click on logout button")
	public void user_click_on_logout_button() {
		landingPageObjectFile.userClickOnLogoutBtn();
		logger.info("user click on logout btn");
	}
	
	
	
	
}
	
		
		




