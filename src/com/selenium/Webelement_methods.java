package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webelement_methods {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\My Computer\\eclipse-workspace\\Selenium_Testing\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get(
				"https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_custrec_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");

		driver.manage().window().maximize();
		
		WebElement emailID = driver.findElement(By.id("ap_email"));
		emailID.sendKeys("shameer@gmail.com");

		boolean enabled = emailID.isEnabled();
		System.out.println("Is enabled:" + enabled);
		
		WebElement enter = driver.findElement(By.id("continue"));
		enter.click();

		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("123456789");

		String attribute = password.getAttribute("name");
		System.out.println(attribute);

		String attribute2 = password.getAttribute("value");
		System.out.println(attribute2);

		boolean displayed = password.isDisplayed();
		System.out.println("Is displayed:" + displayed);

		WebElement login = driver.findElement(By.id("signInSubmit"));

		boolean selected = login.isSelected();
		System.out.println("Is selected:" + selected);

		login.click();

	}

}
