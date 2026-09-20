package com.astanait.patterns.abstractfactory;

// The single place in the app that decides which concrete family to use.
// Keeping this decision here (not inside Application) is what keeps the client free of if/switch.
public final class AppConfigurator {

    private AppConfigurator() {
    }

    public static GUIFactory factoryFor(String osName) {
        String normalized = osName == null ? "" : osName.toLowerCase();
        if (normalized.contains("mac")) {
            return new MacFactory();
        }
        return new WinFactory();
    }
}
