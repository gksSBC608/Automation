/**
 * 
 */
package first_test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * @author M1030608
 *
 */
public class BaseTest extends BaseSuite {

	@BeforeTest
	public void setupBeforeTest() {
		System.out.println("setup before test");
	}

	@BeforeClass
	public void setup() {
		System.out.println("before class");
	}

	@AfterClass
	public void cleanup() {
		System.out.println("after class");
	}

	@AfterTest
	public void cleanUpAfterTest() {
		System.out.println("clean up after test");
	}

}
