package com.hcv.seleniumTest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegressionTest {
public WebDriver driver;
	
	@BeforeMethod
	public void lauchApp() {
		
		if(System.getenv("BROWSER")!=null && System.getenv("BROWSER").equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", new File("Resources/chromedriver.exe").getAbsolutePath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(System.getenv("URL"));
		
		}
	}
	@AfterMethod
	public void closeApp() {
		if(System.getenv("BROWSER")!=null && System.getenv("BROWSER").equalsIgnoreCase("Chrome")) {
		driver.quit();
		}
	}
	@Test
	public void testsearch() throws InterruptedException {
		if(System.getenv("BROWSER")!=null && System.getenv("BROWSER").equalsIgnoreCase("Chrome")) {
		driver.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/div[2]/div[1]/form/span/input")).click();
		driver.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/div[2]/div[1]/form/span/input")).sendKeys("chennai");
		driver.findElement(By.xpath("//*[@id='main']/div[1]/div[2]/div[2]/div[1]/form/input")).click();
		Thread.sleep(5000);
		}
	}
}

