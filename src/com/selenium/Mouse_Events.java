package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Events {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/buttons");
		
		driver.manage().window().maximize();
		
		WebElement clickbutton = driver.findElement(By.xpath("//button[text()='Click Me']"));
		
		Actions act = new Actions(driver);
		act.click(clickbutton).build().perform();
		
		WebElement rightbutton = driver.findElement(By.id("rightClickBtn"));
		act.contextClick(rightbutton).build().perform();
		
		WebElement doubleclick = driver.findElement(By.id("doubleClickBtn"));
		act.doubleClick(doubleclick).build().perform();
		
		driver.navigate().to("https://www.amazon.in/");
		
		WebElement move = driver.findElement(By.xpath("//img[@alt='Google Play recharge']"));
	    act.moveToElement(move).build().perform();
	    
	    driver.navigate().to("http://www.leafground.com/pages/drop.html");
	    
	    WebElement drag = driver.findElement(By.id("draggable"));
	    WebElement drop = driver.findElement(By.id("droppable"));
	    act.dragAndDrop(drag, drop).build().perform();
	    
	    
	}

}
