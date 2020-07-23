package com.cucumber.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Workbook book;
	public static Sheet sheet;

	public static void openExcel(String filePath) {

		try {
			FileInputStream file = new FileInputStream(filePath);
			book = new XSSFWorkbook(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void getSheet(String sheetName) {
		sheet = book.getSheet(sheetName);

	}

	public static int rowCount() {
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		return numberOfRows;
	}

	public static int cellCount(int cellIndex) {
		int cellCount = sheet.getRow(cellIndex).getLastCellNum();
		return cellCount;
	}

	public static String cellData(int rowIndex, int cellIndex) {

		String cellData = sheet.getRow(rowIndex).getCell(cellIndex).toString();
		return cellData;

	}

	public static Object[][] getDataFromExcel(String filePath, String sheetName) {

		openExcel(filePath);
		getSheet(sheetName);

		int rowSize = rowCount();
		int cellSize = cellCount(0);
		Object[][] data = new Object[rowSize - 1][cellSize];
		// iterate rows
		for (int i = 1; i < rowSize; i++) {
			// iterate cell
			for (int j = 0; j < cellSize; j++) {
				data[i - 1][j] = cellData(i, j);
			}
		}

		return data;
	}
	
	public static List<Map<String,String>> getDataFromListOfMaps(String filePath,String sheetName){
		openExcel(filePath);
		getSheet(sheetName);
		
		int rowSize = rowCount();
		int cellSize = cellCount(0);
		
		List<Map<String,String>> list=new ArrayList<>();
		Map<String, String> map;
		
		for (int i = 1; i <rowSize; i++) {
			 map=new LinkedHashMap<>();
			
			for (int j = 0; j <cellSize; j++) {
				String key=cellData(0, j);
				String value=cellData(i, j);
				
				map.put(key, value);
				
				
			}
			list.add(map);
			
			
		}
		return list;
		
		
	}

}
