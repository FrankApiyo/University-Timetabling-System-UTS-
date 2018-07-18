package timetable;

/*
* simulates a class that is made up of:
* Lecturer,
* Unit,
* Course
*/

public class Clss{
  Lecturer l;
  Unit u;
  Course c;
  public Clss(Lecturer l, Unit u, Course c){
    this.l = l;
    this.u = u;
    this.c = c;
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
}
