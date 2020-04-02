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
public class Assignment1 {

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
	public void testGroupKtGetresponseContent() {
		String url = "state/get/IND/all";
		ValidatableResponse response = apiCalls.getRequest(url);

		JsonPath jsonPath = response.extract().response().jsonPath();
//		int size = jsonResponse.size();
//		System.out.println(size);
		List restResponse = jsonPath.getJsonObject("RestResponse.messages");
		String expectedResponse = "Total [36] records found.";
		assertEquals(expectedResponse, restResponse.get(0));

	}

	@Test
	public void testGroupKtGetresponseContentInvalidInput() throws UnsupportedEncodingException {
		String param = URLEncoder.encode("Aus or ind", StandardCharsets.UTF_8.toString());
		String url = "state/get/"+param+"/all";
		//url= URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
		ValidatableResponse response = apiCalls.getRequest(url);

		JsonPath jsonPath = response.extract().response().jsonPath();
//		int size = jsonResponse.size();
//		System.out.println(size);
		List restResponse = jsonPath.getJsonObject("RestResponse.messages");
		String expectedResponse = "Total [0] records found.";
		assertEquals(expectedResponse, restResponse.get(0));

	}

	@Test
	public void testGroupKtGetresponseOK() {

		String url = "state/get/IND/all";

		ValidatableResponse response = apiCalls.getRequest(url);
		response.statusCode(200);

	}

}
