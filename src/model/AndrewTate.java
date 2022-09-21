package model;

public class AndrewTate {

    private double money;
    private int follower;
    private Room location;
    private Car[] cars;

    public AndrewTate() {
        money = 0;
        follower = 0;
    }

    public double getMoney(){ return money; }
    public int getFollower() { return follower;}
    public Room getLocation() { return location; }
    public void setLocation(Room location) { this.location = location; }
}
