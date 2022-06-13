package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PracticeHomePage;
import resources.Base;

public class PracticePage2HomePage extends Base {
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeClass
	public void initialization() throws IOException
	{
		driver =initializeDriver();
		log.info("Webdriver is successfully initialised");
		//driver.get(prop.getProperty("PracticeProjectURL"));
		driver.manage().window().maximize();
		}
	
	@Test
	
	public void PracticePage2Navigation() throws IOException
	{
		driver.get(prop.getProperty("PracticeProjectURL"));
		log.info("Successfully initialized the browser using given URL");
		
		//Create object for PracticeHomePage
		PracticeHomePage pr =new PracticeHomePage(driver);
		pr.Radio1().click();
		log.info("Successfully Clicked on radion button 1");
		pr.Radio2().click();
		log.info("Successfully Clicked on radion button 2");
		pr.Radio3().click();
		log.info("Successfully Clicked on radion button 3");
		System.out.println("Line number 1");
		System.out.println("Line number 2");
		System.out.println("Line number 3");
		
		
	
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
		
	}
	
	
	
	
	}
	


