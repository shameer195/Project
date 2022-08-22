package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Mini_Project {

	public static void main(String[] args)  {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		driver.get("https://adactinhotelapp.com/");		
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.xpath("//input[@id = 'username']"));
		username.sendKeys("Shameer195");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("tC3hqW@PW4m3pPn");
		
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		
		WebElement location = driver.findElement(By.id("location"));		
		Select s = new Select(location);
		s.selectByVisibleText("Paris");
		
		WebElement hotel = driver.findElement(By.id("hotels"));		
		Select s1 = new Select(hotel);
		s1.selectByIndex(4);
		
		WebElement roomtype = driver.findElement(By.id("room_type"));		
		Select s2 = new Select(roomtype);
		s2.selectByVisibleText("Super Deluxe");
		
		WebElement rooms = driver.findElement(By.id("room_nos"));		
		Select s3 = new Select(rooms);
		s3.selectByIndex(1);
		
		WebElement checkin = driver.findElement(By.id("datepick_in"));
		checkin.clear();
		checkin.sendKeys("19/04/2022");
	
		WebElement checkout = driver.findElement(By.id("datepick_out"));
		checkout.clear();
		checkout.sendKeys("25/04/2022");
		
		WebElement adults = driver.findElement(By.id("adult_room"));		
		Select s4 = new Select(adults);
		s4.selectByValue("2");
		
		WebElement submit = driver.findElement(By.id("Submit"));
		submit.click();
		
		WebElement radiobutton = driver.findElement(By.id("radiobutton_0"));
		radiobutton.click();
		
		WebElement next = driver.findElement(By.id("continue"));
		next.click();
		
		WebElement firstname = driver.findElement(By.id("first_name"));
		firstname.sendKeys("Shameer");
		
		WebElement lastname = driver.findElement(By.id("last_name"));
		lastname.sendKeys("D");
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("No.1, Porur, Chennai");
		
		WebElement cc = driver.findElement(By.id("cc_num"));
		cc.sendKeys("1234567823451234");
		
		WebElement cctype = driver.findElement(By.id("cc_type"));		
		Select s5 = new Select(cctype);
		s5.selectByValue("VISA");
		
		WebElement cc_exp_month = driver.findElement(By.id("cc_exp_month"));
		Select s6 = new Select(cc_exp_month);
		s6.selectByVisibleText("June");
		
        WebElement cc_exp_year = driver.findElement(By.id("cc_exp_year"));		
		Select s7 = new Select(cc_exp_year);
		s7.selectByVisibleText("2022");
		
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys("123");
		
		WebElement book = driver.findElement(By.id("book_now"));
		book.click();
		
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
		logout.click();
		
		
		
		
		
		
		
		
		
		
		

	}

}
