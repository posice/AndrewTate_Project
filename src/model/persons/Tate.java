package model.persons;

import model.Car;

public abstract class Tate {

    protected double money;
    protected Car[] cars;

    public Tate() {
        money = 0;
        cars = new Car[1];
        cars[0] = new Car("bugatti1", 5, 10000);
    }

    public double getMoney(){ return money; }

    public void setMoney(double money) { this.money = money; }

    public void newCar(Car newCar) {
        Car[] newCars = new Car[cars.length + 1];
        for (int i = 0; i < cars.length; i++) {
            newCars[i] = cars[i];
        }
        newCars[newCars.length - 1] = newCar;
        cars = newCars;
        money -= newCar.getPrice();
    }

    public void sellCar(Car soldCar) {
        boolean next = true;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == soldCar && !(soldCar==cars[0]) ) {
                cars[i] = null;
                next = true;
            } else { next = false; }
        }
        if (next) {
            Car[] newCars = new Car[cars.length - 1];
            for (int i = 0; i < newCars.length; i++) {
                if (!(cars[i] == null)) {
                    newCars[i] = cars[i];
                }
            }
            cars = newCars;
            money += soldCar.getPrice();
        }
    }

    public int addUpCarMoney() {
        int output = 0;
        for (int i = 0; i < cars.length; i++) {
            output += cars[i].getCoolness();
        }
        output += cars.length*10;
        output *= 100;
        return output;
    }

    public abstract void payDay();
    public abstract void payTaxes();
    public abstract void manageMoney();
}