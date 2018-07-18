package timetable;

public class Room {

    private int capacity;
    private boolean dF;
    private boolean lab;
    private String name;

    public Room(String name, int capacity, boolean dF, boolean lab){
        this.name = name;
        this.capacity = capacity;
        this.dF = dF;
        this.lab = lab;
    }
    public boolean isdF() {
        return dF;
    }

    public void setdF(boolean dFriendliness) {
        this.dF = dFriendliness;
    }

    public boolean isLab() {
        return lab;
    }

    public void setLab(boolean lab) {
        this.lab = lab;
    }

    private Clss[][] days = new Clss[5][5];

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
}