package com.example.courseentry;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public static final String SEIP = "SEIP";
    public static final String PAID = "PAID";
    private String name;
    private String courseName;
    private String courseType;

    public Student(String name, String courseName, String courseType) {
        this.name = name;
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }
    //arrayList
    public static List<String>paidCourseList = new ArrayList<>();
    public static List<String>seipCourseList = new ArrayList<>();
    public static List<Student>studentList = new ArrayList<>();

    static {
        paidCourseList.add("Mastering Flutter on Android and ios");
        paidCourseList.add("Professional Android App Development with Java");
        paidCourseList.add("Professional Android App Development with Kotlin");
        paidCourseList.add("Web Development using Laravel and Vue");
        paidCourseList.add("Graphics Design");

        seipCourseList.add("Mobile Application Development Android");
        seipCourseList.add("Graphics & UI Design");
        seipCourseList.add("Dot Net Framework");
        seipCourseList.add("Server Administration");
    }
}
