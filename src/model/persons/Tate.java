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

    public void newCar(Room currentStore) { // neues Auto in Array
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
        Car[] newCars = new Car[cars.length + 1]; //neues Array mit einem Platz mehr
        for (int i = 0; i < cars.length; i++) {
            newCars[i] = cars[i]; // Car Objekte von altem Array ins neue Array einfügen
        }
        newCars[newCars.length - 1] = car; // an letzte Stelle wird das von uns gekaufte Auto eingefügt
        cars = newCars; // Referenzbezeichner zeigt auf neues Array
        money -= car.getPrice(); //Preis von Auto wird von Geld abgezogen
    }

    /*public void sellCar(String name) { //Auto verkaufen -> ein Car Objekt weniger im Array
        for (int i = 0; i < cars.length; i++) { //prüft alle Objekte im Array, ob es das Auto ist, was verkauft werden soll
            if (Objects.equals(cars[i].getName(), name)) { //außerdem kann der erste Wagen (Bugatti) nicht verkauft werden
                cars[i] = null; // Auto wird aus Array entfernt
                Car[] newCars = new Car[cars.length - 1]; // neues Array mit einem Platz weniger
                for (int j = 0; j < newCars.length; i++) {
                    if (!(cars[i] == null)) { // sucht dien null Referenz
                        newCars[i] = cars[i]; // Car Obejekte aus altem Array werden in das neue array eingesetzt
                    }
                }
                cars = newCars; //Referenzbezeichner zeigt auf neues Array
                break;
            }  // wenn Bedingungen nicht erfüllt stoppt Methode
        }
    } */

    public int addUpCarMoney() { //man bekommt Geld dafür, dass man coole Autos besitzt
        int output = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) output += cars[i].getCoolness(); //Coolness der einzelnen Cars wird aufaddiert
        }
        output += cars.length*10; // außerdem kriegt man Geld für wie viele Autos man besitzt
        output *= 100; // damit das Spiel nicht zu lange dauert
        return output; // Rückgabe des Ergebnisses
    }

    public abstract void payDay();
    public abstract void payTaxes();
    public abstract void manageVariables();
    //abstrakte Methoden, die in den Unterklassen AndrewTate und TristanTate umgesetzt werden müssen
}