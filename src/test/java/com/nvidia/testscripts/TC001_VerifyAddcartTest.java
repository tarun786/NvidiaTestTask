package com.nvidia.testscripts;

import java.util.ArrayList;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nvidia.pageobject.NvidiaShopping;
import com.nvidia.testbase.TestBase;

public class TC001_VerifyAddcartTest extends TestBase{
	NvidiaShopping nvidiashop;
	@BeforeTest
	public void setUp()
	{   
		Properties properties=getProp();
	    String URL=properties.getProperty("URL");
		init(URL);
	}
	
	@Test(priority=1) 
	 public void verifyLoginWithCreadentials() throws InterruptedException
	 {  
		Properties properties=getProp();
		nvidiashop=new NvidiaShopping(driver);
		ArrayList<String> actualdata = nvidiashop.verifyaddItemToCart();
		
		try {
			
			Assert.assertEquals(actualdata.get(0), "Checkoutpage title PayPal Checkout - Create a PayPal account!");
			Assert.assertEquals(actualdata.get(1), "");
		} catch (Exception e) {
			logger.info("Error found "+e.getMessage());
		}
		
	 }
	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
	 
}
