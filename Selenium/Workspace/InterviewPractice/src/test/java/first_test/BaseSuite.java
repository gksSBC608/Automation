package first_test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseSuite {

	public BaseSuite() {

	}

	@BeforeSuite
	public void setupBeforeSuite() {

		System.out.println("before suite");

	}

	@AfterSuite
	public void cleanupAfterSuite() {
		System.out.println("after suite");
	}

}
