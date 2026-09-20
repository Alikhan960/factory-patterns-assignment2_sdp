package com.astanait.patterns.factorymethod;

// Concrete Product: delivers by sea
public final class Ship implements Transport {

    private final int capacityTons;

    public Ship(int capacityTons) {
        if (capacityTons <= 0) {
            throw new IllegalArgumentException("Ship capacity must be positive, got: " + capacityTons);
        }
        this.capacityTons = capacityTons;
    }

    @Override
    public void deliver() {
        System.out.println("Ship: delivering " + capacityTons + "t of cargo by sea, in a container.");
    }

    @Override
    public int getCapacityTons() {
        return capacityTons;
    }
}
