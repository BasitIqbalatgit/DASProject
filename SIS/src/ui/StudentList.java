package ui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author fawad
 */
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;

public class StudentList extends JPanel {
    private JPanel studentList;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField searchField;

    public StudentList() {

        setLayout(new BorderLayout());

        // Create the table model
        String[] columnNames = {"Sr.#", "Reg#", "Prog", "Name", "Father Name", "Contact#", "IDCard#", "Date of Birth",
                "Nationality", "Status", "Group", "Marks", "Obt"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Create the table
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Create the search panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchTable(searchField.getText()));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.NORTH);

        // Populate the table with data from Excel
        String excelFilePath = "/home/fawad/Desktop/students.xlsx";
        try {
            populateTableFromExcel(excelFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error reading Excel file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

       
    }

    private void populateTableFromExcel(String excelFilePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(3);

        for (Row row : sheet) {
            Object[] rowData = new Object[row.getLastCellNum()];
            for (int i = 0; i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);
                if (cell != null) {
                    switch (cell.getCellTypeEnum()) {
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                rowData[i] = cell.getDateCellValue();
                            } else {
                                rowData[i] = cell.getNumericCellValue();
                            }
                            break;
                        case STRING:
                            rowData[i] = cell.getStringCellValue();
                            break;
                        default:
                            rowData[i] = "";
                            break;
                    }
                } else {
                    rowData[i] = "";
                }
            }
            tableModel.addRow(rowData);
        }

        workbook.close();
        fileInputStream.close();
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
