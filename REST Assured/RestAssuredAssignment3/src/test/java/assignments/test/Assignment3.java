/**
 * 
 */
package assignments.test;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import assignments.config.Config;
import assignments.restLibrary.ApiCalls;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * @author Gaurav Sharan
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Assignment3 {

	private static ApiCalls apiCalls;

	private static Map<String, String> requestParams = new HashMap<String, String>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String configFile = "testConfig.properties";
		new Config().loadProperties(configFile);
		apiCalls = new ApiCalls();

		requestParams.put("FirstName", "Tust"); // Cast
		requestParams.put("LastName", "Datam");
		requestParams.put("UserName", "tustd101");
		requestParams.put("Password", "password1");
		requestParams.put("Email", "restassured143@gmail.com");

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

	/**
	 * Test to post new data as to register
	 */
	@Test
	public void test1() {
		// RequestSpecification request = RestAssured.given();
		try {

			ValidatableResponse response = apiCalls.postRequestWithPayload("customer/register", requestParams);
			response.statusCode(201);
			String actualSuccessCode = response.extract().response().jsonPath().getJsonObject("SuccessCode").toString();
			assertEquals("OPERATION_SUCCESS", actualSuccessCode);
			String actualMessage = response.extract().response().jsonPath().getJsonObject("Message").toString();
			assertEquals("Operation completed successfully", actualMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test to post old data do that registration fails
	 */
	@Test
	public void test2() {
		try {

			ValidatableResponse response = apiCalls.postRequestWithPayload("customer/register", requestParams);
			response.statusCode(200);
			String actualFault = response.extract().response().jsonPath().getJsonObject("fault").toString();
			assertEquals("FAULT_USER_ALREADY_EXISTS", actualFault);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
