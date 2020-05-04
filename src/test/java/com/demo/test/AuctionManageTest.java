package com.demo.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuctionManageTest {

private WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() throws Throwable
	{
		String driverPath = System.getProperty("user.dir")+"//drivers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverPath );
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("http://localhost:8888/Online_Auction/fetchbiduser");
	}
	
	@Test
	public void auctionManageTest() throws Throwable{
		  String title=driver.getTitle();
		  assertEquals(title,"Auction Manage Page");
		  driver.findElement(By.xpath("//input[@value='close bid']")).click();
		 
		  Thread.sleep(500);
		  String txt=  driver.findElement(By.xpath("//body/h1[contains(text(),'Congratulations')]")).getText();
		 
		  assertEquals(txt, "Congratulations You Are Winner!!!!!");
		  
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
