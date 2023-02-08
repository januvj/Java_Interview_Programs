package com.orange_testng;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.resuablemethods.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange_testng  extends Baseclass {
	public static WebDriver driver;
	static String usernamelogin = "";
	static String passwordenter = "";
	static String text;
	static String text1;
	public static ChromeOptions desiredoptions() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("Start-Maximized");
		return option;

	}

	@BeforeTest ( groups= {"demo"})
	private void launching() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(desiredoptions());
	}

	@BeforeClass ( groups= {"demo"})

	private void url() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//geturl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 0,  groups= {"demo"})
	public static void username() throws InterruptedException {
		usernamelogin = "";
		passwordenter = "";

		WebElement username = driver.findElement(By.xpath("//p[text()='Username : Admin']"));
		text=username.getText();
		System.out.println(text);
		String[] split = text.split("Username : ", 2);
		for (String a : split) {
			System.out.println(a);
			usernamelogin = usernamelogin + a;
			//Thread.sleep(3000);
			sleep();

		}
	}

	@Test(priority = 1, groups= {"demo"})
	private void password() throws InterruptedException {

		WebElement password = driver.findElement(By.xpath("//p[text()='Password : admin123']"));
		text1 = password.getText();
		System.out.println(text1);

		String[] split1 = text1.split("Password : ", 2);
		for (String a1 : split1) {
			System.out.println(a1);
			passwordenter = passwordenter + a1;
			//Thread.sleep(3000);
			sleep();

		}

	}

	@Test(priority = 2)

	public static void enterusername() throws Exception {

		//Thread.sleep(3000);
		sleep();

		WebElement username1 = driver.findElement(By.xpath("//input[@name='username']"));
		String s = username1.getAttribute("placeholder");
		System.out.println(s);
		if (text.contains(s)) {
	//username1.sendKeys(usernamelogin);
		userInput(username1, s);	
		}
		
}

	@Test(priority = 3)

	private void enter_password() throws Exception {
		//Thread.sleep(3000);
		
		WebElement password1 = driver.findElement(By.xpath("//input[@name='password']"));
		String s1 = password1.getAttribute("placeholder");
		System.out.println(s1);
		if (text1.contains(passwordenter)) {
			//password1.sendKeys(passwordenter);
			userInput(password1, s1);
		}
	}

	@Test(priority = 4)

	public static void click_action() {
		WebElement cli = driver.findElement(By.xpath("//button[@type='submit']"));
		//cli.click();
clickOnElement(cli);		
	}

	@Test(priority = 5)

	private void menuoption() {

		List<WebElement> menuoptions = driver
				.findElements(By.xpath("//ul/child::li[@class='oxd-main-menu-item-wrapper']"));
		for (WebElement options : menuoptions) {
//			String get = options.getText();
//			System.out.println(get);
			getText(options);

		}
	}

	@AfterTest
	private void browserclose() {
		//driver.quit();
		driver.quit();
	}

}
