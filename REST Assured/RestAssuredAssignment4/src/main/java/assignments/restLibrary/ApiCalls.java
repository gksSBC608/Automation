package assignments.restLibrary;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import assignments.config.Config;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class ApiCalls {

//	static {
//		System.setProperty("http.proxyHost", "172.22.218.218");
//		System.setProperty("http.proxyPort", "8085");
//		System.setProperty("https.proxyHost", "172.22.218.218");
//		System.setProperty("https.proxyPort", "8085");
//	}

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

	public Response getRequestWithCookie(String url, String jsessionid) {
		Response response = null;
		URI uri = null;
		try {
			uri = new URI(Config.assignment_baseUrl + url);
			System.out.println(uri.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		Cookie.Builder builder = new Cookie.Builder("JSESSIONID", jsessionid);
		response = SerenityRest.given().cookie(builder.build()).get(uri);
		response.then().log().all();
		return response;
	}

	public Response getRequestForFullUrl(String url) {
		URI uri = null;
		try {
			uri = new URI(url);
			System.out.println(uri.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		Response response = SerenityRest.given().when().get(uri);
		response.then().log().all();
		return response;
	}

	public Response postRequestWithParameters(String url, Map<String, String> parameters, Object body, String header) {
		Response response = null;
		URI uri = null;
		try {
			uri = new URI(Config.assignment_baseUrl + url);
			System.out.println(uri.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		RequestSpecification request = RestAssured.given();
		RestAssured.baseURI = Config.assignment_baseUrl + url;
		// RequestSpecification reqSpec = request.urlEncodingEnabled(true);

//		reqSpec = reqSpec.param("username", parameters.get("username")).param("password", parameters.get("password"))
//				.param("signon", parameters.get("signon")).param("_sourcePage", parameters.get("_sourcePage"))
//				.param("_fp", parameters.get("_fp"));

		Set<Entry<String, String>> entrySet = parameters.entrySet();

//		for (Entry<String, String> entry : entrySet) {
//
//			reqSpec = reqSpec.param(entry.getKey(), entry.getValue());
//
//		}
		response = request.urlEncodingEnabled(true).param("username", parameters.get("username"))
				.param("password", parameters.get("password")).param("signon", parameters.get("signon"))
				.param("_sourcePage", parameters.get("_sourcePage")).param("_fp", parameters.get("_fp")).post(uri);
		// System.out.println(reqSpec.toString());

		// response = reqSpec.when().post(url).then();
		response.then().log().all();
		return response;
	}

	public ValidatableResponse postRequestWithPayload(String path, Map<String, String> requestParams) {
		ValidatableResponse response = null;
		RestAssured.baseURI = Config.assignment_baseUrl;
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
