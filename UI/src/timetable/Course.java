package timetable;

import com.sun.istack.internal.Nullable;

import java.io.Serializable;

public class Course implements Serializable{
  private String name;
  private int year;
  private int studentNumber;
  public Course(String name, int year, int studentNumber){
    this.name = name;
    this.year = year;
    this.studentNumber = studentNumber;
  }
  public String getName(){
    return name;
  }
  public int getYear(){
    return year;
  }
  public int getNumber(){
    return studentNumber;
  }
  public boolean equals(@Nullable Course c){
      return (c.getName().trim().equalsIgnoreCase(this.getName().trim()) && c.getYear() == this.getYear());
  }
}
