package TestScripts;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import UITestFramework.FrameworkTest;


public class ShoppingTest extends FrameworkTest {
	
	@Test(dataProvider="InputData")
	public void AddItem(String email,String password,String searchItem) throws InterruptedException
	{
		
		LoginPage loginpage = new LoginPage(driver);	
		loginpage.loginApplication(driver);		
		Assert.assertTrue(driver.getCurrentUrl().contains("amazon"),"invalid page loaded");
		
		HomePage homepage = new HomePage(driver);
		homepage.searchItem(searchItem);
		
		
	}

}
