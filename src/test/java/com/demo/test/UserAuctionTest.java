package com.demo.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UserAuctionTest {
	 private WebDriver driver;
	

		@BeforeMethod
		public void beforeMethod() throws Throwable
		{
			String driverPath = System.getProperty("user.dir")+"//drivers//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",driverPath );
			driver=new ChromeDriver();
			driver.manage().window().maximize();	
			driver.get("http://localhost:8888/Online_Auction/");
		}
		
		
		//a[text()='Start Bidding']
		
		@Test
		public void userDefinedTest() throws Throwable{
			
			 driver.findElement(By.xpath("//a[text()='Start Bidding']")).click();
			 
			 
			 //fil the form data
			 driver.findElement(By.name("Iteam_name")).sendKeys("phone");
			 driver.findElement(By.name("model")).sendKeys("samsung");
			 driver.findElement(By.name("Auction_Price")).sendKeys("500");
			 driver.findElement(By.name("name")).sendKeys("Mark");
			 driver.findElement(By.name("email")).sendKeys("mark@gmail.com");
			 driver.findElement(By.name("phone")).sendKeys("8834217");
			 driver.findElement(By.name("address")).sendKeys("Aus");
			 driver.findElement(By.xpath("//input[@value='submit']")).click();
			  
			 //verify result
			  String title=driver.getTitle();
			  assertEquals(title,"success page");
		}
		
		@AfterMethod
		public void teardown() {
			driver.close();
		}
}
