package com.demo.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SellerLoginSteps {
	 private WebDriver driver;
	
	@Before
	public void setUp() {
		String driverPath = System.getProperty("user.dir")+"//drivers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverPath );
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("navigate to seller login page")
	public void navigate_to_seller_login_page() {
		driver.get("http://localhost:8888/Online_Auction/seller/login.jsp");
	}

	@When("seller logged in using userid as {string} and password as {string}")
	public void seller_logged_in_using_userid_as_and_password_as(String userid, String pwd) {
	   driver.findElement(By.name("user.userid")).sendKeys(userid);
	   driver.findElement(By.name("user.password")).sendKeys(pwd);
	   driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		
	}

	@Then("Welcome To Seller Login Page should be displayed")
	public int welcome_To_Seller_Login_Page_should_be_displayed() throws Throwable {
		int status=0;
		Thread.sleep(500);
		String title=driver.getTitle();
		if(title.contains(" Seller Bid Data Form")) {
			//fill the register data
			Thread.sleep(500);
			driver.findElement(By.name("iteam_name")).sendKeys("phone");
			driver.findElement(By.name("model")).sendKeys("samsung");
			driver.findElement(By.name("bid_price")).sendKeys("100");
			driver.findElement(By.xpath("//input[@value='Register']")).click();
			
			
			
			return 1;
		}
		else {
			return status;
		}
	}

	@After
	public void teardown() {
		driver.close();
	}
	
}
