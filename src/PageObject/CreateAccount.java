package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

public class CreateAccount extends ObjectPage {

	Faker faker = new Faker();
	String name = faker.name().fullName();
	String phone = faker.phoneNumber().cellPhone();
	String password = faker.internet().password();

	@FindBy(id="createAccountSubmit")
	WebElement createAccountButton;
		
	@FindBy(id="ap_customer_name")
	WebElement cusotmerName;
	
	@FindBy(id="ap_email")
	WebElement cusotmerPhone;
	
	@FindBy(id="ap_password")
	WebElement cusotmerPassword;	
	
	@FindBy(id="ap_password_check")
	WebElement cusotmerRecheckPassword;
	
	@FindBy(id="continue")
	WebElement ContinueButton;
	

	
	public CreateAccount(WebDriver webdriver)
	{
		super(webdriver);
		
	}	
	
	public WebElement createAccountButton()
	{
		return createAccountButton;
	}
	public WebElement cusotmerName()
	{
		return cusotmerName;
	}
	public WebElement cusotmerPhone()
	{
		return cusotmerPhone;
	}
	public WebElement cusotmerPassword()
	{
		return cusotmerPassword;
	}
	public WebElement cusotmerRecheckPassword()
	{
		return cusotmerRecheckPassword;
	}
	public WebElement ContinueButton()
	{
		return ContinueButton;
	}
	
	public void fillCustomerDetails()
	{
	   System.out.println("Entering customer name" + name);
	   cusotmerName().sendKeys(name);
	   System.out.println("Entering customer phone" + phone);
	   cusotmerPhone().sendKeys(phone);
	   System.out.println("Entering customer password" + password);
	   cusotmerPassword().sendKeys(password);
	   cusotmerRecheckPassword().sendKeys(password);
	   ContinueButton().click();				
	}
		
}
