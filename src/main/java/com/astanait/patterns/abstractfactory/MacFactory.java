package com.astanait.patterns.abstractfactory;

// Concrete Factory: produces the full macOS family
public final class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
