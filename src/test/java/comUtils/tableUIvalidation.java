package comUtils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tableUIvalidation {

	private WebDriver driver;

    public tableUIvalidation(WebDriver driver) {
        this.driver = driver;
    }

    // Validation of headers in the table
    public boolean tableHeaders(List<WebElement> e,List<String> headerName) {
        if(e!=null) {
        for (int i = 1; i < e.size()-1; i++) {
            String actualHeader = e.get(i).getText().trim();
            if (!actualHeader.equals(headerName.get(i-1))) {
                System.out.println("Header mismatch in " + (i) + ". Expected Header : " 
                                   + headerName.get(i) + ", Actual Header : " + actualHeader);
                return false;
            }
        }}
        else
        {
        	System.out.println("No Elements found");
        }
        return true; // All headers match
    }

    // Validate presence of UI elements in each row (e.g., edit icon, checkbox)
    public boolean tableRowUIElements(List<WebElement> icons) {

        boolean alliconsValid = true;
       // Check if the edit icon is present
        for(int i=0;i<=icons.size()-1;i++)
		{
        	if(!icons.get(i).isDisplayed()) {
        	    System.out.println("Icon  is not visible in row No: " +i);
        	    alliconsValid = false;
            }
		}
         return alliconsValid;
    }
}
