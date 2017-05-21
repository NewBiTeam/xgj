package xgj.mcj.entity;

import org.apache.poi.hssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.Calendar;
import java.util.Date;
import java.util.List;  
import java.util.Map;  
  
/** 
 * poi ����excel ������ 
 */  
public class POIUtil {  
  
    /** 
     * 1.���� workbook 
     * @return 
     */  
    public HSSFWorkbook getHSSFWorkbook(){  
        return new HSSFWorkbook();  
    }  
  
    /** 
     * 2.���� sheet 
     * @param hssfWorkbook 
     * @param sheetName sheet ���� 
     * @return 
     */  
    public HSSFSheet getHSSFSheet(HSSFWorkbook hssfWorkbook, String sheetName){  
        return hssfWorkbook.createSheet(sheetName);  
    }  
  
    /** 
     * 3.д���ͷ��Ϣ 
     * @param hssfWorkbook 
     * @param hssfSheet 
     * @param headInfoList List<Map<String, Object>> 
     *              key: title         �б��� 
     *                   columnWidth   �п� 
     *                   dataKey       �ж�Ӧ�� dataList item key 
     */  
    public void writeHeader(HSSFWorkbook hssfWorkbook,HSSFSheet hssfSheet ,List<Map<String, Object>> headInfoList){  
        HSSFCellStyle cs = hssfWorkbook.createCellStyle();  
        HSSFFont font = hssfWorkbook.createFont();  
        font.setFontHeightInPoints((short)12);  
        font.setBoldweight(font.BOLDWEIGHT_BOLD);  
        cs.setFont(font);  
        cs.setAlignment(cs.ALIGN_CENTER);  
  
        HSSFRow r = hssfSheet.createRow(0);  
        r.setHeight((short) 380);  
        HSSFCell c = null;  
        Map<String, Object> headInfo = null;  
        //����excel��ͷ  
        for(int i=0, len = headInfoList.size(); i < len; i++){  
            headInfo = headInfoList.get(i);  
            c = r.createCell(i);  
            c.setCellValue(headInfo.get("title").toString());  
            c.setCellStyle(cs);  
            if(headInfo.containsKey("columnWidth")){  
                hssfSheet.setColumnWidth(i, (short)(((Integer)headInfo.get("columnWidth") * 8) / ((double) 1 / 20)));  
            }  
        }  
    }  
  
    /** 
     * 4.д�����ݲ��� 
     * @param hssfWorkbook 
     * @param hssfSheet 
     * @param startIndex ��1��ʼ����ε�����Ҫ����ǰһ�ε�dataList.size() 
     * @param headInfoList List<Map<String, Object>> 
     *              key: title         �б��� 
     *                   columnWidth   �п� 
     *                   dataKey       �ж�Ӧ�� dataList item key 
     * @param dataList 
     */  
    public void writeContent(HSSFWorkbook hssfWorkbook,HSSFSheet hssfSheet ,int startIndex,  
                                     List<Map<String, Object>> headInfoList, List<Map<String, Object>> dataList){  
        Map<String, Object> headInfo = null;  
        HSSFRow r = null;  
        HSSFCell c = null;  
        //��������  
        Map<String, Object> dataItem = null;  
        Object v = null;  
        for (int i=0, rownum = startIndex, len = (startIndex + dataList.size()); rownum < len; i++,rownum++){  
            r = hssfSheet.createRow(rownum);  
            r.setHeightInPoints(16);  
            dataItem = dataList.get(i);  
            for(int j=0, jlen = headInfoList.size(); j < jlen; j++){  
                headInfo = headInfoList.get(j);  
                c = r.createCell(j);  
                v = dataItem.get(headInfo.get("dataKey").toString());  
  
                if (v instanceof String) {  
                    c.setCellValue((String)v);  
                }else if (v instanceof Boolean) {  
                    c.setCellValue((Boolean)v);  
                }else if (v instanceof Calendar) {  
                    c.setCellValue((Calendar)v);  
                }else if (v instanceof Double) {  
                    c.setCellValue((Double)v);  
                }else if (v instanceof Integer  
                        || v instanceof Long  
                        || v instanceof Short  
                        || v instanceof Float) {  
                    c.setCellValue(Double.parseDouble(v.toString()));  
                }else if (v instanceof HSSFRichTextString) {  
                    c.setCellValue((HSSFRichTextString)v);  
                }else {  
                    c.setCellValue(v.toString());  
                }  
            }  
        }  
    }  
  
    public void write2FilePath(HSSFWorkbook hssfWorkbook, String filePath) throws IOException{  
        FileOutputStream fileOut = null;  
        /*filePath =filePath + "download"
				+ new Date().getTime() + ".xls";*/
        try{  
            fileOut = new FileOutputStream(filePath);  
            hssfWorkbook.write(fileOut);  
        }finally{  
            if(fileOut != null){  
                fileOut.close();  
            }  
        }  
    }  
  
  
    /** 
     * ����excel 
     * code example: 
         List<Map<String, Object>> headInfoList = new ArrayList<Map<String,Object>>(); 
         Map<String, Object> itemMap = new HashMap<String, Object>(); 
         itemMap.put("title", "���1"); 
         itemMap.put("columnWidth", 25); 
         itemMap.put("dataKey", "XH1"); 
         headInfoList.add(itemMap); 
 
         itemMap = new HashMap<String, Object>(); 
         itemMap.put("title", "���2"); 
         itemMap.put("columnWidth", 50); 
         itemMap.put("dataKey", "XH2"); 
         headInfoList.add(itemMap); 
 
         itemMap = new HashMap<String, Object>(); 
         itemMap.put("title", "���3"); 
         itemMap.put("columnWidth", 25); 
         itemMap.put("dataKey", "XH3"); 
         headInfoList.add(itemMap); 
 
         List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>(); 
         Map<String, Object> dataItem = null; 
         for(int i=0; i < 100; i++){ 
         dataItem = new HashMap<String, Object>(); 
         dataItem.put("XH1", "data" + i); 
         dataItem.put("XH2", 88888888f); 
         dataItem.put("XH3", "����V5.."); 
         dataList.add(dataItem); 
         } 
         POIUtil.exportExcel2FilePath("test sheet 1","F:\\temp\\customer2.xls", headInfoList, dataList); 
 
     * @param sheetName   sheet���� 
     * @param filePath   �ļ��洢·���� �磺f:/a.xls 
     * @param headInfoList List<Map<String, Object>> 
     *                           key: title         �б��� 
     *                                columnWidth   �п� 
     *                                dataKey       �ж�Ӧ�� dataList item key 
     * @param dataList  List<Map<String, Object>> ���������� 
     * @throws java.io.IOException 
     * 
     */  
    public static void exportExcel2FilePath(String sheetName, String filePath,  
                                   List<Map<String, Object>> headInfoList,  
                                   List<Map<String, Object>> dataList) throws IOException {  
        POIUtil poiUtil = new POIUtil();  
        //1.���� Workbook  
        HSSFWorkbook hssfWorkbook = poiUtil.getHSSFWorkbook();  
        //2.���� Sheet  
        HSSFSheet hssfSheet = poiUtil.getHSSFSheet(hssfWorkbook, sheetName);  
        //3.д�� head  
        poiUtil.writeHeader(hssfWorkbook, hssfSheet, headInfoList);  
        //4.д������  
        poiUtil.writeContent(hssfWorkbook, hssfSheet, 1, headInfoList, dataList);  
        //5.�����ļ���filePath��  
        poiUtil.write2FilePath(hssfWorkbook, filePath);  
    }  
  
}  