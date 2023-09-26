package seleniumTests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseTest {

	WebDriver driver;
	
	public void lauchBrowser() {
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.33.0-win64\\geckodriver.exe");

		driver = new FirefoxDriver();
		driver.get("https://www.olx.pl");
	}
	
	public void searchProduct(String product) throws InterruptedException {
		// Implicit wait 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		String title = driver.getTitle();

		System.out.println(title);
		driver.findElement(By.id("headerSearch")).sendKeys(product);
		driver.findElement(By.id("submit-searchmain")).click();
		
//		Explicit wait until the page is not changed
		wait.until(d -> {
			if (title != driver.getTitle()) return true;
			else {
				System.out.println(driver.getTitle());
				return false;
			}
		}
		);
	}
	
	public void closeBrowser() throws InterruptedException {
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {

		baseTest obj = new baseTest();
		obj.lauchBrowser();
		obj.searchProduct("gramofon");
		obj.closeBrowser();
	}

}