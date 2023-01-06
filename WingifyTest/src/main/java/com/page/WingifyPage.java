package com.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class WingifyPage {
	private WebDriver driver;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@id='log-in']")
	WebElement login;

	@FindBy(xpath = "//*[@id='amount']")
	WebElement amount;


	@FindBy(xpath = "/html/body/div/div[1]/div[1]/a/div[2]")
	WebElement logo;





	public WingifyPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void login() throws InterruptedException{
		username.sendKeys("Krushna");
		Thread.sleep(3000);
		password.sendKeys("123456789");
		Thread.sleep(3000);
		login.click();
		Thread.sleep(3000);
		Assert.assertTrue(logo.isDisplayed());
		System.out.println("******Login Succesfully*******");
	}
	public void verifyIfAmountSorted () throws InterruptedException {
		amount.click();
		amount.click();

		Thread.sleep(3000);


		List<WebElement> list=driver.findElements(By.xpath("//tr/td/span[contains(@class,'text-')]"));

		double ar []= new double[list.size()];
		int count=0;
		for(WebElement el:list)
		{
			String s=el.getText();
			s=s.replace(",", "");
			s=s.replace("USD", "");
			s=s.replace(" ", "");
			s=s.replace(".", "");
			double i=Integer.parseInt(s);
			ar[count]=i;
			count++;
		}

		int count1=0;
		for(int i=1;i<ar.length;i++) {

			if(!(ar[i]<ar[i-1]))
			{
				count1++;
			}
		}

		Assert.assertTrue(count1==0);
		System.out.println("*****Values are sorted*******");

	}
}




