package testCases_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import browsers.Base_Class;
import browsers.StartBrowserNew;
import pages_POM.LoginPage;

public class TC_Login_001 extends Base_Class{
	WebDriver driver;
	
	
		@Test
		public void loginTest()
		{
			driver = StartBrowserNew.startApp(driver, "Chrome", "http://demo.guru99.com/test/login.html");
			
			LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
			lp.typeEmail("mngr269348");
			lp.typePassword("ugEsErY");
			lp.clickLoginButton();
			driver.quit();
			
			
		}
		
		

	}


