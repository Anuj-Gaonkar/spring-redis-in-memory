package com.neosoft.redispoc.service;

import com.neosoft.redispoc.model.Student;
import com.neosoft.redispoc.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(Student student){
        log.info("creating student: {}", student);
        return studentRepository.save(student);
    }

}
