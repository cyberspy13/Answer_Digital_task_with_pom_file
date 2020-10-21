package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Maven_Base.MavenBaseClass;

public class Test_2 extends MavenBaseClass{
	
	public WebDriver driver; 
	
	@BeforeTest
	public void initializeWeDriver() throws IOException
	{
		driver = initializeDriver();
	}
	@Test
	public void test_2() throws InterruptedException
	{ 
		driver.get("http://automationpractice.com/index.php");
		//String ActualValue = driver.getTitle();
		//System.out.println(ActualValue);
		
		Actions action = new Actions(driver);
		WebElement women = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		
		action.moveToElement(women).build().perform();
		Thread.sleep(1000);
		
		WebElement womenDress = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]"));
		action.moveToElement(womenDress);
		action.click().build().perform();
		
		Thread.sleep(2000);
		
		String ActualTitle = driver.getTitle();
		//FSystem.out.println(ActualTitle);
		//String ExpectedTitle = "Summer Dresses - My Store";
		//Assert.assertEquals(ExpectedTitle, ActualTitle);
		System.out.println("Summer collection displayed on the screen");
	}
	@AfterTest
   public void quit(){
    	
		driver.close();
		//driver.quit();
    }

	

}
