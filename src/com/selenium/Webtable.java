package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
				
				WebDriver driver = new ChromeDriver();	
				
				driver.get("http://www.leafground.com/pages/table.html");	
				
				driver.manage().window().maximize();
				
				System.out.println("All Data");
				List<WebElement> alldata = driver.findElements(By.xpath("//table/tbody/tr/td"));		
				for (WebElement all : alldata) {			
					String text = all.getText();
					System.out.println(text);			
				}
				
				System.out.println("Row Data:");
				List<WebElement> rowdata = driver.findElements(By.xpath("//table/tbody/tr[4]/td"));		
				for (WebElement row : rowdata) {
					String text1 = row.getText();
					System.out.println(text1);			
				}
					
				System.out.println("Column Data:");
				
				List<WebElement> columndata = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
				
				for (WebElement column : columndata) {
					String text2 = column.getText();
					System.out.println(text2);
				}
				
				System.out.println();
				System.out.println("Particular Data:");
				
				WebElement particulardata = driver.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
					String text3 = particulardata.getText();
					System.out.println(text3);
					
				System.out.println();	
				System.out.println("All Header:");
				
				List<WebElement> allheader = driver.findElements(By.tagName("th"));
				
				for (WebElement header : allheader) {
					String text4 = header.getText();
					System.out.println(text4);
				}
					
					
	
	
		
	
	}
		
		
	
	
	}


