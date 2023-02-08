package com.Pom_Orange;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.resuablemethods.Baseclass;

public class Sdp_orangee extends Baseclass{
	public static WebDriver driver;
	private Loginpage lp;
	private Homepage hp;

	public Sdp_orangee(WebDriver driver2) {

	
	this.driver=driver2;
	PageFactory.initElements(driver, this);
	
	}

	public Loginpage Loginpage() {

		if (lp == null) {
			lp = new Loginpage(driver);
		}
		return lp;
	}

	public Homepage Homepage() {
		if (hp == null) {
			hp = new Homepage(driver);
		}
		return hp;
	}

}