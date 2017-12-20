package com.nvidia.pageobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nvidia.testbase.TestBase;

public class NvidiaShopping extends TestBase {

     
	
    public static final Logger logger=Logger.getLogger(NvidiaShopping.class.getName());
    Properties prop=getProp();
	public NvidiaShopping(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span/a[@href='https://www.nvidia.com/en-us/geforce/products/10series/'][1]")
	WebElement productHover;
	
	@FindBy(xpath="//*[starts-with(@id,'navigation')]/div[3]/div[1]/div[1]/div[2]/ul/li[3]/a/span")
    WebElement productSel;
	
	@FindBy(xpath=".//*[@id='gtx-1070-family']/div[2]/div/div/div[2]/a/div")
	WebElement addtocart;
	
	@FindBy(xpath=".//*[@id='cart']/div[2]")
	WebElement checkout;
	
	@FindBy(xpath="//img[@title='Checkout with Paypal']")
	WebElement checkoutPaypal;
	
	@FindBy(id="cc")
	WebElement CCard;
	
	@FindBy(id="expiry_value")
	WebElement Expiry_value;
	
	@FindBy(id="firstName")
	WebElement firstname;
	
	@FindBy(id="cvv")
	WebElement cvvno;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(id="telephone")
   WebElement telephoneno;
	
	@FindBy(id="billingLine1")
	WebElement billingstrets;
	

	@FindBy(id="billingCity")
	WebElement billingcity;
	

	@FindBy(id="billingState")
	WebElement selbillingtate;
	
	//New York
	
	@FindBy(id="billingPostalCode")
	WebElement billingpostalcode;

	@FindBy(xpath=".//*[@id='signupContainer']/div[2]/xo-signup-options/div/div/div/div[2]/span/label/span[1]")
	WebElement agreebtn;
	

	@FindBy(id="guestSubmit")
	WebElement guestsubmi;
	

	@FindBy(xpath=".//*[text()='Enter a valid card number']")
	WebElement invaildCard;
	public ArrayList<String> verifyaddItemToCart()
	{
		ArrayList<String> verifyData=new ArrayList<String>();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Actions actions=new Actions(driver);
		actions.moveToElement(productHover).build().perform();
		sleepTime(10);
		
		productSel.click();
		sleepTime(10);
		addtocart.click();
		sleepTime(10);
		checkout.click();
		sleepTime(10);
		checkoutPaypal.click();
		sleepTime(20);
         
		String checoutPage=driver.getTitle();
		logger.info("Checkoutpage title "+checoutPage);
		verifyData.add(checoutPage);
		
		CCard.clear();
		CCard.sendKeys(prop.getProperty("ccard"));
		
		Expiry_value.clear();
		Expiry_value.sendKeys(prop.getProperty("expiryvalue"));
		
		cvvno.clear();
		cvvno.sendKeys(prop.getProperty("cvvno"));
		
		firstname.clear();
		firstname.sendKeys(prop.getProperty("fname"));
		
		lastname.clear();
		lastname.sendKeys(prop.getProperty("lname"));
		
		telephoneno.clear();
		telephoneno.sendKeys("phoneno");
		
		billingstrets.clear();
		billingstrets.sendKeys(prop.getProperty("billingstrete"));
		
		billingcity.clear();
		billingcity.sendKeys(prop.getProperty("billingcity"));
		
		Select selectt=new Select(selbillingtate);
		selectt.selectByVisibleText("New York");
		
		billingpostalcode.clear();
		billingpostalcode.sendKeys(prop.getProperty("postelcode"));
		
		sleepTime(40);
		
		agreebtn.click();
		sleepTime(10);
		guestsubmi.click();
		
		sleepTime(12);
		String invalidmsg=invaildCard.getText();
		logger.info("Invalid text "+invalidmsg);
		verifyData.add(invalidmsg);
		
		return verifyData;
		
		
	}
	
	
}
