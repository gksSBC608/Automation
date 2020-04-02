package assignments.steps;

import java.util.*;

import assignments.restLibrary.ApiCalls;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class Steps {

	private ApiCalls apiCalls;

	private String JSESSIONID;

	private String homepageURL;

	public Steps() {
		apiCalls = new ApiCalls();
	}

	public ValidatableResponse openSignInPage() {

		String url = "actions/Account.action?signonForm=";
		ValidatableResponse response = apiCalls.getRequest(url);
		response.statusCode(200);
		return response;
	}

	public ValidatableResponse submitSignInForm(String username, String password) {
		String url = "actions/Account.action";
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("username", username);
		parameters.put("password", password);
		parameters.put("signon", "Login");
		parameters.put("_sourcePage", "n67kFSqiTy1VLpDEugKfWpw9JPMEAAQCKEi_gehpViXfbNqsrG1bHg==");
		parameters.put("_fp", "gllqdQ5MKAg=");

		String body = "";
		String header = "";
		Response response = apiCalls.postRequestWithParameters(url, parameters, body, header);
		JSESSIONID = response.getCookie("JSESSIONID");

		homepageURL = response.getHeader("Location");

		return response.then();
	}

	public Response validateSignIn() {

		String url = "actions/Catalog.action";

		Response response = apiCalls.getRequestWithCookie(url, this.JSESSIONID);

		response.then().statusCode(200);

		return response;

	}

}
