package Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import PropertyReader.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	PropertyReader filereader;
	
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
		driver.quit();
	}
}
