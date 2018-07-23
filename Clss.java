package timetable;

/*
* simulates a class that is made up of:
* Lecturer,
* Unit,
* Course
*/

public class Clss implements Comparable<Clss>{
  private Lecturer l;
  private Unit u;
  private Course c;
  private int classCount;
  public Clss(Lecturer l, Unit u, Course c){
    this.l = l;
    this.u = u;
    this.c = c;
    classCount = u.calculateHours(); //the number of classes for a particular unit each week

  }
  public Lecturer getL(){
    return l;
  }
  public Course getC(){
    return c;
  }
  public Unit getU(){
    return u;
  }
  public void decClassCount(){
    classCount = classCount - 1;
  }
  public int getClassCount(){return classCount;}
  public String toString(){
    return "Lecturer: "+l.getName()+"Unit Name: "+u.getName()+"Unit Code: "+u.getCode()+"Course: "+c.getName();
  }
  public int compareTo(Clss c){
    return c.getC().getNumber() - this.getC().getNumber();
  }

}
