package com.example.demo.service;

import com.example.demo.domain.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeManager {
    @Autowired
    private StudentMapper studentMapper;

    /* 获取全部学生信息 */
    public List<Student> getAllStudents() {
        return studentMapper.findAll();
    }

    /* 添加学生信息 */
    public void addStudent(Student student) {
        studentMapper.insert(student);
    }

    /* 根据学生 ID 删除学生信息 */
    public void removeStudent(String studentId) {
        studentMapper.deleteByStudentId(studentId);
    }

    /* 根据学生 ID 查询学生信息 */
    public Student findStudent(String studentId) {
        return studentMapper.findByStudentId(studentId);
    }

    /* 根据学生 ID 和新成绩更新学生信息 */
    public void updateStudentGrade(String studentId, double newGrade) {
        Student student = findStudent(studentId);
        if (student != null) {
            student.setGrade(newGrade);
            studentMapper.updateStudentGrade(student);
        }
    }


}
