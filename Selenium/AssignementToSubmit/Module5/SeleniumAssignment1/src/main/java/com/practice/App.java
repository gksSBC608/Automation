package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class App {
	static String driverPath = "driver/";

	private static WebDriver driver;

	public static void main(String[] args) {

		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		driver = new ChromeDriver();
		module4_assignment();
		
		driver.close();
	}
	
	private static void module4_assignment(){
		
		driver.navigate().to("http://newtours.demoaut.com/");
		
		driver.findElement(By.linkText("REGISTER")).click();
		
		driver.findElement(By.name("firstName")).sendKeys("Gaurav");
		driver.findElement(By.name("lastName")).sendKeys("Sharan");
		
	}
}
