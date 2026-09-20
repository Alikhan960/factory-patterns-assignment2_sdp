package com.astanait.patterns.factorymethod;

// Creator: declares the factory method, subclasses decide the concrete Transport
public abstract class Logistics {

    protected abstract Transport createTransport(int capacityTons);

    // Business logic that depends only on the Transport interface
    public final void planDelivery(int capacityTons) {
        Transport transport = createTransport(capacityTons);
        System.out.println("Logistics: planning delivery via " + transport.getClass().getSimpleName() + "...");
        transport.deliver();
    }
}
