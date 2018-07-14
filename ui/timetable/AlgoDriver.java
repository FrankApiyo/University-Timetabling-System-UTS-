package timetable;

import java.util.ArrayList;

public class AlgoDriver {//This class is ment to create the room allocating algorithm

    public static void main(String[] args) {
        RoomChart chart = new RoomChart();
        ArrayList<Room> roomList = chart.getList();

        //populate the rooom chart with rooms.
        //rooms int GO all have a capacity of 25
        for (int i = 1; i <= 25; i++) {
            roomList.add(new Room("GO" + i, 25));
        }

        //rooms in ED all have a capacity of 60
        for (int i = 1; i <= 25; i++) {
            roomList.add(new Room("ED" + i, 60));
        }

        //rooms in TK have a capacity of 80
        for (int i = 1; i <= 25; i++) {
            roomList.add(new Room("TK" + i, 80));
        }

        //create class list and populate
        ArrayList<Clss> classList = new ArrayList<>();
        classList.add(new Clss(new Lecturer("JFK"), new Unit("CS101"), new Course("COMPUTER SCIENCE", 1, 80)));
        classList.add(new Clss(new Lecturer("JFK"), new Unit("CS102"), new Course("COMPUTER SCIENCE", 1, 80)));
        classList.add(new Clss(new Lecturer("JFK"), new Unit("CS201"), new Course("COMPUTER SCIENCE", 2, 75)));
        classList.add(new Clss(new Lecturer("JFK"), new Unit("CS301"), new Course("COMPUTER SCIENCE", 3, 60)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("CS102"), new Course("COMPUTER SCIENCE", 1, 80)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("CS103"), new Course("COMPUTER SCIENCE", 1, 80)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("CS204"), new Course("COMPUTER SCIENCE", 2, 75)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("CS307"), new Course("COMPUTER SCIENCE", 3, 60)));
        classList.add(new Clss(new Lecturer("Mungai"), new Unit("MATH101"), new Course("COMPUTER SCIENCE", 1, 80)));
        classList.add(new Clss(new Lecturer("Mungai"), new Unit("MATH121"), new Course("COMPUTER SCIENCE", 1, 80)));
        classList.add(new Clss(new Lecturer("Mungai"), new Unit("MATH242"), new Course("COMPUTER SCIENCE", 2, 75)));
        classList.add(new Clss(new Lecturer("Mungai"), new Unit("MATH340"), new Course("COMPUTER SCIENCE", 3, 60)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("PHY101"), new Course("COMPUTER SCIENCE", 1, 80)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("PHY102"), new Course("COMPUTER SCIENCE", 1, 80)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("PHY201"), new Course("COMPUTER SCIENCE", 2, 75)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("PHY301"), new Course("COMPUTER SCIENCE", 3, 60)));
        classList.add(new Clss(new Lecturer("JFK"), new Unit("CS101"), new Course("ELECTRICAL E", 1, 25)));
        classList.add(new Clss(new Lecturer("JFK"), new Unit("CS102"), new Course("ELECTRICAL E", 1, 25)));
        classList.add(new Clss(new Lecturer("JFK"), new Unit("CS201"), new Course("ELECTRICAL E", 2, 20)));
        classList.add(new Clss(new Lecturer("JFK"), new Unit("CS301"), new Course("ELECTRICAL E", 3, 20)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("TECH102"), new Course("ELECTRICAL E", 1, 25)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("TECH103"), new Course("ELECTRICAL E", 1, 25)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("TECH204"), new Course("ELECTRICAL E", 2, 20)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("TECH307"), new Course("ELECTRICAL E", 3, 20)));
        classList.add(new Clss(new Lecturer("Mungai"), new Unit("MATH101"), new Course("ELECTRICAL E", 1, 25)));
        classList.add(new Clss(new Lecturer("Mungai"), new Unit("MATH121"), new Course("ELECTRICAL E", 1, 25)));
        classList.add(new Clss(new Lecturer("Mungai"), new Unit("MATH242"), new Course("ELECTRICAL E", 2, 20)));
        classList.add(new Clss(new Lecturer("Mungai"), new Unit("MATH340"), new Course("ELECTRICAL E", 3, 20)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("PHY101"), new Course("ELECTRICAL E", 1, 25)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("PHY102"), new Course("ELECTRICAL E", 1, 25)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("PHY201"), new Course("ELECTRICAL E", 2, 20)));
        classList.add(new Clss(new Lecturer("Odiyo"), new Unit("PHY301"), new Course("ELECTRICAL E", 3, 20)));
        classList.add(new Clss(new Lecturer("Omollo"), new Unit("LIFE101"), new Course("SOIL SCIENCE", 1, 50)));
        classList.add(new Clss(new Lecturer("Omollo"), new Unit("LIFE102"), new Course("SOIL SCIENCE", 1, 50)));
        classList.add(new Clss(new Lecturer("Omollo"), new Unit("LIFE201"), new Course("SOIL SCIENCE", 2, 70)));
        classList.add(new Clss(new Lecturer("Omollo"), new Unit("LIFE301"), new Course("SOIL SCIENCE", 3, 70)));
        classList.add(new Clss(new Lecturer("Nyachio"), new Unit("EL102"), new Course("SOIL SCIENCE", 1, 50)));
        classList.add(new Clss(new Lecturer("Nyachio"), new Unit("EL103"), new Course("SOIL SCIENCE", 1, 50)));
        classList.add(new Clss(new Lecturer("Nyachio"), new Unit("EL204"), new Course("SOIL SCIENCE", 2, 70)));
        classList.add(new Clss(new Lecturer("Nyachio"), new Unit("EL307"), new Course("SOIL SCIENCE", 3, 70)));
        classList.add(new Clss(new Lecturer("Tilder"), new Unit("ORG101"), new Course("SOIL SCIENCE", 1, 50)));
        classList.add(new Clss(new Lecturer("Tilder"), new Unit("ORG121"), new Course("SOIL SCIENCE", 1, 50)));
        classList.add(new Clss(new Lecturer("Tilder"), new Unit("ORG242"), new Course("SOIL SCIENCE", 2, 70)));
        classList.add(new Clss(new Lecturer("Tilder"), new Unit("ORG340"), new Course("SOIL SCIENCE", 3, 70)));
        classList.add(new Clss(new Lecturer("Ondiek"), new Unit("SOIL101"), new Course("SOIL SCIENCE", 1, 50)));
        classList.add(new Clss(new Lecturer("Ondiek"), new Unit("SOIL102"), new Course("SOIL SCIENCE", 1, 50)));
        classList.add(new Clss(new Lecturer("Ondiek"), new Unit("SOIL201"), new Course("SOIL SCIENCE", 2, 70)));
        classList.add(new Clss(new Lecturer("Ondiek"), new Unit("SOIL301"), new Course("SOIL SCIENCE", 3, 70)));

        /* THIS WAS A TEST AREA. ITS COMENTED OFF NOW. you can uncommnet it to see it run at your pleasure

    -----------------------------------------------

    //print out the list of rooms to see if the entry is correct.
    System.out.println("THIS IS THE LIST OF ROOMS\n"+
                       "-------------------------\n"+
                       "NAME\r\t\tCAPACITY\n");
    for(Room r: roomList)
      System.out.println(r.getName()+"\r\t\t"+r.getCapacity());

    //print out the list of classes to see if the entry is correct
    System.out.println("THIS IS THE LIST OF CLASSES\n"+
                       "---------------------------\n"+
                       "lecturer\r\t\tunit\r\t\t\t\tcourse\r\t\t\t\t\t\t\tnumber");
    for(Clss c : classList)
      System.out.println(c.getL().getName()+"\r\t\t"+c.getU().getName()+"\r\t\t\t\t"+c.getC().getName()+"->year: "+c.getC().getYear()+"\r\t\t\t\t\t\t\t"+c.getC().getNumber());

      ---------------------------------------------------

         */
        //now allocate rooms to classes starting from the most populous classes.
        //go through roomchart allocating 2 slots per class
        for (Clss c : classList) //assign a room-slot to each class in class list
        {
            assignRoom(c, roomList);
        }

        //loop through rooms to see the allocated slots
        System.out.println("DAY\r\t\tROOM\r\t\t\t\tSLOT1\r\t\t\t\t\t\tSLOT2\r\t\t\t\t\t\t\t\tSLOT3\r\t\t\t\t\t\t\t\t\t\tSLOT4\r\t\t\t\t\t\t\t\t\t\t\t\tSLOT5");
        for (Room r : roomList)//loop through all rooms.
        {
            Clss[][] classesInRoom = r.getDays();
            for (int i = 0; i < classesInRoom.length; i++) {//loop through all the days per class
                System.out.print(i + "\r\t\t" + r.getName());
                for (int j = 0; j < classesInRoom[i].length; j++) {//and loop through all the slots per day per class.
                    //print the slots per room.
                    System.out.print("\t\t" + "" + (classesInRoom[i][j] != null ? classesInRoom[i][j].getU().getName() : "null"));
                }
                System.out.println();
            }
            System.out.println("----------------------------------------------------");
        }
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
}
