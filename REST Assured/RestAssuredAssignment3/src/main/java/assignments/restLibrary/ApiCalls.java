package assignments.restLibrary;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonObject;

import assignments.config.Config;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class ApiCalls {

	static {
		System.setProperty("http.proxyHost", "172.22.218.218");
		System.setProperty("http.proxyPort", "8085");
		System.setProperty("https.proxyHost", "172.22.218.218");
		System.setProperty("https.proxyPort", "8085");
	}

	public ValidatableResponse getRequest(String url) {
		URI uri = null;
		try {
			uri = new URI(Config.assignment_baseUrl + url);
			System.out.println(uri.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ValidatableResponse response = SerenityRest.given().when().get(uri).then();
		response.log().all();
		return response;
	}

	public ValidatableResponse postRequestWIthParameters(String url, Map<String, String> parameters, Object body,
			String header) {
		ValidatableResponse response = null;
		RequestSpecification request = SerenityRest.given();
		RestAssured.baseURI = Config.assignment_baseUrl + url;
		RequestSpecification reqSpec = request.urlEncodingEnabled(true);

		Set<Entry<String, String>> entrySet = parameters.entrySet();

		for (Entry<String, String> entry : entrySet) {

			reqSpec = reqSpec.param(entry.getKey(), entry.getValue());

		}

		response = reqSpec.when().post(url).then();
		response.log().all();
		return response;
	}

	private RequestSpecification frameParameters(RequestSpecification reqSpec, String paramKey, String paramVal) {
		return reqSpec.param(paramKey, paramVal);
	}

	public ValidatableResponse postRequestWithPayload(String path, Map<String, String> requestParams) {
		ValidatableResponse response = null;
		RestAssured.baseURI = Config.assignment_baseUrl ;
		JsonObject parameters = new JsonObject();
		Set<Entry<String, String>> entrySet = requestParams.entrySet();

		for (Entry<String, String> entry : entrySet) {
			parameters.addProperty(entry.getKey(), entry.getValue());
		}

		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(parameters.toString());
		response = httpRequest.post(path).then();
		response.log().all();
		return response;
	}

}
