package Tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Maven_Base.MavenBaseClass;


public class Test_5 extends MavenBaseClass {

	public WebDriver driver;

	@BeforeTest
	
	public void initializeWebDriver() throws IOException
	{
		driver = initializeDriver();
	}
	@Test
	public void test_5() throws InterruptedException
	{
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String pageTitle = driver.getTitle();							 
		System.out.println("The title of this page is ===> " +pageTitle);
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		driver.findElement(By.xpath("//*[@id=\"block_various_links_footer\"]/ul/li[4]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"map\"]/div[2]/table/tr/td[2]/button")).click();
		driver.findElement(By.id("addressInput")).sendKeys("Wes palm Beach");	
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/div[3]/button/span")).click();
        driver.
        TakesScreenshot screenShot =(TakesScreenshot)driver;
        File file = screenShot.getScreenshotAs(OutputType.FILE);
        try {
        	
        	FileUtils.copyFile(file, new File(".//Screenshot/Test_5.png"));
		
        	} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println("The  screenshot is taken");
        
        //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	}
	@AfterTest
    public void quit(){
    	
    	driver.close();
    }
}
