package Tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Maven_Base.MavenBaseClass;

public class Test_1 extends MavenBaseClass{

	public WebDriver driver;
	
	@BeforeTest
	public void initializeWebDriver() throws IOException
	{
		driver = initializeDriver();
	}
@Test
public void test_1() throws InterruptedException
{
	driver.get("http://automationpractice.com/index.php");
	String ActualValue = driver.getTitle();
	//System.out.println(ActualValue);
	
	driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
	driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
	String ActualValuePage = driver.getTitle();
	//System.out.println(ActualValuePage);
	String actualPageTitle = "Order - My Store";
	
	if(ActualValuePage.equals(actualPageTitle))
	{
		Thread.sleep(2000);
		driver.findElement(By.id("1_1_0_0")).click();
	}
	Thread.sleep(3000);
	String ki = driver.findElement(By.xpath("//p[contains(text(),'Your shopping cart is empty.')]")).getText();
	System.out.println(ki);
}
	@AfterTest
	public void afterTest()
	{
		driver.close();
		//driver.quit();
	}
	
}
