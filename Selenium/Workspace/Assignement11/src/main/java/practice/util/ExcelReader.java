/**
 * 
 */
package practice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author M1030608
 *
 */
public class ExcelReader {

	FileInputStream inputStream;
	private static Workbook book;
	private static Sheet sheet;
	private String[][] dataSet;

	/**
	 * 
	 */
	public ExcelReader(String filepath, String sheetname, int numberOfColumns) {

		File file = new File(filepath);
		try {
			inputStream = new FileInputStream(file);
			book = new XSSFWorkbook(inputStream);
			sheet = book.getSheet(sheetname);
			dataSet = new String[getRows()][numberOfColumns];
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void loadExcelSheetData() {
		Iterator<Row> rowIterator = sheet.iterator();
		int i = 0;
		while (rowIterator.hasNext()) {
			int j = 0;
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				String cellValue = cell.getStringCellValue();
				dataSet[i][j] = cellValue;
				j++;

			}
			i++;

		}
	}

	public String[][] getDataSet() {
		return this.dataSet;
	}

	public String[][] readExcelSheetData() {
		int rows = getRows();
		//String[][] dataSet = new String[rows][2];
		Iterator<Row> rowIterator = sheet.iterator();
		int i = 0;
		while (rowIterator.hasNext()) {
			int j = 0;
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				//String cellValue = cell.getStringCellValue();
				String cellValue =(new DataFormatter()).formatCellValue(cell);
				dataSet[i][j] = cellValue;
				j++;

			}
			i++;

		}
		return dataSet;

	}

	public int getRows() {
		int rows = 0;
		rows = sheet.getPhysicalNumberOfRows();
		return rows;
	}

	public int getColumns() {

		return 0;
	}

	public void closeStreamReader() {
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
