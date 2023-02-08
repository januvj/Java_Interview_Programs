package com.orange.sdp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Pom_Orange.Homepage;
import com.Pom_Orange.Loginpage;
import com.Pom_Orange.Sdp_orangee;
import com.resuablemethods.Baseclass;

public class Script_Orange_Sdp extends Baseclass {
public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		driver=   browserlaunch("chrome");

	    getUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String usernamelogin = "";
		String passwordenter = "";
		Sdp_orangee sdp = new Sdp_orangee(driver);
		
		sdp.Loginpage().getUsername();
		String text= getText(sdp.Loginpage().getUsername());
		System.out.println(text);
		String[] split = text.split("Username : ", 2);
		for (String a : split) {
			System.out.println(a);
			usernamelogin = usernamelogin + a;

		}

		
		sdp.Loginpage().getPassword();
		String text1= getText(sdp.Loginpage().getPassword());
		System.out.println(text1);
		
		
		String[] split1 = text1.split("Password : ", 2);
		for (String a1 : split1) {
			System.out.println(a1);
			passwordenter = passwordenter + a1;

		}

		sdp.Loginpage().getUsername1();
		sleep();
		String s = sdp.Loginpage().getUsername1().getAttribute("placeholder");
		System.out.println(s);
		if (text.contains(s)) {
			sdp.Loginpage().getUsername1().sendKeys(usernamelogin);
		}

		sdp.Loginpage().getPassword();
		String s1 = sdp.Loginpage().getPassword1().getAttribute("placeholder");
		System.out.println(s1);
		if (text1.contains(passwordenter)) {
			sdp.Loginpage().getPassword1().sendKeys(passwordenter);
		}
		
		
		sdp.Homepage().getCli();
		sdp.Homepage().getCli().click();
		
		sdp.Homepage().getMenuoptions();
		for (WebElement options : sdp.Homepage().getMenuoptions()) {
			String get = options.getText();
			System.out.println(get);
			
		}
		capture();
	}
	

}

	
	
	
	
	
	
	
	
	
	
	



