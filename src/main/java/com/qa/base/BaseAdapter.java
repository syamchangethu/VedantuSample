package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.constants.Constants;

public class BaseAdapter {
	
	public static WebDriver driver;
	public static Properties props;
	public static WebDriverWait wait;
	public static Actions actions;
	
	public BaseAdapter() {
		try {
			props=new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+
												"/src/main/java/com/qa/config/config.properties");
			props.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static WebDriver init() {
		String browser = props.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, Constants.EXPLICIT_TIMEOUT);
			actions = new Actions(driver);
		}
			
		else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait( Constants.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		//Loading the URL
		driver.get(props.getProperty("url"));
		return driver;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void tearDown() {	
		//Quitting the Browser after execution
		driver.quit();
	}
	
}
