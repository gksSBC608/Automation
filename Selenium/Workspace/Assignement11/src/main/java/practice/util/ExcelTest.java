package practice.util;

public class ExcelTest {

	public ExcelTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ExcelReader excelReader;
		String[][] dataSet;

		String excelPath = "D:\\201 Courses\\testData.xlsx";
		String sheetname = "credentials";

		excelReader = new ExcelReader(excelPath, sheetname, Config.COLUMMNS_IN_CREDENTIALS_SHEET);
		dataSet = excelReader.readExcelSheetData();
		// excelReader.loadExcelSheetData();
		// String[][] dataSet = excelReader.getDataSet();
		for (String[] arr : dataSet) {
			for (String str : arr) {
				System.out.print(str + " ");
			}
			System.out.println();

		}

		sheetname = "keywords";
		excelReader = new ExcelReader(excelPath, sheetname, Config.COLUMMNS_IN_KEYWORD_SHEET);
		dataSet = excelReader.readExcelSheetData();
		// excelReader.loadExcelSheetData();
		// String[][] dataSet = excelReader.getDataSet();
		for (String[] arr : dataSet) {
			for (String str : arr) {
				System.out.print(str + " ");
			}
			System.out.println();

		}
	}

}
