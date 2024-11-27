package Utilities;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public String filePath;
	public FileInputStream fis;
	public XSSFWorkbook workbook;

	public ExcelUtility(String path) {
		filePath = path;

		try {
			readExcelFile();
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace();
		}

	}

	private void readExcelFile() throws IOException, InvalidFormatException {
		// Open the Excel file
		fis = new FileInputStream(new File(filePath));

		// Create a workbook instance for reading .xlsx files
		workbook = new XSSFWorkbook(fis);

	}

	public void closeExcelFile() throws IOException, InvalidFormatException {
		workbook.close();
		fis.close();
	}

	public int getRowCount(String sheetName) throws IOException, InvalidFormatException {
		Sheet sheet = getExcelSheet(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
	}

	public int getCellCount(String sheetName, int rowIndex) throws IOException, InvalidFormatException {
		Sheet sheet = getExcelSheet(sheetName);
		int rowCount;
		Row row = sheet.getRow(rowIndex);
		// Get the number of cells in this row
		rowCount = row.getPhysicalNumberOfCells();

		return rowCount;
	}

	public Sheet getExcelSheet(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet;

	}

	public String getCellData(String sheetName, int row, int col) {

		Sheet sheet = workbook.getSheet(sheetName);
		Row row1 = sheet.getRow(row);
		Cell cell = row1.getCell(col);
		try {
		return cell.getStringCellValue();
		}catch(Exception e)
		{
		return null;	
		}
	}

}
