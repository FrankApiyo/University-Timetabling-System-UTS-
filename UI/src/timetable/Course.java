package timetable;

public class Course{
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
}
