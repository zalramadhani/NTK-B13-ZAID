package com.noorteck.selenium.HW1; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Hooks;
import org.openqa.selenium.JavascriptExecutor;

public class Exe3 extends Hooks {

	public static void main(String[] args) throws InterruptedException {
		setUp("edge");

		driver.get("https://demo.nopcommerce.com/");

		WebElement registerLink = driver.findElement(By.linkText("Register"));
		registerLink.click();
		Thread.sleep(5000);

//-------------------------------------if/else statement & captchaCheckbox bypass-------------------------------------------------------------------------------	

		String pageTitle = driver.getTitle();
		if (pageTitle.contains("Just a moment...")) {
			System.out.println("Page title is correct.");
			WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 15 seconds /html/body/div[1]

			new WebDriverWait(driver, 10)
					.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[1]")));
			WebElement captchaCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#uHkM6")));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", captchaCheckbox);
			captchaCheckbox.click();
			Thread.sleep(5000);

		} else {
			System.out.println("Page title is incorrect. Found: " + pageTitle);
		}
//---------------------------------------Data Fill Out-----------------------------------------------------------------------------	

		WebElement genderMale = driver.findElement(By.id("gender-male"));
		genderMale.click();
		Thread.sleep(500);

		WebElement firstName = driver.findElement(By.id("FirstName"));
		firstName.sendKeys("Zaid");
		Thread.sleep(500);

		WebElement lastName = driver.findElement(By.id("LastName"));
		lastName.sendKeys("David");
		Thread.sleep(500);

		WebElement email = driver.findElement(By.id("Email"));
		email.sendKeys("v.vondeta@gmail.com");
		Thread.sleep(500);

		WebElement company = driver.findElement(By.id("Company"));
		company.sendKeys("Al Ramadhani LLC");
		Thread.sleep(500);

//----------------------------------------newsletterCheckbox----------------------------------------------------------------------------	
		WebElement newsletterCheckbox = driver.findElement(By.id("Newsletter"));
		if (newsletterCheckbox.isSelected()) {
			newsletterCheckbox.click();
		}
//--------------------------------------------------------------------------------------------------------------------	
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("NTK123@");
		Thread.sleep(500);

		WebElement confPassword = driver.findElement(By.id("ConfirmPassword"));
		confPassword.sendKeys("NTK123@");
		Thread.sleep(500);

		WebElement registerButton = driver.findElement(By.id("register-button"));
		registerButton.click();
		Thread.sleep(5000);

		// --------------------------------------------------------------------------------------------------------------------

		String pageTitle1 = driver.getTitle();
		if (pageTitle1.contains("Just a moment...")) {
			System.out.println("Page title is correct.");
			WebDriverWait wait2 = new WebDriverWait(driver, 10); // Wait for up to 11 seconds

			WebElement captchaCheckbox2 = wait2
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#uHkM6")));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", captchaCheckbox2);
			captchaCheckbox2.click();
			Thread.sleep(500);

			System.out.println("CAPTCHA checkbox found and clicked!");

		} else {
			System.out.println("Page title is incorrect. Found: " + pageTitle1);
		}

//--------------------------------------------------------------------------------------------------------------------	
		WebElement confirmationMessage = driver.findElement(By.className("result"));
		String messageText = confirmationMessage.getText();

		if (messageText.equals("Your registration completed!!!")) {
			System.out.println("TESTCASE PASSED");
		} else {
			System.out.println("TESTCASE FAILED");
		}

		tearDown();
	}
}
