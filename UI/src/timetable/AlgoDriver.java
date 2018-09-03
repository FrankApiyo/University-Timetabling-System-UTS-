package timetable;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.io.*;

public class AlgoDriver{
    static ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Room> availableRooms = new ArrayList<>();
    static ArrayList<Clss> classes = new ArrayList<>();
    static boolean generated;
    public AlgoDriver(){
        DbDriver dbDriver = new DbDriver();
        classes = dbDriver.getClasses();
        getRoomFromFile();
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
    public ArrayList<Room> getAvailableRooms(int s, int d){
        ArrayList<Room> r = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++){
            Clss[][] days = rooms.get(i).getDays();
                if(days[d][s] == null)
                    r.add(rooms.get(i));
        }
        //}
        return r;
    }

    private void assignRoom(Clss c){
        //loop through rooms until an appropriate class is found then assign

        ONE:
        for(int k = 0; k < rooms.size(); k++){
            if(c.getClassCount() <= 0) return;
            Clss[][] days = rooms.get(k).getDays();
            for(int i = 0; i < days.length; i++) {
                //if class already in day or course already has two classes in day move to next day
                if(classInDay(c, i)) continue;
                if(courseMoreThanTwice(days[i], c.getC())) continue;
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
    private boolean classInDay(Clss c, int x){
        for(Room r: rooms) {
            Clss[] day = r.getDays()[x];
            for (int i = 0; i < day.length; i++)
                if (day[i] != null)
                    if (day[i].equals(c))
                        return true;
        }
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
    public  void getRoomFromFile(){
        //restore the timetable from file.
        try(
                ObjectInputStream fileOut = new ObjectInputStream(new FileInputStream("timetable.dat"))
        ){
            rooms = (ArrayList<Room>) fileOut.readObject();
        }catch(FileNotFoundException ex){
            DbDriver driver = new DbDriver();
            rooms = driver.getRooms();
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
                        if (clsses[dayNumber][i].getC().equals(c)) {
                            String code = clsses[dayNumber][i].getU().getCode();
                            String venue = r.getName();
                            String s = code + ", " + venue;
                            day.setSlot(s, i);
                        }
                    }
                    }
        }
        return day;
    }
}