@ui @ProdTest
Feature: E-Commerce project website ProdTest

Background: Navigate to the base URL of application
Given user navigate to the home application url "http://automationexercise.com"
And user verify the home page is visible successfully

@HeaderSectionvalidate
Scenario: User is able to open browser, Navigate to URL and validate the header section button of website
Given user is able to click on Product button
When user is redirected to the product page title as "Automation Exercise - All Products"
Then user is able to click on Cart button
And user able on cart page title as "Automation Exercise - Checkout"
Then user is able to click on signup/login button
And user over the signup/login page with title as "Automation Exercise - Signup / Login"
Then user is able to Click on test cases button
And user is able over the test cases title as "Automation Practice Website for UI Testing - Test Cases"
When user click on API Testing button
Then User verify the "APIS LIST FOR PRACTICE" text is visible
#When user cilck on Video Tutorials button
#Then user redirected to you tube video page with url as  "https://www.youtube.com/c/AutomationExercise"
Then user is click on contact us button
And user able to see contact us page title as "Automation Exercise - Contact Us"


@EmailSubscriptionValidation
Scenario: User is able to open browser, Navigate to URL and verify the subscription field
Given User Scroll down to footer of the page
When  After scrooling down user is able to see "SUBSCRIPTION" keyword 
And  user enter email address as "matemayur786@gmail.com" in box
And  user click on arrow button
Then user Verify success message "You have been successfully subscribed!" is visible on Display
