package Custcommands;

import java.io.File;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import Config.StartBrowser;

public class ActionDriver {


WebDriver driver;

public ActionDriver ()
{
	driver= StartBrowser.driver;
}

public void launchApplication (String url) throws Exception
{

	
 try {
	 driver.get(url);
	 StartBrowser.childTest.pass("Navigated to Application URL" +url+ StartBrowser.childTest.addScreenCaptureFromPath(screenshot(driver)));
 }

 
catch (Exception e) {
	StartBrowser.childTest.fail("Navigated unsuccessfull " +url);
	throw e;// if throw is not given , the steps will continue.. else it stops
}
}

public void click(By locator, String ename) throws Exception
{
	try {
driver.findElement(locator).click();
StartBrowser.childTest.pass("Able to perform click operation on " + ename);
	}
	catch (Exception e)

	{
		StartBrowser.childTest.fail("Unable to perform click action on " +ename);
	throw e;
		
	}
}
public void type (By locator, String testData) throws Exception
{
	try {
	
driver.findElement(locator)	.clear();
driver.findElement(locator).sendKeys(testData);

StartBrowser.childTest.pass("Able to perform type " + testData);
}
	catch (Exception e)

	{
		StartBrowser.childTest.fail("Unable to perform type action on " +testData);
	throw e;
	}
	}
	
public void mouseHover(By locator)
{
Actions a= new Actions(driver)	;
WebElement mo = driver.findElement(locator);
a.moveToElement(mo).build().perform();
}

public String screenshot(WebDriver driver)

{
String src_path = "/SShot";	
UUID uuid = UUID.randomUUID();
File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

try {
	FileHandler.copy(srcfile, new File (src_path+".jpeg"));
	
}
catch (Exception e)
{
	System.out.println("Unable to capture Screenshot");
	}
return src_path + uuid+".jpeg" ;
}}
