package com.demo.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SellerBidDataTest {
	private WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() throws Throwable
	{
		String driverPath = System.getProperty("user.dir")+"//drivers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverPath );
		driver=new ChromeDriver();
		driver.manage().window().maximize();	
		driver.get("http://localhost:8888/Online_Auction/seller/login.jsp");
	}
	@Test
	public void sellerLoginTest() throws Throwable{
	   //seller login
	   
	   driver.findElement(By.name("user.userid")).sendKeys("admin");
	   driver.findElement(By.name("user.password")).sendKeys("admin");
	   driver.findElement(By.xpath("//input[@value='Submit']")).click();
	   
	  
		Thread.sleep(500);
		String title=driver.getTitle();
		assertEquals(title,"Seller Bid Data Form");
		
		
			//fill the register data
			Thread.sleep(500);
			driver.findElement(By.name("iteam_name")).sendKeys("phone");
			driver.findElement(By.name("model")).sendKeys("samsung");
			driver.findElement(By.name("bid_price")).sendKeys("100");
			driver.findElement(By.xpath("//input[@value='Register']")).click();
			
			//verify success page
			String regtitle=driver.findElement(By.xpath("//h1[text()='Register Success']")).getText();
			assertEquals(regtitle,"Register Success");
			
			
			
		
}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
