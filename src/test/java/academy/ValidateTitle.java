package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;

import resources.Base;

public class ValidateTitle extends Base {
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeClass
	public void initialization() throws IOException
	{
		driver =initializeDriver();
		log.info("Webdriver is successfully initialised");
		driver.get(prop.getProperty("url"));
		log.info("successfully initialised given URL");
		driver.manage().window().maximize();
		}
	
	@Test
	public void validatingTitle() throws IOException
	{
		//driver =initializeDriver();
		//driver.get("https://rahulshettyacademy.com/");
		//driver.get(prop.getProperty("url"));
		//driver.manage().window().maximize();
		
		//Create object for LandingPage
		LandingPage ln =new LandingPage(driver);
		
		//verify text present on website and text given by business people
		log.info(ln.gettitle().getText());
		//System.out.println(ln.gettitle().getText());
		Assert.assertEquals(ln.gettitle().getText(),"An Academy to Learn Earn & Shine  in your QA Career");
		log.info("Successfully validated title");
		
		
		//Verify title of webpage and title given by business people
		log.info(driver.getTitle());
		//System.out.println(driver.getTitle());
		
		
		Assert.assertEquals(driver.getTitle(),"Rahul Shetty Academy");
		log.info("Successfully validated title");
		
		Assert.assertTrue(ln.joinNowText().isDisplayed());
		log.info("Successfully Clicked on Join Now Link");
		
		
		
		
		
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
		log.info("successfully closed the browser");
	}
	
	

}
