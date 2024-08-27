
package UITestFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FrameworkTest {
	
protected static WebDriver driver;

public static XSSFWorkbook workbook;
public static XSSFSheet worksheet;
public static DataFormatter formatter= new DataFormatter();
static String ROOT = System.getProperty("user.dir");
static String xlFilePath = ROOT +"\\TestData.xlsx"; 
static String SheetName = "Datasheet";
public  String Res;  
public int DataSet=-1;


	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",ROOT + "\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void screenCapture(ITestResult testresult) throws IOException
	{
	if(ITestResult.FAILURE==testresult.getStatus()) {
	// Call method to capture screenshot
	String methodname = testresult.getName(); 
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


	String location = ROOT + "\\Failure Screenshots\\";

	org.openqa.selenium.io.FileHandler.copy(scrFile,new File(location + methodname + "_" + ".png" ));
	
	driver.quit();
	}
	else
	driver.quit();

	}	
	
	
	
	@DataProvider
	public static Object[][] InputData() throws IOException
	{
	FileInputStream fileInputStream= new FileInputStream(xlFilePath); 
	    workbook = new XSSFWorkbook (fileInputStream); 
	    worksheet=workbook.getSheet(SheetName);
	    XSSFRow Row=worksheet.getRow(0);     
	 
	    int RowNum = worksheet.getPhysicalNumberOfRows();
	    int ColNum= Row.getLastCellNum(); 
	     
	    Object Data[][]= new Object[RowNum-1][ColNum]; 
	     
	        for(int i=0; i<RowNum-1; i++) 
	        {  
	        	XSSFRow row= worksheet.getRow(i+1);
	             
	            for (int j=0; j<ColNum; j++) 
	            {
	                if(row==null)
	                    Data[i][j]= "";
	                else
	                {
	                	XSSFCell cell= row.getCell(j);
	                    if(cell==null)
	                        Data[i][j]= ""; 
	                    else
	                    {
	                        String value=formatter.formatCellValue(cell);
	                        Data[i][j]=value; 
	                    }
	                }
	            }
	        }

	    return Data;
	}

}
