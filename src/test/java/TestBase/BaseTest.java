package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j

public class BaseTest {
	public static WebDriver driver;
	public Logger logger; // log4j
	public Properties p;

	@Parameters({ "OS", "browser" })
	@BeforeClass(groups = { "regression", "datadrivern", "sanity", "Master","tc004","tc005" })
	public void setUp(String os, String br) throws IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");

		p = new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		 
		if(os.equalsIgnoreCase("window")) {
			capabilities.setPlatform(Platform.WIN11);
		}
		else if (os.equalsIgnoreCase("mac")) {
			capabilities.setPlatform(Platform.MAC);
		}else {
			System.out.println("No Matching OS");
		}
		switch (br.toLowerCase()) {

		case "chrome":
			 capabilities.setBrowserName("chrome");
			break;

		case "edge":
			 capabilities.setBrowserName("MicrosoftEdge");
			break;

		default:
			System.out.print("No Matching Brwser IN REMOTE");
			return;

		}
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		if(p.getProperty("execution_env").equalsIgnoreCase("local")){
			
		
		switch (br.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;

		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.print("Browser Problem");
			return;

		}
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(p.getProperty("appURL")); // Reading From Property File...
		driver.manage().window().maximize();
	}

	@AfterClass(groups = { "regression", "datadrivern", "sanity", "Master","tc004" ,"tc005"})
	public void teardown() {
		driver.quit();
	}

	public String RandomString() {
		return RandomStringUtils.randomAlphabetic(7);

	}

	public String RandomInteger() {
		return RandomStringUtils.randomNumeric(10);

	}

	public String RandomAlphanumric() {
		return RandomStringUtils.randomNumeric(3) + RandomStringUtils.randomAlphabetic(3);

	}

	public String captureScreenShot(String tname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyy.MM.HH.mm.ss").format(new Date());
		TakesScreenshot tss = (TakesScreenshot) driver;
		File sourcefile = tss.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timestamp;
		File targetfile = new File(targetFilePath);
		
		sourcefile.renameTo(targetfile);
		return targetFilePath;
	}
}
