package com.phaete;

public record Animal(
        int id,
        String name,
        Species species,
        int age,
        Owner owner
) {

}
