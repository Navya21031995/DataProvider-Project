package DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Dataprovider {
	
	@DataProvider(name="loaddata")
	public static Object[][] fetchData() throws IOException {	
		FileInputStream fis = new FileInputStream("./inputsheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int row = sheet.getPhysicalNumberOfRows();
		System.out.println(row);
		Object Data[][]= new Object[row][2];
		for (int i=0;i<row;i++) {
			int col = sheet.getRow(i).getPhysicalNumberOfCells();
			for (int j=0;j<col;j++) {
				XSSFCell cell = sheet.getRow(i).getCell(j);
				Data[i][j] = cell.getStringCellValue();
			}
		}
		return Data;
		
	
	}
	

}
