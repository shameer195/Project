package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Windows_Handling {

	public static void main(String[] args) throws AWTException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") +"\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();		
		driver.get("https://www.amazon.in/");
		
		WebElement Bestsellers = driver.findElement(By.xpath("//a[text()='Best Sellers']"));	
		
		Actions ac = new Actions(driver);
		ac.contextClick(Bestsellers).build().perform();
		
		Robot r = new Robot();		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement Electronics = driver.findElement(By.xpath("//a[text()=' Electronics ']"));
		ac.contextClick(Electronics).build().perform();
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Set<String> windowHandles = driver.getWindowHandles();		
		for (String id : windowHandles) {			
			String title = driver.switchTo().window(id).getTitle();
			System.out.println(title);			
		}
		
		String s = "Amazon.in Bestsellers: The most popular items on Amazon";
		for (String string : windowHandles) {
			if (driver.switchTo().window(string).getTitle().equals(s)) {
				break;
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
	}

}
