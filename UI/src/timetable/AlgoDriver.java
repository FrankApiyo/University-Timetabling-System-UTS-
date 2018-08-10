package timetable;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.io.*;

public class AlgoDriver{
    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Clss> classes = new ArrayList<>();
    static boolean generated = false;
    public AlgoDriver(){
        DbDriver dbDriver = new DbDriver();

        rooms = dbDriver.getRooms();
        classes = dbDriver.getClasses();
        //generateTimetable();
        if(generated)
            getRoomFromFile();
        //create timetable by assigning each class a room
        //generateTimetable();
        //saveRooms();
        //getRoomFromFile();
        // Test code-- prints out the timetable
        /*
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

        }*/
    }
    public static void main(String[] args){
        //this method was used to test the methods in this class.
        AlgoDriver driver = new AlgoDriver();
        //driver.getClasses(1, new Course("COMPUTER SCIENCE", 2, 70));
    }
    public void generateTimetable(){
        for(Clss c: classes) {
            //System.out.println(c.getU().getCode()+" "+c.getClassCount()+" "+c.getC().getName()+" "+c.getC().getYear());
            assignRoom(c);
        }
        saveRooms();
        generated = true;
    }
    private void assignRoom(Clss c){
        //loop through rooms until an appropriate class is found then assign

        ONE:
        for(int k = 0; k < rooms.size(); k++){
            if(c.getClassCount() <= 0) return;
            Clss[][] days = rooms.get(k).getDays();
            TWO:
            for(int i = 0; i < days.length; i++) {
                //if class already in day or course already has two classes in day move to next day
                if(classInDay(c, days[i])) continue TWO;
                if(courseMoreThanTwice(days[i], c.getC())) continue TWO;
                for (int j = 0; j < days[i].length; j++) {
                    if (days[i][j] == null && !conflict(c, i, j, rooms.get(k))) {//also ensure no conflicts
                        days[i][j] = c;
                        c.decClassCount();
                        //System.out.println(c.getClassCount());
                        continue ONE;
                    }
                }
            }
        }
    }
    private boolean classInDay(Clss c, Clss[] day){
        for(int i = 0; i < day.length; i++)
            if(day[i] != null)
                if(day[i].equals(c))
                    return true;
        return false;
    }
    //checks if course has had a class more than twice on on day
    private boolean courseMoreThanTwice(Clss[] day, Course c){
        int count = 0;
        for(int i = 0; i < day.length; i++)
            if(day[i] != null)
                if(day[i].getC().equals(c))
                    count++;
        if(count >= 2) {
            //System.out.println("flagged one");
            return true;
        }
        else return false;
    }
    private  boolean conflict(Clss c, int i, int j, Room room){
        for(Room r: rooms){
            if(r == room) break;
            Clss[][] classes = r.getDays();
            if(classes[i][j] == null) continue;
            else if(classes[i][j].getC().equals(c.getC())) return true;
        }
        return false;
    }
    private void saveRooms(){
        //store the time table in a file
        //first get working directory of the app.
        try(
                ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream("./timetable.dat"))
        ){
            fileOut.writeObject(rooms);
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    private  void getRoomFromFile(){
        //restore the timetable from file.
        try(
                ObjectInputStream fileOut = new ObjectInputStream(new FileInputStream("timetable.dat"))
        ){
            rooms = (ArrayList<Room>) fileOut.readObject();
        }catch(FileNotFoundException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("file system error error");
            alert.setContentText("couldn't locate the database file");
            alert.showAndWait();
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    public Day getClasses(int dayNumber, Course c){
        Day day = null;
        switch (dayNumber){
            case 0: day = new Day("Monday"); break;
            case 1: day = new Day("Tuesday"); break;
            case 2: day = new Day("Wednesday"); break;
            case 3: day = new Day("Thursday"); break;
            case 4: day = new Day("Friday");
        }

        //loop through 'room-chart' looking for classes by this course on day 'dayNumber'
        for(Room r: rooms){
            Clss[][] clsses = r.getDays();
                for(int i = 0; i < clsses[dayNumber].length; i++){
                    if(clsses[dayNumber][i] != null) {
                        //System.out.println("\n\n"+clsses[dayNumber][i].getC().getName()+"\t"+clsses[dayNumber][i].getC().getYear());
                        //System.out.println(c.getName()+"\t"+c.getYear());
                        //System.out.println(clsses[dayNumber][i].getC().equals(c));
                        if (clsses[dayNumber][i].getC().equals(c)) {
                            //System.out.println(c.getName());
                            //for the string that represents the lesson. i.e.
                            //A concatenation of the unit code, ', ', and the venue.
                            String code = clsses[dayNumber][i].getU().getCode();
                            String venue = r.getName();
                            String s = code + ", " + venue;
                            //System.out.println(day.getWeekDay()+"\t"+s+"\t"+i);
                            day.setSlot(s, i);
                        }
                    }
                    }
        }
        return day;
    }
}