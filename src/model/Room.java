package model;

public class Room {

    private String name;
    private String info;
    private String[] personsInRoom;

    public Room(String name, String info, String[] personsInRoom) {
        this.name = name;
        this.info = info;
        this.personsInRoom = personsInRoom;
    }

    public String getName() { return name; }
    public String getInfo() { return info; }
    public String[] getPersonsInRoom() { return personsInRoom; }

    public void setTristanInRoom() {
        String[] newPINR = new String[personsInRoom.length + 1]; //neues Array mit einem Platz mehr
        for (int i = 0; i < personsInRoom.length; i++) {
            newPINR[i] = personsInRoom[i]; // alle Indexe werden dem alten Array gleichgesetzt
        }
        newPINR[newPINR.length - 1] = "Tristan"; // an letzte Stelle wird Tristan gepackt
        personsInRoom = newPINR; //Referenz zeigt auf neues Array mit Tristan
    } //setzt Tristan in das array personsInRoom rein, damit man weiß, ob Tristan gerade in dem Zimmer ist

    public void setTristanOutRoom() {
        String[] newPINR = new String[personsInRoom.length - 1]; // neues Array mit einem Platz weniger
        for (int i = 0; i < newPINR.length; i++) {
            newPINR[i] = personsInRoom[i]; // alle Indexe werden dem alten Array gleichgesetzt, außer letzter, weil da Tristan war
        }
    } //setzt Tristan aus dem Array personsInRoom raus, damit man weiß, ob Tristan gerade in dem Zimmer ist
}
