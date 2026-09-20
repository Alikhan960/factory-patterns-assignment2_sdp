package com.astanait.patterns.factorymethod;

// Product: common contract for all transport types
public interface Transport {
    void deliver();
    int getCapacityTons();
}
