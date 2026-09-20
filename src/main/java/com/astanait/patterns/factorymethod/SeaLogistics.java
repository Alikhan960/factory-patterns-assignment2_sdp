package com.astanait.patterns.factorymethod;

// Concrete Creator: produces a Ship
public final class SeaLogistics extends Logistics {

    @Override
    protected Transport createTransport(int capacityTons) {
        return new Ship(capacityTons);
    }
}
