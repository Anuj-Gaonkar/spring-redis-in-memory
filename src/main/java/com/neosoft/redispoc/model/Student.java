package com.neosoft.redispoc.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
@Data
@Builder
public class Student {

    public enum Gender {
        MALE, FEMALE
    }
    private String id;
    private String name;
    private Gender gender;
    private int grade;
}
