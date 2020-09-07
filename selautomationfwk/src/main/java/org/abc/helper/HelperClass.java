package org.abc.helper;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	int i = 0;
	WebDriver driver;
	
	public HelperClass(WebDriver driver){
		this.driver = driver;
	}
	public void login(String uName, String password){

		 
	}
	public void captureScreenshot(String tc_Name) throws IOException
	{
		System.out.println("Inside Capturing Screenshot method");
		TakesScreenshot tsh = (TakesScreenshot)driver;
		File sourceFile = tsh.getScreenshotAs(OutputType.FILE);
		System.out.println(sourceFile.getAbsolutePath());
		String destinationPath = System.getProperty("user.dir")+"\\screenshots\\"+tc_Name+"_"+
											Calendar.getInstance().getTimeInMillis()%1000000000+".jpg";
		File destFile = new File(destinationPath); 
		FileUtils.copyFile(sourceFile,destFile);
		System.out.println(destinationPath);
		System.out.println("Exiting Screenshot");
		
	}
	public WebDriver switchToAFrameAvailable(String frameId,int timeinSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		return driver;
	}
	public void switchToSideBar(){
		driver.findElement(By.xpath("//div[@class='left-sidebar']")).click();
	}
	public void highLightElement(WebElement ele){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;')", ele);
	}
	 


}
