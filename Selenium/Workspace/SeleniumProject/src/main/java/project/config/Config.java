package project.config;

import java.io.*;
import java.util.Properties;

public class Config {

	public static String username;
	public static String password;
	public static String flightToConfirm;

	public Config() {
	}

	public static void loadData() {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			final String dir = System.getProperty("user.dir");
			System.out.println(dir);
			String filePath = dir + "/testdata.properties";
			input = new FileInputStream(filePath);
			prop.load(input);
			username = prop.getProperty("username");
			password = prop.getProperty("username");
			flightToConfirm = prop.getProperty("flightToConfirm");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
