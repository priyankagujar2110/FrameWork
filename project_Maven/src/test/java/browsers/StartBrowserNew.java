package browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
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
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setCapability("ignoreZoomSetting", true);
			WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver(caps);
            
		}
		else 
		{
			System.out.println("We Dont Support this Browser");
		}
		
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.get(appIURL);
		
		return driver;
		
	}
		
		public static void closeBrowser(WebDriver driver)
		{
			driver.quit();
		}
		
		
		
		
	}
	
