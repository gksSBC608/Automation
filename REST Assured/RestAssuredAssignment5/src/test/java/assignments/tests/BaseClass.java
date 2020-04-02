/**
 * 
 */
package assignments.tests;

import org.testng.annotations.BeforeClass;

import assignments.config.Config;
import assignments.restLibrary.ApiCalls;
import io.restassured.RestAssured;

/**
 * @author M1030608
 *
 */
public class BaseClass {

	protected static ApiCalls apiCalls;

	@BeforeClass
	public static void setup() {
		String configFile = "testConfig.properties";
		new Config().loadProperties(configFile);

		RestAssured.basePath = Config.assignment_baseUrl;
		apiCalls = new ApiCalls();

	}

}
