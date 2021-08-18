package automation.common;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
    XSSFWorkbook workbook;

    public ExcelReader(String path){
        File f = new File(path);

        try{
            InputStream in = f.isAbsolute()? new FileInputStream(f):
                    Thread.currentThread().getContextClassLoader().getResource(path).openStream();
            workbook = new XSSFWorkbook(in);
        } catch(Exception e){
            logger.error("read excel file failed, path is: " + path);
        }
    }


    public List<Map<String,String>> getDataWithHeader(String sheetName) {
        XSSFSheet sheet = this.workbook.getSheet(sheetName);
        List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
        Map<String,String> cellValueMap = new HashMap<>();
        int totalRow = sheet.getLastRowNum() + 1;
        int totalCol = sheet.getRow(0).getLastCellNum();

        XSSFRow rowHeaders = sheet.getRow(0);

        for(int i=1;i < totalRow;i++){
            XSSFRow row = sheet.getRow(i);
            cellValueMap = new HashMap<>();
            for(int j=0;j<totalCol;j++){
                XSSFCell cell = row.getCell(j);
                String header = getCellValue(rowHeaders.getCell(j));
                String cellValue = getCellValue(cell);
                cellValueMap.put(header,cellValue);
            }
            dataList.add(cellValueMap);
        }
        return dataList;
    }

    public String getCellValue(XSSFCell cell){
        String cellValue;
        if(null != cell){

            switch (cell.getCellType()){
                case NUMERIC: cellValue = String.valueOf(cell.getNumericCellValue());break;
                case STRING: cellValue = cell.getStringCellValue();break;
                case BOOLEAN: cellValue = String.valueOf(cell.getBooleanCellValue());break;
                case FORMULA: cellValue = String.valueOf(cell.getNumericCellValue());break;
                case BLANK:
                case ERROR: cellValue = ""; break;
                default:cellValue = cell.toString();

            }
        }else {
            return "";
        }
        return cellValue;
    }
}
