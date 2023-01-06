package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.page.WingifyPage;

public class WingTest {

	 WebDriver driver;
	WingifyPage page;
	@BeforeClass
	public void initialization() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://sakshingp.github.io/assignment/login.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@Test(priority = 1)
	public void loginTest() throws InterruptedException
	{
      page=new WingifyPage(driver);
      page.login();
      
	}

	@Test(priority = 2)
	public void VerifyAmmountTest() throws InterruptedException  
	{
		page=new WingifyPage(driver);
	    page.verifyIfAmountSorted();
	}

	
	@AfterClass
	public void closeBrowser() throws InterruptedException {

		driver.close();
	}

}
