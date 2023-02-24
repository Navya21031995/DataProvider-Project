package TestClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import DataProvider.Dataprovider;
import PageObjects.LoginPages;

public class Test01 extends BaseClass {
	
	
	@Test(dataProvider="loaddata" , dataProviderClass = Dataprovider.class)
	public void test01(String un , String pwd) {
		LoginPages lg = new LoginPages(driver);
		lg.enterCred(un , pwd);
		System.out.println("Iteration over");
	}
	


}
