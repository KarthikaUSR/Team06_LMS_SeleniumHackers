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
	By clkArrownUpProgName=By.xpath("//tr//th[2]//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-up-alt']");
	By clkArrownDownProgName=By.xpath("//tr//th[2]//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-down']");
	By listProgram=By.xpath("//tr/td[2]");
	By clkArrowNextToProgDescription=By.xpath("//tr//th[3]");
	By listProgDescription=By.xpath("//tr/td[3]");
	By clkArrowNextToProgStatus=By.xpath("//tr//th[4]");
	By listProgStatus=By.xpath("//tr/td[4]");
	
	By txtsearch=By.xpath("//div//span//input[@id='filterGlobal']");
	By resultProgramName=By.xpath("//tr//td[2]");
	By resultProgramDescription=By.xpath("//tr//td[3]");
	By resultProgramNameZero=By.xpath("//span[.='Showing 0 to 0 of 0 entries']");
	
	By selectCheckBox1=By.xpath("(//tr//td//div//div[2])[1]");  
	By selectedCheckBox1=By.xpath("(//tr//td//div//div//input)[1]");
	By selectCheckBox2=By.xpath("(//tr//td//div//div[2])[3]");  
	By selectedCheckBox2=By.xpath("(//tr//td//div//div//input)[3]");
	By progNameCheckBox1=By.xpath("(//tr/td[2])[1]");
	By progNameCheckBox2=By.xpath("(//tr/td[2])[3]");
	By btnDelete=By.xpath("(//div//div//div//button//span)[1]");
	By msgBoxConfirmDelete=By.xpath("//div//div[@class='ng-trigger ng-trigger-animation ng-tns-c204-7 p-dialog p-confirm-dialog p-component ng-star-inserted']");
	
	public program2Module(WebDriver driver) {
		this.driver=driver;
        }
	public void landProgramPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		wait.until(
	            ExpectedConditions.elementToBeClickable(clkProgramBtn));	        
		driver.findElement(clkProgramBtn).click();
//		String classPageName_Actual = driver.findElement(programPageName).getText();
//		return classPageName_Actual;
}
	
	public void clickProgramName() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement element1=wait.until(
	            ExpectedConditions.elementToBeClickable(clkArrowNextToProgram));	        
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
//		boolean up=driver.findElement(clkArrownUpProgName).isDisplayed();	
//		System.out.println("clkArrownUpProgName------"+up);
//		boolean down=driver.findElement(clkArrownDownProgName).isDisplayed();	
//		System.out.println("clkArrownDownProgName------"+down);
//		if(down==true) {
//			driver.findElement(clkArrownDownProgName).click();
//		}
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
		Assert.assertTrue(sortedList.equals(originalList));
		
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
		Assert.assertTrue(sortedList.equals(originalList));
		
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
		Assert.assertTrue(sortedList.equals(originalList));
		
	}
	
	public void setSearchProgName() {
		cr = new configReader();
        prop = cr.init_prop();
        System.out.println("Property------------->"+prop.getProperty("searchWholeWord"));
        WebElement txtsearchProgName=driver.findElement(txtsearch);
        txtsearchProgName.clear();
        txtsearchProgName.sendKeys(prop.getProperty("searchWholeWord"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement element2=wait.until(
	            ExpectedConditions.elementToBeClickable(clkArrowNextToProgram));	        
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);

		
	}
	
	public String searchResult() {
		
		String searchResultProgName=driver.findElement(resultProgramName).getText();
		System.out.println(searchResultProgName);
		return searchResultProgName;
	}
	
	public void setSearchProgDescription() {
		cr = new configReader();
        prop = cr.init_prop();
        System.out.println("Property------------->"+prop.getProperty("searchWholeWordProgDesc"));
        WebElement txtsearchProgName=driver.findElement(txtsearch);
        txtsearchProgName.clear();
        txtsearchProgName.sendKeys(prop.getProperty("searchWholeWordProgDesc"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement element2=wait.until(
	            ExpectedConditions.elementToBeClickable(clkArrowNextToProgDescription));	        
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);

		
	}
	
	public String searchResultProgDesc() {
		
		String searchResultProgDesc=driver.findElement(resultProgramDescription).getText();
		System.out.println(searchResultProgDesc);
		return searchResultProgDesc;
	}

	public void setSearchProgNameInvalid() {
		cr = new configReader();
        prop = cr.init_prop();
        System.out.println("Property------------->"+prop.getProperty("invalid"));
        WebElement txtsearchProgName=driver.findElement(txtsearch);
        txtsearchProgName.clear();
        txtsearchProgName.sendKeys(prop.getProperty("invalid"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement element2=wait.until(
	            ExpectedConditions.elementToBeClickable(clkArrowNextToProgram));	        
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);
		
	}
	
	public String searchResultProgNameInvalid() {
		
		String searchResultProgNameInvalid=driver.findElement(resultProgramNameZero).getText();
		System.out.println(searchResultProgNameInvalid);
		return searchResultProgNameInvalid;
	}
	
	
	public void clickOnWebelement(WebElement element, long waitTimeSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSecond));
		element= wait.until(ExpectedConditions.elementToBeClickable(element));
          element.click();
	}
	
	public void setSearchProgNamePartial() {
		cr = new configReader();
        prop = cr.init_prop();
        System.out.println("Property------------->"+prop.getProperty("searchPartialWord"));
        WebElement txtsearchProgName=driver.findElement(txtsearch);
        txtsearchProgName.clear();
        txtsearchProgName.sendKeys(prop.getProperty("searchPartialWord"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement element2=wait.until(
	            ExpectedConditions.elementToBeClickable(clkArrowNextToProgram));	        
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element2);
		
	}
	
	public void selectCheckBox() {
		WebElement selectCheckBoxOne=driver.findElement(selectCheckBox1);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
			WebElement element=wait.until(
		            ExpectedConditions.elementToBeClickable(selectCheckBoxOne));	        
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
			System.out.println(selectCheckBoxOne.isSelected());
			
			WebElement selectCheckBoxTwo=driver.findElement(selectCheckBox2);
			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); 
				WebElement element1=wait1.until(
			            ExpectedConditions.elementToBeClickable(selectCheckBoxTwo));	        
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
				System.out.println(selectCheckBoxTwo.isSelected());

	}
	
	public boolean selectedCheckBox() {
		boolean selectCheckBoxOne_Actual=driver.findElement(selectedCheckBox1).isSelected();
		System.out.println(selectCheckBoxOne_Actual);
		boolean selectCheckBoxTwo_Actual=driver.findElement(selectedCheckBox2).isSelected();
		System.out.println(selectCheckBoxTwo_Actual);
		boolean selected =selectCheckBoxOne_Actual && selectCheckBoxTwo_Actual;
		return selected;
	}
	
	public String valueOfCheckBox1() {
		String valueOfCheckBox1=driver.findElement(progNameCheckBox1).getText();
		System.out.println(valueOfCheckBox1);
		return valueOfCheckBox1;
	}
	public String valueOfCheckBox2() {
		String valueOfCheckBox2=driver.findElement(progNameCheckBox2).getText();
		System.out.println(valueOfCheckBox2);
		return valueOfCheckBox2;
	}
	
	public void delete() {
		driver.findElement(btnDelete).click();
	}
	
	public boolean msgConfirmDisplayed() {
		boolean confirm=driver.findElement(msgBoxConfirmDelete).isDisplayed();
		return confirm;
	}
}
