package model;

public class Room {

    /**
     * speichert Informationen über einen Ort
     */

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

    /**
     * neues Array personsInRoom wird erstellt, damit Tristan darein gesetzt werden kann
     */
    public void setTristanInRoom() {
        String[] newPINR = new String[personsInRoom.length + 1];
        for (int i = 0; i < personsInRoom.length; i++) {
            newPINR[i] = personsInRoom[i];
        }
        newPINR[newPINR.length - 1] = "Tristan";
        personsInRoom = newPINR;
    }

    /**
     * neues Array personsInRoom wird erstellt, damit Tristan rausgesetzt werden kann
     */
    public void setTristanOutRoom() {
        String[] newPINR = new String[personsInRoom.length - 1];
        for (int i = 0; i < newPINR.length; i++) {
            newPINR[i] = personsInRoom[i];
        }
    }
}
