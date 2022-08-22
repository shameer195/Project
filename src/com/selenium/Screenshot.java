package com.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.myntra.com/");

		driver.manage().window().maximize();

		TakesScreenshot TS = (TakesScreenshot) driver;

		File source = TS.getScreenshotAs(OutputType.FILE);

		File destination = new File(
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Screenshot\\myntra.png");

		FileUtils.copyFile(source, destination);
	}

}
