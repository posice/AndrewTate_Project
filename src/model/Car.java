package model;

public class Car {

    private final String company;
    private final int coolness;
    private final int price;

    public Car(String company, int coolness, int price) {
        this.company = company;
        this.coolness = coolness;
        this.price = price;
    }

    public String getCompany() { return company; }
    public int getCoolness() { return coolness; }
    public int getPrice() { return price; }
}
