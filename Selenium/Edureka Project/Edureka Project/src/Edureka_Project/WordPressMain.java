package Edureka_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WordPressMain {

	static WebDriver driver;
	
	public static void main(String[] args)throws Exception 
	
	{
		// Automating in chrome browser
		System.setProperty("webdriver.chrome.driver", "D:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		// calling wordpress login page
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		ElementSelection.validateFields(driver);
		
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
