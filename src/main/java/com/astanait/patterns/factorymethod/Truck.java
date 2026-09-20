package com.astanait.patterns.factorymethod;

// Concrete Product: delivers by land
public final class Truck implements Transport {

    private final int capacityTons;

    public Truck(int capacityTons) {
        if (capacityTons <= 0) {
            throw new IllegalArgumentException("Truck capacity must be positive, got: " + capacityTons);
        }
        this.capacityTons = capacityTons;
    }

    @Override
    public void deliver() {
        System.out.println("Truck: delivering " + capacityTons + "t of cargo by land, in a box.");
    }

    @Override
    public int getCapacityTons() {
        return capacityTons;
    }
}
