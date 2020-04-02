package assignments.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class Question1 extends BaseClass {

	private static Logger logger = Logger.getLogger(Question1.class);

	@Test
	public void searchCountriesWithIsoCode() {
		logger.debug("searchCountriesWithIsoCode test");
		String countryCode = "co";
		String url = "rest/v2/alpha/" + countryCode;
		Response response = apiCalls.getRequest(url);

		response.then().statusCode(200);

		String actual = response.jsonPath().get("name");

		assertEquals("Colombia", actual);

	}

	@Test
	public void searchCountriesWithCountryName() {
		logger.info("searchCountriesWithCountryName test");
		String countryName = "India";
		String url = "rest/v2/name/" + countryName;
		Response response = apiCalls.getRequest(url);
		response.then().statusCode(200);

		List<Object> jsonArr = response.jsonPath().getList("$");
		HashMap<String, Object> jsonObj = (HashMap<String, Object>) jsonArr.get(0);
		assertEquals(jsonObj.get("name"), "British Indian Ocean Territory");
	}
}
