package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BaseAdapter;


public class LaunchPage extends BaseAdapter{
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath="//button[text()='Start a chat']")
	WebElement startChat;
	
	@FindBy(xpath="//button[text()='Join Call']")
	WebElement joinCall;
	
	@FindBy(xpath="//span[text()='Invite']")
	WebElement inviteButton;
	
	public LaunchPage() {
		this.driver = init();
		PageFactory.initElements(driver, this);
	}
	
	public void joinClass() throws InterruptedException {
		startChat.click();
		joinCall.click();
		Thread.sleep(2000);
	}
	
	public String getLandingPageURL() {
		return driver.getCurrentUrl();
	}
}
