package com.astanait.patterns.abstractfactory;

// Concrete Product: macOS family
public final class MacCheckbox implements Checkbox {

    private boolean checked = false;

    @Override
    public void paint() {
        System.out.println("[macOS] Rendering a rounded checkbox.");
    }

    @Override
    public void toggle() {
        checked = !checked;
        System.out.println("[macOS] Checkbox toggled (checked=" + checked + ").");
    }
}
