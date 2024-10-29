package comPages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import comUtils.ResuableMethods;
import comUtils.commonFunctions;
import comUtils.excelReader;
import pojo.ClassRecord;
import pojo.batchRecords;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClassModulePage extends ResuableMethods {

	WebDriver driver;
	private Actions driverActions;
	private commonFunctions comFuntion;
	public excelReader readclass = new excelReader();

	By EditButton = By.xpath("//button[@class = 'p-button-rounded p-button-success p-button p-component p-button-icon-only']");
	public By menuBarclass = By.xpath("//span[text()= 'Class']");
	// webElement menuBarclass = driver.findElement(menuBarclass);
	By ClassButton = By.xpath("//*[@class='ng-star-inserted']/button[3]");
//	List<WebElement> Rows = (List<WebElement>) By.xpath("//tr") ;
	By classDelete = By.xpath("//span[@class='p-button-icon pi pi-trash']");
	By deletePopup = By.xpath("//span[@class='p-button-icon pi pi-trash']");
	By deleteNoBtn    =     By.xpath("//span[contains(text(),'No')]");
	By deleteYesBtn  =  By.xpath("//span[contains(text(),'Yes')]");
	By succesfulMessasge = By.xpath("//*[text()='Successful']");
	By userDeleteMessage= By.xpath("//*[text()='User Deleted']");
	
	By CclassDetails = By.id("pr_id_3-label");
//	 WebElement popup = driver.findElement(By.xpath("//div[@class= 'ng-trigger ng-trigger-animation ng-tns-c168-7 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']"));
	By classDiscription = By.xpath("//input[@id='classDescription']");
	By SelectClassDate = By.xpath("//input[@id='icon']");
	By SatffName = By.xpath("//input[@class='p-dropdown-label p-inputtext ng-tns-c171-28 ng-star-inserted']");
	By Status = By.xpath("//lable[@class='requiredSession']");
	By Active = By.xpath("//*[text()=' Active ']");
	By Comment = By.xpath("//input[@id='classComments']");
	By Notes = By.xpath("//input[@id='classNotes']");
	By Recording = By.xpath("//input[@id='classRecordingPath']");
	By Save = By.id("saveClass");
	By Cancel = By.id("//*[text()='Cancel']");
	By crossButton = By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c168-7 pi pi-times']");
	By editSuccessmessage = By.xpath("//div[@class  = 'p-toast-message-text ng-tns-c91-67 ng-star-inserted']");
	By pageName = By.xpath("//*[@class='ng-star-inserted']/button[2]/span[1]");
    By titalBar = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
	By BatchNameField = By.id("batchName");
    By classTopicField = By.id("classTopic");
    By successMessage = By.xpath("//*[contains(@class,'p-toast-summary ng-tns-c91')]");
    By editCloseCross = By.xpath("By editCloseCross = By.xpath(//span[@class='p-dialog-header-close-icon ng-tns-c168-52 pi pi-times'])");
    By deleteClosecross= By.xpath("//span[@class='pi pi-times ng-tns-c204-53']");
    
	
    By SingleArrowbutton = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By lastPageIcon = By.xpath("//span[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	By paginationBottomText = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	By footerText = By.xpath("//span[@class='p-datatable-footer ng-star-inserted']");
	By screenFooterText = By.xpath("//span[@class='p-datatable-footer ng-star-inserted']");
    By DoubleArrowIcon = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']") ;
	
   
    
	// By SingleArrowbutton =
	// By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]");
	By nextPage = By.xpath("//button[text()='2']");
			//"//button [@class='p-paginator-page p-paginator-element p-link p-ripple ng-star-inserted p-highlight']");

    //constractor
	public ClassModulePage(WebDriver driver) {
		this.driver = driver;
		comFuntion = new commonFunctions(driver, 10);
	    driverActions = new Actions(driver);

	}

	public void landClassPage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ClassButton));
		driver.findElement(ClassButton).click();

	}

	public void clickOnEditbutton() {
		//Actions action = new Actions(driver);
		
		driverActions.doubleClick(driver.findElement(By.xpath(
				"//button[@class = 'p-button-rounded p-button-success p-button p-component p-button-icon-only']")))
				.build().perform();
	}
	
	public String alertText() {
		Alert alert = driver.switchTo().alert(); 
		alert.accept();
		return alert.getText();
		
	}
	
	public void clickOndeleteIcon() {
		//Actions action = new Actions(driver);
		driverActions.doubleClick(driver.findElement(classDelete))
				.build().perform();
	}
	
	public  By Deletealert() {
		driver.findElement(deletePopup);
//		driverActions.doubleClick(driver.findElement(deletePopup))
//		.build().perform();
//		
		return  deletePopup;
	}
	
	public WebElement deleletePopUpOptionNo() {
	 driver.findElement(deleteNoBtn);
		return (WebElement) deleteNoBtn;		
		}
	
	  public WebElement deleletePopUpOptionYes() {
			return (WebElement) deleteYesBtn;
				
		}
	  
	  public void ClickDeleteYesBtn() {
			clickOnWebelement(driver.findElement(deleteYesBtn), 20);
		}
	  
	  public void ClickDeleteNOBtn() {
			clickOnWebelement(driver.findElement(deleteNoBtn), 20);
		}
	  public void ClickOnClosebutton() {
			clickOnWebelement(driver.findElement(deleteNoBtn), 20);
		}
	  
	  public String getConfirmText() {
		  
		   String text = driver.findElement(deletePopup).getText();
		System.out.println("The confirmation text is: " + text);
		    return text;
		}
	  public boolean isSuccessDeleteMessageDisplayed() {
		   driver.findElement(succesfulMessasge);
	        return ((WebElement) succesfulMessasge).isDisplayed();
	    }
	  public String getSuccessDeleteMessageText()  {	  
	        String textsuccess=driver.findElement(succesfulMessasge).getText();
	        return textsuccess;
	    }
	  
	  public String getDeleteMessageText() {
		  WebElement deleteText = driver.findElement(userDeleteMessage);
	        return deleteText .getText();
	    }
	 
	  public boolean  classDeleteMessageDisplayed() {
		 WebElement message= driver.findElement(userDeleteMessage);
		   return message.isDisplayed();
	    }
	  
	  public void userDeleteSucess() {
			
			String footermsgforyes1=driver.findElement(footerText).getAttribute("innerText");
			System.out.println("this is after clicking yes to del  " +footermsgforyes1);
			String footerMsgforYes = null;
			int num1 = Integer.parseInt(footerMsgforYes.replaceAll("\\D", ""));
	        int num2 = Integer.parseInt(footermsgforyes1.replaceAll("\\D", ""));

	        Assert.assertEquals(num1, num2 + 1);
	    }
	  
	  

	public void clickOnWebelement(WebElement element, long waitTimeSecond) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSecond));
		System.out.println("clickOnWebelement wait started");
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("clickOnWebelement wait ended");
		element.click();
	}

	// validate one icon
	public void IEconVisiable(WebElement element) {
		if (element.isDisplayed()) {
			System.out.println("icon is visiable on UI");
		} else {
			System.out.println("icon is not visiable on UI");

		}
	}
	
	public void elementIsEnable(WebElement element) {
		if(element.isEnabled()) {
			System.out.println("icon is enable");
		} else {
			System.out.println("icon is not enabled");
		}

	}
	
	public void  BatchFieldIsEnable() {
		elementIsEnable(driver.findElement(BatchNameField));
		
	}
	
	public void  classTopicFieldIsEnable() {
		elementIsEnable(driver.findElement(classTopicField));
		
	}
	
	
	public void Editcrossbutton () {
		clickOnWebelement(driver.findElement(editCloseCross), 10);
	}
	
	public void EditSaveButton () {
		clickOnWebelement(driver.findElement(Save), 10);
	}
	
	public void message() {
		clickOnWebelement(driver.findElement(editSuccessmessage), 10);
	}
	
	
	public void deleteIconVisibilitty() {
		
	if(driver.findElement(classDelete).isEnabled()){
		System.out.println("delete icon is enabled");
	} 

		
	}
	

	
//	public void IconValidate(List<WebElement> element ) {
//		
//		for(WebElement row: Rows) {
//			 WebElement EditIcon = row.findElement(EditButton);
//			 if (EditIcon.isDisplayed()) {
//	                System.out.println("Edit icon is visible for this row.");
//	            } else {
//	                System.out.println("Edit icon is NOT visible for this row.");
//	            }
//			
//		}
//		
//	}

//	  
	
	 public boolean isUserConfirmPopUpDisplayed() {
	    	if((driver.findElement(deletePopup)).isDisplayed()) {
	    		System.out.println("User confirmation pop-up is displayed.");
	    		return true;
	    	}else 
	    	{
	    		System.out.println("User confirmation pop-up is not displayed.");
	    		return false;
	    	 
	    	    }
	    
	
		
		}
	
	
	public void PopupWindowVisiable() {
		Alert alert = driver.switchTo().alert();
		WebElement popup = driver.findElement(By.xpath("//div[@class= 'ng-trigger ng-trigger-animation ng-tns-c168-7 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']"));

		
		//System.out.println(popup.getText());
		if (popup.isDisplayed()) {
			if(popup.getText().contains("Class Details")) {
				
		   System.out.println("Popup is visible with class details.");
	        } else {
	            System.out.println("Popup is not visible.");
	        }
		}
	
		
		}

//	public void enterClassDiscription(String classDiscription) {
//		driver.findElement(ClassDiscription).sendKeys(classDiscription);
//	}
//
//	public void enterSelectClassDate(String selectClassDate) {
//		driver.findElement(SelectClassDate).sendKeys(selectClassDate);
//	}
//
//	public void enterSatffName(String satffName) {
//		driver.findElement(SatffName).sendKeys(satffName);
//	}
//
//	public void enterComment(String comment) {
//		driver.findElement(Comment).sendKeys(comment);
//	}
//
//	public void enterNotes(String notes) {
//		driver.findElement(Notes).sendKeys(notes);
//	}
//
//	public void enterRecording(String recording) {
//		driver.findElement(Recording).sendKeys(recording);
//	}

//	public void testMoveToNextPage() {
//		WebElement nextbutton = driver.findElement(SingleArrowbutton);
//		System.out.println("nextButton enabled = "+nextbutton.isEnabled());
//		if (nextbutton.isEnabled()) {
//			clickToArrow(nextbutton);
//			WebElement paginationBottomTextElement = driver.findElement(paginationBottomText);
//			String bottomText = paginationBottomTextElement.getText();
//			System.out.println("bottom text " +bottomText);
//			WebElement nextPageNumber = driver.findElement(nextPage);
//			Assert.assertEquals("2", nextPageNumber.getText());
//		} else {
//			// Verify that total records are 5 or less
//
//		}
//
//	}
	
	
//	public void testMoveToLastPage() {
//		WebElement lastPageIconElement = driver.findElement(lastPageIcon);
//		if (lastPageIconElement.isEnabled()) {
//			clickToArrow(lastPageIconElement);
//			WebElement paginationBottomTextElement = driver.findElement(paginationBottomText);
//			String bottomText = paginationBottomTextElement.getText();
//			
//			// Verify page showing last entries
//			String[] numbersInBottomText = bottomText.split("\\D+");
//			assertEquals(numbersInBottomText[1], numbersInBottomText[2]);
//			System.out.println("numbersInBottomText "+numbersInBottomText);
//			WebElement footer = driver.findElement(nextPage);
//			String expectedFooterText = "In total there are "+numbersInBottomText[2]+" classes";
//			assertEquals(footer.getText(), expectedFooterText);
//			//Assert.assertEquals("2", nextPageNumber.getText());
//		} else {
//			// Verify that total records are 5 or less
//
//		}
//
//	}

	public  void clickToArrow() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0 ,1000)");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;

		jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(SingleArrowbutton)); 
		
		clickOnWebelement(driver.findElement(SingleArrowbutton), 30);
		comFuntion.visibilityOfAllElementsLocated(SingleArrowbutton);
		if(!driver.findElement(SingleArrowbutton).isSelected()) {
    	    System.out.println("checkbox  is not checked in row No: ");
    	    
        }
		

		//driverActions.moveToElement(webElement).click().perform();
		//driverActions.click().perform();
		//clickOnWebelement(driver.findElement(SingleArrowbutton), 30);

	}
	
	public String footerText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500 ,1000)");
		String footerText= driver.findElement(titalBar).getText();
		
		return footerText;
     
       
	}

	
   	
    /// auto add batch start  	
   	public  String addClass(String Pname) throws IOException
   	{
   		
   		List<ClassRecord> classRecordlist = new ArrayList<>();
   		classRecordlist=readclass.readExcel_Class(Pname);
   	   for(ClassRecord record:classRecordlist) {

	   //Batch_tag.click();
	   clickOnEditbutton();
	    
	   //sendKeys("ChatBotTest");
	  
	  
	   //WebElement class_Discription= comFuntion.presenceOfElementLocated(classDiscription);
	 WebElement class_Discription= driver.findElement(classDiscription);
	   class_Discription.click();
	   class_Discription.clear();
	  // System.out.println("classDescription displayed "+class_Discription.isDisplayed() + " enabled "+class_Discription.isEnabled());
	   class_Discription.sendKeys(record.getClassDescription());
//	   WebElement Select_Class_Dates= comFuntion.visibilityOfElementLocated(SelectClassDate);
//	   driverActions.moveToElement(Select_Class_Dates);
//	   Select_Class_Dates.click();
//	   Select_Class_Dates.clear();
//	   Select_Class_Dates.sendKeys(record.getSelectClassDates());
	//   JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0 ,1000)");
	  
	   
	   WebElement staff_Name= comFuntion.elementToBeClickable(SatffName);
	   driverActions.moveToElement(staff_Name);
	   staff_Name.click();
	   staff_Name.clear();
	   staff_Name.sendKeys(record.getStaffName());
       WebElement comments= comFuntion.presenceOfElementLocated(Comment);
       driverActions.moveToElement(comments);
       comments.click();
      comments.sendKeys(record.getComments());
      WebElement notes= comFuntion.elementToBeClickable(Notes);
      driverActions.moveToElement(notes);
	   notes.click();
	   notes.clear();
	   notes.sendKeys(record.getNotes());
	   WebElement recording= comFuntion.elementToBeClickable(Recording);
	   driverActions.moveToElement(recording);
	   recording.click();
	   recording.clear();
	   recording.sendKeys(record.getRecording());
	   
      
      
//	   //batchprogramName.sendKeys("ChatBotTest");
//	   
//		//WebElement Succesmsgclose=comMethod.presenceOfElementLocated(SuccessMSgclose);
//	   	//Succesmsgclose.click();
//	   Actions actions = new Actions(driver);
//
//       WebElement Batch_tag=comFuntion.presenceOfElementLocated(batchButton);
//      
//       actions.click(Batch_tag);
//	   //WebElement batch_Button=comMethod.presenceOfElementLocated(batchButton);
//	   //batch_Button.click();
//	   
   		}
	   
   
	WebElement Succesmsg=comFuntion.presenceOfElementLocated(successMessage);
   	String Succes_msg=Succesmsg.getText();
		
	   
	   
	   return Succes_msg;
		
	}
   	
   	
    public  List<ClassRecord> readExcel_Class(String SheetName) throws IOException {
		 
 	   
 		String path = System.getProperty("user.dir")+"/src/test/resources/testData/Testdata.xlsx";
 		
 		File Excelfile = new File(path);
 		List<ClassRecord> classRecordlist = new ArrayList<>();
 		FileInputStream Fis = new FileInputStream(Excelfile);
 		XSSFWorkbook workbook = null;	
 		try {
 			workbook = new XSSFWorkbook(Fis);
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		System.out.println("Entered sheet in excel:"+SheetName);
 		if (SheetName != null && SheetName.trim().equalsIgnoreCase("Class")) {
 			classRecordlist = getClassRecordlist(workbook, SheetName);
 		} else {
 			System.out.println("Enter valid Sheetname");
 		}
 		try {
 			workbook.close();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		System.out.println("read batch list values : "+classRecordlist);
 		return classRecordlist;
 		}
   
  //sub method for numeric cell
    private String getCellData(Cell cell) {
      if (cell.getCellType() == CellType.NUMERIC) {
          return String.valueOf((int) cell.getNumericCellValue());
      } else {
          return cell.getStringCellValue().trim();
      }
  }
   
   
   
   
   private List<ClassRecord> getClassRecordlist(XSSFWorkbook workbook, String sheetName) throws IOException {
 	    List<ClassRecord> classRecordlist = new ArrayList<>();
 	     sheetName = sheetName.trim();
 	    XSSFSheet sheet = workbook.getSheet(sheetName);
 	     System.out.println("Last row index: " + sheet.getLastRowNum());
 	    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
 	        XSSFRow row = sheet.getRow(i);
 	        if (row != null) {
 	        	
 	            String ClassDescription = row.getCell(0) != null ? row.getCell(0).getStringCellValue().trim() : "";
 	            String SelectClassDates = row.getCell(1) != null ? getCellData(row.getCell(1)) : "";
 	            String StaffName = row.getCell(2) != null ? row.getCell(2).getStringCellValue().trim() : "";
 	            String Comments = row.getCell(3) != null ? getCellData(row.getCell(3)) : "";
 	            String Notes = row.getCell(4) != null ? getCellData(row.getCell(4)) : "";
 	            String Recording = row.getCell(5) != null ? getCellData(row.getCell(5)) : "";
 	           // classRecordlist.add(new ClassRecord(ClassDescription, SelectClassDates,  StaffName, Comments, Notes,Recording));
 	            classRecordlist.add(new ClassRecord(ClassDescription, SelectClassDates,  StaffName, Comments, Notes,Recording));
 	        }
 	    }
 	    workbook.close();
 	    return classRecordlist;
 	}
   
 }









	

