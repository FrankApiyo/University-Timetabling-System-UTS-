package timetable;


import javafx.beans.property.SimpleStringProperty;

public class Day {
    
    private SimpleStringProperty weekDay;
    private SimpleStringProperty[] slots = new SimpleStringProperty[11];

    public Day(String weekday){
        this.weekDay = new SimpleStringProperty(weekday);
    }

    public void setSlot(String lesson, int slotNumber){
        slots[slotNumber] = new SimpleStringProperty(lesson);
    }
    public String getWeekDay() {
        if(weekDay != null)
            return weekDay.get();
        return "";
    }

    public String getC1(){
        if(slots[0] != null)
            return slots[0].get();
        else return "";
    }
    public String getC2(){
        if(slots[1] != null)
            return slots[1].get();
        else return "";

    }
    public String getC3(){
        if(slots[2] != null)
            return slots[2].get();
        else return "";

    }
    public String getC4(){
        if(slots[3] != null)
            return slots[3].get();
        else return "";
    }
    public String getC5(){
        if(slots[4] != null)
            return slots[4].get();
        else return "";
    }
    public String getC6(){
        if(slots[5] != null)
            return slots[5].get();
        else return "";
    }
    public String getC7(){
        if(slots[6] != null)
            return slots[6].get();
        else return "";
    }
    public String getC8(){
        if(slots[7] != null)
            return slots[7].get();
        else return "";
    }
    public String getC9(){
        if(slots[8] != null)
            return slots[8].get();
        else return "";
    }
    public String getC10(){
        if(slots[9] != null)
            return slots[9].get();
        else return "";
    }
    public String getC11(){
        if(slots[10] != null)
            return slots[10].get();
        else return "";

    }
}
