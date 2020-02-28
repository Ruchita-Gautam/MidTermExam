package test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		driver = BrowserFactory.startBrowser();
	}

	@Test(priority = 1)
	public void userShouldBeAbleToCreateDraft() throws InterruptedException {

		driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName("opensourcecms");
		loginPage.enterPassword("opensourcecms");
		loginPage.clickLogIn();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		Random random = new Random();
		int randomNumber = random.nextInt(999);
		String expectedTitleEntered = "Mid Term" + randomNumber;
		dashboardPage.addTitleDetails(expectedTitleEntered);
		dashboardPage.addContentDetails("Hi There, This is my mid term exam!!");
		dashboardPage.clickOnSaveDraft();

		Thread.sleep(2000);

		dashboardPage.waitForPage();

		String actualTitleEntered = dashboardPage.validateMyRecentDraft();
		Assert.assertEquals(actualTitleEntered, expectedTitleEntered, "Draft Not Created");

		Thread.sleep(2000);

		dashboardPage.clickPosts();

		Thread.sleep(2000);

		dashboardPage.isDraftPostedOnTable();

		System.out.println("Draft found in the table - " + expectedTitleEntered);
	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}
}