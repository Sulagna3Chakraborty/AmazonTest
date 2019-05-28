package com.cleartrip.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.support.events.EventFiringWebDriver;


public class Base {
	public static WebDriver driver;
	public static Properties prop;
	//public  static EventFiringWebDriver e_driver;
	//public static WebEventListener eventListener;
	
	public Base(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\eclipse-workspace\\AmazonTest\\src\\main\\java\\com\\cleartrip\\qa\\configFile\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() throws Exception{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			//DesiredCapabilities cap=DesiredCapabilities.chrome();
			//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver", "D:/Selenium_all software/chrome/chromedriver_win32/chromedriver.exe");
Map<String, Object> prefs = new HashMap<String, Object>();
            
            // Set the notification setting it will override the default setting
	prefs.put("profile.default_content_setting_values.notifications", 2);

            // Create object of ChromeOption class
	ChromeOptions options = new ChromeOptions();

            // Set the experimental option
	options.setExperimentalOption("prefs", prefs);

            // pass the options object in Chrome driver
			driver = new ChromeDriver(options); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("site"));
		
		
		
		
;

		
	}
	
	
	
	
	
	
	
	

}


