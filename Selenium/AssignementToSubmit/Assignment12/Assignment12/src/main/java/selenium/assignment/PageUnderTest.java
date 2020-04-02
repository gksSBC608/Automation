package selenium.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class PageUnderTest {

	private WebDriver driver;

	@FindBy(linkText = "smilechart.xls")
	private WebElement fileToDownload;

	public PageUnderTest(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (ElementNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickTheDownloadFileLink() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 19);
			wait.until(ExpectedConditions.visibilityOf(fileToDownload));
			fileToDownload.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
