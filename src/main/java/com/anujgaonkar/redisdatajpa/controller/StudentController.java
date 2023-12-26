package com.anujgaonkar.redisdatajpa.controller;

import com.anujgaonkar.redisdatajpa.model.Student;
import com.anujgaonkar.redisdatajpa.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/students")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return this.studentService.createStudent(student);
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId) {
        return this.studentService.findById(studentId);
    }

    @GetMapping("/all")
    public List<Student> getAllStudent() {
        return this.studentService.findAll();
    }
}
