package utilities;


import com.google.gson.JsonElement;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.Properties;

public class DataUtility {


    public static String readConfig(String propertyName,String...configFile){

        // Reads the value for a key from the property file
        Properties prop = new Properties();
        InputStream input = null;
        String propertyValue = null;

        try {
            String filename = ".\\pre_requisites\\configs\\master_config.properties";
            File file = new File(filename);

            input = new FileInputStream(file);

            if (configFile.length>0){
                filename =configFile[0];
                input = DataUtility.class.getClassLoader().getResourceAsStream(filename);
            }


            //load a properties file from class path, inside static method
            prop.load(input);

            propertyValue = prop.getProperty(propertyName);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propertyValue;
    }

    private int getSheetIndex(String testCaseNo){
        //Identifies the Excel sheet no. depending on the test case no. passed
        int testNo = Integer.parseInt(testCaseNo);
        return testNo/50;
    }

//    public Hashtable getTestData(String testCaseNo) {
//
//        // Returns the Test Data in the form of Hash Table from the excel
//
//        InputStream dataFileStream = DataUtility.class.getClassLoader().getResourceAsStream(readConfig("dataSource.name"));
//
//
//        Workbook workBook = null;
//        try {
//
//            workBook = WorkbookFactory.create(dataFileStream);
//
//        } catch (Exception e) {
//        	throw e;
//            
//        }
//
//        XSSFFormulaEvaluator evaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workBook);
////        workBook.setForceFormulaRecalculation(true);
//        int sheetIndex = getSheetIndex(testCaseNo);
//        Sheet dataSheet = workBook.getSheetAt(sheetIndex);
//        int startRow = dataSheet.getFirstRowNum();
//        int endRow = dataSheet.getLastRowNum();
//        Hashtable <String,String>dataTable  = new Hashtable <String,String>();
//
//        for (int i = startRow; i <= endRow; i++) {
//            Row row = dataSheet.getRow(i);
//            String cellReference = getCellValue(row.getCell(0),evaluator);
//            if (cellReference.equals(testCaseNo)) {
//                dataTable.put(getCellValue(row.getCell(1),evaluator), getCellValue(row.getCell(2),evaluator));
//            }
//
//        }
//        return dataTable;
//    }
//
//    private String getCellValue(Cell cell, XSSFFormulaEvaluator evaluator){
//        // returns the cell value in the form of String
//        String cellValue = null;
//        evaluator.evaluate(cell);
//        DataFormatter formatter = new DataFormatter();
//        cellValue = formatter.formatCellValue(cell, evaluator);
//        if (cellValue.equals("departDateOffset")){
//
//
//        }
//
//        return cellValue;
//    }

    public static JsonObject getJsonData (String fileName){
        // Reads the JSON file
//        String filePath = DataUtility.class.getClassLoader().getResource(fileName).getPath();
        InputStream fis = DataUtility.class.getClassLoader().getResourceAsStream(fileName);
        JsonObject jsonObject = new JsonObject();


        try {
            Reader reader = new InputStreamReader(new BufferedInputStream(fis), "UTF-8");
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);
            jsonObject = jsonElement.getAsJsonObject();
        }catch (IOException ioe){
            ioe.printStackTrace();
            throw new RuntimeException("Data source not found");
        }


        return jsonObject;
    }

//    public static void writeConfig(String propertyValue){
//        Properties prop = new Properties();
//        OutputStream output = null;
//
//        try {
//
//            output = new FileOutputStream("/test/resources/config.properties");
//
//            // set the properties value
//            prop.setProperty("app.url", propertyValue);
//
//            // save properties to project root folder
//            prop.store(output, null);
//
//        } catch (IOException io) {
//            io.printStackTrace();
//        } finally {
//            if (output != null) {
//                try {
//                    output.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }


//    public static void configWrite(String propertyValue, String...filePath) {
//        Properties prop = new Properties();
//        InputStream input = null;
//
//
//        try {
//
//
//            if (filePath.length > 0){
//
//            }
//
//            input = DriverFactory.class.getClassLoader().getResourceAsStream(filename);
//            //load a properties file from class path, inside static method
//            prop.load(input);
//
//            prop.setProperty("app.url", propertyValue);
//            prop.store(new FileOutputStream("src//test//resources//config.properties"),null);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (input != null) {
//                try {
//                    input.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//        }
//    }
}


