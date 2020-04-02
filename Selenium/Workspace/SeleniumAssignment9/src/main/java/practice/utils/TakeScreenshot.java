package practice.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.OutputType;

public class TakeScreenshot {

	public static void takeScreenshot(WebDriver driver, String screenName) {
		try {
			String directory = "D:/Selenium_test_screenshots/";
			File file = new File(directory);
			if (!file.isDirectory()) {
				file.mkdir();
			}
			String fileName = screenName + "_" + new Date().getTime()+".png";
			java.io.File sourceFile = (java.io.File) ((org.openqa.selenium.TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			// File sourceFile = ((TakesScreenshot)
			// driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(sourceFile, new java.io.File(directory + fileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// String destination = directory + fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
