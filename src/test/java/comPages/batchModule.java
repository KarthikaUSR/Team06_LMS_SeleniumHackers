package comPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class batchModule {
	
	private  WebDriver driver;

	By batchButton=By.xpath("//*[@class='ng-star-inserted']/button[2]");
	By pageName=By.xpath("//*[@class='ng-star-inserted']/button[2]/span[1]");
	By batchLabel=By.xpath("//*[@class='mat-card mat-focus-indicator']/mat-card-title/div[1]");
	
	//constructor
	public batchModule(WebDriver driver) {
        this.driver = driver;
		}

	public String landbatchpage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(
	            ExpectedConditions.elementToBeClickable(batchButton));	        
		driver.findElement(batchButton).click();
		String label=driver.findElement(pageName).getText();
		return label;
		
	}
	
	public String labelBatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(
	            ExpectedConditions.visibilityOfElementLocated(pageName));
		
		String label=driver.findElement(pageName).getText();
		return label;
		
	}
	public String batchheading() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(
	            ExpectedConditions.elementToBeClickable(batchLabel));
	        
		String label=driver.findElement(batchLabel).getText();
		return label;
		
	}
	
	public String currentUrl()
	{
		return driver.getCurrentUrl();
	}
	public String title()
	{
		return driver.getTitle();
	}

	
	

}
