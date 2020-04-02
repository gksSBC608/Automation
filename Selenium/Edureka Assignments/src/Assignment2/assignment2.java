package Assignment2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

@SuppressWarnings("deprecation")

public class assignment2 
{

	private Selenium selenium;


	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://www.facebook.com/");
		selenium.start();
	}

	@Test
	public void testModule2_Assignment1() throws Exception {
		selenium.open("/");
		System.out.println(selenium.getText("xpath=//body"));
		String text = selenium.getText("xpath=//body");
		if(text.contains("Connect with friends and the\nworld around you on Facebook."))
			System.out.println("Pass");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
