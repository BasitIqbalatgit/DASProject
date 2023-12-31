package model;


import common.Student;
import dsa.linklist.LinkedList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class StudentInformation {


  
    public static LinkedList<Student> getStudents(String excelFilePath) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(1);
        LinkedList<Student> studentList = new LinkedList<>();

        for (int rowIndex = 1; rowIndex <= 1044; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            
            Student student = new Student();
            student.setRegNo(row.getCell(1).getStringCellValue());
            student.setProg(row.getCell(2).getStringCellValue());
            student.setName(row.getCell(3).getStringCellValue());
            student.setFatherName(row.getCell(4).getStringCellValue());
            student.setNationality(row.getCell(8).getStringCellValue());
            student.setStatus(row.getCell(9).getStringCellValue());
            student.setGroup(row.getCell(10).getStringCellValue());
            studentList.add(student);
        }

        workbook.close();
        fileInputStream.close();
        return studentList;
    }
    
 }
