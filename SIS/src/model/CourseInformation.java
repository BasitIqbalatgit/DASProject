package model;


import common.Course;
import common.Student;
import dsa.linklist.LinkedList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CourseInformation {


  
    public static LinkedList<Course> getCourses(String excelFilePath) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        LinkedList<Course> courseList = new LinkedList<>();

        for (int rowIndex = 1; rowIndex <= 34; rowIndex++) {
            Row row = sheet.getRow(rowIndex);          
            
            Course course = new Course();
            
            course.setCourseCode(row.getCell(0).getStringCellValue());
            course.setCourseName(row.getCell(1).getStringCellValue());
                String cHour = String.valueOf(row.getCell(2).getNumericCellValue());
                course.setCreditHour(cHour);
            courseList.add(course);
            System.out.println(course.toString());
        }

        workbook.close();
        fileInputStream.close();
        return courseList;
    }
    
 }
