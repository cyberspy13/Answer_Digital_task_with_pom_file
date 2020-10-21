package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Maven_Base.MavenBaseClass;

public class Test_4 extends MavenBaseClass{
	
	public WebDriver driver;
	
	@BeforeTest
	
	public void initializeWebDriver() throws IOException
	{
		driver = initializeDriver();
	}

	@Test
	public void test_4() throws InterruptedException
	{
		driver.get("http://automationpractice.com/index.php");
		
		String pageTitle = driver.getTitle();							 
		//System.out.println("The title of this page is ===> " +pageTitle);
		
		
		
		//if you want to make this past you need to change email every time when you doing the test because the system is giving an error.
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys("mlecwwari_1@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(1000);
		
		WebElement radioButton = driver.findElement(By.id("id_gender1"));
		radioButton.click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Mihail");
		driver.findElement(By.id("customer_lastname")).sendKeys("Lecari");
		driver.findElement(By.id("passwd")).sendKeys("Thursday08");
		
		Select day = new Select(driver.findElement(By.id("days")));
		day.selectByValue("14");
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByValue("1");
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("1988");
		
		WebElement checkNewsletterBox = driver.findElement(By.id("newsletter"));
		for(int i = 0; i < 1;i++)
		{
			checkNewsletterBox.click();
			System.out.println(checkNewsletterBox.isSelected());
		}
		
		WebElement checkSpecialOffersBox = driver.findElement(By.id("optin"));
		for(int i = 0; i < 1;i++)
		{
			checkSpecialOffersBox.click();
			System.out.println(checkNewsletterBox.isSelected());
		}
		
		driver.findElement(By.id("firstname")).sendKeys("Mihail");
		driver.findElement(By.id("lastname")).sendKeys("Lecari");
		driver.findElement(By.id("company")).sendKeys("DriftersLodge");
		driver.findElement(By.id("address1")).sendKeys("18404 Sterling Hwy Cooper Landing, Alaska , United States");
		driver.findElement(By.id("city")).sendKeys(" Cooper Landing ");
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByValue("2");
		driver.findElement(By.id("postcode")).sendKeys("99572");
		Select country = new Select(driver.findElement(By.id("id_country")));
		country.selectByValue("21");
		driver.findElement(By.id("other")).sendKeys("No additional information");
		driver.findElement(By.id("phone")).sendKeys("+(907)891-8720");
		driver.findElement(By.id("phone_mobile")).sendKeys("+(907)891-8720");
		driver.findElement(By.id("alias")).sendKeys("Drifters Lodge");
		driver.findElement(By.id("submitAccount")).click();
		
		System.out.println("The registration form is complete");
	}
	@AfterTest
    public void quit(){
    	
    	driver.close();
    }

}
