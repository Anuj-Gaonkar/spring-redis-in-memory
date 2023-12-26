package com.anujgaonkar.redisdatajpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;

@RedisHash
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public enum Gender {
        MALE, FEMALE
    }
    @Id
    private String id;

    @Indexed
    private String name;
    private Gender gender;
    private int grade;

    @Reference
    private List<Subject> subjects = new ArrayList<>();

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

}
