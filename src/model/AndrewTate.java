package model;

import java.util.Timer;
import java.util.TimerTask;

public class AndrewTate extends Tate {

    private int follower;
    private int taxday;

    public AndrewTate() {
        follower = 0;
        taxday = 1;
        manageMoney();
    }

    public double getMoney(){ return money; }
    public int getFollower() { return follower;}

    public void setMoney(double money) { this.money = money; }
    public void setFollower(int follower) { this.follower = follower;}
    public void setCars(Car[] cars) { this.cars = cars; }

    @Override
    public void payDay() { money += follower * 10;}

    @Override
    public void payTaxes() { money *= 0.9; }

    @Override
    public void manageMoney() {
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (taxday == 4){
                    taxday = 1;
                    payTaxes();
                }
                payDay();
                taxday ++;
            }
        };

        timer.schedule(timerTask, 0, 5000);
    }
}
