package timetable;


import javafx.beans.property.SimpleStringProperty;

public class Day {
    
    private SimpleStringProperty weekDay;
    private SimpleStringProperty[] slots = new SimpleStringProperty[11];

    public Day(String weekday, String[] classes){
        this.weekDay = new SimpleStringProperty(weekday);
        for(int i = 0; i < slots.length; i++){
            slots[i] = new SimpleStringProperty(classes[i]);
        }
    }

    public String getWeekDay() {
        return weekDay.get();
    }

    public void setWeekDay(SimpleStringProperty weekday) {
        this.weekDay = weekday;
    }
    public String getC1(){
        return slots[0].get();
    }
    public String getC2(){
        return slots[1].get();
    }
    public String getC3(){
        return slots[2].get();
    }
    public String getC4(){
        return slots[3].get();
    }
    public String getC5(){
        return slots[4].get();
    }
    public String getC6(){
        return slots[5].get();
    }
    public String getC7(){
        return slots[6].get();
    }
    public String getC8(){
        return slots[7].get();
    }
    public String getC9(){
        return slots[8].get();
    }
    public String getC10(){
        return slots[9].get();
    }
    public String getC11(){
        return slots[10].get();
    }
}
