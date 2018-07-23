package timetable;

public class Unit {

    String name;
    String code;
    double cf;
    int hours;

    public Unit(String name, String code, double cf) {
        this.name = name;
        this.code = code;
        this.cf = cf;
    }

    public String getName() {
        return name;
    }
    public String getCode(){return code; }

    public int calculateHours(){
        if(cf == 1.0){
            hours = 1;
        }

        if(cf == 1.5){
            hours = 2;
        }

        if(cf == 2.0){
            hours = 2;
        }

        if(cf == 2.5){
            hours = 3;
        }

        if(cf == 3.0){
            hours = 3;
        }

        if(cf == 3.5){
            hours = 4;
        }

        if(cf == 4.0){
            hours = 6;
        }
        return hours;
    }
}
