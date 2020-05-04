package com.utility;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtility {
	public void baseUtility() {
		
		String driverPath = System.getProperty("user.dir")+"//drivers//chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverPath );
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
}
