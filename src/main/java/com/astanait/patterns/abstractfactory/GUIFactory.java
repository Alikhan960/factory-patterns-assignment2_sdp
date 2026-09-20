package com.astanait.patterns.abstractfactory;

// Abstract Factory: one creation method per product type in the family
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
