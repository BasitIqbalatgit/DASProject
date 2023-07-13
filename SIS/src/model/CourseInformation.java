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
            //student.setSrNo(""+row.getCell(0).getNumericCellValue());
//            student.setRegNo(row.getCell(1).getStringCellValue());
//            student.setProg(row.getCell(2).getStringCellValue());
//            student.setName(row.getCell(3).getStringCellValue());
//            student.setFatherName(row.getCell(4).getStringCellValue());
//            student.setNationality(row.getCell(8).getStringCellValue());
//            student.setStatus(row.getCell(9).getStringCellValue());
//            student.setGroup(row.getCell(10).getStringCellValue());
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
