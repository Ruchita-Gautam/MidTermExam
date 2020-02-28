package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h1[text()='Dashboard']") WebElement PageTitle;
	@FindBy(how = How.XPATH, using = "//input[@name='post_title']") WebElement AddTitle;
	@FindBy(how = How.ID, using = "content") WebElement AddContent;
	@FindBy(how = How.ID, using = "save-post") WebElement SaveDraft;
	@FindBy(how = How.XPATH, using = "//*[@id='dashboard_quick_press']/descendant::a[contains(text(),'Mid Term')]") WebElement MyRecentDraft;
	@FindBy(how = How.XPATH, using = "//li[@id='menu-posts']/descendant::div[contains(text(),'Posts')]") WebElement PostsMenu;
	@FindBy(how = How.XPATH, using = "//li[@id='menu-posts']/descendant::a[contains(text(),'All Posts')]") WebElement AllPosts;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Mid Term')]") WebElement PostInTable;
	
	public void waitForPage() {
		waitForElement(PageTitle, driver);
	}
	
	public void addTitleDetails(String Title) {
		AddTitle.sendKeys(Title);
	}
	
	public void addContentDetails (String Content) {
		AddContent.sendKeys(Content);
	}
	public void clickOnSaveDraft() {
		SaveDraft.click();
	}
	
	public String validateMyRecentDraft() {
		return MyRecentDraft.getText();
	}
	
	public void clickPosts() {
		PostsMenu.click();
		AllPosts.click();
	}
	
	public boolean isDraftPostedOnTable() {
		return PostInTable.isDisplayed();	
	}
	
	public boolean isDashboardDisplayed() {
		try {
			waitForPage();
			return true;
		} catch (Exception e) {

		}
		return false;
	}
		
}
