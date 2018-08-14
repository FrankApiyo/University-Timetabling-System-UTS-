package timetable;

import java.io.Serializable;

public class Room implements  Comparable<Room>, Serializable{
    private int capacity;
    private boolean isDisabilityFriendly;
    private boolean lab;
    private String name;
    private String boardType;
    private Clss[][] days = new Clss[5][11];
    public Room(String name, int capacity, boolean isDisabilityFriendly, boolean lab, String boardType){
        this.name = name;
        this.capacity = capacity;
        this.isDisabilityFriendly = isDisabilityFriendly;
        this.lab = lab;
        this.boardType = boardType;
    }
    public boolean isDisabilityFriendly() {
        return isDisabilityFriendly;
    }

    public boolean isLab() {
        return lab;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    public Clss[][] getDays() {
        return days;
    }

    public String getBoardType() {
        return boardType;
    }

    public  String toString(){
        return "name: "+name+"capacity: "+capacity;
    }
    public int compareTo(Room r){
        return r.getCapacity() - this.capacity;
    }
}