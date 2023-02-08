package com.cucumber_runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.property.ConfigurationHelper;
import com.resuablemethods.Baseclass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\Vijay\\eclipse-workspace\\Janaki\\orangehrm\\src\\test\\java\\com\\orange_feature\\orange.feature", 
glue = "com.orange._stepdefinition")

public class RunnerClass {
	public static WebDriver driver;

	
	public static void browserLaunch() throws IOException {
		String browser = ConfigurationHelper.getInstanceCR().getbrowser();
		driver = Baseclass.browserlaunch(browser);

	}

	@AfterClass
	public static void browserclose() {
		driver.close();
	}
}


	
	
	
	
	
	
	
	
	
	
	
	

