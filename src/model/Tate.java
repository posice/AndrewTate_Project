package model;

public abstract class Tate {

    protected double money;
    protected Car[] cars;

    public Tate() {
        money = 0;
    }

    public double getMoney(){ return money; }

    public void setMoney(double money) { this.money = money; }
    public void setCars(Car[] cars) { this.cars = cars; }

    public abstract void payDay();
    public abstract void manageMoney();
    public abstract void payTaxes();
}
