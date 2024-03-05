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
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseClass {
	
static public WebDriver driver;
static Properties p;
public static Logger logger;

ChromeOptions options = new ChromeOptions();
EdgeOptions option=new EdgeOptions();

	@BeforeTest(groups= {"sanity","regression","master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		 
		 //Logger
		 logger=LogManager.getLogger();
		 
		 if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			 DesiredCapabilities capabilities=new DesiredCapabilities();
			 //os
			 if(os.equalsIgnoreCase("windows")) {
				 capabilities.setPlatform(Platform.WIN11);
			 }
			 else if(os.equalsIgnoreCase("mac")) {
				 capabilities.setPlatform(Platform.MAC);
			 }
			 else
			 {
				System.out.println("NO Matching OS..");
				return;
			 }
			 
			 switch(br.toLowerCase()) {
			 case "chrome": capabilities.setBrowserName("chrome");
			 options.addArguments("--disable-blink-features=AutomationControlled");
			 options.addArguments("--disable-notifications");
			 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			 break;
			 case "edge": capabilities.setBrowserName("MicrosoftEdge");
			 option.addArguments("--disable-blink-features=AutomationControlled");
			 option.addArguments("--disable-notifications");
			 capabilities.setCapability(EdgeOptions.CAPABILITY, option);
			 break;
			 default: System.out.println("No matching browser..");return;
			 }
			 
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities); 
		 }
		 
		 else if(p.getProperty("execution_env").equalsIgnoreCase("local"));{
			 
		switch(br.toLowerCase())
		{
		case "chrome": 
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
		logger.info("Chrome Browser is Opened.......................");
		break;
		case "edge": 
			option.addArguments("--disable-blink-features=AutomationControlled");
			option.addArguments("--disable-notifications");
			driver=new EdgeDriver(option);
		
		logger.info("Edge Browser is Opened.......................");
		break;
		
		default: System.out.println("No matching browser..");
		logger.info("Browser Not available.......................");
					return;
		}
		 }
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	} 
	
	@AfterTest(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public static String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

}
