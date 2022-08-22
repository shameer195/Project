package com.task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Myntra_Task {

	static ChromeDriver driver;

	public static void productName(int given_Text) {

		List<WebElement> disPrice = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));

		for (WebElement price : disPrice) {

			String dPrice = price.getText().replace("Rs. ", "");

			if (Integer.parseInt(dPrice) == given_Text) {

				WebElement productName = price
						.findElement(By.xpath("//ancestor::div[@class='product-price']//preceding-sibling :: h3"));

				String text = productName.getText();

				System.out.println(text);

			}
		}
	}

	public static void productPrice() {

		List<WebElement> productPrice = driver.findElements(
				By.xpath("//li[@class = 'product-base']//descendant::span[@class='product-discountedPrice']"));

		for (WebElement price1 : productPrice) {

			String aPrice = price1.getText().replace("Rs. ", "");

			System.out.println(aPrice);
		}
	}
	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver104.exe");

		driver = new ChromeDriver();
		driver.get(
				"https://www.myntra.com/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false");
		driver.manage().window().maximize();

		productName(899);
		productPrice();

	}
}
