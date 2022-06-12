package academy;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;	
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	//declare driver object as local to this class because if u run test in parallel mode then it will create confusion
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialization() throws IOException
	{
		driver =initializeDriver();
		log.info("Webdriver is successfully initialised");
		
		}
	
	@Test(dataProvider="getData")
	
	public void homePageNavigation(String username, String password) throws IOException
	{
		/*driver =initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();*/
		
		driver.get(prop.getProperty("url"));
		log.info("Successfully Navigated to Home Page");
		driver.manage().window().maximize();
		log.info("Successfully maximized the screen window");
		
		//Create object for LandingPage
		LandingPage ln =new LandingPage(driver);

		
		WebElement LoginButton = driver.findElement(By.cssSelector("a[class='theme-btn register-btn']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", LoginButton);
		
		//ln.LogIn().click();
		log.info("Successfully Clicked on Log In button");
		
		//Create object for LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.EnterEmail().sendKeys(username);
		log.info("Successfully Entered the username");
		lp.EnterPassword().sendKeys(password);
		log.info("Successfully Entered the password");
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="Sandeep.patil@gmail.com";
		data[0][1]="9754879954";
		
		data[1][0]="javedlamture@yahoo.com";
		data[1][1]="67890";
		
		
		return data;
	}

	@AfterClass
	public void teardown()
	{
		driver.close();
	}

}
