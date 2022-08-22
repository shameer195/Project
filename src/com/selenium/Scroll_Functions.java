package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll_Functions {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.myntra.com/");

		driver.manage().window().maximize();
		
		WebElement contact = driver.findElement(By.xpath("(//a[@href ='/contactus'])[3]"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		jse.executeScript("arguments[0].scrollIntoView();", contact);
		
		Thread.sleep(2000);
		
		jse.executeScript("window.scrollBy(0, -4000);");
		
		Thread.sleep(2000);
		
		jse.executeScript("window.scrollBy(0, 3000);");
		
		
		
		
	}

}
