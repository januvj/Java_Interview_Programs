package com.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	
	public static Properties p;

public ConfigurationReader() throws IOException {
	
	File f =new File("C:\\Users\\Vijay\\eclipse-workspace\\Janaki\\orangehrm\\src\\main\\java\\com\\property\\Orange.properties");
	FileInputStream fi= new FileInputStream(f);
	p=new Properties();
	p.load(fi);
			
}

public static String getbrowser() {
	String browser = p.getProperty("browser");
	return browser;
}
 public static String geturl() {
	 String url = p.getProperty("url");
	return url;
}


}