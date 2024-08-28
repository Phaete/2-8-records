package com.phaete;

public record Student(
        String id,
        String name,
        int age
) {

    public Student withName(String name) {
        return new Student(id, name, age);
    }
}
