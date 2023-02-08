package com.orange.basicscript;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.resuablemethods.Baseclass;


public class Orange_basicscript_with_baseclss extends Baseclass {
	
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
	
		driver=   browserlaunch("chrome");

		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    getUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String usernamelogin = "";
		String passwordenter = "";
		WebElement username = driver.findElement(By.xpath("//p[text()='Username : Admin']"));
		//String text = username.getText();
		String text= getText(username);
		System.out.println(text);
		String[] split = text.split("Username : ", 2);
		for (String a : split) {
			System.out.println(a);
			usernamelogin = usernamelogin + a;

		}

		WebElement password = driver.findElement(By.xpath("//p[text()='Password : admin123']"));
		//String text1 = password.getText();
		String text1= getText(password);
		System.out.println(text1);
		
		
		String[] split1 = text1.split("Password : ", 2);
		for (String a1 : split1) {
			System.out.println(a1);
			passwordenter = passwordenter + a1;

		}

		WebElement username1 = driver.findElement(By.xpath("//input[@name='username']"));
		String s = username1.getAttribute("placeholder");
		System.out.println(s);
		if (text.contains(s)) {
			username1.sendKeys(usernamelogin);
		}

		WebElement password1 = driver.findElement(By.xpath("//input[@name='password']"));
		String s1 = password1.getAttribute("placeholder");
		System.out.println(s1);
		if (text1.contains(passwordenter)) {
			password1.sendKeys(passwordenter);
		}
		
		
		WebElement cli = driver.findElement(By.xpath("//button[@type='submit']"));
		cli.click();
		
		List<WebElement> menuoptions = driver.findElements(By.xpath("//ul/child::li[@class='oxd-main-menu-item-wrapper']"));
		for (WebElement options : menuoptions) {
			String get = options.getText();
			System.out.println(get);
			
		}
		capture();
	}
	

}

