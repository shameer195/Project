package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyboard_Events {
	
	public static void main(String[] args) throws AWTException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		
		driver.manage().window().maximize();
		
		WebElement gmail = driver.findElement(By.xpath("//a[@class='gb_d']"));
		
		Actions act = new Actions(driver);
		act.contextClick(gmail).build().perform();
		
		Robot rob = new Robot();
		
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyPress(KeyEvent.VK_DOWN);
		
		
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
	
	
	
	

}
