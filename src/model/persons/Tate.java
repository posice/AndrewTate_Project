package model.persons;

import model.Car;

public abstract class Tate {

    protected double money;
    protected Car[] cars;
    protected int taxDay;

    public Tate() {
        money = 0;
        cars = new Car[1];
        taxDay = 1;
        cars[0] = new Car("bugatti1", 5, 10000);
    }

    public double getMoney(){ return money; }

    public void setMoney(double money) { this.money = money; }

    public void newCar(Car newCar) { // neues Auto in Array
        Car[] newCars = new Car[cars.length + 1]; //neues Array mit einem Platz mehr
        for (int i = 0; i < cars.length; i++) {
            newCars[i] = cars[i]; // Car Objekte von altem Array ins neue Array einfügen
        }
        newCars[newCars.length - 1] = newCar; // an letzte Stelle wird das von uns gekaufte Auto eingefügt
        cars = newCars; // Referenzbezeichner zeigt auf neues Array
        money -= newCar.getPrice(); //Preis von Auto wird von Geld abgezogen
    }

    public void sellCar(Car soldCar) { //Auto verkaufen -> ein Car Objekt weniger im Array
        boolean next = true; // prüft, ob die Methode weiterarbeiten soll
        for (int i = 0; i < cars.length; i++) { //prüft alle Objekte im Array, ob es das Auto ist, was verkauft werden soll
            if (cars[i] == soldCar && !(soldCar==cars[0]) ) { //außerdem kann der erste Wagen (Bugatti) nicht verkauft werden
                cars[i] = null; // Auto wird aus Array entfernt
                next = true; // Methode kann weiterarbeiten
            } else { next = false; } // wenn Bedingungen nicht erfüllt stoppt Methode
        }
        if (next) { // prüft ob es weitergehen kann
            Car[] newCars = new Car[cars.length - 1]; // neues Array mit einem Platz weniger
            for (int i = 0; i < newCars.length; i++) {
                if (!(cars[i] == null)) { // sucht dien null Referenz
                    newCars[i] = cars[i]; // Car Obejekte aus altem Array werden in das neue array eingesetzt
                }
            }
            cars = newCars; //Referenzbezeichner zeigt auf neues Array
            money += soldCar.getPrice(); // Geld für das Verkaufen des Autos
        }
    }

    public int addUpCarMoney() { //man bekommt Geld dafür, dass man coole Autos besitzt
        int output = 0;
        for (int i = 0; i < cars.length; i++) {
            output += cars[i].getCoolness(); //Coolness der einzelnen Cars wird aufaddiert
        }
        output += cars.length*10; // außerdem kriegt man Geld für wie viele Autos man besitzt
        output *= 100; // damit das Spiel nicht zu lange dauert
        return output; // Rückgabe des Ergebnisses
    }

    public abstract void payDay();
    public abstract void payTaxes();
    public abstract void manageMoney();
    //abstrakte Methoden, die in den Unterklassen AndrewTate und TristanTate umgesetzt werden müssen
}