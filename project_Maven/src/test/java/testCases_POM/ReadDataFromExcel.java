package testCases_POM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadDataFromExcel {

	public static void main(String[] args) throws IOException {

		//first new commit
		// To open excel file in read/input mode-
		FileInputStream file = new FileInputStream("C:\\Users\\rahul\\iCloudDrive\\Backup\\Excel.sbi.xlsx");
		
		// To Interacting with Workbook-
		XSSFWorkbook wb = new XSSFWorkbook(file);
		
		//To Interacting with Sheet-
		XSSFSheet sheet = wb.getSheetAt(0); //providing sheet number
		
        //To Interacting with Row-
		// how to count no of rows
		int rowcount = sheet.getLastRowNum(); // return row count
		
		// how to count no of cells
		int coloumncount = sheet.getRow(0).getLastCellNum(); // return coloumn count
		
		for (int i=0; i<rowcount; i++)
		{
			XSSFRow currentrow = sheet.getRow(i); // focussed on current row
			
			for(int j=0; j<coloumncount; j++)
			{
				String value =currentrow.getCell(j).toString(); // read the value from cell
				System.out.print("  " +value); // to give some space
			}
			System.out.println(); // just for allignment
		}
		
		
	}

}
