package timetable;

import java.util.ArrayList;
import java.util.Collections;

public class AlgoDriver{
    static ArrayList<Room> rooms;
    static ArrayList<Clss> classes;
    public static  void main(String[] args){
        DbDriver dbDriver = new DbDriver();
        rooms = dbDriver.getRooms();
        classes = dbDriver.getClasses();
        for(Clss c: classes) {
            System.out.println(c.getU().getCode()+" "+c.getClassCount()+" "+c.getC().getName()+" "+c.getC().getYear());
            assignRoom(c);
        }
        Clss[][] slots = rooms.get(0).getDays();
        for(Clss c : slots[0])
            System.out.print("SLOT\t\t");
        System.out.println();
        for(Room r: rooms){
            System.out.println("\n\n"+r.getName());
            Clss[][] s = r.getDays();
            for(int i = 0; i < s.length; i++) {
                for (int j = 0; j < s[i].length; j++)
                    if(s[i][j] != null)
                        System.out.print(s[i][j].getU().getCode() + "\t\t");
                    else
                        System.out.print(null + "\t\t");
                System.out.println();
            }

        }
    }
    private static void assignRoom(Clss c){
        //loop through rooms until an appropriate class is found then assign

        ONE:
        for(int k = 0; k < rooms.size(); k++){
            if(c.getClassCount() <= 0) return;
            Clss[][] days = rooms.get(k).getDays();
            TWO:
            for(int i = 0; i < days.length; i++) {
                //if class already in day move to next day
                if(classInDay(c, days[i])) continue TWO;
                for (int j = 0; j < days[i].length; j++) {
                    if (days[i][j] == null && !conflict(c, i, j, rooms.get(k))) {//also ensure no conflicts
                        days[i][j] = c;
                        c.decClassCount();
                        System.out.println(c.getClassCount());
                        continue ONE;
                    }
                }
            }
        }
    }
    private static boolean classInDay(Clss c, Clss[] day){
        for(int i = 0; i < day.length; i++)
            if(day[i] == c)
                return true;
        return false;
    }
    private static boolean conflict(Clss c, int i, int j, Room room){
        for(Room r: rooms){
            if(r == room) break;
            Clss[][] classes = r.getDays();
            if(classes[i][j] == c) return true;
        }
        return false;
    }
}