package timetable;
import javafx.scene.control.Alert;

import javax.lang.model.type.ArrayType;
import java.sql.*;
import java.util.ArrayList;

public class DbDriver {
    private static final String dBase = "jdbc:mysql://localhost/utsscratch";
    private static final String name = "root";
    private  static final String pwd = "Frankline";
    public Connection connectDb(String database, String username, String password){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            connection = DriverManager.getConnection(database, username, password);
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            //ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("database error");
            alert.setContentText("couldn't connect to database. please contact support.");

            alert.showAndWait();
        }

        return connection;
    }

    /**
     *
     * @return the list of all classes in the database
     */
    public ArrayList<Clss> getClasses(){
        ArrayList<Clss> list = new ArrayList<>();
        try {
            //TODOne -- Create a table with the schema of Class
            //TODOne -- Create a table with the schema in line Courses
            //TODOne -- Ensure that there are foreighn key constraints such that no course can be in Class table thats not in Course table.
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT lecturer, unit, course FROM Class");
            while(resultSet.next()){
                String lec = resultSet.getString(1);
                String unit = resultSet.getString(2);
                String course = resultSet.getString(3);
                //look in course table and find course data to create new course objects.
                //we can not have an sql error here because for there is a foreighn key constaint that ensures that there is at least
                //one entry in the course table for each entry in the class table :-)
                Statement statement1 = connectDb(dBase, name, pwd).createStatement();
                ResultSet resultSet1 = statement1.executeQuery("SELECT year, number FROM Course WHERE name = '"+course+"'");
                resultSet1.next();
                int year = resultSet1.getInt(1);
                int number = resultSet1.getInt(2);
                list.add(new Clss(new Lecturer(lec), new Unit(unit), new Course(course, year, number)));
            }
        }catch(SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return list;
    }

    /**
     *
     * @return a list of all the rooms currently in db
     */
    public ArrayList<Room> getRooms(){
        ArrayList<Room> list = new ArrayList<>();
        try{
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, capacity, dF, lab FROM Room");
            while(resultSet.next()){
                String name = resultSet.getString(1);
                int capacity = resultSet.getInt(2);
                boolean dF = resultSet.getBoolean(3);
                boolean lab = resultSet.getBoolean(4);
                Room room = new Room(name, capacity, dF, lab);
                list.add(room);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return list;
    }
    public boolean addRoom(Room r){
        try{
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            statement.executeUpdate("INSERT INTO Room VALUES('"+r.getName()+"', "+r.getCapacity()+", "+r.isdF()+", "+r.isLab()+")");
        }catch(SQLIntegrityConstraintViolationException ex){
            //TODOne add this exception's message to the ui.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("database error");
            alert.setContentText(ex.getMessage());

            alert.showAndWait();
            System.out.println(ex.getMessage());
            return false;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return true;
    }
    public void addClass(Clss c){
        try{
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            statement.executeUpdate("INSERT INTO Class VALUES('"+c.getL().getName()+"', '"+c.getU().getName()+"', '"+c.getC().getName()+"')");
        }catch(SQLIntegrityConstraintViolationException ex){
            //TODO add this exception's message to the ui.
            System.out.println(ex.getMessage());
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public void removeRoom(String room){
        //TODO these things here
        //ensure room is deleted from all tables that reference the Room table with a foreighn key
        //finally delete room from room table.
        try{
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            statement.executeUpdate("");
        }catch(SQLException ex){

        }
    }
}
