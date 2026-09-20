package com.astanait.patterns.abstractfactory;

// Client: depends only on GUIFactory + abstract products, no concrete classes, no if/switch
public final class Application {

    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void renderUi() {
        button.paint();
        checkbox.paint();
    }

    public void simulateUserInteraction() {
        button.click();
        checkbox.toggle();
    }
}
