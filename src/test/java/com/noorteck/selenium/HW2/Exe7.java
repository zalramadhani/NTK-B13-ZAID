package com.noorteck.selenium.HW2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exe7 extends Hooks{
	public static void main(String[] args) throws InterruptedException {
		
		setUp("safari"); 
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-");
		
		WebElement openqaSelenium = driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")); 
		openqaSelenium.click();
		Thread.sleep(1000); 
		
		WebElement alertS = driver.findElement(By.xpath("//a[text()='Alert']")); 
		alertS.click();
		Thread.sleep(1000); 
		
		WebElement alertInterface = driver.findElement(By.xpath("//h1[@title='Interface Alert']")); 
		String interFaceAlrtmsg = alertInterface.getText(); 
		System.out.println(alertInterface.getText());
		String confirmText = "Interface Alert"; 
		if (interFaceAlrtmsg.contains(confirmText)) { 
			System.out.println("TESTCASE PASSED");
		}else { 
			System.out.println("TESTCASE FAILED");
		}
		
		Thread.sleep(1000); 
		
		WebElement overviewPackage = driver.findElement(By.xpath("//a[@href='../../../index.html']")); 
		overviewPackage.click(); 
		Thread.sleep(1000); 
		
		WebElement openqaChrome = driver.findElement(By.xpath("//a[@href='org/openqa/selenium/chrome/package-summary.html']")); 
		openqaChrome.click();
		Thread.sleep(1000); 
		
		WebElement chromeDriver = driver.findElement(By.xpath("//a[text()='ChromeDriver']")); 
		chromeDriver.click();
		Thread.sleep(1000); 
		
		//h1[text()='Class ChromeDriver']
		WebElement classChromeDriver = driver.findElement(By.xpath("//h1[@title='Class ChromeDriver']")); 
		String interFaceAlrtmsg1 = classChromeDriver.getText(); 
		//System.out.println(classChromeDriver.getText());
		String confirmText1 = "Class ChromeDriver"; 
		if (interFaceAlrtmsg1.equals(confirmText1)) { 
			System.out.println("TESTCASE PASSED");
		}else { 
			System.out.println("TESTCASE FAILED");
		}
		
		
		tearDown(); 
		
		
	}

}