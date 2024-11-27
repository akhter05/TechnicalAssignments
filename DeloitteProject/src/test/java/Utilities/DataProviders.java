package Utilities;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException, InvalidFormatException
	{
		String path = ".\\testData\\LoginData.xlsx";
		
		ExcelUtility excelutil = new ExcelUtility(path);
		
		int totalrows= excelutil.getRowCount("Sheet1");
		int totalcols= excelutil.getCellCount("Sheet1",1);
		
		String logindata[][] = new String[totalrows-1][totalcols];
		
		for (int i=1; i<totalrows ;i++)
		{
			for (int j=0; j < totalcols ;j++)
			{
				logindata[i-1][j] = excelutil.getCellData("Sheet1",i,j);
			}
		}
		
		return logindata;	
	}

}
