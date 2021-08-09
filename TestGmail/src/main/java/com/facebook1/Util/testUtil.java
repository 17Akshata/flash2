package com.facebook1.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.facebook1.Bbase.TestBase;

public class testUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT =10;
	public static String str1;
	public String getExcelData(String sheetName,int rowNum,int cellNum) 
	{
		String empno=null;
		
		try {
			FileInputStream inp=new FileInputStream("C:\\Projects\\TestGmail\\DataFiles\\RegistationPage.xlsx");
			Workbook wrkFact=WorkbookFactory.create(inp);
			Sheet sheet=wrkFact.getSheet(sheetName);
			Row row=	sheet.getRow(rowNum);

			Cell cell=row.getCell(cellNum);
			//to get integer data from excel sheet use dataformatter class
			DataFormatter formatter = new DataFormatter();
			empno = formatter.formatCellValue(cell);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empno;
	}

	public int getLastRowNumb(String sheetName)
	{
		int lastRow=0;
		try {
			FileInputStream fis=new FileInputStream("C:\\\\Projects\\\\TestGmail\\\\DataFiles\\\\RegistationPage.xlsx");
			Workbook wrkfact=	WorkbookFactory.create(fis);
			Sheet sh=wrkfact.getSheet(sheetName);
			lastRow=sh.getLastRowNum();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastRow;
	}
	public int getLastCellNumb(String sheetName, int row)
	{

		short ls = (short)0;
		try {
			FileInputStream fis=new FileInputStream("C:\\\\Projects\\\\TestGmail\\\\DataFiles\\\\RegistationPage.xlsx");
			Workbook wrkfact=	WorkbookFactory.create(fis);
			Sheet sh=wrkfact.getSheet(sheetName);
			Row rw=sh.getRow(row);
			ls=  rw.getLastCellNum();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ls;
	}
	public static void createNewUser()
	{
		testUtil util=new testUtil();
		int lastRowCount=util.getLastRowNumb("Registration");
		int cellLastval=util.getLastCellNumb("Registration", 1);

		for (int i = 1; i <= lastRowCount; i++) 
		{
			for (int j = 0; j <= cellLastval; j++) 
			{	

				 str1=	util.getExcelData("Registration", i, j);
				//System.out.print(str1 +" "  );
			}
			//System.out.println();
		}
	}
	
	public static void takeSnapShot() throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
               String currentDir=System.getProperty
            		   ("user.dir");
            //Move image file to new destination

                File DestFile=new File(currentDir+"/screenshot/"+ System.currentTimeMillis()+".png");

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }

}