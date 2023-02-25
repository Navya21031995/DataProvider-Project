package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PropertyReader.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	PropertyReader filereader;
	static ExtentTest test;
	static ExtentReports report;
	
	@BeforeClass
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\ExtentReportResults.html");
	test = report.startTest("ExtentDemo");
	}
	
@BeforeMethod
public void setUp() throws Exception {
		filereader= new PropertyReader();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(filereader.getURL());
		driver.manage().window().maximize();		
	}

	
	@AfterMethod()
	public void tearDown() {
		
		test.log(LogStatus.PASS, "Quit Driver");
		driver.quit();
	
	}
	
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
}
