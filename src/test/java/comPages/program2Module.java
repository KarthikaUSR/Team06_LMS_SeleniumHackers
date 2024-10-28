package comPages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import comUtils.configReader;

public class program2Module {
	//private WebDriver driver;
	private static WebDriver driver;
	private static configReader cr;
	private static Properties prop;

	By clkProgramBtn=By.xpath("//*[@class='ng-star-inserted']/button[1]");
	By programPageName=By.xpath("//*[@class='ng-star-inserted']/button[1]/span[1]");
	By clkArrowNextToProgram=By.xpath("//tr//th[2]");
	By listProgram=By.xpath("//tr/td[2]");
	By clkArrowNextToProgDescription=By.xpath("//tr//th[3]");
	By listProgDescription=By.xpath("//tr/td[3]");
	By clkArrowNextToProgStatus=By.xpath("//tr//th[4]");
	By listProgStatus=By.xpath("//tr/td[4]");
	
	By txtsearch=By.xpath("//div//span//input[@id='filterGlobal']");
	By resultProgramName=By.xpath("//tr//td[2]");
	
	public program2Module(WebDriver driver) {
		this.driver=driver;
        }
	public String landProgramPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(
	            ExpectedConditions.elementToBeClickable(clkProgramBtn));	        
		driver.findElement(clkProgramBtn).click();
		String classPageName_Actual = driver.findElement(programPageName).getText();
		return classPageName_Actual;
}
	
	public void clickProgramName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement element1=wait.until(
	            ExpectedConditions.elementToBeClickable(clkArrowNextToProgram));	        
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
		}
	
	public void sortingProgramName() {
				
		//capture All WebElements into List
		List<WebElement> programsList=driver.findElements(listProgram);
		System.out.println("programsList-----"+programsList);
		//capture text of all webelements into new(original) list
		List<String> originalList=programsList.stream().map(s->s.getText()).map(o->o.toLowerCase()).collect(Collectors.toList());
		System.out.println("originalList-----"+originalList);
		//sort on the original List
		List<String> sortedList=originalList.stream().map(l->l.toLowerCase()).sorted().collect(Collectors.toList());
		System.out.println("sortedList-----"+sortedList);
		//compare original List vs sorted List 
		Assert.assertTrue(originalList.equals(sortedList));
		
	}
	
	public void clickProgramDescription() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement elementLink=wait.until(
	            ExpectedConditions.elementToBeClickable(clkArrowNextToProgDescription));	        
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", elementLink);
		
	}
	public void sortingProgDescription() {	
		List<WebElement> programsList=driver.findElements(listProgDescription);
		System.out.println("programsList-----"+programsList);
		List<String> originalList=programsList.stream().map(s->s.getText()).map(o->o.toLowerCase()).collect(Collectors.toList());
		System.out.println("originalList-----"+originalList);
		List<String> sortedList=originalList.stream().map(l->l.toLowerCase()).sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		
	}
	
	public void clickProgramStatus() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement element1=wait.until(
	            ExpectedConditions.elementToBeClickable(clkArrowNextToProgStatus));	        
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
		}
	
	public void sortingProgramStatus() {
				
		List<WebElement> programsList=driver.findElements(listProgStatus);
		System.out.println("programsList-----"+programsList);
		List<String> originalList=programsList.stream().map(s->s.getText()).map(o->o.toLowerCase()).collect(Collectors.toList());
		System.out.println("originalList-----"+originalList);
		List<String> sortedList=originalList.stream().map(l->l.toLowerCase()).sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		
	}
	
	public void setSearchProgName() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
//		wait.until(
//	            ExpectedConditions.elementToBeClickable(clkProgramBtn));	        
//		driver.findElement(clkProgramBtn).click();
		
				
		
		cr = new configReader();
        prop = cr.init_prop();
        System.out.println("Property------------->"+prop.getProperty("searchWholeWord"));
        WebElement txtsearchProgName=driver.findElement(txtsearch);
        txtsearchProgName.sendKeys(prop.getProperty("searchWholeWord"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement element2=wait.until(
	            ExpectedConditions.elementToBeClickable(clkArrowNextToProgStatus));	        
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);

		
	}
	
	public String searchResult() {
		
		String searchResultProgName=driver.findElement(resultProgramName).getText();
		System.out.println(searchResultProgName);
		return searchResultProgName;
	}
	
	
	public void clickOnWebelement(WebElement element, long waitTimeSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSecond));
		element= wait.until(ExpectedConditions.elementToBeClickable(element));
          element.click();
	}
	
}
