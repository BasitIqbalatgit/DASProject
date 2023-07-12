/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Student;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Message;
import model.MessageType;
import model.Response;
import model.StudentInformation;
import model.UserDTO;

/**
 *
 * @author fawad
 */
public class SISController {

    public void verifyUser(UserDTO user, Response res) {
        if (user.getUsername().equals("fawad") && user.getPassword().equals("root")) {
            user.setRole("faculty");
        } else if (user.getUsername().equals("basit") && user.getPassword().equals("root")) {
            user.setRole("faculty");
        } else {
            res.messagesList.addAtEnd(new Message("Invalid credentials.", MessageType.Error));
        }
    }

    public static JScrollPane getStudentListPanel() {
        ArrayList<Student> list;
        try {
            String relativePath = "../data/students.xlsx";

            File file = new File(relativePath);
            String absolutePath = file.getAbsolutePath();

            list = StudentInformation.getStudents(absolutePath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            list = null;
        }
//        if(!(list==null)){
        // Create a DefaultTableModel to hold the data for the JTable
        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model
        model.addColumn("Registration Number");
        model.addColumn("Program");
        model.addColumn("Name");
        model.addColumn("Father's Name");
        model.addColumn("Nationality");
        model.addColumn("Status");
        model.addColumn("Group");

        // Add rows to the model using the data from the ArrayList
        for (Student student : list) {
            model.addRow(new Object[]{
                student.getRegNo(),
                student.getProg(),
                student.getName(),
                student.getFatherName(),
                student.getNationality(),
                student.getStatus(),
                student.getGroup()
            });
        }

        // Create a JTable with the created model
        JTable table = new JTable(model);

        // Create a JScrollPane to hold the JTable
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        // Return Jpanel
        return scrollPane;
//        }
//        
//        return new JScrollPane();
    }
}
