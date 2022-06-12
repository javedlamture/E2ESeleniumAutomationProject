package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	
	
	//Write one reusable method to invoke browser in Chrome, Firefox and IT for all test cases 
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		//Create properties file for driving which browser should invoke
		
		prop = new Properties();
		//FileInputStream fis = new FileInputStream("C:\\Users\\javed\\eclipse-workspace\\E2ESeleniumProject\\src\\main\\java\\resources\\data.properties");
		
		//To get project path dynamically we need to use System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//Below line will work if you want perform browser value from properties file
		//String browserName = prop.getProperty("browser");
		
		////Below line will work if you want perform browser value from jenkin with parameterization
		String browserName = System.getProperty("browser");
		
		
		if (browserName.contains("chrome"))
		{
			
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\javed\\SeleniumDriver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			if (browserName.contains("headless"))
			{
			option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
		}
		else if (browserName.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\javed\\SeleniumDriver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","C:\\Users\\javed\\SeleniumDriver\\IEDriverServer.exe");
			//System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		//set implicit wait for all your test cases
		
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
			
		return driver;
		
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException 
	{
		//TakesScreenshot ts = (TakesScreenshot) driver;
		File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		FileUtils.copyFile(source, new File (destinationFile));
		
		return destinationFile;
	} 

}
