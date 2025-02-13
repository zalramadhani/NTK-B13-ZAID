package com.noorteck.selenium.HW1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Hooks;

public class Exe2 extends Hooks{
	
	public static void main(String[] args) throws InterruptedException {
		
		setUp("edge"); 
        driver.get("https://demo.guru99.com/test/newtours/");
        
        Thread.sleep(1000);
        
        WebElement register = driver.findElement(By.linkText("REGISTER")); 
        register.click(); 
        Thread.sleep(500);
        
        // Contact Information
        WebElement firstName = driver.findElement(By.name("firstName")); 
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement phoneNum = driver.findElement(By.name("phone"));
        WebElement email = driver.findElement(By.id("userName")); 

        // Mailing Information
        WebElement address = driver.findElement(By.name("address1")); 
        WebElement city = driver.findElement(By.name("city"));
        WebElement state = driver.findElement(By.name("state"));
        WebElement zipCode = driver.findElement(By.name("postalCode"));
        WebElement country = driver.findElement(By.name("country"));
        Select countryObj = new Select(country);
        
        // User Information
        WebElement userName = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement confPassword = driver.findElement(By.name("confirmPassword"));

        firstName.sendKeys("Zaid"); 
        Thread.sleep(500);
        
        lastName.sendKeys("David");
        Thread.sleep(500);
        
        phoneNum.sendKeys("4077777777");
        Thread.sleep(500);
        
        email.sendKeys("v.vondeta@gmail.com");
        Thread.sleep(500);
        
        address.sendKeys("7930 Citrus Garden Dr APT212");
        Thread.sleep(500);
        
        city.sendKeys("Tampa");
        Thread.sleep(500);
        
        state.sendKeys("Florida");
        Thread.sleep(500);
        
        zipCode.sendKeys("33625");
        Thread.sleep(500);
        
        countryObj.selectByVisibleText("UNITED STATES");

        userName.sendKeys("DoggonGecko");
        Thread.sleep(500);
        
        password.sendKeys("HappyLifeTampa1$");
        Thread.sleep(500);
        
        confPassword.sendKeys("HappyLifeTampa1$");
        Thread.sleep(500);

        WebElement submit = driver.findElement(By.name("submit")); 
        submit.click(); 
        Thread.sleep(500);

        WebElement confirmationMsg = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font"));

        String confirmationText = confirmationMsg.getText();
        String confText = "Thank you for registering"; 
        
        if (confirmationText.contains(confText)) { 
            System.out.println("TESTCASE PASSED");
        } else {
            System.out.println("TESTCASE FAILED. Expected 'Thank you for registering.', but got: " + confirmationText);
        }

        tearDown(); 
    }
}
