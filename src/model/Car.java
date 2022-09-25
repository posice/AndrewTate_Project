package model;

public class Car {

    private final String name;
    private final String company;
    private final int coolness;
    private final int price;

    public Car(String name, String company, int coolness, int price) {
        this.name = name;
        this.company = company;
        this.coolness = coolness;
        this.price = price;
    }

    public String getName() { return name; }
    public int getCoolness() { return coolness; }
    public int getPrice() { return price; }
}

//Containerklasse: speichert nur wichtige Daten über Auto