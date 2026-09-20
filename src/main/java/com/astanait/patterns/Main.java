package com.astanait.patterns;

import com.astanait.patterns.abstractfactory.AppConfigurator;
import com.astanait.patterns.abstractfactory.Application;
import com.astanait.patterns.abstractfactory.GUIFactory;
import com.astanait.patterns.abstractfactory.MacFactory;
import com.astanait.patterns.factorymethod.Logistics;
import com.astanait.patterns.factorymethod.RoadLogistics;
import com.astanait.patterns.factorymethod.SeaLogistics;

public final class Main {

    public static void main(String[] args) {
        System.out.println("=== Part A: Factory Method (Logistics / Transport) ===");
        runFactoryMethodDemo();

        System.out.println();
        System.out.println("=== Part B: Abstract Factory (GUI toolkit) ===");
        runAbstractFactoryDemo();
    }

    private static void runFactoryMethodDemo() {
        Logistics roadLogistics = new RoadLogistics();
        roadLogistics.planDelivery(12);

        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery(500);
    }

    private static void runAbstractFactoryDemo() {
        GUIFactory factory = AppConfigurator.factoryFor(System.getProperty("os.name"));
        Application app = new Application(factory);
        app.renderUi();
        app.simulateUserInteraction();

        System.out.println();
        System.out.println("-- forcing the other family explicitly, for the demo --");
        Application macApp = new Application(new MacFactory());
        macApp.renderUi();
        macApp.simulateUserInteraction();
    }
}
