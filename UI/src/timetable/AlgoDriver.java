package timetable;

import java.util.ArrayList;

public class AlgoDriver {//This class is meant to create the room allocating algorithm

    public static void main(String[] args){
        DbDriver dbDriver = new DbDriver();
        //dbDriver.addClass(new Clss(new Lecturer("Benjamin Odiyo"),new Unit("introduction to computing", "CS101"), new Course("CHINESE", 2, 70)));
        dbDriver.removeRoom("L3");
    }
    private static void assignRoom(Clss c, ArrayList<Room> roomList) {
        for (int i = 0; i < 2; i++) {
            //this loop ensures that each class is assigned a room twice.
            boolean done = false; //this checks for when we are done assigning a room-slot.
            for (int j = 0; j < 5; j++) {//this loops through the days.
                if (done) {
                    break;
                }
                for (Room r : roomList) {//this loops through the rooms till a room of an appropriate capacity is found with a time slot for the classes
                    if (done) {
                        break;
                    }
                    Clss[][] classOfDay = r.getDays(); //gets the classes on that day for the room r.
                    for (int k = 0; k < 5; k++) //loop through those classes on that day.
                    {
                        if (classOfDay[j][k] == null && r.getCapacity() < c.getC().getNumber()) {
                            classOfDay[j][k] = c;
                            done = true;
                            break;
                        }
                    }
                }
            }
        }
    }
    public static void generateTimeTable(){
        //this method takes classes from the database and generates a roomchat using them
        // step 1: get all classes and add to class list from db : written getClasses for this
        // step 2: get all rooms and add to room list from db : written getRooms for this
        // step 3: call assign room for every room
        // step 4: add room chart to database *one table per room*.
    }
}