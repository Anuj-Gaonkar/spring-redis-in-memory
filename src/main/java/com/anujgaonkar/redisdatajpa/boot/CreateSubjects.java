package com.anujgaonkar.redisdatajpa.boot;

import com.anujgaonkar.redisdatajpa.model.Subject;
import com.anujgaonkar.redisdatajpa.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
@Order(1)
public class CreateSubjects implements CommandLineRunner {

    private final SubjectRepository subjectRepository;

    @Override
    public void run(String... args) throws Exception {
        if (subjectRepository.count() == 0) {
            log.info("creating subjects");
            Subject maths = Subject.builder()
                    .name("Mathematics")
                    .faculty("Govind Sir")
                    .build();

            Subject science = Subject.builder()
                    .name("science")
                    .faculty("Rohini ma'am")
                    .build();

            subjectRepository.save(maths);
            subjectRepository.save(science);
            log.info("Saving maths {} and science {}", maths, science);
        }
    }
}
