package model.persons;

import java.util.Timer;
import java.util.TimerTask;

public class AndrewTate extends Tate {

    /**
     * Andrew Tate, der Hauptcharakter hat eine eigene Klasse
     * Hier wird alles vorbereitet, damit dieser später in den Controller Klassen gesteuert werden kann
     */

    private int follower;

    public AndrewTate() {
        follower = 0;
        manageVariables();
    }

    public double getMoney(){ return money; }
    public int getFollower() { return follower;}


    /**
     * alle Autos werden in ein String gepackt, mit Leerzeichen getrennt
     * @return String mit allen Autos
     */

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

    /**
     * Andrew bekommt Geld, weil die Autos die er hat cool sind
     * Dabei wird beachtet wie viele Autos Andrew hat und wie cool die einzelnen Autos sind
     * @return das Ergebnis der Rechnung
     */
    public int addUpCarMoney() {
        int output = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) output += cars[i].getCoolness();
        }
        output += cars.length*10;
        output *= 100;
        return output;
    }

    /**
     * Geld wird angepasst, abstrakte Methode wird umgesetzt
     */
    @Override
    public void payDay() {
        money += follower;
        money += (int)(Math.random()*1000);
        money += addUpCarMoney();
    }

    /**
     * Geld wird durch Steuern angepasst, abstrakte Methode wird umgesetzt
     */
    @Override
    public void payTaxes() {
        if (money > 0) money*= 0.9;
    }

    /**
     * timer für alle 5 Sekunden wird eingesetzt -> nimmt Änderungen an follower und money vor
     */
    @Override
    public void manageVariables() {

        Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (taxDay == 4){
                    taxDay = 1;
                    payTaxes();
                } else { taxDay ++; }
                payDay();
                generateFollower();
            }
        };// Quelle für den Timer: https://www.youtube.com/watch?v=QEF62Fm81h4

        timer.schedule(timerTask, 5000, 5000);
    }
}