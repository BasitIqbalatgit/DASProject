package ui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author fawad
 */
import common.Student;
import dsa.linklist.LinkedList;
import dsa.linklist.Node;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.StudentInformation;

public class StudentList extends JPanel {

    private JPanel studentList;
    private DefaultTableModel tableModel;
    private final JTable table;
    private JTextField searchField;
    LinkedList<Student> list;

    public StudentList() throws IOException {

        setLayout(new BorderLayout());

        // Create the table model
        String[] columnNames = {"Reg#", "Prog", "Name", "Father Name",
            "Nationality", "Status", "Group",};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create the table
        // Create the search panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchTable(searchField.getText(),list));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        // Populate the table with data from Excel
        String relativePath = "../data/students.xlsx";

        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();

        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model
        model.addColumn("Registration Number");
        model.addColumn("Program");
        model.addColumn("Name");
        model.addColumn("Father's Name");
        model.addColumn("Nationality");
        model.addColumn("Status");
        model.addColumn("Group");
        
        list = StudentInformation.getStudents(absolutePath);
        // Add rows to the model using the data from the ArrayList
        Node<Student> currentNode = list.head;
        while (currentNode != null) {
            Student student = currentNode.getData();
            // Access student properties and add rows to the model
            System.out.println(student.getRegNo());
            model.addRow(new Object[]{
                student.getRegNo(),
                student.getProg(),
                student.getName(),
                student.getFatherName(),
                student.getNationality(),
                student.getStatus(),
                student.getGroup()
            });

            currentNode = currentNode.next;
        }
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);
    }

    private void searchTable(String searchText,LinkedList<Student> list) {
        if (searchText.isEmpty()) {
            
            
            
            return; // Don't perform search if the search text is empty
        }
        String searchLowercase = searchText.toLowerCase();
        boolean found = false;

        Student s=list.find(searchText);
        JOptionPane.showMessageDialog(studentList, s.toString());
    }
}
