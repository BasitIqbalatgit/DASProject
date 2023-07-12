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

    public StudentList() throws IOException {

        setLayout(new BorderLayout());

        // Create the table model
        String[] columnNames = {"Reg#", "Prog", "Name", "Father Name", 
                "Nationality", "Status", "Group", };
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create the table
        

        // Create the search panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchTable(searchField.getText()));
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
        ArrayList<Student> list;
        list=StudentInformation.getStudents(absolutePath);
        // Add rows to the model using the data from the ArrayList
        for (Student student : list) {
            System.out.print(student.getRegNo());
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
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

       
    }

    

    private void searchTable(String searchText) {
        if (searchText.isEmpty()) {
            return; // Don't perform search if the search text is empty
        }

        String searchLowercase = searchText.toLowerCase();

        boolean found = false;

        for (int row = 0; row < table.getRowCount(); row++) {
            String regNo = String.valueOf(table.getValueAt(row, 1)).toLowerCase(); // Assuming Reg# is at index 1
            if (regNo.contains(searchLowercase)) {
                table.setRowSelectionInterval(row, row);
                table.scrollRectToVisible(table.getCellRect(row, 0, true));
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "No results found for: " + searchText, "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
