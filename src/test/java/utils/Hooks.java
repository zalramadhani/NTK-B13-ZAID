package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	public static WebDriver driver; 
	
	
	//Method 1 --> it opens browsers 
	
	public static void setUp(String browserName) { 
		
		if (browserName.equals("edge")) { 
			//set up edge for webdriverManager
			
			WebDriverManager.edgedriver().setup(); 
			driver = new EdgeDriver(); 
		
		}else if (browserName.equals("safari")) { 
		
			WebDriverManager.safaridriver().setup(); 
			driver = new SafariDriver(); 
			
	
		} else if (browserName.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver (); 
		}
}
	
	
	//Method 2 --> it closes the browser 
	
	public static void tearDown() { 
		
	try {	
		Thread.sleep(5000);
	} catch (InterruptedException e) { 
		e.printStackTrace();
	}
	driver.quit();
	}
}