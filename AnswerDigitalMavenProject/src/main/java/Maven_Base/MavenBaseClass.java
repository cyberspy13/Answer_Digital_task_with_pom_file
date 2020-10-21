package Maven_Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MavenBaseClass {

	public WebDriver driver;
	public Properties proper;
	
	
	public WebDriver initializeDriver() throws IOException
	{
		proper = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\properties");
		proper.load(file);
		String browserName = proper.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium\\\\drivers\\\\chromedriver_86\\\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browserName.contains("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\\\Selenium\\\\drivers\\\\geckodriver_update\\\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else
		{
			System.out.println("Driver are not found");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
		
		
		
	
	}
}
