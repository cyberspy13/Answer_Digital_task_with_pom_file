package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Maven_Base.MavenBaseClass;

public class Test_3 extends MavenBaseClass{
	
	public WebDriver driver;
	
	@BeforeTest
	
	public void initializeWebDriver() throws IOException
	{
		driver = initializeDriver();
	}
	@Test
	public void test_3() throws InterruptedException
	{
		
		driver.get("http://automationpractice.com/index.php");
		String ActualValue = driver.getTitle();
		//System.out.println(ActualValue);
		
		Actions action = new Actions(driver);
		WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		
		action.moveToElement(women).build().perform();
		Thread.sleep(1000);
		
		WebElement womenDress = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]"));
		action.moveToElement(womenDress);
		action.click().build().perform();
		
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)", "");
        Thread.sleep(2000);
		WebElement priceSlider = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[1]"));
		
		for(int i = 0; i <= 24; i++)
		{
			priceSlider.sendKeys(Keys.ARROW_RIGHT);
		}
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "Summer Dresses - My Store";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println("Price range is changed to 20F");
	}
	@AfterTest
    public void quit(){
    	
    	driver.close();
    }
	

}
