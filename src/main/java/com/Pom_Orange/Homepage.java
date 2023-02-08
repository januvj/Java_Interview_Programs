package com.Pom_Orange;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	public static WebDriver driver;

	@FindBy(xpath ="//button[@type='submit']")
	private WebElement cli;

	public Homepage(WebDriver driver3) {
		this.driver = driver3;
		PageFactory.initElements(driver3, this);
	}

	public WebElement getCli() {
		return cli;
	}

	public List<WebElement> getMenuoptions() {
		return menuoptions;
	}

	@FindBy(xpath ="//ul/child::li[@class='oxd-main-menu-item-wrapper']")
	private List<WebElement> menuoptions;

}
