package pages;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DigitalTronsTestPage { 
	
	public static WebDriver driver;
	
	
	public DigitalTronsTestPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	@CacheLookup
	WebElement windowpopupclose;
	
	@FindBy(xpath="//div[@class='O8ZS_U']/child::*[1]")
	@CacheLookup
	WebElement searchElement;
	
	@FindBy(xpath="(//a[text()='Mobiles'])[2]")
	@CacheLookup
	WebElement mobileslinkElement;
	
	@FindBy(xpath="(//div[@class='_3aQU3C'])[1]")
	@CacheLookup
	WebElement sliderElement1;
	
	@FindBy(xpath="(//div[@class='_3aQU3C'])[2]")
	@CacheLookup
	WebElement sliderElement2;
	
	@FindBy(xpath="(//select[@class='fPjUPw'])[1]")
	@CacheLookup
	WebElement dropdownElement1;
	
	@FindBy(xpath="(//select[@class='fPjUPw'])[2]")
	@CacheLookup
	WebElement dropdownElement2;
	
	@FindBy(xpath="//div[text()='Price -- Low to High']")
	@CacheLookup
	WebElement pricelowtohighElement;
	
	@FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK']")
	@CacheLookup
	WebElement pricesortedlistElement;
	
	@FindBy(xpath="//div[text()='Redmi Go (Blue, 8 GB)']")
	@CacheLookup
	WebElement productdescriptionlinkElement;
	
	@FindBy(xpath="//span[@class='_2ExopE']")
	@CacheLookup
	WebElement sharelinkElement;
	
	@FindBy(xpath="(//div[@class='zUGA5b'])[1]")
	@CacheLookup
	WebElement facebooklinkElement;
	
	@FindBy(xpath="(//div[@class='_2eBknn'])[2]/button[@class='_2AkmmA _1Q_hL_']")
	@CacheLookup
	WebElement emiElement;
	
	@FindBy(xpath="(//div[@class='nndWP7 row'])[4]/child::*[3]")
	@CacheLookup
	WebElement monthlyemiElement;
	
	@FindBy(xpath="(//div[@class='nndWP7 row'])[4]/child::*[1]")
	@CacheLookup
	WebElement yearlyInterestElement;
	
	@FindBy(xpath="//div[@class='_2hkGFg']/child::*[2]/child::*[2]")
	@CacheLookup
	WebElement interestPerYearPaidElement;
	
	@FindBy(xpath="//div[@class='_3hgEev _3PkuKO']/child::*[1]")
	@CacheLookup
	WebElement closeEmiWindowElement;
	
	public void closePopUp()
	{
		windowpopupclose.click();
	}
	
	public void enterValueInSearchBox(String value)
	{
		
		searchElement.clear();
		searchElement.sendKeys(value);
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchElement.sendKeys(Keys.ENTER);
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public void clickOnMobilesLink()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(mobileslinkElement));
		mobileslinkElement.click();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public void setPriceRange()
	{
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		Actions actions = new Actions(driver);
				
		actions.clickAndHold(sliderElement1).build().perform();
		
		actions.moveByOffset(20, 0).build().perform();
		
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		actions.clickAndHold(sliderElement2).build().perform();
		
		actions.moveByOffset(-60, 0).build().perform();
		
			
	}
		
	
	public void setLowToHigh()
	{
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(pricelowtohighElement).build().perform();
		
		actions.click(pricelowtohighElement).build().perform();
		
		
		verifyLowToHigh();
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void verifyLowToHigh()
	{	
		
		// get all the price elements 
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));
		
		System.out.println("Size of list of price elements : " + list.size());
		
		List<String> prices = new ArrayList<String>();
		
		for(WebElement e : list)
		{
			prices.add(e.getText().substring(1));
		}
		
		// make copy of the list
		List<String> sortedPries = new ArrayList<String>(prices);
		
		// sort the list 
		Collections.sort(sortedPries);
		
		// true if the prices are sorted
		System.out.println("Elements Sorted : " +sortedPries.equals(prices));
		
		// print the aorted array of prices
		int i=1;
		for (String price : sortedPries) 
		{
			System.out.println("Price "+ i + ": " + price);
			i++;
		}
		
	}
	
	public void openPDPPageItem()
	{

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productdescriptionlinkElement.click();
		
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public void shareLink()
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		it.next();
		
		driver.switchTo().window(it.next());
		
		sharelinkElement.click();
		
	}
	
	public void shareToFacebook()
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(facebooklinkElement));*/
		facebooklinkElement.click();
		
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public void getTitle()
	{
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		it.next(); // home
		it.next(); // pdp
		
		driver.switchTo().window(it.next()); // facebook
		
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		System.out.println("Title of window is :"+title);
		
		driver.close();
	}
	
	public void clickOnEmi()
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		it.next(); // home
		
		driver.switchTo().window(it.next());
		
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		/*Actions actions = new Actions(driver);
		actions.moveToElement(emiElement).build().perform();
		actions.click(emiElement).build().perform();*/
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		executor.executeScript("arguments[0].click();", emiElement);
		
		//emiElement.click();
		
	}
	
	public void calculateEmi()
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String EMI = monthlyemiElement.getText();
		System.out.println("Emi Amount Per Month :"+EMI.substring(1));
		
		yearlyInterestElement.click();
		
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		String interest = interestPerYearPaidElement.getText();		
		System.out.println("Interest Paid For a year :"+interest.substring(3));
		
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		closeEmiWindowElement.click();
	}
	

}
