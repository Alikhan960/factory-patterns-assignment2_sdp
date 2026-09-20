package com.astanait.patterns.abstractfactory;

// Concrete Product: Windows family
public final class WinButton implements Button {

    private boolean clicked = false;

    @Override
    public void paint() {
        System.out.println("[Windows] Rendering a square, flat-style button.");
    }

    @Override
    public void click() {
        clicked = true;
        System.out.println("[Windows] Button clicked (state=" + clicked + ").");
    }
}
