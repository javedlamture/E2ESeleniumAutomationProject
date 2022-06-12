package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	public WebDriver driver;
	
	private By email = By.xpath("//input[@name='email']");
	
	private By password = By.xpath("//input[@name='password']");
	
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}
	
	public WebElement EnterEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement EnterPassword()
	{
		return driver.findElement(password);
	}
	
	
	
	
	
	

}
