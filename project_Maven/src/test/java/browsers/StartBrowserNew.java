package browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowserNew {
	
	
	public static WebDriver startApp(WebDriver driver,String browserName, String appIURL)
	{
		if (browserName.equals("Chrome") )
		{
			 WebDriverManager.chromedriver().setup();
	         driver = new ChromeDriver();
		}
		else if (browserName.equals("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
		}
		else 
		{
			System.out.println("We Dont Support this Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.get(appIURL);
		
		return driver;
		
	}
		
		public static void closeBrowser(WebDriver driver)
		{
			driver.quit();
		}
		
		
		
		
	}
	
