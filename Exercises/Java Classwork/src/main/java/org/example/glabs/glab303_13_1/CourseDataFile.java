package org.example.glabs.glab303_13_1;

public class CourseDataFile {
    private String code, course_name, instructor_name;
    public CourseDataFile (String code, String name, String instructor) {
        this.code = code;
        this.course_name = name;
        this.instructor_name = instructor;
    }
    public CourseDataFile () {
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCourse_name() {
        return course_name;
    }
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
    public String getInstructor_name() {
        return instructor_name;
    }
    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }
}



