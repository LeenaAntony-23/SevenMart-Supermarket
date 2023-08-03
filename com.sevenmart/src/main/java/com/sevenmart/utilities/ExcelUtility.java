package com.sevenmart.utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import com.sevenmart.constants.Constants;

public class ExcelUtility {
	XSSFSheet sheet;
	XSSFWorkbook workbook;

	XSSFRow row;
	XSSFCell cell;

	public void setExcelFile(String workBookName, String sheetName) {
		try {
			String path = Constants.EXCEL_FILE_PATH + workBookName + ".xlsx";
			File src = new File(path);
			FileInputStream fileinputstream = new FileInputStream(src);
			workbook = new XSSFWorkbook(fileinputstream);// initializing work book
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}

	}

	public String getCellData(int rowNumber, int columnNumber) {
		row = sheet.getRow(rowNumber);
		cell = row.getCell(columnNumber);
		switch (cell.getCellType()) {
		case STRING: {
			String data;
			data = cell.getStringCellValue();
			return data;
		}
		case NUMERIC: {// number to string
			long data = (long) cell.getNumericCellValue();
			return String.valueOf(data);
		}

		default:
			return null;// to avoid return type error
		}

	}
	public Object[][] getMultiDimensionalData(int rowNo, int columnNo) {
		Object data[][] = new Object[rowNo][columnNo];
		for (int i = 0; i < rowNo; i++) {
			for (int j = 0; j < columnNo; j++) {
				data[i][j] = getCellData(i, j);
			}
		}
		return data;

	}
}
