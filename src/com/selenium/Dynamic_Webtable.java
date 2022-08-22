package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Webtable {
	
	static int indexoftotalcase, indexofrecovered, indexofactive;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		
		driver.get("https://www.worldometers.info/coronavirus/");
		
		driver.manage().window().maximize();
		
		List<WebElement> headers = driver.findElements(By.tagName("th"));
		
		for (int i = 0; i < headers.size(); i++) {
			
			String text = headers.get(i).getText();
//			System.out.println(text);			
			String allheaders = text.replaceAll("\n", " ");
//			System.out.println(allheaders);
			
			if (allheaders.equalsIgnoreCase("Total Cases")) {
				
				indexoftotalcase = i;
				System.out.println("Index of total case: " + indexoftotalcase);				
			}
			
			else if (allheaders.equalsIgnoreCase("Total recovered")) {	
				
				indexofrecovered = i;
				System.out.println("Index of recovered: " + indexofrecovered);				
			}
			
			else if (allheaders.equalsIgnoreCase("Active Cases")) {	
				
				indexofactive = i;
				System.out.println("Index of active case: "+ indexofactive);				
			}			
		}
		
		List<WebElement> allrows = driver.findElements(By.xpath("//table/tbody[1]/tr"));	
		
		for (int i = 0; i < allrows.size(); i++) {
			
			List<WebElement> alldata = allrows.get(i).findElements(By.tagName("td"));
			
			for (int j = 0; j < alldata.size(); j++) {		
				
				if (alldata.get(j).getText().equalsIgnoreCase("india")) {					
					System.out.println("Total cases :" + alldata.get(indexoftotalcase).getText());
					System.out.println("Recovered cases :" +alldata.get(indexofrecovered).getText());
					System.out.println("Active cases :" +alldata.get(indexofactive).getText());
					
				}
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
