package com.assignment.module8;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpClient;

public class Main {

	private static String driverPath = "driver/";
	private static WebDriver driver;

	public static void main(String[] args) {

		String navigationLink = "https://www.facebook.com/";

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		navigate(navigationLink);

		testCase();

		driver.close();
		System.out.println("Closed the driver");
	}

	private static void testCase() {

		String css = "ul[class='uiList pageFooterLinkList _509- _4ki _703 _6-i'] li a";

		List<WebElement> links = driver.findElements(By.cssSelector(css));
		int validLinks = 0;
		for (WebElement we : links) {
			String text = we.getText();
			String href = we.getAttribute("href");
			System.out.println(text + " " + href);
			boolean valid = checkIfLinkIsValid(href);
			if (valid)
				validLinks++;
			System.out.println(validLinks);
		}
		System.out.println("Total links are:-" + links.size());
		System.out.println("Total valid links are:-" + validLinks);

	}

	private static boolean checkIfLinkIsValid(String href) {
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(href);

			con = (HttpURLConnection) url.openConnection();
			int responseCode = con.getResponseCode();
			System.out.println("response code: " + responseCode);
			if (responseCode == 200 || (responseCode >= 300 && responseCode <= 310)) {
				return true;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		return false;
	}

	private static void navigate(String navigationLink) {

		driver.navigate().to(navigationLink);
	}

}
