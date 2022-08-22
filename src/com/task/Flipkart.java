package com.task;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	static WebDriver driver;

	public static void browserLaunch() {

		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver104.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

	}

	public static void login() {

		WebElement email = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		email.sendKeys("9840323845");

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Flipkart@987");

		WebElement click = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		click.click();

	}

	public static void iPhoneSearch() {

		WebElement mobile = driver
				.findElement(By.xpath("//div[@id='container']//ancestor::div[contains(text(), 'Mobiles')]"));

		mobile.click();

		WebElement iphone = driver.findElement(By.xpath("//input[@class='_3704LK']"));

		iphone.sendKeys("iphone 13 pro max");

		WebElement click = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		click.click();

		WebElement iphone1TB = driver
				.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 13 Pro Max (Gold, 1 TB)')]"));
		iphone1TB.click();

		WebElement iphone128GB = driver
				.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 13 Pro Max (Gold, 128 GB)')]"));
		iphone128GB.click();

		WebElement iphoneS128GB = driver
				.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 13 Pro Max (Silver, 128 GB)')]"));
		iphoneS128GB.click();

		WebElement iphoneS1TB = driver
				.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 13 Pro Max (Silver, 1 TB)')]"));
		iphoneS1TB.click();

	}

	public static void windowHandles() {

		Set<String> windowID = driver.getWindowHandles();

		for (String ID : windowID) {
			String title = driver.switchTo().window(ID).getTitle();
			System.out.println(title);
		}

		String s = "APPLE iPhone 13 Pro Max (Gold, 128 GB)";

		for (String string : windowID) {

			if (driver.switchTo().window(string).getTitle().contentEquals(s)) {

				break;

			}
		}
	}

	public static void main(String[] args) {
		browserLaunch();
		login();
		iPhoneSearch();
		windowHandles();
	}

}
