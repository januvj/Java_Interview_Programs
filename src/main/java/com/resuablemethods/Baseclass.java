package com.resuablemethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;

	public static void userInput(WebElement element, String value) throws Exception {

		try {
			boolean enabled = element.isEnabled();
			if (enabled==true) {
				element.sendKeys(value);
	
			}
			else {
			throw new Exception();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void clickOnElement(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			if (enabled==true) {
				element.click();

			}
			
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void isSelectedInput(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println("to check is selected or not:" + selected);

	}

	public static boolean isDisplayedInput(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
			return displayed;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return displayed;
		//boolean displayed = element.isDisplayed();
		//System.out.println("to check is displayed or not:" + displayed);

	}

	public static void isEnabledInput(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println("to check is displayed or not:" + enabled);
	}

	public static String getText(WebElement element) {

		String text = element.getText();
		System.out.println(" get the text:" + text);
		return text;

	}

	public static void getAttributePlaceholder(WebElement element) {
		String attribute = element.getAttribute("Placeholder");
		System.out.println(attribute);
	}

	public static void getAttributeValue(WebElement element, String value) {
		String attributevalue = element.getAttribute(value);
		System.out.println(attributevalue);

	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(5000);
	}

	public static WebDriver browserlaunch(String browser) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {

				ChromeOptions option = new ChromeOptions();
				option.addArguments("Start-Maximized");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(option);

			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();

			}

			else if (browser.equalsIgnoreCase("gecko")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

			else {
				System.out.println("invalid browser launch");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void maximize() {

		driver.manage().window().maximize();

	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();

	}

	public static void fullScreen() {
		driver.manage().window().fullscreen();
	}

	public static void navigateTo(String url) {

		driver.navigate().to(url);

	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static Set<String> multipleWindow() {

		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public static String singleWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	public static void robotActionDown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);

	}

	public static void robotActionup() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	public static void robotActionEnter() throws AWTException {

		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void Alert(String option) {

		Alert alert = driver.switchTo().alert();

		if (option.equalsIgnoreCase("ok")) {
			alert.accept();

		} else if (option.equalsIgnoreCase("cancel")) {
			alert.dismiss();

		}

		else {
			System.out.println("invalid alert");
		}
	}

	public static void alertSendkeys(String value) {

		driver.switchTo().alert().sendKeys(value);

	}

	public static void frameSwitch(WebElement element) {

		driver.switchTo().frame(element);

	}

	public static void defaultFrame() {
		driver.switchTo().defaultContent();
	}

	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

	public static int totalFrame(List<WebElement> element) {
		int size = element.size();
		return size;

	}

	public static void mouseAction(WebDriver driver, WebElement element, String option, WebElement element1) {

		Actions a = new Actions(driver);
		if (option.equalsIgnoreCase("click")) {
			a.click(element).perform();
		} else if (option.equalsIgnoreCase("rightclick")) {
			a.contextClick(element).build().perform();
		} else if (option.equalsIgnoreCase("move")) {
			a.moveToElement(element).perform();
		} else if (option.equalsIgnoreCase("doubleclick")) {
			a.doubleClick(element).build().perform();
		} else if (option.equalsIgnoreCase("drag_drop")) {
			a.dragAndDrop(element, element1).build().perform();
		} else {
			System.out.println("invalid mouseaction");
		}
	}

	public static void dropDownSelect(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		}

		else if (option.equalsIgnoreCase("visibletext")) {
			s.selectByVisibleText(value);

		}

		else if (option.equalsIgnoreCase("index")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
		}

		else {
			System.out.println("select the invalid dropdown");
		}
	}

	public static void deSelect(WebElement element, String option, String value) {

		try {
			Select s = new Select(element);

			if (option.equalsIgnoreCase("value")) {
				s.deselectByValue(value);
			}

			else if (option.equalsIgnoreCase("visibletext")) {
				s.deselectByVisibleText(value);

			}

			else if (option.equalsIgnoreCase("index")) {
				int parseInt = Integer.parseInt(value);
				s.deselectByIndex(parseInt);
			}

			else {
				System.out.println("deselect the invalid dropdown");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void getOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		System.out.println(options);
	}

	public static void getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allselectedoptions = s.getAllSelectedOptions();
		System.out.println(allselectedoptions);

	}

	public static void getFirstSelectedoptions(WebElement element) {
		Select s = new Select(element);
		s.getFirstSelectedOption();
	}

	public static void selectIsMuliple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
	}

	public static void capture() throws IOException {

		try {
			Date date = new Date();
			SimpleDateFormat d = new SimpleDateFormat("mm/dd/yyyy");
			d = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			String format = d.format(date);
			String r = format.replaceAll("/", "-");

			TakesScreenshot t = (TakesScreenshot) driver;
			File get = t.getScreenshotAs(OutputType.FILE);
			File f = new File(
					"C:\\Users\\Vijay\\eclipse-workspace\\Janaki\\orangehrm\\screenshot\\orange" + r + ".png");
			FileUtils.copyFile(get, f);
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

}