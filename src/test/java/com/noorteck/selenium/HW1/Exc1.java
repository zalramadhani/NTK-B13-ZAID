package com.noorteck.selenium.HW1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.Hooks;

public class Exc1 extends Hooks {
	public static void main(String[] args) throws InterruptedException {

		setUp("edge");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(1000);
		WebElement userNameField = driver.findElement(By.name("username"));
		userNameField.sendKeys("admin");

		Thread.sleep(500);

		// Password Field
		WebElement passwordField = driver.findElement(By.name("password"));
		passwordField.sendKeys("admin123");

		Thread.sleep(500);

		WebElement loginBtn = driver
				.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));

		loginBtn.click();

		// The header Text is the Dashboard.
		
//		WebElement header = driver.findElement(By.linkText("Dashboard"));
		System.out.println("BEFORE"); // To TEST THE LOCATION OF THE ERROR 
		WebElement header = driver.findElement(By.xpath("//.[.='Dashboard']"));
		System.out.println("AFTER"); //TO TEST THE LOCATION OF THE ERROR 
		System.out.println(header);
        String confText = "Dashboard"; 
        String headerText = header.getText(); 
        
        if (headerText.contains(confText)) {
            System.out.println("Login successful. Header verified: " + header);
        } else {
            System.out.println("Login failed. Expected 'Dashboard', but got: " + header);
        }

		tearDown();

	}
}
