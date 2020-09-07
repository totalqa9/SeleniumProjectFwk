package org.abc.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Utility {

	static Random rand;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static String generateRandom(int n,int range)
	{
		rand = new Random();
		String str = "";
		for(int j=0; j<n; j++)
		{
			str = str+ 9;	 
		}
		System.out.println(str);

		return str+rand.nextInt(range);
	}
	public static String readFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuffer sb = new StringBuffer();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}
	public static String getFutureDate(int days,String pattern)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String date = sdf.format(d);
		return date;
	}
	public  static String getFutureDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		Date d = cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String date = sdf.format(d);
		return date;
	}

	public static void ExcelUtils(String excelPath, String sheetName) {
		try {
			//creating a reference variable for workbook and sheet.
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getLastRowNum()+1;
			System.out.println("No of Rows: " + rowCount);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}

	// Total number of columns 
	public static int getcolCount() {
		int colCount = 0;
		try 
		{
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		} 
		catch (Exception exp) 
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}

	public static String getCellDataString(int rowCount, int colCount) {
		String cellData = null;
		try {

			cellData = sheet.getRow(rowCount).getCell(colCount).getStringCellValue();
			//System.out.println("Using Excel util"+cellData);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}
	public String[][] readXlsFile(String filepath,String SheetName) throws IOException
	{
		File f=new File(filepath);
		FileInputStream fis=new FileInputStream(f);

		HSSFWorkbook hWB=new HSSFWorkbook(fis);
		HSSFSheet sheet=hWB.getSheet(SheetName);

		//No of rows
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println("Row count:::" +rows);

		//no of columns
		int cols=sheet.getRow(0).getLastCellNum();
		System.out.println("Column count:::" +cols);

		int k=0;

		String[][] data=new String[rows-1][cols];

		//If the first row contains the column names
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				data[k][j]=sheet.getRow(i).getCell(j).toString();
				System.out.println(data[k][j]);
			}
			k++;
		}
		hWB.close();		
		return data;

	}
}
