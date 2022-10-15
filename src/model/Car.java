package model;

public class Car {

    /**
     *  Containerklasse: speichert nur wichtige Daten über Auto
     */

    private final String name;
    private final int coolness;
    private final int price;

    public Car(String name, int coolness, int price) {
        this.name = name;
        this.coolness = coolness;
        this.price = price;
    }

    public String getName() { return name; }
    public int getCoolness() { return coolness; }
    public int getPrice() { return price; }
}

