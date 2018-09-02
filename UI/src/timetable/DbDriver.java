package timetable;
import javafx.scene.control.Alert;

import javax.lang.model.type.ArrayType;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DbDriver {
    private static final String dBase = "jdbc:mysql://localhost/utsbase";
    private static final String name = "root";
    private  static final String pwd = "";
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
            ResultSet resultSet = statement.executeQuery("SELECT Lecturer.name, Unit.name, Unit.code, Course.name, Course.year, Course.number, Lecturer.regNo, Lecturer.department, Unit.cF FROM"+
                                                        "(((Lecturer INNER JOIN Class ON Lecturer.regNo = Class.lec_reg_no)" +
                                                        "INNER JOIN Unit ON Class.unit_code = Unit.code)" +
                                                        "INNER JOIN Course ON Course.code = Class.course_code)");
            while(resultSet.next()){
                String lecName = resultSet.getString(1);
                String unitName = resultSet.getString(2);
                String unitCode = resultSet.getString(3);
                String course = resultSet.getString(4);
                int year = resultSet.getInt(5);
                int number = resultSet.getInt(6);
                String lecRegNo = resultSet.getString(7);
                String lecDepartment = resultSet.getString(8);
                double cf = resultSet.getDouble(9);
                //System.out.println(cf);
                list.add(new Clss(new Lecturer(lecName, lecDepartment, lecRegNo), new Unit(unitName, unitCode, cf), new Course(course, year, number)));
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
            ResultSet resultSet = statement.executeQuery("SELECT name, capacity, d9F10, lab, boardType FROM Room");
            while(resultSet.next()){
                String name = resultSet.getString(1);
                int capacity = resultSet.getInt(2);
                boolean dF = resultSet.getBoolean(3);
                boolean lab = resultSet.getBoolean(4);
                String boardType = resultSet.getString(5);
                Room room = new Room(name, capacity, dF, lab, boardType);
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
            //System.out.println("\n\n"+"INSERT INTO Room VALUES("+(r.isdF()?1:0)+", '"+r.getBoardType()+"', "+r.getCapacity()+", '"+r.getName()+"', "+r.isLab()+");"+"\n\n");
            statement.executeUpdate("INSERT INTO Room VALUES("+(r.isdF()?1:0)+", '"+r.getBoardType()+"', "+r.getCapacity()+", '"+r.getName()+"', "+r.isLab()+");");
        }catch(SQLIntegrityConstraintViolationException | SQLSyntaxErrorException ex){
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
    //I realized there is no need to implement this functionality sooo....
    /*
    //public void addClass(Clss c){
        try{
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            statement.executeUpdate("INSERT INTO Class VALUES('"+c.getL().getName()+"', '"+c.getU().getName()+"', '"+c.getC().getName()+"')");
        }catch(SQLIntegrityConstraintViolationException ex){
            //TODO add this exception's message to the ui.
            System.out.println(ex.getMessage());
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }*/
    public void removeRoom(String room){
        //TODO these things here
        //ensure room is deleted from all tables that reference the Room table with a foreighn key
        //finally delete room from room table.
        try{
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            statement.executeUpdate("DELETE FROM Room WHERE name = '"+room+"';");
        }catch(SQLException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("database error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            ex.printStackTrace();
        }
    }
    public boolean addLecturer(Lecturer l){
        try{
            Statement statement  = connectDb(dBase, name, pwd).createStatement();
            statement.executeUpdate("INSERT INTO Lecturer values('"+l.getRegNo().toUpperCase()+"', '"+l.getDepartment().toUpperCase()+"', '"+l.getName().toUpperCase()+"');");
        }catch(SQLException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("database error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public ArrayList<Lecturer> getLecturers(){
        try{
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Lecturer");
            //THE ORDER OF FIELDS IS: regNo, department, name
            ArrayList<Lecturer> list = new ArrayList<>();
            while(resultSet.next())
                list.add(new Lecturer(resultSet.getString(3), resultSet.getString(2), resultSet.getString(1)));
            return list;
        }catch(SQLException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("database error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            ex.printStackTrace();
            return null;
        }
    }
    public boolean removeLecturer(Lecturer l){
        try{
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            statement.executeUpdate("DELETE FROM Lecturer WHERE regNo = '"+l.getRegNo()+"'");
            return true;
        }catch(SQLException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("database error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            ex.printStackTrace();
            return false;
        }
    }
    public ArrayList<Course> getCourses(){
        try{
            ArrayList<Course> list = new ArrayList<>();
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Course;");
            while(resultSet.next()){
                list.add(new Course(resultSet.getString(1),resultSet.getInt(2), resultSet.getInt(3)));
            }
            return list;
        }catch (SQLException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("database error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            ex.printStackTrace();
            return null;
        }
    }

    public String addIEO(IEO ieo) {
        String message = "";
        try {
            Statement statement = connectDb(dBase,name,pwd).createStatement();
            statement.executeUpdate("INSERT INTO `IEO` VALUES ('"+ieo.getDepartment()+"'," +
                    "'"+ieo.getEmail()+"'," +
                    "'"+ieo.getPhone()+"'," +
                    "'"+ieo.getFname()+"'," +
                    "'"+ieo.getLname()+"'," +
                    "'"+ieo.getPassword()+"');");
            message = "Information Added";

        }catch (SQLIntegrityConstraintViolationException e){
            message = "Duplicate Entry";
        }
        catch (SQLException e){
            message = "Something Went Wrong";

        }

        return message;
    }

    public ArrayList<String> getDepartments() {
        ArrayList<String> departments = new ArrayList<>();
        try {
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT department FROM `DepFaculty`;");
            while (resultSet.next()){
                String dep = resultSet.getString(1);
                departments.add(dep);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }
    
    public String getEmail() {
        String ieoMail;
        try {
            Statement statement = connectDb(dBase, name, pwd).createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT email FROM `ieo`;");
            while (resultSet.next()){
                ieoMail = resultSet.getString(1);
                return ieoMail;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
