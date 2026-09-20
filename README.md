# Assignment #2 — Factory Method & Abstract Factory

**Course:** ShP-2216 – Software Design Patterns (OP 6B06102)
**Institution:** Astana IT University — School of Computer Engineering
**Option chosen:** Option A — Logistics / Transport (Factory Method) extended into a cross-platform GUI toolkit (Abstract Factory)

## 1. What this repository contains

| Part | Pattern | Package |
|---|---|---|
| A | Factory Method | `com.astanait.patterns.factorymethod` |
| B | Abstract Factory | `com.astanait.patterns.abstractfactory` |

### Part A — Factory Method (`factorymethod` package)

- `Transport` — **Product** interface (`deliver()`, `getCapacityTons()`)
- `Truck`, `Ship` — **Concrete Products**
- `Logistics` — abstract **Creator**, declares the factory method `createTransport()` and a template method `planDelivery()` that works only against the `Transport` interface
- `RoadLogistics`, `SeaLogistics` — **Concrete Creators**, each returning a specific `Transport`

### Part B — Abstract Factory (`abstractfactory` package)

- `Button`, `Checkbox` — **Abstract Products** (one interface per product type in the family)
- `WinButton`, `WinCheckbox` / `MacButton`, `MacCheckbox` — **Concrete Products**, two consistent families
- `GUIFactory` — **Abstract Factory** interface, one creation method per product type
- `WinFactory`, `MacFactory` — **Concrete Factories**
- `Application` — **Client**; depends only on `GUIFactory`, `Button`, `Checkbox` — never on a concrete class, and contains no `if`/`switch` on platform type
- `AppConfigurator` — the single, isolated "composition root" method that decides which concrete family to hand to `Application`. Keeping this decision in one dedicated place (instead of inside the client) is what satisfies the assignment's "no large switch/if-else chain in client code" requirement.

### Entry point

`com.astanait.patterns.Main` runs a short demo of both parts.

## 2. Folder structure

```
factory-patterns-assignment/
├── README.md
├── diagrams/
│   ├── factory_method_uml.png
│   └── abstract_factory_uml.png
└── src/main/java/com/astanait/patterns/
    ├── Main.java
    ├── factorymethod/
    │   ├── Transport.java
    │   ├── Truck.java
    │   ├── Ship.java
    │   ├── Logistics.java
    │   ├── RoadLogistics.java
    │   └── SeaLogistics.java
    └── abstractfactory/
        ├── Button.java
        ├── Checkbox.java
        ├── WinButton.java
        ├── WinCheckbox.java
        ├── MacButton.java
        ├── MacCheckbox.java
        ├── GUIFactory.java
        ├── WinFactory.java
        ├── MacFactory.java
        ├── Application.java
        └── AppConfigurator.java
```

## 3. How to build & run

No external dependencies — plain Java (JDK 17+).

```bash
# from the repository root
mkdir -p out
find src -name "*.java" > sources.txt
javac -d out @sources.txt
java -cp out com.astanait.patterns.Main
```

### Expected output (abridged)

```
=== Part A: Factory Method (Logistics / Transport) ===
Logistics: planning delivery via Truck...
Truck: delivering 12t of cargo by land, in a box.
Logistics: planning delivery via Ship...
Ship: delivering 500t of cargo by sea, in a container.

=== Part B: Abstract Factory (GUI toolkit) ===
[Windows] Rendering a square, flat-style button.
[Windows] Rendering a square checkbox.
...
```

## 4. Why Factory Method for Part A, Abstract Factory for Part B

Part A only ever needs to create **one** kind of object at a time (a single
`Transport`), and the choice is naturally tied to a subclass (`RoadLogistics`
vs. `SeaLogistics`) — a textbook Factory Method situation.

Part B needs to create **several related objects that must stay consistent
with each other** (a `Button` and a `Checkbox` that belong to the same visual
family). That "family of related products" requirement is exactly what
Abstract Factory is for, and it cannot be expressed cleanly with a single
Factory Method.

## 5. Clean Code principles applied

See the accompanying report (Section 3) for the full list with before/after
excerpts. Summary:

1. Meaningful, role-revealing names (`Logistics`/`Transport`, `GUIFactory`/`Button`)
2. No conditional/type-checking logic in client code (`Application`, `Logistics.planDelivery`)
3. Small, single-purpose factory methods (each `create...()` method does exactly one thing)
4. No duplicated object-assembly logic between concrete factories/creators
5. Consistent, validated object construction (`Truck`/`Ship` constructors reject invalid capacities)
6. The one unavoidable platform-selection decision is isolated in `AppConfigurator`, kept out of business/client code (Law of Demeter / single responsibility)

## 6. Author

Individual assignment — Astana IT University, ShP-2216.
