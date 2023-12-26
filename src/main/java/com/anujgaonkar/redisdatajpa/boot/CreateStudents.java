package com.anujgaonkar.redisdatajpa.boot;

import com.anujgaonkar.redisdatajpa.model.Student;
import com.anujgaonkar.redisdatajpa.model.Subject;
import com.anujgaonkar.redisdatajpa.repository.StudentRepository;
import com.anujgaonkar.redisdatajpa.repository.SubjectRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@Order(2)
@Slf4j
@RequiredArgsConstructor
public class CreateStudents implements CommandLineRunner {

    private final StudentRepository studentRepository;

    private final SubjectRepository subjectRepository;

    @Override
    public void run(String... args) throws Exception {

        Subject mathematics = subjectRepository.findFirstByName("Mathematics");
        Subject science = subjectRepository.findFirstByName("science");
        log.info("Mathematics -> {} and science -> {}", mathematics.getId(), science.getId());

        if (studentRepository.count() == 0) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                TypeReference<List<Student>> typeReference = new TypeReference<List<Student>>() {
                };
                InputStream inputStream = getClass().getResourceAsStream("/data/students.json");

                List<Student> students = mapper.readValue(inputStream, typeReference);

                students.forEach(s -> {
                            s.addSubject(mathematics);
                            s.addSubject(science);
                            studentRepository.save(s);
                        });
                log.info(">>>> {} Students Saved", students.size());
            } catch (Exception ex) {
                log.info(">>>> Unable to create students -> {}", ex.getMessage());
            }
        }
    }
}
