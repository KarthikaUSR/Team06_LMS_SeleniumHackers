package comPages;



import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import comUtils.driverManager;
import comUtils.excelReader;
import comUtils.commonFunctions;
import comUtils.configReader;
import comUtils.tableUIvalidation;

import pojo.batchRecords;


public class batchModule {
	
	private  WebDriver driver;
	public commonFunctions comMethod ;
	public tableUIvalidation tableUI;
	public excelReader readbatch=new excelReader();
	 private static configReader cr;
	 private static Properties prop;
	   
	   

	

	By batchButton=By.xpath("//*[@class='ng-star-inserted']/button[2]");
	By classButton=By.xpath("//*[@routerlink='/session']");
	By pageName=By.xpath("//*[@class='ng-star-inserted']/button[2]/span[1]");
	By batchLabel=By.xpath("//*[@class='mat-card mat-focus-indicator']/mat-card-title/div[1]");
	By B_Delete = By.xpath("//*[@class='mat-card-title']/div[2]/div/button");
	By navigateStatus=By.xpath("//*[@class='p-paginator-pages ng-star-inserted']");
	By headerpath=By.xpath("//*[@class='p-datatable-thead']/tr/th");
	By checkboxui=By.xpath("//*[@class='p-datatable-tbody']/tr/td[1]/p-tablecheckbox");
	By editiconui=By.xpath("//*[@class='p-button-icon pi pi-pencil']");
	By deleteiconui=By.xpath("//*[@class='p-button-icon pi pi-pencil']");
	By checkboxvalidate=By.xpath("//*[@class='p-datatable-thead']/tr/th/p-tableheadercheckbox");
	By Overlaycontainer=By.xpath("//*[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']");
	By Addbatch = By.xpath("//*[@class='mat-menu-content ng-tns-c225-3']");
	By closebatch = By.xpath
			("//*[@class='ng-tns-c168-6 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']");
	By Addbatchheader= By.xpath("//*[@id='pr_id_2-label']");
	
	///Add batch locATORS
   	By batchprogramName= By.xpath("//*[@role='button']");
   	By batchprogmatch=By.xpath("//*[@id='programName']/div/input");
   	By batchprogdropdown=By.xpath("//*[@id='programName']/div/div[2]/span");
   	By batchproglist=By.xpath("//*[contains(@class,'p-dropdown-items ng-tns-c171')]/p-dropdownitem/li/span");
   	//*[contains(@class,'p-toast-summary ng-tns-c91')]
   	
   	By batchBName1= By.xpath("//*[@id='batchProg']");
   	By batchBName2= By.xpath("//*[@pattern='^[0-9]{0,5}$']");  			
   	By batchDesc= By.xpath("//*[@id='batchDescription']");
   	By batchstatusActive= By.xpath("//*[@ng-reflect-input-id='ACTIVE']");
	By batchstatusInavtive= By.xpath("//*[@ng-reflect-input-id='INACTIVE']");
   	By batchNoOfClass= By.xpath("//*[@id='batchNoOfClasses']");
   	By batchCancelbutton= By.xpath("//*[@label='Cancel']']");
   	By batchSavebutton= By.xpath("//*[@label='Save']");
   	By BatchTxt=By.xpath("//*[text()='Batch']");
   	By Searchbatch=By.xpath("//*[@id='filterGlobal']");
   	By reacordtxt=By.xpath("//*[@class='p-datatable-tbody']/tr[1]/td[2]");
   	
   	By SuccessMSg=By.xpath("//*[contains(@class,'p-toast-message-content ng-tns-c91')]");
 	By SuccessMSgclose=By.xpath("//*[contains(@class,'p-toast-icon-close-icon pi pi-times na-†ns-c91')]");
 	By Session =By.xpath("//*[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']");
 	
  // /Add batch locATORS close
 	//search
 	By SearchTxt=By.xpath("//*[@id='filterGlobal']");
	By SearchtxtinGrid=By.xpath("//*[@class='p-datatable-tbody']/tr/td[2]");
 	
	
	
	//constructor
	public batchModule(WebDriver driver) {
        this.driver = driver;
        this.comMethod = new commonFunctions(driverManager.getDriver(), 20);
        this.tableUI= new tableUIvalidation(driverManager.getDriver());
       

		}

	public void landbatchpage() {
		WebElement batchbutton=comMethod.elementToBeClickable(batchButton);        
		batchbutton.click();
		
	}
	public String checkBatchpage() {
		//landbatchpage();//remove later
		String label=driver.findElement(pageName).getText();
		return label;
		
	}
	
	public String labelBatch() {
		WebElement pagename=comMethod.visibilityOfElementLocated(pageName);
		String label=pagename.getText();
		return label;
		
	}
	public String batchheading() {
		
		WebElement batchlabel=comMethod.visibilityOfElementLocated(batchLabel);
		String label=batchlabel.getText();
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

	public boolean H_deleteIcon()
	{
		WebElement deleteicon=comMethod.visibilityOfElementLocated(B_Delete);
        return deleteicon.isDisplayed();
	}
	public boolean pageNavigate()
	{
		WebElement navigateState=comMethod.visibilityOfElementLocated(navigateStatus);
        return navigateState.isEnabled();
	}
	
	public List<WebElement> getNonCheckboxElements() {
        // Use CSS selector to select non-checkbox input elements, textarea, and select
        return driver.findElements(By.cssSelector("input:not([type='checkbox']), textarea, select"));
    }
	
	public boolean tableHeaders()

	{
		
		List<WebElement> headerelements= comMethod.visibilityOfAllElementsLocated(headerpath);
        List<String> Headers = Arrays.asList("Batch Name", "Batch Description", "Batch Status", "No Of Classes","Program Name", "Edit / Delete");
       boolean headerresult= tableUI.tableHeaders(headerelements,Headers);
       return headerresult;
	}
	public boolean checkBox()

	{
		List<WebElement> checkboxUI=comMethod.visibilityOfAllElementsLocated(checkboxui);
		 boolean checkboxstatus= tableUI.tableRowUIElements(checkboxUI);
        return checkboxstatus;
	}
	public boolean editIcon()

	{
		
		List<WebElement> editiconUI=comMethod.visibilityOfAllElementsLocated(editiconui);
		System.out.println("Size edit : "+editiconUI.size());
		 boolean editiconstatus= tableUI.tableRowUIElements(editiconUI);
        return editiconstatus;
	}
	public boolean deleteIcon()

	{
		List<WebElement> deleteiconUI=comMethod.visibilityOfAllElementsLocated(deleteiconui);
		 boolean deleteiconstatus= tableUI.tableRowUIElements(deleteiconUI);
        return deleteiconstatus;
	}
	public boolean sortIcon()

	{
		List<WebElement> sorticonUI=comMethod.visibilityOfAllElementsLocated(deleteiconui);
		 boolean sorticonstatus= tableUI.tableRowUIElements(sorticonUI);
        return sorticonstatus;
	}
	
	//method for Addclick
	
	public void batchaddclick() {
		

		WebElement Add=comMethod.presenceOfElementLocated(Addbatch);
		
		Add.click();
		
	}
	//method for closeaddclick
	
		public void batchaddclose() {

			WebElement Addclose=comMethod.presenceOfElementLocated(closebatch);
			
			Addclose.click();
			
			
		}
	
	
	public boolean checkboxvalidate()  {
		
		
		batchaddclick();
		batchaddclose();
		
		WebElement checkAll=comMethod.elementToBeClickable(checkboxvalidate);
		
		checkAll.click();
		List<WebElement> checkboxUI=comMethod.visibilityOfAllElementsLocated(checkboxui);
		for(WebElement e:checkboxUI)
		{
			comMethod.visibilityOfAllElementsLocated(checkboxui);
			
        	if(!e.isSelected()) {
        	    System.out.println("checkbox  is not checked in row No: ");
        	    return false;
            }
		}
		return true;
	}


//Add Batch

		public String addbatchUI()  {
			
			landbatchpage();
			WebElement Add=comMethod.presenceOfElementLocated(Addbatch);
			
			String name=Add.getText();
			
			return name;
			
		}
       public String addbatchpopup()  {
    	 batchaddclick();
   		     
   		WebElement batchheader=comMethod.presenceOfElementLocated(Addbatchheader);
   		String name=batchheader.getText();
   		batchaddclose();
		return name;
			
		}
 // manual add batch
    
    

   	
  /* 	public String addbatchmanual(){
   		
		WebElement Batch_tag=comMethod.presenceOfElementLocated(BatchTxt);
		Batch_tag.click();
		batchaddclick();
		WebElement batch_progmatch=comMethod.presenceOfElementLocated(batchprogmatch);
		batch_progmatch.clear();
		WebElement batchprog_dropdown=comMethod.presenceOfElementLocated(batchprogdropdown);
		batchprog_dropdown.click();
		List<WebElement> BatchpageProgList=comMethod.presenceOfElementsLocated(batchproglist);
		System.out.println("BatchpageProgList Size: "+BatchpageProgList.size());
		// Iterate through options and add text to the list
		for(int i=0;i<=BatchpageProgList.size()-1;i++) {
			   String B_ProgName=BatchpageProgList.get(i).getText();
			   System.out.println("BatchpageProgList: "+B_ProgName);
			   if(B_ProgName.equalsIgnoreCase("ChatBotTestuk")) {
			   BatchpageProgList.get(i).click();
			   break;
			   }
			   
		}
		//sendKeys("ChatBotTest");
		WebElement batchB_Name2=comMethod.presenceOfElementLocated(batchBName2);
		//batchB_Name2.click();
		batchB_Name2.sendKeys("15");
		WebElement batch_Desc=comMethod.visibilityOfElementLocated(batchDesc);
		batch_Desc.sendKeys("XXXXX");
		WebElement batchstatus_Active=comMethod.elementToBeClickable(batchstatusActive);
		batchstatus_Active.click();
		WebElement batch_NoOfClass=comMethod.presenceOfElementLocated(batchNoOfClass);
		batch_NoOfClass.sendKeys("5");
		//batchprogramName.sendKeys("ChatBotTest");
		WebElement batch_Savebutton=comMethod.elementToBeClickable(batchSavebutton);
		batch_Savebutton.click();	
		WebElement Succesmsg=comMethod.presenceOfElementLocated(SuccessMSg);
		String s=Succesmsg.getText();
		return s;
			
}
   	*/

    // close manual add 	
   	
   	
 /// auto add batch start  	
   	public  String addbatch(String Pname) throws IOException
   	{
   		
   		List<batchRecords> batchRecordlist = new ArrayList<>();
   		batchRecordlist=readbatch.readExcel_LMSPrograms(Pname);
   		
   		try {
   			if(batchRecordlist!=null) {
   		
   	   for(batchRecords record:batchRecordlist) {
   	   landbatchpage();
	   batchaddclick();
	   WebElement batch_progmatch=comMethod.presenceOfElementLocated(batchprogmatch);
	   batch_progmatch.clear();
	   WebElement batchprog_dropdown=comMethod.presenceOfElementLocated(batchprogdropdown);
	   batchprog_dropdown.click();
	   List<WebElement> BatchpageProgList=comMethod.presenceOfElementsLocated(batchproglist);
	   System.out.println("BatchpageProgList Size: "+BatchpageProgList.size());
	   // Iterate through options and add text to the list
       for(int i=0;i<=BatchpageProgList.size()-1;i++) {
    	   String B_ProgName=BatchpageProgList.get(i).getText();
    	   System.out.println("BatchpageProgList: "+B_ProgName);
    	   if(B_ProgName.equalsIgnoreCase(record.getProgramName())) {
    	   BatchpageProgList.get(i).click();
    	   break;
    	   }
         
       }
	   
       //Log.info("Batch Extracted from the excel");
	   WebElement batchB_Name2=comMethod.presenceOfElementLocated(batchBName2);
	   //batchB_Name2.click();
	   batchB_Name2.sendKeys(record.getBatchName());
	   //Log.info("batch no is entering");
	   WebElement batch_Desc=comMethod.visibilityOfElementLocated(batchDesc);
	   batch_Desc.sendKeys(record.getDescription());
	   WebElement batchstatus_Active=comMethod.elementToBeClickable(batchstatusActive);
	   batchstatus_Active.click();
       WebElement batch_NoOfClass=comMethod.presenceOfElementLocated(batchNoOfClass);
       batch_NoOfClass.sendKeys(record.getNoOfClass());
	   //batchprogramName.sendKeys("ChatBotTest");
	   WebElement batch_Savebutton=comMethod.elementToBeClickable(batchSavebutton);
	   batch_Savebutton.click();
   	   }
   			}
   			}
   			catch(Exception e)
   			{
   				System.out.println("Record completed");
   			}
   		String Succes_msg=handlealert();
	   
  	   return Succes_msg;
		
	}
   	
   	public String handlealert()
   	{
   		By toastLocator = By.cssSelector("div.p-toast-message-content[role='alert']");

        // Wait for the toast to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));

        // Retrieve and print the toast message text
        String toastMessage = toastElement.getText();
        System.out.println("Toast Message: " + toastMessage);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
		return toastMessage;
   	}
   	
   	
   	public  void classtabclick()
   	{
   		
   	 WebElement class_Button=comMethod.elementToBeClickable(classButton);
   	 class_Button.click();
   		
   		
   	}
   	
   	public void searchtext()
   	{cr = new configReader();
    prop = cr.init_prop();
   	   JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("document.elementFromPoint(0, 0).click();");
   		WebElement Searchtext=comMethod.presenceOfElementLocated(SearchTxt);
   		Searchtext.click();
   		Searchtext.sendKeys(prop.getProperty("batchsearchtext"));
   	}
   	public boolean searchtextvalidation()
   	{
   		
   		cr = new configReader();
	    prop = cr.init_prop();
   		List<WebElement> searchingrid=comMethod.visibilityOfAllElementsLocated(SearchtxtinGrid);
		    
   		    if (searchingrid == null || searchingrid.isEmpty()) {
   		        System.out.println("Grid is null or empty");
   		        return false;
   		    }
          String expectedText = prop.getProperty("batchsearchtext");
   		    if (expectedText == null) {
   		        System.out.println("Property 'batchsearchtext' is null");
   		        return false;
   		    }
   		    
   		    for (WebElement e : searchingrid) {
   		        String text = e.getText();
   		        
   		        
   		        if (!text.equalsIgnoreCase(expectedText)) {
   		            System.out.println("Searched text  failed ");
   		            return false;
   		        }
   		    }
   		    return true;
   		}
   		
   		
   		
   		
   		
   	
   	
   	
   	
   	
  
       
}

