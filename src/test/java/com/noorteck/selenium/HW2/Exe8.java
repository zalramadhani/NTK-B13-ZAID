package com.noorteck.selenium.HW2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exe8 extends Hooks{
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp("safari"); 
		driver.get("https://demo.automationtesting.in/Frames.html");
		Thread.sleep(1000); 
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		
		driver.switchTo().frame(iframe); 
		
		WebElement textField = driver.findElement(By.xpath("/html/body/section/div/div/div/input")); 
		textField.click();
		Thread.sleep(2000); 
		
		driver.switchTo().defaultContent(); 
		
		WebElement iframeWithin = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")); 
		
		iframeWithin.click(); 
		Thread.sleep(1000); 
		
		//driver.switchTo().frame("nestedIFrames");
		WebElement nestedIFrames = driver.findElement(By.xpath("//iframe[@style='float: left;height: 300px;width:600px']"));
		driver.switchTo().frame(nestedIFrames); 
		
		//driver.switchTo().frame("iframe3");
		
		WebElement iframe3 = driver.findElement(By.xpath("//iframe[@style='float: left;height: 250px;width: 400px']"));
		
		driver.switchTo().frame(iframe3); 
		
		WebElement textField2 = driver.findElement(By.xpath("/html/body/section/div/div/div/input")); 
		textField2.sendKeys("Iframe is easy"); 
		Thread.sleep(2000); 
		driver.switchTo().defaultContent();
		
		WebElement homeClick = driver.findElement(By.xpath("//a[text()='Home']")); 
		homeClick.click();
		
		driver.getTitle();
		if (driver.getTitle().contains("Index")) {
			System.out.println("TESTCASE PASSED");
		}else { 
			System.out.println("TESTCASE FAILED");
		} 
		
		
		
		//input[@type='text']
		
		tearDown(); 
		
	}

}