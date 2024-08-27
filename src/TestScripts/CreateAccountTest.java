package TestScripts;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import PageObject.CreateAccount;
import PageObject.LoginPage;
import UITestFramework.FrameworkTest;

public class CreateAccountTest   extends FrameworkTest{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@Test
	public void createNewAccountTest() throws InterruptedException
	{
		LoginPage loginpage = new LoginPage(driver);	
		loginpage.loginApplication(driver);		
		Assert.assertTrue(driver.getCurrentUrl().contains("amazon"),"invalid page");		
		Assert.assertTrue(loginpage.Account().isDisplayed());
		Actions actions=new Actions(driver);
		actions.moveToElement(loginpage.Account()).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(loginpage.SignIn()));
		Assert.assertTrue(loginpage.SignIn().isDisplayed());
		loginpage.SignIn().click();
		CreateAccount createAccount = new CreateAccount(driver);;
        createAccount.createAccountButton().click();
        createAccount.fillCustomerDetails();
               
		
	}	

}
