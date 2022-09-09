package Model;

public class Person {

    protected String name;
    protected double money;
    protected Room location;
    protected int bodyCount;
    protected int age;

    public Person(String name, double money, Room location, int bodyCount, int age) {
        this.name = name;
        this.money = money;
        this.location = location;
        this.bodyCount = bodyCount;
        this.age = age;
    }
}
