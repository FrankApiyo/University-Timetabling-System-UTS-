package timetable;

import java.io.Serializable;

public class Lecturer implements Serializable{

    private String name;
    private String regNo;
    private String department;

    public Lecturer(String name, String department, String regNo) {
        this.name = name;
        this.regNo = regNo;
        this.department = department;
    }

    public String getName() {
        return name;
    }
    public String getRegNo(){return regNo; }
    public String getDepartment(){ return department; }
    public boolean equals(Lecturer l){
        return l.getRegNo().trim().equalsIgnoreCase(this.getRegNo().trim());
    }
}
