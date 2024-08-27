package PageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends ObjectPage {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath=".//*[@id='nav-link-accountList-nav-line-1']")
	WebElement Account;
	
	@FindBy(linkText="Sign in")
	WebElement SignIn;
	
	@FindBy(name="email")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(id="signInSubmit")
	WebElement Submit;
        
    @FindBy(id="auth-error-message-box")
	WebElement ErrorWrongUserName;
	
    @FindBy(id="continue")
	WebElement ContinueButton;
    
    @FindBy(xpath="//button[@type=\"submit\"]")
   	WebElement ContinueShoppingButton;
    
	public WebElement Account()
	{
		return Account;
	}
	
	public WebElement SignIn()
	{
		return SignIn;
	}
	
	public WebElement Username()
	{
		return Username;
	}
	
	public WebElement Password()
	{
		return Password;
	}
	
	public WebElement Submit()
	{
		return Submit;
	}
        
	public WebElement ErrorWrongUserName()
	{
		return ErrorWrongUserName;
	}
	
	public WebElement ContinueButton()
	{
		return ContinueButton;
	}
	public WebElement ContinueShoppingButton()
	{
		return ContinueShoppingButton;
	}


	
	public LoginPage(WebDriver webdriver)
	{
	super(webdriver);
	}	
	
	
	public void loginApplication(WebDriver webdriver) throws InterruptedException {
		
	webdriver.get("https://www.amazon.com/");	
	Thread.sleep(2000);
	if (webdriver.getTitle().equals("Amazon.com"))
	{
		Thread.sleep(2000);
		webdriver.navigate().refresh();
	}	   		   
	}
	
	public void logIn(String email, String password) throws InterruptedException
	{
	   System.out.println("Entering email address");
	   Username().sendKeys("thejdeep.p@gmail.com"); 
	   System.out.println("Click on Continue button");
	   ContinueButton().click();
	   Thread.sleep(2000);
	   Assert.assertTrue(Password().isDisplayed()); 
	   System.out.println("Entering password");
	   Password().sendKeys("241991@Reddy");
	   Submit().click();
		
    }
}
