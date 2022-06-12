package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeHomePage {
	
	public WebDriver driver;
	
	//Constructor 
	public PracticeHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory design of locators
	@FindBy(linkText = "Automation Practise - 2")
	private WebElement AutomationPractice2;
	
	@FindBy(xpath="//input[@value='radio1']")
	private WebElement firstRadio;
	
	@FindBy(xpath="//input[@value='radio2']")
	private WebElement secondRadio;
	
	@FindBy(xpath="//input[@value='radio3']")
	private WebElement thirdRadio;
	
	
	
	
	//****************************************************************************************************
	//Methods for locators
	public WebElement NavigationOfPractice2()
	{
		return AutomationPractice2;
	}
		
	public WebElement Radio1()
	{
		return firstRadio;
	}
	
	public WebElement Radio2()
	{
		return secondRadio;
	}
	
	public WebElement Radio3()
	{
		return thirdRadio;
	}
		

}
