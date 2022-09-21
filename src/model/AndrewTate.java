package model;

public class AndrewTate extends Tate{

    private int follower;

    public AndrewTate() {
        follower = 0;
    }

    public int getFollower() { return follower;}

    public void setFollower(int follower) { this.follower = follower;}

    public void payDay() { money += follower * 10; }
}