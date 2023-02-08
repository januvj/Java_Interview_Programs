package com.Pom_Orange;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	public static WebDriver driver;

	@FindBy(xpath = "//p[text()='Username : Admin']")
	private WebElement username;

	@FindBy(xpath = "//p[text()='Password : admin123']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='username']")
	private WebElement username1;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password1;

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getUsername1() {
		return username1;
	}

	public WebElement getPassword1() {
		return password1;
	}

	public Loginpage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

}
