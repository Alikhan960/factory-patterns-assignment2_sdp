package com.astanait.patterns.factorymethod;

// Concrete Creator: produces a Truck
public final class RoadLogistics extends Logistics {

    @Override
    protected Transport createTransport(int capacityTons) {
        return new Truck(capacityTons);
    }
}
