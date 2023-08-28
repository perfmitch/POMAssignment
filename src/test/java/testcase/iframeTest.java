package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import basePages.iframePage;

public class iframeTest {
	
	WebDriver d = new ChromeDriver();
	iframePage driver = new iframePage(d);

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void iFrameCodeFormat() {
		String testText = "This Is A Test";
		Assert.assertEquals(testText, driver.newTextBox(testText));
		
	}
}
