package com.task;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Worldometer {

	static String header;

	static int indexOfCountry, indexOfPopulation;
	static WebDriver driver;
	static WebElement table;
	static Map<Integer, String> allHeaderIndexMap;

	public static void browserLaunch() {

		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver104.exe");
		driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();
		table = driver.findElement(By.xpath("//table[@id='main_table_countries_today']"));
	}

	public static void getHeaderIndexes() {
		// Iterate all headers

		allHeaderIndexMap = new LinkedHashMap<>();

		List<WebElement> allHeaders = table.findElements(By.xpath("//thead/tr/th"));

		for (int i = 0; i < allHeaders.size(); i++) {

			header = allHeaders.get(i).getText().replaceAll("\n", " ");
			allHeaderIndexMap.put(i, header);

			switch (header) {

			case "Country, Other":
				indexOfCountry = i;
				break;

			case "Population":
				indexOfPopulation = i;
				break;

			default:
				break;
			}
		}

		System.out.println(allHeaderIndexMap);
	}

	public static void getParticularData(String countryName) {
		System.out.println("\n==Particular Data==");
		// traverse into body
		List<WebElement> allRows = table.findElements(By.xpath("//tbody[not(@class)]/tr"));

		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> allColumn = allRows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < allColumn.size(); j++) {

				if (j == indexOfCountry) {

					if (allColumn.get(j).getText().equalsIgnoreCase(countryName)) {
						System.out.println("\n Population of " + countryName + " is: "
								+ allColumn.get(indexOfPopulation).getText());
						break;
					}
					break;
				}
			}
		}
	}

	public static void getRow_wiseData(String countryName) {
		System.out.println("\n" + countryName + " Row-Data is: ");
		List<WebElement> allRows = table.findElements(By.xpath("//tbody[not(@class)]/tr"));

		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> allColumn = allRows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < allColumn.size(); j++) {

				if (allColumn.get(indexOfCountry).getText().equalsIgnoreCase(countryName)) {
					System.out.println(allHeaderIndexMap.get(j) + " = " + allColumn.get(j).getText());
				}
			}
		}
	}

	public static void getColumn_wiseData(String countryList) {
		System.out.println("\n" + countryList + " Column-Data is: ");

		List<WebElement> allRows = table.findElements(By.xpath("//tbody[not(@class)]/tr"));
		System.out.println("Country List: " + allRows.size());

		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> allColumn = allRows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < allColumn.size(); j++) {

				if (countryList.contains(allHeaderIndexMap.get(j))) {
					System.out.println(allColumn.get(j).getText());
				}
			}
		}
	}

	public static void main(String[] args) {
		String country = "Russia";

		browserLaunch();
		getHeaderIndexes();
		getParticularData(country);
		getRow_wiseData(country);
		getColumn_wiseData("Country");
	}
}
