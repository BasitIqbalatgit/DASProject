package ui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author fawad
 */
import common.Course;
import common.Student;
import dsa.linklist.LinkedList;
import dsa.linklist.Node;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import model.CourseInformation;
import model.StudentInformation;

public class CourseList extends JPanel {

    private JPanel studentList;
    private DefaultTableModel tableModel;
    private final JTable table;
    private JTextField searchField;
    LinkedList<Course> list;

    public CourseList() throws IOException {

        setLayout(new BorderLayout());

        // Create the table model
        String[] columnNames = {"Course Code#", "Course Name", "Credit Hour"};
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
        String relativePath = "../data/courses.xlsx";

        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();

        DefaultTableModel model = new DefaultTableModel();

        // Add columns to the model
        model.addColumn("Course Code#");
        model.addColumn("Course Name");
        model.addColumn("Credit Hour");
        
        list = CourseInformation.getCourses(absolutePath);
        // Add rows to the model using the data from the ArrayList
        Node<Course> currentNode = list.head;
        while (currentNode != null) {
            Course course = currentNode.getData();
            // Access student properties and add rows to the model
            model.addRow(new Object[]{
                course.getCourseCode(),
                course.getCourseName(),
                course.getCreditHour(),
                
            });

            currentNode = currentNode.next;
        }
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

    }

    
    private void searchTable(String searchText,LinkedList<Course> list) {
        if (searchText.isEmpty()) {
            return; // Don't perform search if the search text is empty
        }

        String searchLowercase = searchText.toUpperCase();

        boolean found = false;

        Course c=list.findCourse(searchLowercase);
        
        JOptionPane.showMessageDialog(studentList, c.toString());
    }
}
