package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil1 {

	private static String TEST_DATA_SHEET = "./src/test/resources/testdata/opencart_TestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] getTestData(String SheetName) {

		Object data[][] = null;

		try {
			FileInputStream fis = new FileInputStream(TEST_DATA_SHEET);

			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(Constants.REGISTER_SHEET_NAME);

			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//data[1][1] = sheet.getRow(1).getCell(1).toString();
//System.out.println(data[1][3]);
			
for (int i = 0; i < sheet.getLastRowNum(); i++) {
for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
data[i][j] = sheet.getRow(i+1).getCell(j).toString();
}
}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}