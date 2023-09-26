package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseTest {

	WebDriver driver;
	
	public void lauchBrowser() {
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.33.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.get("https://www.olx.pl");
	}
	
	public void searchProduct(String product) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("headerSearch")).sendKeys(product);
		driver.findElement(By.id("submit-searchmain")).click();
	}
	
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {

		baseTest obj = new baseTest();
		obj.lauchBrowser();
		obj.searchProduct("gramofon");
		obj.closeBrowser();
	}

}