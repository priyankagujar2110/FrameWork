package pages_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}

	

	@FindBy(id = "email") WebElement email;
	@FindBy(id = "passwd") WebElement password;
	@FindBy(xpath = "//*[@id=\'SubmitLogin\']/span") WebElement loginbutton;
	
	public void typeEmail(String prigujargmailcom)
	{
		email.sendKeys(prigujargmailcom);
	}
	
	public void typePassword(String abcd)
	{
		password.sendKeys(abcd);
	}
	
	public void clickLoginButton()
	{
		loginbutton.click();
	}
	
	
	
}
