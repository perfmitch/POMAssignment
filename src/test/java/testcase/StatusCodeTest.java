package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basePages.StatusCodePage;

public class StatusCodeTest {
	WebDriver d = new ChromeDriver();
	StatusCodePage driver = new StatusCodePage(d);

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@Test
	public void Status200Test() {
		Assert.assertEquals(200, driver.checkStatus(200));
	}
	
	@Test
	public void Status301Test() {
		Assert.assertEquals(301, driver.checkStatus(301));
	}
	
	@Test
	public void Status404Test() {
		Assert.assertEquals(404, driver.checkStatus(404));
	}
	
	@Test
	public void Status500Test() {
		Assert.assertEquals(500, driver.checkStatus(500));
	}
}
