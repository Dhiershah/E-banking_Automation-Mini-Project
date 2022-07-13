package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;


public class TC_AddCustomerTest_2 extends BaseClass

{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		
		Thread.sleep(2000);
		lp.clickSubmit();
		
		Thread.sleep(2000);
		//driver.switchTo().alert().dismiss();
		//driver.findElement(By.cssSelector(cookie_path)).click();
		AddCustomerPage addcust= new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		//driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/a")).click();
		//addcust.clickAddNewCustomer();
		
		logger.info("Providing the Customer details......");
		
		addcust.custName("Tanya");

		addcust.custgender("female");

		addcust.custdob("10","15","1985");

		addcust.custaddress("India");

		addcust.custcity("Mangalore");

		addcust.custstate("Karnataka");

		addcust.custpinno("560089");

		addcust.custtelephoneno("8792276890");

		
		String email=randomString()+"@gmail.com";
		addcust.custemailid(email);

		addcust.custpassword("zxcvbnnm");

		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}

