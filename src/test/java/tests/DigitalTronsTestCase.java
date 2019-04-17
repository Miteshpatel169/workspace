package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BrowserUtility;
import pages.DigitalTronsTestPage;

public class DigitalTronsTestCase {
	
	static WebDriver driver;
	
	public static void setWaitTime(int time)
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public static void runTests()
	{
		
		// call to browser utility do work till getting URL
		driver = BrowserUtility.setup();
		
		DigitalTronsTestPage page = PageFactory.initElements(driver, DigitalTronsTestPage.class);
		
		// close the popup 
		page.closePopUp();
		
		// enter value in searchBox
		page.enterValueInSearchBox("mi");
		
		// click on mobiles link 
		page.clickOnMobilesLink();
		
		// set range low to high
		page.setLowToHigh();
		
		//slider1
		page.setPriceRange();
		
		
		//PDP page
		page.openPDPPageItem();
		
		//Click on Share Link
		page.shareLink();
	
		//Click On FacebookLink
		page.shareToFacebook();
		
		//Get Title
		page.getTitle();
		
		//click on EMI
		page.clickOnEmi();
		
		//Click EMI per Month
		page.calculateEmi();
		
		setWaitTime(15000);
		
		driver.quit();
		
		
	}

}

