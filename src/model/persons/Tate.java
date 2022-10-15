package model.persons;

import model.Car;
import model.Room;

import java.util.Objects;

public abstract class Tate {

    protected double money;
    protected Car[] cars;
    protected int taxDay;

    public Tate() {
        money = 0;
        cars = new Car[1];
        taxDay = 1;
        cars[0] = new Car("bugatti1", 5, 100000);
    }

    public double getMoney(){ return money; }

    public void setMoney(double money) { this.money = money; }

    /**
     * neues Auto wird erstellt, dann ein neues auto array, welches alle alten und das neue Auto enthält
     * dabei wird das neue Auto an die letzte Stelle des neuen arrays gepackt
     * von Andrews Geld wird der Preis abgezogen
     * @param currentStore prüft ob Auto überhaupt gekauft werden kann
     */
    public void newCar(Room currentStore) {
        Car car = null;
        if (currentStore.getName() == "Bugatti store") {
            car = new Car("newBugatti",5, 100000);
        } else if (currentStore.getName() == "Lambo store") {
            car = new Car("newLambo",4,80000);
        } else if (currentStore.getName() == "Aston Martin store") {
            car = new Car("newAston",3,60000);
        } else if (currentStore.getName() == "Ferrari store") {
            car = new Car("newFerrari",4,85000);
        } else if (currentStore.getName() == "Opel store") {
            car = new Car("shit",0,10000);
        }
        Car[] newCars = new Car[cars.length + 1];
        for (int i = 0; i < cars.length; i++) {
            newCars[i] = cars[i];
        }
        newCars[newCars.length - 1] = car;
        cars = newCars;
        money -= car.getPrice();
    }


    /**
     * Andrew bekommt Geld, weil die Autos die er hat cool sind
     * Dabei wird beachtet wie viele Autos Andrew hat und wie cool die einzelnen Autos sind
     * @return das Ergebnis der Rechnung
     */
    public int addUpCarMoney() {
        int output = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) output += cars[i].getCoolness();
        }
        output += cars.length*10;
        output *= 100;
        return output;
    }

    /**abstrakte Methoden, die in den Unterklassen AndrewTate und TristanTate umgesetzt werden müssen */

    /**
     * Die Tate-Brüder haben verschiedene payDays, dabei werden Kinder, Follower etc. beachtet, hier wird dies festgelegt
     */
    public abstract void payDay();

    /**
     * Zahlen von Steuern, wegen Kindern fällt dies anders aus
     */
    public abstract void payTaxes();

    /**
     * für jeden Tate werden die Variablen anders gemanaged, hier wird dies festgelegt
     */
    public abstract void manageVariables();

}