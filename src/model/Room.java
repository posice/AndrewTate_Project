package model;

public class Room {

    private String name;
    private String info;

    public Room(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() { return name; }
    public String getInfo() { return info; }
}
