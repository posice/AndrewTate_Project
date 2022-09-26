package model.persons;

import java.util.Timer;
import java.util.TimerTask;

public class AndrewTate extends Tate {

    private int follower;

    public AndrewTate() {
        follower = 1000;
        manageVariables();
    }

    public double getMoney(){ return money; }
    public int getFollower() { return follower;}

    public String getAllCars() {
        String output = "";
        for (int i=0; i < cars.length; i++) {
            output += cars[i].getName() + " ";
        }
        return output;
    }

    public void setMoney(double money) { this.money = money; }
    public void setFollower(int follower) { this.follower = follower;}


    public void generateFollower() {
        int randomN = (int) (Math.random()*100 -25);
        follower += randomN;
    }

    @Override
    public void payDay() { //Umsetzen von abstrakter Methode
        money += follower * 10; //Geld für Anzahl von Follower
        money += (int)(Math.random()*1000); // damit das Spiel nicht zu lange dauert
        money += addUpCarMoney(); // Geld für Autos
    }

    /*@Override
    public void payTaxes() {
        if (money > 0) money*= 0.9;
    } // Geld wird von dem Staat abgezogen */

    @Override
    public void manageVariables() {
        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() { //Timer für alle 5 Sekunden
                if (taxDay == 4){ //jeden viertan Tag werden Steuern gezahlt
                    taxDay = 1;  //zurücksetzen auf ersten Tag
                    //payTaxes();  // Steuern werden bezahlt
                } else { taxDay ++; } // wenn nicht taxday, dann kommt nächster Tag
                payDay(); // Tate bekommt sein Geld
                generateFollower(); // Followerzahl wird vergrößert
            }
        };// Quelle für den Timer: https://www.youtube.com/watch?v=QEF62Fm81h4

        timer.schedule(timerTask, 5000, 5000);
    }
}