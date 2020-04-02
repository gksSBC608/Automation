package assignments.restLibrary;

import java.net.URI;
import java.net.URISyntaxException;

import assignments.config.Config;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
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
			uri = new URI(Config.assignment1_baseUrl + url);
			System.out.println(uri.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ValidatableResponse response = SerenityRest.given().when().get(uri).then();
		response.log().all();
		return response;
	}

	public Response postRequest(String url, Object body, String header) {
		Response response = null;
		return response;
	}

}
