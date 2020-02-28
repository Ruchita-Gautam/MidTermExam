package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	public LoginPage (WebDriver driver) {	
		this.driver = driver;		
	}
	
	@FindBy(how = How.ID, using = "user_login") WebElement UserName;
	@FindBy(how = How.ID, using = "user_pass") WebElement Password;
	@FindBy(how = How.ID, using = "wp-submit") WebElement LogInButton;
	
	public void enterUserName (String userName) {
		UserName.sendKeys(userName);
	}
	public void enterPassword (String password) {
		Password.sendKeys(password);
	}
	public void clickLogIn () {
		LogInButton.click();
	}
	public String getTheTitle() {
		return driver.getTitle();
		
	}
}
