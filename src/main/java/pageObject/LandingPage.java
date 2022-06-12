package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	public WebDriver driver;
	
	private By login = By.xpath("//div[@class='login-btn'][2]");
	
	
	//Pagefactory
	 @FindBy(xpath="//div[@class='col-md-6 text-left']/h2/span")
	 private WebElement title;
	
	private By joinnow = By.linkText("JOIN NOW");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}


	public WebElement LogIn()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(login));
		return driver.findElement(login);
	}
	
	public WebElement gettitle()
	{
		return title;
	}
	
	public WebElement joinNowText()
	{
		return driver.findElement(joinnow);
	}
	

}
