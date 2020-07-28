package testCases_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Custome {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        
		/*
		 * driver.get("https://teamme.azurewebsites.net/#/login");
		 * driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(
		 * "priyanka");
		 */
     
       driver.get("https://www.google.com/");

       String title = driver.getTitle();
       System.out.println(title);
       System.out.println(driver.getCurrentUrl());
       boolean value=driver.findElement(By.name("btnK")).isDisplayed();
       System.out.println(value);
       System.out.println(driver.findElement(By.xpath("//input[@class='RNmpXc' and @type='submit']")).isEnabled());
       
       
       
       
       
       
       driver.quit();
       
	}

}
