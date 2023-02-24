package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.BaseClass;

public class LoginPages extends BaseClass {
	WebDriver driver;
	
	public LoginPages(WebDriver driver){
		this.driver = driver;		
	}
	
	By username = By.name("username");
	By password = By.name("password");
	
	By submit = By.id("submit");
	By login = By.className("post-header");

	
	public void enterCred(String un , String pwd) 
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submit).click();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(login)));
		driver.findElement(login).isDisplayed();
		driver.navigate().refresh();
		
	}
	
	

}
