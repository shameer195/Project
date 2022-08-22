package com.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_Example {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://www.leafground.com/pages/Alert.html");
	
	driver.manage().window().maximize();
	
	WebElement Alertbox = driver.findElement(By.xpath("//button[text()='Alert Box']"));
	Alertbox.click();
	
	Thread.sleep(2000);
	
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
	WebElement ConfirmBox = driver.findElement(By.xpath("//button[text()='Confirm Box']"));
	ConfirmBox.click();
	
	Thread.sleep(2000);
	
	Alert alert2 = driver.switchTo().alert();
	alert2.dismiss();
	
	WebElement PromptBox = driver.findElement(By.xpath("//button[text()='Prompt Box']"));
	PromptBox.click();
	
	Alert alert3 = driver.switchTo().alert();
	alert3.sendKeys("Selenium");
	Thread.sleep(2000);
	String text = alert3.getText();
	System.out.println(text);
	alert3.accept();
	
	}

}
