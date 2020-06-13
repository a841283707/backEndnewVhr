package org.javaboy.vhr.config.utils;

import org.apache.poi.xssf.usermodel.*;
import org.javaboy.vhr.bean.Employee;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PoiUtils {
    public static XSSFWorkbook exportExcel(Class schema, Map<String, String> title, List<?> list) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            // Excel底部每张表的名称
            XSSFSheet sheet = workbook.createSheet("sheet1");

            sheet.setDefaultColumnWidth((short) 15);

            XSSFRow row = sheet.createRow(0);

            Field[] fields = schema.getDeclaredFields();

            int index1 = 0;
            for (Field field : fields) {
                if (title.containsKey(field.getName())) {
                    XSSFCell cell = row.createCell(index1);
                    XSSFRichTextString text = new XSSFRichTextString(title.get(field.getName()));
                    cell.setCellValue(text);
                    index1++;
                }
            }

            for (int i = 0, len = list.size(); i < len; i++) {
                row = sheet.createRow(i + 1);
                Object object = list.get(i);

                int index2 = 0;
                for (Field field: fields) {
                    String filedName = field.getName();

                    if (title.containsKey(filedName)) {
                        XSSFCell cell = row.createCell(index2);

                        String getMethodName = "get" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);

                        Method getMethod = schema.getMethod(getMethodName);
                        Object value = getMethod.invoke(object);
                        XSSFRichTextString text = new XSSFRichTextString(String.valueOf(value));
                        cell.setCellValue(text);

                        index2++;
                    }
                }
            }

            return workbook;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void exportFile(HttpServletResponse response, XSSFWorkbook workbook) {
        if (workbook != null) {
            String fileName = "gzyr_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".xlsx";
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/octet-stream;charset=GB2312");
            response.setCharacterEncoding("GB2312");
            OutputStream outputStream;
            try {
                outputStream = response.getOutputStream();
                workbook.write(outputStream);
                outputStream.flush();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                response.getWriter().print("error");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static List<Employee> parseFile2List(MultipartFile file) throws IOException {
        List<Employee> pEntities=new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet sheet = workbook.getSheetAt(0);
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();//获取表单所有的行
        for (int i = 1; i < physicalNumberOfRows; i++) {
            XSSFRow row = sheet.getRow(i);
            Employee employee=new Employee();
//            我设定的导入模板第一列是序号，所以取值舍弃了第一列，如有需求可放开注释对应修改即可
//            HSSFCell c0 = row.getCell(0);
//            j1.setId((int) c0.getNumericCellValue());

/*            XSSFCell c1 = row.getCell(1);
            personnelTblEntity.setName(c1.getStringCellValue());

            XSSFCell c2 = row.getCell(2);
            personnelTblEntity.setCardNo(c2.getStringCellValue());

            XSSFCell c3 = row.getCell(3);
            personnelTblEntity.setPhone(c3.getStringCellValue());

            XSSFCell c4 = row.getCell(4);
            personnelTblEntity.setGender(c4.getStringCellValue().equals("男")?"0":"1");

            pEntities.add(personnelTblEntity);*/
        }

        return pEntities;
    }
}
