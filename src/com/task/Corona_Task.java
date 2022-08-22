package com.task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Corona_Task {

	static WebDriver driver;
	static String given_Country = "India";
	static int indexoftotalpopulation;

	public static void browserLaunch() {

		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver104.exe");
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();

	}

	public static void getHeaderIndex() {

		List<WebElement> headers = driver.findElements(By.tagName("th"));

		for (int i = 0; i < headers.size(); i++) {

			String text = headers.get(i).getText();

			if (text.equalsIgnoreCase("population")) {

				indexoftotalpopulation = i;

				System.out.println(i);

			}
		}
	}

	public static void getRowData() {

		List<WebElement> allRows = driver
				.findElements(By.xpath("//table[@id=\"main_table_countries_today\"]/tbody[1]/tr"));

		for (int i = 0; i < allRows.size(); i++) {

			if (allRows.get(i).getText().contains(given_Country)) {

				List<WebElement> allData = allRows.get(i).findElements(By.tagName("td"));

				for (int j = 0; j < allData.size(); j++) {

					System.out.println(allData.get(j).getText());

				}
			}
		}
	}

	public static void getParticularData() {

		List<WebElement> allRows = driver
				.findElements(By.xpath("//table[@id=\"main_table_countries_today\"]/tbody[1]/tr"));

		for (int i = 0; i < allRows.size(); i++) {

			List<WebElement> allData = allRows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < allData.size(); j++) {

				if (allData.get(j).getText().equalsIgnoreCase("india")) {
					System.out.println("Total Population :" + allData.get(indexoftotalpopulation).getText());

				}
			}
		}
	}	

	public static void main(String[] args) {

		browserLaunch();
		getHeaderIndex();
		getRowData();
		getParticularData();

	}

}
