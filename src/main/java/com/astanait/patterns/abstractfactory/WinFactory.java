package com.astanait.patterns.abstractfactory;

// Concrete Factory: produces the full Windows family
public final class WinFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
