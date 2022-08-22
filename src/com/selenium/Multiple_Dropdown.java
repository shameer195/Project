package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Multiple_Dropdown {

	public static void main(String[] args){

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		
		driver.manage().window().maximize();
		
		WebElement multiple = driver.findElement(By.xpath("(//select)[6]"));
		
		Select s = new Select(multiple);
		
		boolean multiple2 = s.isMultiple();
		System.out.println("Is multiple:" + multiple2);
		
		s.selectByIndex(1);
		s.selectByValue("2");
		s.selectByVisibleText("Loadrunner");
		s.deselectByIndex(4);
		
		System.out.println();		
		System.out.println("All options:");
		List<WebElement> options = s.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}
		
		System.out.println();
		System.out.println("First selected option:");
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();		
		System.out.println(text);
		
		System.out.println();
		System.out.println("All selected options:");
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			String text2 = webElement.getText();
			System.out.println(text2);			
		}
		
		driver.close();
	}

}
