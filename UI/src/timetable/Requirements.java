package timetable;

import java.sql.Date;

public class Requirements{
    private String department;
    private String date;
    public Requirements(String department, Date date){
        this.department = department;
        this.date = date.toString();
    }
    public String getDate(){
        return date;
    }
    public String getDepartment(){
        return department;
    }
}
