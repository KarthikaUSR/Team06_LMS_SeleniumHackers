package comPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	private By userNameField = By.xpath("//input[@id='username']");
	private By passwordField = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//button[@id='login']");
	
	////button[@id='login']

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(userNameField).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	
	// Method that combines login actions
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
	
}
