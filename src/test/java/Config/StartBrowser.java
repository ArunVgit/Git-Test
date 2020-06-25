package Config;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;

public class StartBrowser {
 public static WebDriver driver;
 public static String method;
 public ExtentHtmlReporter htmlReporter;
 public static ExtentReports extent;
 public static ExtentTest parentTest;
 public static ExtentTest childTest;
 @BeforeTest
 public void report() 
 {
	 htmlReporter= new ExtentHtmlReporter("Reports/MyHtmlReport.html");
	 extent = new ExtentReports();
	extent.attachReporter(htmlReporter);		 
 }
 
 @BeforeMethod
 public void methodName(Method method)
 {
	 parentTest = extent.createTest(method.getName());
	 
 }
  @BeforeClass
  public void beforeClass() {

		System.setProperty("webdriver.chrome.driver","E:\\\\Chrome driver\\\\chromedriver.exe" );

		ChromeOptions options = new ChromeOptions();
		 
		// add parameter which will disable the extension
		options.addArguments("--disable-extensions");
				//disable-popup-blocking");
		 
		// Start the chrome session
		 driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  extent.flush();// tell the report that test case is done
	  
  }

}
