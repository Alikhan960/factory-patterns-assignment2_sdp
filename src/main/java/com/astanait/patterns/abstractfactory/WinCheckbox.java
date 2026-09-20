package com.astanait.patterns.abstractfactory;

// Concrete Product: Windows family
public final class WinCheckbox implements Checkbox {

    private boolean checked = false;

    @Override
    public void paint() {
        System.out.println("[Windows] Rendering a square checkbox.");
    }

    @Override
    public void toggle() {
        checked = !checked;
        System.out.println("[Windows] Checkbox toggled (checked=" + checked + ").");
    }
}
