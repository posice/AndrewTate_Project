package model;

public class AndrewTate extends Person {

    private Car[] cars;

    public AndrewTate(String name, double money, Room location, int bodyCount, int age) {
        super(name,money,location,bodyCount,age);
    }

    public double getMoney(){return money;}

    public int getBodyCount(){return bodyCount;}

    public int getAge(){return age;}
}
