/**
 * 
 */
package assignments.test;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import assignments.config.Config;
import assignments.restLibrary.ApiCalls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

/**
 * @author Gaurav Sharan
 *
 */
public class Assignment2 {

	private static ApiCalls apiCalls;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String configFile = "testConfig.properties";
		new Config().loadProperties(configFile);
		apiCalls = new ApiCalls();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCountResultRecords() {

		String url = "/state/search/IND?text=pradesh";
		ValidatableResponse response = apiCalls.getRequest(url);
		List<Object> list = response.extract().response().jsonPath().getList("RestResponse.result");
		assertEquals(5, list.size());
	}

	@Test
	public void testFindLargestCity() {
		String url = "/state/get/IND/AP";
		ValidatableResponse response = apiCalls.getRequest(url);
		String actual = response.extract().response().jsonPath().getJsonObject("RestResponse.result.largest_city")
				.toString();
		assertEquals("Hyderabad Amaravati", actual);

	}

	@Test
	public void getDetails() {
		String url = "/state/search/IND?text=Bihar";
		ValidatableResponse response = apiCalls.getRequest(url);
		Object object = response.extract().response().jsonPath().getJsonObject("$");
		System.out.println(object);
	}

}
