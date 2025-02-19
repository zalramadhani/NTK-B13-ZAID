package com.noorteck.selenium.HW2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exe6 extends Hooks{
	public static void main(String[] args) throws InterruptedException {
		
		
		setUp("safari"); 
		driver.get("https://demo.automationtesting.in/Alerts.html");
		
		
		driver.getTitle();
		if (driver.getTitle().contains("Alerts")) {
			System.out.println("Page Title is verfied as Alerts");
		} else {
			System.out.println("Page Title is not verfied");
		}
		
		WebElement alertwithTextBk = driver.findElement(By.xpath("//a[@href='#Textbox']")); 
		alertwithTextBk.click();
		Thread.sleep(1000);
		
		WebElement demoPromtBox = driver.findElement(By.xpath("//button[@class = 'btn btn-info']")); 
		demoPromtBox.click();
		Thread.sleep(1000); 
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Zaid David"); 
		Thread.sleep(5000);

        // Accept the alert (click OK button)
        alert.accept();
		
        WebElement promptText = driver.findElement(By.id("demo1"));
        
        
        String msgVerify = promptText.getText();
        String confText = "Hello Zaid David How are you today"; 
        System.out.println(promptText.getText());
        if (msgVerify.contains(confText)) { 
            System.out.println("TESTCASE VERIFIED");
        } else {
            System.out.println("TESTCASE FAILED. Expected 'Thank you for registering.', but got: " + msgVerify);
        }
        driver.navigate().refresh();
        
        WebElement alertwithokcancel = driver.findElement(By.xpath("//a[@href='#CancelTab']")); 
        alertwithokcancel.click(); 
        Thread.sleep(1000); 
        
        WebElement displayBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary']")); 
        displayBtn.click();
        
        Alert alert2 = driver.switchTo().alert();
        String alertmsg = alert2.getText(); 
        if(alertmsg.contains("Press a Button !")) { 
        	alert2.dismiss(); 
        	System.out.println("TRUE CANCEL");
        	System.out.println("TEXT CONFIRMED (PRESS A BUTTON)");	
        } else { 
        	System.out.println("FALSE");
        	alert2.accept();
        }
		
		tearDown(); 
	}

}