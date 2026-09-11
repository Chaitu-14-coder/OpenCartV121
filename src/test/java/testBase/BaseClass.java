package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
public WebDriver driver;
public Logger logger;
public Properties p;
	
    @Parameters({"os","browser"})
	@BeforeClass(groups = {"Sanity","Master","Regression"})	
	public void setUp(String os , String browser) throws IOException {
		logger=LogManager.getLogger(this.getClass());
		
		//Loading the config.properties file
		FileReader file = new FileReader("./src//main//java//Config.properties");
		p=new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("Remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else {
				System.out.println("No Maching Os Found");
				return;
			}
			//browser
			switch (browser.toLowerCase()) {
			case "chrome":capabilities.setBrowserName("chrome");break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox":capabilities.setBrowserName("firefox");break;
			default:System.out.println("Invalid Browser Name");return;		
		}
			driver=new RemoteWebDriver(new URL("http://192.168.0.103:4444/wd/hub"),capabilities);
			
 }
		
	  if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		//driver=new ChromeDriver();
		switch (browser.toLowerCase()) {
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:System.out.println("Invalid Browser Name");return;
		}
	}
		   
	    driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
	}		
	
	@AfterClass(groups = {"Sanity","Master","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		 String genertatedString=RandomStringUtils.randomAlphabetic(5);
		 return genertatedString;
		}
		public String randomNumeric() {
			String genertatedNumber=RandomStringUtils.randomNumeric(10);
			 return genertatedNumber;
		}
		public String randomAlphNumeric() {
			String genertatedString=RandomStringUtils.randomAlphabetic(5);
			String genertatedNumber=RandomStringUtils.randomNumeric(10);
			return (genertatedString + "@"+genertatedNumber);
		} 
		
		public String captureScreen(String tname) throws IOException {

	        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
	        File targetFile = new File(targetFilePath);

	        sourceFile.renameTo(targetFile);

	        return targetFilePath;
	    }


}
