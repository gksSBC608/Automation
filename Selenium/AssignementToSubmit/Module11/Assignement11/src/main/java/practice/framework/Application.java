/**
 * 
 */
package practice.framework;

import java.util.Arrays;

import practice.util.Config;
import practice.util.ExcelReader;

/**
 * @author M1030608
 *
 */
public class Application {

	String[][] credentials;
	String[][] keywords;

	/**
	 * 
	 */
	public Application() {

	}

	/**
	 * 
	 */
	public Application(String[][] credentials, String[][] keywords) {

		this.credentials = credentials.clone();
		this.keywords = keywords.clone();

	}

	public void testExcelSheetData() {

		for (String[] arr : credentials) {
			for (String str : arr) {
				System.out.print(str + " ");
			}
			System.out.println();

		}

		for (String[] arr : keywords) {
			for (String str : arr) {
				System.out.print(str + " ");
			}
			System.out.println();

		}

	}

	public void performKeywordsBasedActions() {

		for (int i = 1; i < keywords.length; i++) {

			String keyword = keywords[i][Config.KEYWORD_COLUMN];
			String locator = keywords[i][Config.LOCATOR_COLUMN];
			String locatorValue = keywords[i][Config.LOCATOR_VAL_COLUMN];
			String parameter = keywords[i][Config.PARAM_COLUMN];
			switch (keyword) {

			case Config.OPEN_BROWSER:
				Actions.openBrowser();
				break;

			case Config.MAXIMIZE_BROWSER:
				Actions.maximizeBrowser();
				break;

			case Config.IMPLEMNT_WAIT:
				Actions.implementWait();
				break;

			case Config.NAVIGATE:
				Actions.navigate(parameter);
				break;

			case Config.ENTER_USERNAME:
				Actions.enterValueInTextbox(locator, locatorValue, parameter);
				break;

			case Config.ENTER_PASWORD:
				Actions.enterValueInTextbox(locator, locatorValue, parameter);
				break;

			case Config.CLICK_SUBMIT:
				Actions.clickButton(locator, locatorValue);
				break;

			case Config.VERIFY_MESSAGE:
				Actions.validateMessage(locator, locatorValue, parameter);
				break;
			case Config.VERIFY_PAGE_TITLE:
				Actions.validateTitle(parameter);
				break;

			case Config.CLOSE_BROWSER:
				Actions.closeBrowser();

			}

		}

	}

}
