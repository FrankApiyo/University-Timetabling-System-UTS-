package timetable;

public class Unit {

    String name;
    String code;
    double cf;

    public Unit(String name, String code, double cf) {
        this.name = name;
        this.code = code;
        this.cf = cf;
    }

    public String getName() {
        return name;
    }
    public String getCode(){return code; }
    public double getcf(){return cf;}
}
