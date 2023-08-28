package basePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iframePage {
//URL for home page and webdriver
	WebDriver driver;
	String URL = "https://the-internet.herokuapp.com/";

	// WebElements
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[22]/a")
	public WebElement framesHomeLink;

	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[2]/a")
	public WebElement iframesLink;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]/div[1]/div[1]/button[4]/span")
	public WebElement formatButton;

	@FindBy(xpath = "//div/div/div[1]/div[7]/div[2]")
	public WebElement codeButton;

	public iframePage(WebDriver driver) {
		// initalize web elements
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void close() {
		driver.close();
	}

	/**
	 * Navigate to iFrames page click on format clear text box then click on code
	 * format add new text
	 * 
	 * @return the changed text
	 */
	public String newTextBox(String sample) {
		driver.get(URL);
		framesHomeLink.click();
		iframesLink.click();
		formatButton.click();
		codeButton.click();

		// switch to iFrame (HTML within iFrame)
		driver.switchTo().frame(0);
		WebElement textBox = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));

		// input code format test and return the new text
		textBox.sendKeys(sample);
		WebElement codeElement = driver.findElement(By.xpath("//*[@id=\"_mce_caret\"]/code"));

		return codeElement.getText();
	}
}
