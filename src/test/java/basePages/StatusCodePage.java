package basePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusCodePage {
//URL for home page and webdriver
	WebDriver driver;
	String URL = "https://the-internet.herokuapp.com/";

	// Web elements
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[42]/a")
	public WebElement statusCodeLink;

	@FindBy(xpath = "//*[@id=\"content\"]/div/p")
	public WebElement StatusResults;

	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[1]/a")
	public WebElement Status200;

	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/a")
	public WebElement Status301;

	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[3]/a")
	public WebElement Status404;

	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[4]/a")
	public WebElement Status500;

	public StatusCodePage(WebDriver driver) {
		// initalize web elements
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void close() {
		driver.close();
	}

	/**
	 * Navigate to status code page click on a status click on here to return repeat
	 * @return 
	 * 
	 * @return
	 */
	public Integer checkStatus(int code) {
		// navigate to status code page
		driver.get(URL);
		statusCodeLink.click();

		if(code == 200) {
			Status200.click();
		}else if(code == 301) {
			Status301.click();
		}else if(code == 404) {
			Status404.click();
		}else if(code == 500) {
			Status500.click();
		}

		// extract the status code
		String results = StatusResults.getText();
		String statusCode = results.replaceAll("[^0-9]", "");
		return Integer.valueOf(statusCode);
	}
}
