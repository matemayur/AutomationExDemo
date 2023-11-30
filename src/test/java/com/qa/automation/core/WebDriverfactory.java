package com.qa.automation.core;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverfactory {
	
	public class WebDriverFactory {
		
		private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
		
		private static WebDriver driver = null;
		 static WebDriverWait wait;
		
		
		
		public static WebDriver setUpBrowser(String browser) 
		{
			
			switch(browser.toLowerCase()) 
			{
			case"chrome":
		
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
				logger.info("Setting up for browser path is completed");
				ChromeOptions opt = new ChromeOptions();
				opt.setBinary("C:\\Users\\ADMIN\\eclipse-workspace\\chrome-win64\\chrome.exe");
				logger.info("Setting up chrome binary completed");
				driver = new ChromeDriver(opt);
				logger.info("Chrome Browser invoked"); 
			    break;
			case"firefox":
			
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("Firefox Browser invoked");
			    break;
			case"opera":
			
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				logger.info("Opera Browser invoked");
			    break;
			case"edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				logger.info("Edge Browser invoked");
				break;
		    case "headless":
	         	System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
	     		logger.info("Setting up for browser path is completed");
	     		ChromeOptions options = new ChromeOptions();
	     		options.setBinary("C:\\Users\\ADMIN\\eclipse-workspace\\chrome-win64\\chrome.exe");
	     		logger.info("Setting up chrome binary completed");
	     		options.addArguments("headless");
	             driver = new ChromeDriver(options);
	             logger.info("Headless Chrome Browser invoked");
	             break;
				
			default:
				logger.fatal("No such browser is implemented.Browser name sent: " + browser);
				break;
			
			}
			
			driver.manage().window().maximize();
			logger.info("Browser get maximized");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			 wait =  new WebDriverWait(driver,15);
			 return driver;  
		} 
		       
		 public static String getBrowserName(){ 
		        String browserDefault = "chrome"; 
		        String browserSentFromCmd = System.getProperty("browser");
		        if (browserSentFromCmd==null)
		        {
		            return browserDefault;
		        }
		        else
		        {
		            return browserSentFromCmd;
		        }
		    }
		
		public  static void quitDriver()
		{
			driver.quit();
			logger.info("Browser got closed");
		}
		
		public  static void setURL(String url)
		{
			driver.get(url);
			logger.info("navigate to the url");
		}
		
		public static void failedScnScreenshot(Scenario scn)
		{
			if(scn.isFailed())
			{
			TakesScreenshot scrnShot = (TakesScreenshot)driver;
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png","Failed Step Name: " + scn.getName());
			}
			else
			{
				scn.log("The test case get passed,no screenshot get atttached");
			}
		}
	}
}
