package com.cleartrip.qa.main;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.baseclass.Base;

public class LoginPage extends Base{
	
	//pagefactory object
	
	@FindBy(id="userAccountLink")
	WebElement signinDrop;
	
	@FindBy(id="SignIn")
	WebElement signinButton1;
	
	@FindBy(id="signInButton")
	WebElement signinButton2;
	
	@FindBy(className="weak")
	WebElement registerButton;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(className ="social icon32 connect fb")
	WebElement facebook;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle(); 
	}
	
public HomePage signIn(String un, String pw) {
	signinDrop.click();
	signinButton1.click();
	//robot.keyPress(KeyEvent.VK_TAB);
	//robot.keyPress(KeyEvent.VK_ENTER);
	username.sendKeys(un);
	password.sendKeys(pw);
	signinButton2.click();
	
	facebook.click();
	
	return new HomePage();
	
	}
}


