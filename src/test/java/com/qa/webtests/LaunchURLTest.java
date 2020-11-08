package com.qa.webtests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.BaseAdapter;
import com.qa.pages.LaunchPage;

public class LaunchURLTest extends BaseAdapter
{
	WebDriver driver;
	LaunchPage launchPage = new LaunchPage();
	
	public LaunchURLTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		this.driver = getDriver();
	}
	
	@AfterMethod
	public void tearDownBrowser() {
		tearDown();
	}
	
	@Test
	public void callJoinTest() throws InterruptedException {
		launchPage.joinClass();
		// After Joining class, getting the classroom URL
		System.out.println(launchPage.getLandingPageURL());
	}
	
}