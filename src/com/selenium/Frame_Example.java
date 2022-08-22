
package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_Example {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Frames.html");		
		driver.manage().window().maximize();
		
		driver.switchTo().frame("singleframe");
		
		WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
		textbox.sendKeys("Selenium");
		 
		driver.switchTo().defaultContent();
		
		WebElement Multiframe = driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
		Multiframe.click();
		
		WebElement OuterFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(OuterFrame);
		
		WebElement InnerFrame = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
		driver.switchTo().frame(InnerFrame);
		
		WebElement textbox1 = driver.findElement(By.xpath("//input[@type='text']"));
		textbox1.sendKeys("Java");
		
		driver.switchTo().parentFrame();		
		driver.switchTo().defaultContent();
		
			
	}
	

}
