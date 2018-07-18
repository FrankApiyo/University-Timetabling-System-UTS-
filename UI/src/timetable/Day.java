package timetable;


import javafx.beans.property.SimpleStringProperty;

public class Day {
    
    private SimpleStringProperty weekday = new SimpleStringProperty();
    
    public Day(String weekday){
        this.weekday = new SimpleStringProperty(weekday);
    }

    public String getWeekday() {
        return weekday.get();
    }

    public void setWeekday(SimpleStringProperty weekday) {
        this.weekday = weekday;
    }
}
