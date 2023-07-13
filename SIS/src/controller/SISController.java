/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAL.DALManager;
import common.Course;
import common.Student;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Response;
import model.StudentInformation;
import common.UserDTO;
import dsa.linklist.LinkedList;
import dsa.linklist.Node;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.CourseInformation;
//import java.lang.System.Logger;
//import java.lang.System.Logger.Level;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author fawad
 */
public class SISController {

    DALManager dalManager;

    public SISController() {
        dalManager = new DALManager();
    }

    public void verifyUser(UserDTO user, Response res) {
        dalManager.verifyUser(user, res);
    }

    public void saveUser(UserDTO user, Response res) {
        dalManager.saveUser(user, res);
    }

    public static void writeStudentToExcel(Student student) {
        String relativePath = "../data/students.xlsx";

        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();
        try {
            Workbook workbook = null;
            Sheet sheet;
            Row dataRow;

            // Check if the file already exists
            if (new File(absolutePath).exists()) {
                FileInputStream fis = new FileInputStream(absolutePath);
                try {
                    workbook = WorkbookFactory.create(fis);
                } catch (InvalidFormatException ex) {
//                    Logger.getLogger(SISController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sheet = workbook.getSheet("Sheet3");
                int lastRowNum = sheet.getLastRowNum();
                dataRow = sheet.createRow(lastRowNum + 1);
                fis.close();
            } else {
                // Create new workbook and sheet if the file doesn't exist
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Students");
                dataRow = sheet.createRow(0); // Start from row 1 (0-based index)
            }

            // Create header row if it doesn't exist
            if (sheet.getRow(0) == null) {
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Name");
                headerRow.createCell(1).setCellValue("Father's Name");
                headerRow.createCell(2).setCellValue("CNIC");
                headerRow.createCell(3).setCellValue("FSC Marks");
                headerRow.createCell(4).setCellValue("Reg No");
                headerRow.createCell(5).setCellValue("Program");
            }

            // Populate data row with student values
            dataRow.createCell(0).setCellValue(student.getName());
            dataRow.createCell(1).setCellValue(student.getFatherName());
            dataRow.createCell(2).setCellValue(student.getCnic());
            dataRow.createCell(3).setCellValue(student.getFscMarks());
            dataRow.createCell(4).setCellValue(student.getRegNo());
            dataRow.createCell(5).setCellValue(student.getProg());

            // Save the workbook to a file
            try (FileOutputStream outputStream = new FileOutputStream(absolutePath)) {
                workbook.write(outputStream);
            }
            workbook.close();

        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }

}
