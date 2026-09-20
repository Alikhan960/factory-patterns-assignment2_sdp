package com.astanait.patterns.abstractfactory;

// Concrete Product: macOS family
public final class MacButton implements Button {

    private boolean clicked = false;

    @Override
    public void paint() {
        System.out.println("[macOS] Rendering a rounded, translucent button.");
    }

    @Override
    public void click() {
        clicked = true;
        System.out.println("[macOS] Button clicked (state=" + clicked + ").");
    }
}
