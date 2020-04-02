/**
 * 
 */
package listenerdemo;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

/**
 * @author M1030608
 *
 */
public class TestReporter implements IReporter {

	/**
	 * 
	 */
	public TestReporter() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.testng.IReporter#generateReport(java.util.List, java.util.List, java.lang.String)
	 */
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		
	}

}
