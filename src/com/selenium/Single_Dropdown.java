package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Single_Dropdown {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://twitter.com/i/flow/signup");

		driver.manage().window().maximize();
		
		Thread.sleep(2000);

		WebElement signup = driver.findElement(By.xpath("(//span[contains(@class,'css')])[8]"));
		signup.click();
		
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("shameer");
		
		WebElement phone_no = driver.findElement(By.name("phone_number"));
		phone_no.sendKeys("9840323845");
		
		WebElement month = driver.findElement(By.xpath("//select[@aria-invalid='false']"));
				
		Select s = new Select(month);
		s.selectByIndex(5);
		
		WebElement day = driver.findElement(By.xpath("(//select[@aria-invalid='false'])[2]"));
		
		Select s1 = new Select(day);
		s1.selectByValue("19");
		
		WebElement year = driver.findElement(By.xpath("(//select[@aria-invalid='false'])[3]"));
		
		Select s2 = new Select(year);
		s2.selectByVisibleText("1996");
		
		System.out.println("All options:");
		List<WebElement> options = s.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);			
		}
		System.out.println("First Selected Option:");
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);
		
		System.out.println("All Selected Options:");
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			String text2 = webElement.getText();
			System.out.println(text2);
		}
		
		WebElement next = driver.findElement(By.xpath("(//div[@dir='auto'])[10]"));
		next.click();
		
		
		
	}

}
