package timetable;

public class Room {

    private int capacity;
    private String name;
    private Clss[][] days = new Clss[5][5];

    public Room(String name, int capacity) {
        this.capacity = capacity;
        this.name = name;
    }

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
