package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserUtility {
	
		public static WebDriver driver;
		
		public static WebDriver setup()
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			System.setProperty("webdriver.chrome.driver", "D:\\AutomationPractice\\test\\driver\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
		}

}
