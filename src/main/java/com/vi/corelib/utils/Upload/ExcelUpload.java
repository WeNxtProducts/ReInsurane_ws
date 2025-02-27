package com.vi.corelib.utils.Upload;

import com.vi.corelib.config.Config;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j

@Service
public class ExcelUpload {

    Workbook workbook;
    HashMap<String,Object> template;
    Long templateId;

    public ExcelUpload(Long templateId) {
        this.templateId = templateId;

    }
    public List<HashMap<String, Object>> getHashMapOnlyColumns(Long documentId,String sheetName) {
        return start(documentId,sheetName,"columns");
    }
    public List<HashMap<String, Object>> getHashMap(Long documentId,String sheetName) {
        return start(documentId,sheetName,"hash");
    }

    public List<HashMap<String, Object>> getSqlStatement(Long documentId,String sheetName) {
        return start(documentId,sheetName,"sql");
    }
    @SneakyThrows
    public List<HashMap<String, Object>> start(Long documentId,String sheet,String type) {
        System.out.println(documentId + " dataDocumentId");
        this.template  = this.getDataMappingTemplate(documentId);
        File file =new File(this.template.get("path").toString());
        FileInputStream fileStream  = new FileInputStream(file);
        this.workbook= new XSSFWorkbook(fileStream);
        List<String> sheetNames = this.getSheets();
        for(String sheetName : sheetNames) {
            if(sheetName.equals(sheet)) {
                return this.readData(sheetName, type);
            }
        }
        return null;
    }
    private List<String> getSheets() {
        return IntStream.range(0, this.workbook.getNumberOfSheets())
                .mapToObj(workbook::getSheetAt)
                .map(Sheet::getSheetName)
                .collect(Collectors.toList());
    }
    private List<HashMap<String, Object>>  readData(String sheetName,String type) {
        List<String> list =  new ArrayList<String>();
        Integer llRowKIndex =0;
        List<String> sqlStatement = new ArrayList<>();
        Sheet sheet = this.workbook.getSheet(sheetName);
       // List<HashMap<String,Object>> rowObject = new List<HashMap<>>();
        List<HashMap<String, Object>> data = new ArrayList<>();

        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            HashMap<String,Object> rowObject = new HashMap<>();
            Iterator<Cell>cellIterator = row.iterator();
            Integer llColumnIndex=0;
            if(llRowKIndex==5 && type.equals("columns")) {
                break;
            }
            int lastColumn = Math.max(row.getLastCellNum(),1);
            for (int cn = 0; cn < lastColumn; cn++) {
                Cell cell = row.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                if(llRowKIndex.equals(0)) {
                    list.add(cell.getStringCellValue().replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
                }
                else {
                    if(cell==null) {
                        rowObject.put(list.get(llColumnIndex), null);//cell.getStringCellValue());
                        llColumnIndex++;
                        continue;
                    }
          //  while(cellIterator.hasNext()) {
                //Cell cell = cellIterator.next();

                  //  if (this.template.get("columns").toString().contains(list.get(llColumnIndex))) {
                        CellType cellType = cell.getCellType();
                        switch (cellType) {
                            case STRING:
                                String strValue;

                                strValue = cell.getStringCellValue().replace("'"," ").trim();
                                rowObject.put(list.get(llColumnIndex), strValue);//cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                if (this.isDate(cell)) {
                                    rowObject.put(list.get(llColumnIndex), converDate(cell));
                                } else {
                                    cell.setCellType(CellType.STRING);
                                    rowObject.put(list.get(llColumnIndex), cell.getStringCellValue());//  cell.getNumericCellValue());
                                }
                        }
                        llColumnIndex++;
                    //}
                }

            }
            llRowKIndex++;
            //sqlStatement.add(getInsertStatement(rowObject,list));
            data.add(rowObject);
            llRowKIndex++;
            //Row Completed
            System.out.print(rowObject);
        }
        if(type.equals("sql")) {
            HashMap<String, Object> sql = new HashMap<String, Object>();
            sql.put("statements", sqlStatement);
            data.add(sql);
        }
        return data;
    }
    private Boolean isDate(Cell cell) {
        return DateUtil.isCellDateFormatted(cell);
    }
    private String converDate(Cell cell) {
        Date d = cell.getDateCellValue();
        SimpleDateFormat sf = new SimpleDateFormat();
        return sf.format(d);
    }
    private  HashMap<String,Object> getDataMappingTemplate(Long documentId) throws IOException, ParseException {
            HashMap<String,Object> hashMap = new HashMap<String,Object>();
            System.out.println("inside the mappingTemplate");
            System.out.println(new Config().getDataMappingFolderPath() + " dataMapping file path step0 ");
            //String path = (new Config()).getFilePath(Long.valueOf(documentId));
          //  String path = new StringBuilder(new Config().getFileRepositoryPath()).append(documentId.toString()).append(".xlsx").toString();
            String path = new StringBuilder(new Config().getDataMappingFolderPath()).append(documentId.toString()).append(".xlsx").toString();
            System.out.println(path + " dataMapping file path step1 ");
            if(new File(path).exists()) {
                hashMap.put("path",path);
                System.out.println(" inside a step 2");
            } else {
                path = new StringBuilder(new Config().getFileRepositoryPath()).append(documentId.toString()).append(".xlsx").toString();
                hashMap.put("path",path);
                System.out.println(" inside a step 3 else");
            }
            hashMap.put("columns","a,b");
            hashMap.put("tableName","abc");
            System.out.println(" inside last step " + hashMap);
            return hashMap;
    }
    private String  getInsertStatement(HashMap<String,Object> hashMap,List<String>columnNames) {
            if(!hashMap.isEmpty()) {
                StringBuilder sql = new StringBuilder("INSERT INTO ")
                        .append(this.template.get("tableName"))
                        .append(" ( ")
                        .append(String.join(",", columnNames))
                        .append(" ) values ( ");
                List<String> values = new ArrayList<String>();
                for (String column : columnNames) {
                   // System.out.print(column);
                    //System.out.print(hashMap);
                    if (hashMap.get(column) != null) {
                        System.out.print(hashMap.get(column).getClass());
                        if (hashMap.get(column).getClass().equals(Long.class) || hashMap.get(column).getClass().equals(Double.class) ) {
                            values.add(hashMap.get(column).toString());
                        } else if (hashMap.get(column).getClass().equals(String.class)) {
                            values.add(new StringBuilder(" ' ").append(hashMap.get(column)).append(" ' ").toString());
                        }
                    }
                }
                sql.append(String.join(",", values)).append(" ) ");
                System.out.println(sql.toString());
             return sql.toString();
            }
            return "";
    }
}
