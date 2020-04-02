package Edureka_Project;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import org.openqa.selenium.support.ui.Select;


public class ElementSelection 

{

	//Validate of the fields are present or not
	public static void validateFields(WebDriver driver) throws Exception
	{
		
		
		//Find whether the required username,password field and login button is present or not
		if(driver.findElement(By.xpath("html/body/div[1]/form/p[1]/label/input")).isEnabled() && 
				driver.findElement(By.xpath("html/body/div[1]/form/p[2]/label/input")).isEnabled() &&
				driver.findElement(By.xpath("html/body/div[1]/form/p[4]/input[1]")).isEnabled())
		{
			Thread.sleep(7000);
			
			dataValidate(driver);

		}
		
		else
		{
			System.out.println("Automation cannot proceed as the required fields are not present");
			
			Thread.sleep(5000);
			
			driver.quit();
		}
		

	}
	

	//Validate username and password and check if log in button is enabled
	public static void dataValidate(WebDriver driver) throws Exception
	{
		
		WebElement uname,pass;
		String username = "admin";
		String password = "demo123";
		
		// fetching value from the username field
		uname = driver.findElement(By.xpath("html/body/div[1]/form/p[1]/label/input"));
		uname.getAttribute("value");
		
		//fetching password from the password field
		pass = driver.findElement(By.xpath("html/body/div[1]/form/p[2]/label/input"));
		pass.getAttribute("value");
		
		// compare the username and password from the fields to the username and password provided
		
		//print if uesrid and password already entered are eqaul or not
		System.out.println(username.equals(uname));
		System.out.println(password.equals(pass));
		
		Thread.sleep(3000);
		
		// Check if login button is present or not 
		if(driver.findElement(By.xpath("html/body/div[1]/form/p[4]/input[1]")).isEnabled())
		{
			System.out.println("'Login' button is present");
			
			// SCREENSHOT 1
			WordpressScreenshots.pic1(driver);
			
			Thread.sleep(7000);
			
			//method for validating email text box and get new password button
			validateFields1(driver);
			
		}
		
		else
		{
			System.out.println("Automation cannot proceed");
			
			// SCREENSHOT 2
			WordpressScreenshots.pic2(driver);
			
			Thread.sleep(4000);
			
			
			driver.quit();
		}
				
		
	}

	
	//Valid email text box and get new password button
	public static void validateFields1(WebDriver driver) throws Exception
	{
		
		driver.findElement(By.xpath("html/body/div[1]/p[1]/a")).click();
		
		Thread.sleep(4000);
		
		if(driver.findElement(By.xpath("html/body/div[1]/form/p[1]/label/input")).isEnabled() && driver.findElement(By.xpath("html/body/div[1]/form/p[2]/input")).isEnabled())
		{
			System.out.println("'email text box' and 'get new password button' are present");
			
			Thread.sleep(7000);
			
			// Calling the login method
			userLogin(driver);
		}
		else
		{
			System.out.println("'email text box' and 'get new password button' are not present");
			
			Thread.sleep(7000);
			
			// Calling the login method
			userLogin(driver);
		}
	}

	
	//Get to the previous link and login using valid username and password
	public static void userLogin(WebDriver driver) throws Exception
	{
		
		// cal the URL again
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		WebElement uname,pass,login;
		
		
		//Enter Username
		uname = driver.findElement(By.xpath("html/body/div[1]/form/p[1]/label/input"));
		uname.click();
		
		Thread.sleep(2000);
		
		uname.clear();
		
		Thread.sleep(2000);
		
		uname.sendKeys("admin");
		
		
		//Enter Password
		pass = driver.findElement(By.xpath("html/body/div[1]/form/p[2]/label/input"));
		pass.click();
		
		Thread.sleep(2000);
		
		pass.clear();
		
		Thread.sleep(2000);
		
		pass.sendKeys("demo123");
		
		
		//Click on login button
		login = driver.findElement(By.xpath("html/body/div[1]/form/p[4]/input[1]"));
		login.click();
		
		Thread.sleep(7000);
		
		
		//calling method to add new post
		newPost(driver);		
		
	}

	
	//Adding a new post after loging in
	public static void newPost(WebDriver driver) throws Exception
	{
		
		WebElement post,newpost,title;
		//WebElement description;
		
		//clicks on the "Posts" link
		post = driver.findElement(By.xpath("html/body/div/div[2]/ul/li[3]/a"));
		post.click();
		
		Thread.sleep(3000);
		
		//clicks on the "Add New" link
		newpost = driver.findElement(By.xpath("html/body/div/div[3]/div[2]/div[1]/div[4]/h2/a"));
		newpost.click();
		
		Thread.sleep(7000);
		
		
		//add title
		title = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[1]/div[4]/form/div/div/div[1]/div[1]/div[1]/input"));
		title.click();
		
		Thread.sleep(2000);
		
		title.clear();
		
        Thread.sleep(2000);
		
		title.sendKeys("Wordpress Automation");
		
		Thread.sleep(5000);
		
		//add description
		
		//driver.findElement(By.xpath("html/body/p")).sendKeys("Wordpress Automation is going on using Selenium WebDriver");
		//description = driver.findElement(By.id(".//*[@id='tinymce']/p"));
		
		//description.click();
		
	   // Thread.sleep(3000);
		
	   // description.clear();
		
        //Thread.sleep(3000);
		
       // description.sendKeys("Wordpress Automation is going on using Selenium WebDriver");
		
		//Thread.sleep(5000);
		//select preview button and close the newly opened tab
        prevButton(driver);
		
	}

	
	//select preview button and adding tags
	public static void prevButton(WebDriver driver) throws Exception
	{
		WebElement prev,tags;
		
		// click on the preview button
		prev = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[1]/div[4]/form/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/a"));
		prev.click();
		
		Thread.sleep(7000);
		
		//move to previous tab
		
	/*	for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
		{

	        String winHandle = driver.getWindowHandles().toArray()[i].toString();

	        driver.switchTo().window(winHandle);

	        driver.close();

	    }*/
		
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
		
		System.out.println("SUCCESSFUL");
		
		Thread.sleep(7000);
		
		
		//Adding tags
		tags = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[1]/div[4]/form/div/div/div[2]/div/div[3]/div[2]/div/div[1]/div[2]/p/input[1]"));
		tags.click();
		
		Thread.sleep(3000);
		
		tags.clear();
		
		Thread.sleep(3000);
		
		tags.sendKeys("abcd,efgh,ijkl");
		
		Thread.sleep(3000);
		
		//Click on Add button
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[1]/div[4]/form/div/div/div[2]/div/div[3]/div[2]/div/div[1]/div[2]/p/input[2]")).click();
		
		Thread.sleep(5000);
		
		//click on the screen options button
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/a")).click();
		
		Thread.sleep(4000);
		
		//uncheck the Tags checkbox
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/form/div[1]/label[2]/input")).click();
		
		Thread.sleep(5000);
		
		//click on the preview button
		driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[1]/div[4]/form/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[2]/a")).click();
		
		
		Thread.sleep(5000);
		
		 ArrayList<String> tab = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tab.get(1));
		 
		 Thread.sleep(5000);
		
//		WebElement elements;
		
		//select logout option
		
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[1]/div[2]/div/form/p[1]/a[2]")).click();
//		element = driver.findElement(By.xpath("*[@id='wp-admin-bar-my-account']/a"));
//		elements.click();
		
		Thread.sleep(5000);
//		driver.findElement(By.xpath("html/body/div[2]/div/ul[2]/li[2]/a")).click();
//		elements.click();
//		Thread.sleep(3000);
//		elements = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/ul[2]/li/div/ul/li[3]/a"));
//		elements.click();


//         Select select = new Select(driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/ul[2]/li/a")));
//         select.selectByVisibleText("Log Out");
		
		
//	    Thread.sleep(5000);
	    
	    driver.quit();

	}
	

	
}
