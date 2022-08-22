package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Concept {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.instagram.com/");
		
		driver.manage().window().maximize();
		
//		Implicit Wait
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		username.sendKeys("shameer");
		
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		
//		Explicit Wait
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(password));
	
		password.sendKeys("1234abc");
	}

}
