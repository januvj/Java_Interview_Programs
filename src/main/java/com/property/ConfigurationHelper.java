package com.property;

import java.io.IOException;

public class ConfigurationHelper {


	private ConfigurationHelper() {
		
	}
	
	public static ConfigurationReader getInstanceCR() throws IOException {

		ConfigurationReader reader= new ConfigurationReader();
		return reader;
		
	}
}

	
	
	
	
	

