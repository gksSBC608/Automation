package assignments.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Question2 extends BaseClass {
	private static Logger logger = Logger.getLogger(Question2.class);

	@Test
	public void searchCurrencyOfCountry() {
		logger.info("searchCurrencyOfCountry test");
		String countryCode = "372";
		String url = "rest/v2/callingcode/" + countryCode;
		Response response = apiCalls.getRequest(url);
		response.then().statusCode(200);
		List<Object> jsonArr = response.jsonPath().getList("$");
		HashMap<String, Object> jsonObj = (HashMap<String, Object>) jsonArr.get(0);
		System.out.println(jsonObj.get("name"));
		assertEquals("Estonia", jsonObj.get("name"));
	}
}
