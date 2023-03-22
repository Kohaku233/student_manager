package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.Student;
import com.example.demo.service.GradeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {
    @Autowired
    private GradeManager gradeManager;

    @GetMapping
    public ApiResponse getAllStudents() {
        List<Student> students = gradeManager.getAllStudents();
        return new ApiResponse("success", students);
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        gradeManager.addStudent(student);
        return new ApiResponse("success", "添加学生信息成功");
    }

    @GetMapping("/get")
    public ApiResponse getStudent(@RequestParam String studentId) {
        Student student = gradeManager.findStudent(studentId);
        if (student != null) {
            return new ApiResponse("success", student);
        } else {
            return new ApiResponse("fail", "Student not found");
        }
    }

    @PostMapping("/update")
    public ApiResponse updateStudent(@RequestParam String studentId, @RequestParam double newGrade) {
        Student student = gradeManager.findStudent(studentId);
        if (student != null) {
            gradeManager.updateStudentGrade(studentId, newGrade);
            return new ApiResponse("success", "成绩已修改为" + newGrade);
        } else {
            return new ApiResponse("fail", "成绩修改失败，请查看传参是否正确");
        }
    }

    @PostMapping("/delete")
    public ApiResponse deleteStudent(@RequestParam String studentId) {
        Student student = gradeManager.findStudent(studentId);
        if (student != null) {
            gradeManager.removeStudent(studentId);
            return new ApiResponse("success", student);
        } else {
            return new ApiResponse("fail", "删除学生失败，请查看学号是否正确 ");
        }
    }
}
