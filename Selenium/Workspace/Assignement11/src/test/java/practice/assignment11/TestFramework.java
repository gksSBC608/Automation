package practice.assignment11;

import org.testng.annotations.Test;

import practice.framework.Application;
import practice.util.Config;
import practice.util.ExcelReader;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestFramework {

	private ExcelReader excelReader;
	private static String[][] credentials;
	private static String[][] keywords;

	@BeforeClass
	public void beforeClass() {
	}

	@BeforeTest
	public void beforeTest() {
		String excelPath = "D:\\201 Courses\\testData.xlsx";
		String sheetname = "credentials";

		excelReader = new ExcelReader(excelPath, sheetname, Config.COLUMMNS_IN_CREDENTIALS_SHEET);
		credentials = excelReader.readExcelSheetData();
		// excelReader.loadExcelSheetData();
		sheetname = "keywords";
		excelReader = new ExcelReader(excelPath, sheetname, Config.COLUMMNS_IN_KEYWORD_SHEET);
		keywords = excelReader.readExcelSheetData();

	}

	@Test
	public void test() {

		Application app = new Application(credentials, keywords);
		// app.testExcelSheetData();
		app.performKeywordsBasedActions();

	}

	@AfterTest
	public void afterTest() {

		excelReader.closeStreamReader();
	}

	@AfterClass
	public void afterClass() {
	}

}
