/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author CUI
 */
public class Course {
    private String courseCode;
    private String courseName;
    private String creditHour;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(String creditHour) {
        this.creditHour = creditHour;
    }
    
    public String toString() {
    return "{" +
            "\"course ID\":\"" + courseCode + "\"" +
            ", \"course Name\":\"" + courseName + "\"" +
            ", \"credit Hour\":\"" + creditHour + "\"" +
            "}";
}
}
