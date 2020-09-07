package org.abc.enforcement.tests;

import org.abc.base.TestBase;
import org.abc.enforcement.pages.EnforcementPage;
import org.abc.helper.HelperClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnforcementTests extends TestBase{
	
	@BeforeMethod
	public void login()
	{
		HelperClass helper = new HelperClass(driver);
		helper.login("uname", "password");
		driver.get("http://total-qa.com");
		driver.findElement(By.xpath("")).sendKeys("uname"));
		driver.findElement(By.xpath("")).sendKeys("uname"));
		driver.findElement(By.xpath("")).click();
	}
	
	@Test
	public void validateEnforcementRules()
	{
		EnforcementPage ePage = new EnforcementPage(driver);
	}
	@AfterMethod
	public void logout()
	{
		
	}

}
