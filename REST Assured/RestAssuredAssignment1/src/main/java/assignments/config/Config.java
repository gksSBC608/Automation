package assignments.config;

import java.io.*;
import java.util.*;

public class Config {
	
	public static String assignment1_baseUrl;
	
	public void loadProperties(String configFile) {
		Properties properties = new Properties();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configFile);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		assignment1_baseUrl = properties.getProperty("assignment1_baseUrl");
	}
	

}
