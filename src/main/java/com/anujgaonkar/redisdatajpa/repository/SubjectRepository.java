package com.anujgaonkar.redisdatajpa.repository;

import com.anujgaonkar.redisdatajpa.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    Subject findFirstByName(String name);
}
