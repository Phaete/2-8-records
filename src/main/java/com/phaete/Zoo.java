package com.phaete;

import java.util.List;

public record Zoo(
        List<Animal> animals
) {
    public int calculateTotalFoodRequirement() {
        int totalFoodRequirement = 0;
        for (Animal animal : animals) {
            totalFoodRequirement += animal.species().foodRequirementsInGramsPerDay();
        }
        return totalFoodRequirement;
    }
}
