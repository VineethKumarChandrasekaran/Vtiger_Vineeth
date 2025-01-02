package com.crm.generic.fileutilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream("./src/test/resource/Vtiger.properties");
		Properties properties = new Properties();
		properties.load(file);
		return properties.getProperty(key);
	}

}
