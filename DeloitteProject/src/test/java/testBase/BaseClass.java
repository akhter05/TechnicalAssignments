package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
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
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties prop;

	@BeforeClass(groups = { "sanity", "regression", "datadriven", "master" })
	@Parameters({ "browser", "os" })
	public void setup(String br, String os) {
		try {
			FileReader file = new FileReader("./src//test//resources//config.properties");
			prop = new Properties();
			prop.load(file);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger = LogManager.getLogger(BaseClass.class);

		if (prop.getProperty("RunEnvironment").equalsIgnoreCase("remoteGrid")) {
			DesiredCapabilities cap = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			} else {

				System.out.println("Operating system is not specified correctly");
				return;
			}

			switch (br.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;
			case "firefox":
				cap.setBrowserName("firefox");
				break;
			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.print("Invalid browser type");
				logger.error("Invalid browser type");
				return;
			}
			
			try {
				driver = new RemoteWebDriver(new URL(prop.getProperty("appURLRemote")),cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (prop.getProperty("RunEnvironment").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.print("Invalid browser type");
				logger.error("Invalid browser type");
				return;
			}

			
		} else {
			System.out.println("Run envirnment is not specified correctly");
			return;
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();

	}

	@AfterClass(groups = { "sanity", "regression", "datadriven", "master" })
	public void tearDown() {
		driver.close();
	}

	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File soureFile = takescreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		soureFile.renameTo(targetFile);
		return targetFilePath;

	}

	public String randomAlphaNumeric() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatedNumber = RandomStringUtils.randomAlphanumeric(3);
		return generatedString + generatedNumber;
	}

	public String randomNumeric() {
		String generatedNumber = RandomStringUtils.randomAlphanumeric(10);
		return generatedNumber;
	}

}
