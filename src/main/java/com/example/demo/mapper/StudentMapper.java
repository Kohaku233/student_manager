package com.example.demo.mapper;

import com.example.demo.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> findAll();

    void insert(Student student);

    Student findByStudentId(String studentId);

    void updateStudentGrade(Student student);

    void deleteByStudentId(String studentId);
}
