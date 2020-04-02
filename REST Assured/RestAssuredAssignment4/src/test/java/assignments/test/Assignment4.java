package assignments.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import assignments.config.Config;
import assignments.steps.Steps;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

/**
 * 
 * @author M1030608
 * 
 *         Two test methods test login feature, first method sends valid
 *         credentials which if succeeds returns 302 as response code. Second
 *         method sends invalid credentials, for which the server returns 200
 *         response code.
 * 
 *         Handling cookies is implemented to validate login
 *
 */
public class Assignment4 {

	private static Steps steps;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String configFile = "testConfig.properties";
		new Config().loadProperties(configFile);

	}

	@Test
	public void testLoginWithValidCredentials() {
		steps = new Steps();
		String username = "j2ee";
		String password = "j2ee";
		try {
			ValidatableResponse response = steps.openSignInPage();
			response.statusCode(200);
			response = steps.submitSignInForm(username, password);
			response.statusCode(302);
			Response response1 = steps.validateSignIn();
			String respBody = response1.getBody().asString();
			assertTrue(respBody.contains("Sign Out"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Test
	public void testLoginWithInvalidCredentials() {
		steps = new Steps();
		String username = "j2ee1";
		String password = "j2ee1";
		try {
			ValidatableResponse response = steps.openSignInPage();
			response.statusCode(200);
			response = steps.submitSignInForm(username, password);
			response.statusCode(200);
			Response response1 = steps.validateSignIn();
			String respBody = response1.getBody().asString();
			assertTrue(respBody.contains("Sign In"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
