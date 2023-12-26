package com.anujgaonkar.redisdatajpa.repository;

import com.anujgaonkar.redisdatajpa.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
