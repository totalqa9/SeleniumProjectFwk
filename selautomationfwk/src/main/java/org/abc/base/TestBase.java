package org.abc.base;
import java.util.Properties;

import org.abc.license.config.ProjectConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected  WebDriver driver;
	protected  Properties pro;
	
	@BeforeTest
	public void readConfig() throws Exception
	{
		ProjectConfiguration pConf = new ProjectConfiguration();
		pro = pConf.loadProperites();
	}
	@BeforeClass
	public void instantiateDriver() throws Exception{
		System.out.println("First line of the instantiate method");
		 
		String browser = pro.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")){	
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		System.out.println("LastLine of the instatiate method of TestBase");
	}

	 

}
