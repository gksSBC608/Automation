package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Events 
{
	private AppiumDriver<MobileElement>  driver;
	//private WebElement[] element;
	
	
	
	
	
	
	
	public void setDriver(AppiumDriver<MobileElement>  thisDriver)
	{
		this.driver = thisDriver;
	}
	
	public void clearElement(WebElement element)
	{
		element.clear();
	}
	
	public WebElement getElement(String checkBy, String value)
	{
		WebElement element = null;
		
		HashMap<String, Object> existsObj = this.checkElementExists(checkBy, value);
		
		boolean exists = (Boolean) existsObj.get("exists");
		
		if(exists)
		{
			element = (WebElement) existsObj.get("element");
		}
		
		return element;
	}
	
	public List<MobileElement> getElements(String checkBy, String value)
	{
		List<MobileElement> elements = null;
		
		if(checkBy == "xpath")
		{
			elements = this.driver.findElements(By.xpath(value));
		}
		
		return elements;
	}
	
	public String getElementType(String checkBy, String value)
	{
		String elementType = "";
		
		HashMap<String, Object> existsObj = checkElementExists(checkBy, value);
		
		boolean exists = (Boolean) existsObj.get("exists");
		
		if(exists)
		{
			WebElement element = (WebElement) existsObj.get("element");
			
			elementType = element.getTagName();
		}
		
		return elementType;
	}
	
	public boolean clickElement(String checkBy, String value, boolean ifNotSelected)
	{
		boolean clicked = false;
		
		HashMap<String, Object> existsObj = checkElementExists(checkBy, value);
		
		boolean exists = (Boolean) existsObj.get("exists");
		
		if(exists)
		{
			WebElement element = (WebElement) existsObj.get("element");
			
			//if we want to 'clickElement' only 'ifNotSelected'
			if(ifNotSelected)
			{
				//only click the element if it is not already selected.  Applies to checkboxes only.
				if(!this.isSelected(element))
				{
					element.click();
				}
			}
			//otherwise just click the element
			else
			{
				element.click();
			}
			
			clicked = true;
		}
		
		return clicked;
	}
	
	public void clickElement(WebElement element, boolean ifNotSelected)
	{
		if(ifNotSelected)
		{
			if(!this.isSelected(element))
			{
				element.click();
			}
		}
		else
		{
			element.click();
		}
	}
	
	public boolean typeElement(String locatorType, String value, String typedValue)
	{
		boolean typed = false;
		
		HashMap<String, Object> existsObj = checkElementExists(locatorType, value);
		
		if((Boolean) existsObj.get("exists"))
		{
			WebElement element = (WebElement) existsObj.get("element");
			
			//clear any pre-entered values first
			element.clear();
			
			element.sendKeys(typedValue);
			
			typed = true;
		}
		
		return typed;
	}
	
	public WebElement getSelectedIndex(WebElement element)
	{
		WebElement name = null;
		String attValue = null;
		
		List<WebElement> options = element.findElements(By.tagName("option"));
		
		for(int i = 0; i > options.size(); i++)
		{
			attValue = getAttributeValue(options.get(i), "selected");
			
			if(attValue != null && attValue.toLowerCase() == "selected")
			{
				name = options.get(i);
				break;
			}
		}
		
		return name;
	}
	
	public String getAttributeValue(WebElement element, String attribute)
	{
		String attValue = element.getAttribute(attribute);
		
		return attValue;
	}
	
	public String getElementText(String checkBy, String value)
	{
		String elementText = "";
		
		HashMap<String, Object> existsObj = checkElementExists(checkBy, value);
		
		if((Boolean) existsObj.get("exists"))
		{
			WebElement element = (WebElement) existsObj.get("element");
			
			elementText = element.getText();
		}
		
		return elementText;
	}
	
	public boolean isSelected(WebElement element)
	{
		boolean isSelected = element.isSelected();
		
		return isSelected;
	}
	
	public boolean elementExists(String checkBy, String value)
	{
		HashMap<String, Object> existsObj = checkElementExists(checkBy, value);
		
		return (Boolean) existsObj.get("exists");
	}
	
	public boolean elementIsVisible(String checkBy, String value)
	{
		boolean elementIsVisible = false; 
		
		HashMap<String, Object> existsObj = checkElementExists(checkBy, value);
		
		if((Boolean) existsObj.get("exists"))
		{
			WebElement element = (WebElement) existsObj.get("element");
			
			elementIsVisible = element.isDisplayed();
		}
		
		return elementIsVisible;
	}
      
	public void mouseOverToElement1() {
    	WebElement mnuElement;  
    	WebElement submnuElement;
    	mnuElement = driver.findElement(By.xpath("//ul[@id='PanelCmd']/li/a/img")); 
    	submnuElement = driver.findElement(By.xpath("//ul[@id='PanelCmd']/li/div/a"));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(mnuElement).perform(); 
    	//driver.findElement(By.xpath("submnuElement")).click();  
    	builder.moveToElement(submnuElement).click().build().perform(); 
    	
    }
    public void mouseOverToElement2() {
    	WebElement mnuElement;  
    	WebElement submnuElement;
    	mnuElement = driver.findElement(By.xpath("//ul[@id='PanelCmd']/li/a/img")); 
    	submnuElement = driver.findElement(By.xpath("//ul[@id='PanelCmd']/li/div/a[2]"));
    	Actions builder = new Actions(driver);
    	builder.moveToElement(mnuElement).perform(); 
    	//driver.findElement(By.xpath("submnuElement")).click();  
    	builder.moveToElement(submnuElement).click().build().perform(); 
    }
    
//	public WebDriver openNewWindow(Browsers browser)
//	{
//		//make sure this driver is new so as to not interfere with the existing test driver
//		DriverBuilder driverBuilder = new DriverBuilder();
//		
//		//build and start a driver
//		driverBuilder.setDriver(browser);
//		
//		return driverBuilder.getDriver(60, TimeUnit.SECONDS);
//	}
	
	public void changeFrame(String frameIdOrName)
	{
		this.driver.switchTo().frame(frameIdOrName);
	}
	
	public void changeToDefaultFrameOrWindow()
	{
		this.driver.switchTo().defaultContent();
	}
	
	private HashMap<String, Object> checkElementExists(String checkBy, String value)
	{
		List<MobileElement> element = null;
		
		HashMap<String, Object> returnObj = new HashMap<String, Object>();
		returnObj.put("exists", (boolean) false);
		returnObj.put("element", (WebElement) element);
		
		if(checkBy.toLowerCase() == "xpath")
		{
			element = this.driver.findElements(By.xpath(value));
		}
		else if(checkBy.toLowerCase() == "id")
		{
			
			element = this.driver.findElements(By.id(value));
		}
		else if(checkBy.toLowerCase() == "name")
		{
			element = this.driver.findElements(By.name(value));
		}
		else if(checkBy.toLowerCase() == "cssSelector")
		{
			element = this.driver.findElements(By.cssSelector(value));
		}
		else if(checkBy.toLowerCase() == "linkText")
		{
			element = this.driver.findElements(By.linkText(value));
		}
		if(element.size() == 1)
		{
			returnObj.put("exists", (boolean) true);
			returnObj.put("element", (WebElement) element.get(0));
		}
		
		return returnObj;
	}
}
