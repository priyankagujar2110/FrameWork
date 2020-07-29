package browsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	
	public String uRL="http://demo.guru99.com/test/login.html";
	public String userName="mngr269348";
	public String password="ugEsErY";
	public static WebDriver driver;
	
	
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	
	

}
