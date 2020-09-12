package org.totalqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests {

	
	@Test(description="Validate the title of the website")
	public void validateTotalQATitle()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://total-qa.com/");
		String expected ="Total-QA - Automation Tools";
		String actual =driver.getTitle();
		Assert.assertEquals(actual, expected);
	}
}
