package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
	public static List<SampleVO> readExcel() throws IOException{

		
		ExcelReader objExcelFile = new ExcelReader();

	    //Prepare the path of excel file

	    String filePath = System.getProperty("user.dir")+"\\src\\main\\resources";
	    String fileName="test.xlsx";
	    String sheetName="Sheet1";
	    //Call read file method of the class to read data

		
		
	    //Create an object of File class to open xlsx file

	    File file =    new File(filePath+"\\"+fileName);

	    //Create an object of FileInputStream class to read excel file

	    FileInputStream inputStream = new FileInputStream(file);

	    Workbook guru99Workbook = null;

	    //Find the file extension by splitting file name in substring  and getting only extension name

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));

	    //Check condition if the file is xlsx file

	    if(fileExtensionName.equals(".xlsx")){

	    //If it is xlsx file then create object of XSSFWorkbook class

	    guru99Workbook = new XSSFWorkbook(inputStream);

	    }

	    //Check condition if the file is xls file

	    else if(fileExtensionName.equals(".xls")){

	        //If it is xls file then create object of HSSFWorkbook class

	        guru99Workbook = new HSSFWorkbook(inputStream);

	    }

	    //Read sheet inside the workbook by its name

	    Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);

	    //Find number of rows in excel file

	    int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	    //Create a loop over all the rows of excel file to read it
	    List<SampleVO> rows=new ArrayList();
	    
	    for (int i = 0; i < rowCount+1; i++) {

	        Row row = guru99Sheet.getRow(i);

	        //Create a loop to print cell values in a row
	       
	       
	        
	        SampleVO excelRow=getValue(row);
	        rows.add(excelRow);
	        for (int j = 0; j < row.getLastCellNum(); j++) {

	            //Print Excel data in console
	        	if(null!=row.getCell(j))
	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }

	        System.out.println();
	    } 
	    return rows;
	    }  

	    //Main function is calling readExcel function to read data from excel file

	    public static void main(String...strings) throws IOException{

	    //Create an object of ReadGuru99ExcelFile class

	    	ExcelReader objExcelFile = new ExcelReader();

	    //Prepare the path of excel file

	    String filePath = System.getProperty("user.dir")+"\\src\\main\\resources";

	    //Call read file method of the class to read data

	    objExcelFile.readExcel();

	    }
	    
	    private static SampleVO getValue(Row row) {
	    String fname= null==row.getCell(0)?"":row.getCell(0).getStringCellValue();
	    String sname= null==row.getCell(1)?"":row.getCell(1).getStringCellValue();

	    String gender= null==row.getCell(2)?"":row.getCell(2).getStringCellValue();

	    String country= null==row.getCell(3)?"":row.getCell(3).getStringCellValue();
	    return new SampleVO(fname, sname, gender, country);

	    }

	}
	
	
	

