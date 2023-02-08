package com.orange.pom;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Pom_Orange.Homepage;
import com.Pom_Orange.Loginpage;
import com.resuablemethods.Baseclass;

public class Orange_Pom extends Baseclass {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		
	
		driver=   browserlaunch("chrome");

	    getUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String usernamelogin = "";
		String passwordenter = "";
		Loginpage lp = new Loginpage(driver);
		
		
		lp.getUsername();
		String text= getText(lp.getUsername());
		System.out.println(text);
		String[] split = text.split("Username : ", 2);
		for (String a : split) {
			System.out.println(a);
			usernamelogin = usernamelogin + a;

		}

		
		lp.getPassword();
		String text1= getText(lp.getPassword());
		System.out.println(text1);
		
		
		String[] split1 = text1.split("Password : ", 2);
		for (String a1 : split1) {
			System.out.println(a1);
			passwordenter = passwordenter + a1;

		}

		lp.getUsername1();
		sleep();
		String s = lp.getUsername1().getAttribute("placeholder");
		System.out.println(s);
		if (text.contains(s)) {
			lp.getUsername1().sendKeys(usernamelogin);
		}

		lp.getPassword();
		String s1 = lp.getPassword1().getAttribute("placeholder");
		System.out.println(s1);
		if (text1.contains(passwordenter)) {
			lp.getPassword1().sendKeys(passwordenter);
		}
		
		Homepage hp = new Homepage(driver);
		
		hp.getCli();
		hp.getCli().click();
		
		hp.getMenuoptions();
		for (WebElement options : hp.getMenuoptions()) {
			String get = options.getText();
			System.out.println(get);
			
		}
		capture();
	}
	

}



