package Edureka_Project;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class WordpressScreenshots 
{

	public static void pic1(WebDriver driver)throws Exception
	{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:/WORDPRESS SCREENSHOTS/pic1.png"));
		
	}
	
	
	public static void pic2(WebDriver driver)throws Exception
	{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:/WORDPRESS SCREENSHOTS/pic2.png"));
		
	}
}
