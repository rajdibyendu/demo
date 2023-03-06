/**
 * 
 */
package com.xais.genericlibrary;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Dibyendu.raj
 *
 */
public class FileLibrary {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public FileLibrary(){
		try {
			String filePath = "C:\\Users\\Dibyendu.raj\\git\\repository\\xais_project\\src\\test\\resources\\TestData\\TestData.xlsx";
			File file = new File(filePath);
			FileInputStream fis = new  FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public int getRowCount(String sheet) {
		return wb.getSheet(sheet).getLastRowNum();
	}
	
	public int getColumnCount(String sheet) {
		return wb.getSheet(sheet).getRow(0).getLastCellNum();
	}
	
	public String getCellData(String sheet, int row, int column) {
		Cell cell = wb.getSheet(sheet).getRow(row).getCell(column);
		CellType cellType = cell.getCellType();
		String data = "";
		switch (cellType) {
		case STRING:
			data = cell.getStringCellValue();
			break;

		case NUMERIC:
			data = Integer.toString((int)cell.getNumericCellValue());
			break;
			
		default:
			break;
		}
		return data;
	}
	
	public Object[][] dataProvider(String sheet) {
		int row = getRowCount(sheet);
		int column = getColumnCount(sheet);
		Object[][] obj = new Object[row][column];
		for (int i=0; i<row; i++) {
			for (int j=0; j<column; j++) {
				obj[i][j] = getCellData(sheet, i+1, j);
			}
		}
		return obj;
	}


}
