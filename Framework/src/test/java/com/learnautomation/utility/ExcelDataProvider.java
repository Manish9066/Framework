package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	//create the constructor to fetch the file. no need to load again by again. only call the constructor
	public ExcelDataProvider() {
		File src= new File("./TestData/Data.xlsx");
		//convert file input in raw data
		try {
			FileInputStream fis = new FileInputStream(src);
			//To read xslx we have XSSFWorkBook class, create the object of class and provide the fileinputstream object
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("unable to read Excel file:"+e.getMessage());
			
		} 
		}
	//here we are using method overloading. means method name is same but type of parameter is different.
	// now create the method for read the data
	public String getSringData(String SheetName,int row,int column) {
		//navigate to sheet first then take row and column which one we want. and it return String so we made method as a string.
		//return wb.getSheet("").getRow(0).getCell(0).getStringCellValue();
		return wb.getSheet(SheetName).getRow(row).getCell(column).getStringCellValue();
		
		
	}
	//we can take the data from sheetname as well as sheetindex
	//if we want to read the data from sheet index then
	
	public String getSringData(int SheetIndex,int row,int column) {
		
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(column).getStringCellValue();	
	}
	//similarly we will use this method only changes it return double.
	public double getNumericData(String SheetName,int row,int column) {
		return wb.getSheet(SheetName).getRow(row).getCell(column).getNumericCellValue();
		
	}
	}

