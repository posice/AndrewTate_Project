package model.persons;

import model.Car;

import java.util.Timer;
import java.util.TimerTask;

public class AndrewTate extends Tate {

    private int follower;

    public AndrewTate() {
        follower = 0;
        manageMoney();
    }

    public double getMoney(){ return money; }
    public int getFollower() { return follower;}

    public void setMoney(double money) { this.money = money; }
    public void setFollower(int follower) { this.follower = follower;}
    public void setCars(Car[] cars) { this.cars = cars; }

    @Override
    public void payDay() { //Umsetzen von abstrakter Methode
        money += follower * 10; //Geld für Anzahl von Follower
        money += (int)(Math.random()*1000); // damit das Spiel nicht zu lange dauert
        money += addUpCarMoney(); // Geld für Autos
    }

    @Override
    public void payTaxes() { money*= 0.9; } // Geld wird von dem Staat abgezogen

    @Override
    public void manageMoney() {
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() { //Timer für alle 5 Sekunden
                if (taxDay == 4){ //jeden viertan Tag werden Steuern gezahlt
                    taxDay = 1;  //zurücksetzen auf ersten Tag
                    payTaxes();  // Steuern werden bezahlt
                } else { taxDay ++; } // wenn nicht taxday, dann kommt nächster Tag
                payDay(); // Tate bekommt sein Geld
            }
        };// Quelle für den Timer: https://www.youtube.com/watch?v=QEF62Fm81h4

        timer.schedule(timerTask, 0, 5000);
    }
}