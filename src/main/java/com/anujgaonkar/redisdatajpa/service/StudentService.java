package com.anujgaonkar.redisdatajpa.service;

import com.anujgaonkar.redisdatajpa.repository.StudentRepository;
import com.anujgaonkar.redisdatajpa.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student createStudent(Student student){
        log.info("creating student: {}", student);
        return studentRepository.save(student);
    }

    public Student findById(String studentId) {
        log.info("finding student: {}", studentId);
        return studentRepository.findById(studentId).orElseThrow();
    }

    public List<Student> findAll() {
        Iterable<Student> all = studentRepository.findAll();
        List<Student> students = new ArrayList<>();
        all.forEach(students::add);
        return students;
    }
}
