package testCases_POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDataFromExcel {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-sbi-bsb001.html");
        driver.manage().window().maximize();

		
		FileInputStream file = new FileInputStream("C:\\Users\\rahul\\iCloudDrive\\Backup\\Excel.sbi.xlsx");
		
		
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0); 
		
        int rowcount = sheet.getLastRowNum(); 
		
		
		//int coloumncount = sheet.getRow(0).getLastCellNum(); 
		
		for (int i=1; i<rowcount; i++)
		{
			XSSFRow row = sheet.getRow(i); 
			int principalValue = (int)row.getCell(0).getNumericCellValue();
			
			XSSFCell rateInterest =row.getCell(1);
			int roi=(int)rateInterest.getNumericCellValue();
			
			XSSFCell period =row.getCell(2);
			int perod=(int)rateInterest.getNumericCellValue();
			
			XSSFCell frequency =row.getCell(3);
			String Freq=frequency.getStringCellValue();
			
			XSSFCell maturityValue =row.getCell(4);
			int ExpMaturity=(int)maturityValue.getNumericCellValue();
			
			
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(principalValue));
			driver.findElement(By.name("interest")).sendKeys(String.valueOf(roi));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(perod));
			
			Select days=new Select(driver.findElement(By.name("tenurePeriod")));
			days.selectByVisibleText("year(s)");
			
			Select freqncy=new Select(driver.findElement(By.name("frequency")));
			freqncy.selectByVisibleText(Freq);

			driver.findElement(By.xpath("//*[@id=\'fdMatVal\']/div[2]/a[1]/img")).click();
			
			String actualMaturity= driver.findElement(By.xpath("//*[@id=\'resp_matval\']/strong")).getText();
			System.out.println(actualMaturity);
			
			if (Double.parseDouble(actualMaturity)==ExpMaturity)
{
	System.out.println("Test Passed");
}
else
{
	System.out.println("Test failed");
}
		driver.findElement(By.xpath("//*[@id=\'fdMatVal\']/div[2]/a[2]/img")).click();
		
	}
		driver.quit();
	}
}
