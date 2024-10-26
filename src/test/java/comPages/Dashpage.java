package comPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashpage {
private By dashboard=By.xpath("//*[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']");
private By lms=By.xpath("//span[contains(.,'LMS - Learning Management System')]");
private By program=By.cssSelector("#program");
private By batch=By.xpath("//span[@class='mat-button-wrapper' and text()='Program']");
private 
WebDriver driver;
public Dashpage(WebDriver driver) {
	this.driver=driver;
}

}
