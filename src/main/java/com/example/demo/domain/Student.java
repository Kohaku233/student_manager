package com.example.demo.domain;

public class Student {
    private Long id;
    private String name;
    private String studentId;
    private double grade;

    public Student(Long id, String name, String studentId, double grade) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", grade=" + grade +
                '}';
    }
}
