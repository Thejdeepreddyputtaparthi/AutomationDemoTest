package PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ObjectPage{
	
    @FindBy(id="twotabsearchtextbox")
	WebElement SearchBox;
  
	@FindBy(xpath=".//*[@type='submit']")
	WebElement Search;
	
	@FindBy(id="a-autoid-3-announce")
	WebElement SortBy;
	
	@FindBy(linkText="iphone x 64gb")
	WebElement Filter1;
	
	@FindBy(id="s-result-sort-select_2") 
	WebElement PriceSort;
		
	
	public HomePage(WebDriver webdriver)
	{
		super(webdriver);
		
	}
	
	public WebElement SearchBox()
	{
		return SearchBox;
	}

	public WebElement Search()
	{
		return Search;
	}

	public WebElement Filter1()
	{
		return Filter1;
	}
	public WebElement SortBy()
	{
		return SortBy;
	}
	public WebElement PriceSort()
	{
		return PriceSort;
	}
	public void searchItem(String searchItem)
	{
		
    System.out.println("Enter search Item");
	SearchBox().sendKeys("iphone x 64gb");
	System.out.println("Click on Search");
	Search().click();
    SortBy().click();
    }

}
