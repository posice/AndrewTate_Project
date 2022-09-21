package model;

public class AndrewTate {

    private double money;
    private int follower;
    private Car[] cars;

    public AndrewTate() {
        money = 0;
        follower = 0;
    }

    public double getMoney(){ return money; }
    public int getFollower() { return follower;}

    public void setMoney(double money) { this.money = money; }
    public void setFollower(int follower) { this.follower = follower;}
    public void setCars(Car[] cars) { this.cars = cars; }

    public void payDay() {money += follower * 10;}

    public void taxes(){money = money*0.1}
}
