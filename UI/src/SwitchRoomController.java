import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import timetable.*;
import timetable.Day;

public class SwitchRoomController implements Initializable {
    ArrayList<Room> aRooms = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();
    private int d;
    private int ts;
    private int s;
    String data;
    int row;
    int newRow;

    private ArrayList<Course> courses;
    @FXML public ComboBox<String> dayOfWeek;
    @FXML public ComboBox<String> timeSlot;
    @FXML public ComboBox<String> availableRooms;
    @FXML public ComboBox<String> course;
    @FXML public ComboBox<String> year;
    @FXML public TableColumn<Day, String> c11;
    @FXML public TableColumn<Day, String> c10;
    @FXML public TableColumn<Day, String> c9;
    @FXML public TableColumn<Day, String> c8;
    @FXML public TableColumn<Day, String> c7;
    @FXML public TableColumn<Day, String> c6;
    @FXML public TableColumn<Day, String> c5;
    @FXML public TableColumn<Day, String> c4;
    @FXML public TableColumn<Day, String> c3;
    @FXML public TableColumn<Day, String> c2;
    @FXML public TableColumn<Day, String> c1;

    ArrayList<TableColumn<Day, String>>  columns = new ArrayList<>();

    @FXML
    private TableView<Day> timetable;

    @FXML
    private TableColumn<Day, String> dayColumn;

    ArrayList<String> l = new ArrayList<>();

    ArrayList<String> timeSlots = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columns.add(c1);
        columns.add(c2);
        columns.add(c3);
        columns.add(c4);
        columns.add(c5);
        columns.add(c6);
        columns.add(c7);
        columns.add(c8);
        columns.add(c9);
        columns.add(c10);
        columns.add(c11);

        l.add("Monday");
        l.add("Tuesday");
        l.add("Wednesday");
        l.add("Thurday");
        l.add("Friday");

        dayOfWeek.setItems(FXCollections.observableList(l));

        timeSlots.add("7:00-8:00");
        timeSlots.add("8:00-9:00");
        timeSlots.add("9:00-10:00");
        timeSlots.add("10:00-11:00");
        timeSlots.add("11:00-12:00");
        timeSlots.add("12:00-13:00");
        timeSlots.add("13:00-14:00");
        timeSlots.add("14:00-15:00");
        timeSlots.add("15:00-16:00");
        timeSlots.add("16:00-17:00");
        timeSlots.add("17:00-18:00");


        timeSlot.setItems(FXCollections.observableList(timeSlots));

        DbDriver dbDriver = new DbDriver();
        courses = dbDriver.getCourses();

        Set<String> courseNames = new HashSet<>();

        for(Course c: courses){
            courseNames.add(c.getName());

        }
        course.setItems(FXCollections.observableList(new ArrayList<>(courseNames)));
        //year.setItems(FXCollections.observableList(new ArrayList<>(courseYears)));
    }

    public void backButt(ActionEvent event) throws IOException {
        Parent backBut = FXMLLoader.load(getClass().getResource("resources/homeV2.fxml"));
        Scene backButScene = new Scene(backBut);

        Stage addRoomWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(backButScene);
        addRoomWindow.show();
    }
    public void selectCourse(){
        String courseName = course.getValue();
        ArrayList<String> courseYears = new ArrayList<>();
        for(Course c : courses)
            if(c.getName().compareTo(courseName) == 0)
                courseYears.add(c.getYear()+"");
        year.setItems(FXCollections.observableList(courseYears));
    }
    public void selectYear(){
        //show timetable on table
        //first create the days objects representing the timetable for this specific course and year.
        Day[] days = new Day[5];

        //get selected course
        String courseName = course.getValue();
        int courseYear = 0;
       try{if(year.getValue() == null)
            return;
        else courseYear = Integer.parseInt(year.getValue());
       }catch (ClassCastException e){

       }
        Course selectedCourse = null;

        for(Course c : courses)
            if(c.getName().compareTo(courseName) == 0 && c.getYear() == courseYear)
                selectedCourse = c;

        //loop through days finding classes for each day
        AlgoDriver driver = new AlgoDriver();

        for(int i = 0; i < days.length; i++){
            days[i] = driver.getClasses(i, selectedCourse);
        }

        ObservableList<Day> data =
                FXCollections.observableArrayList(days);

        timetable.setItems(data);
        dayColumn.setCellValueFactory(
                new PropertyValueFactory<>("weekDay")
        );
        c1.setCellValueFactory(
                new PropertyValueFactory<>("c1")
        );
        c2.setCellValueFactory(
                new PropertyValueFactory<>("c2")
        );
        c3.setCellValueFactory(
                new PropertyValueFactory<>("c3")
        );
        c4.setCellValueFactory(
                new PropertyValueFactory<>("c4")
        );
        c5.setCellValueFactory(
                new PropertyValueFactory<>("c5")
        );
        c6.setCellValueFactory(
                new PropertyValueFactory<>("c6")
        );
        c7.setCellValueFactory(
                new PropertyValueFactory<>("c7")
        );
        c8.setCellValueFactory(
                new PropertyValueFactory<>("c8")
        );
        c9.setCellValueFactory(
                new PropertyValueFactory<>("c9")
        );
        c10.setCellValueFactory(
                new PropertyValueFactory<>("c10")
        );
        c11.setCellValueFactory(
                new PropertyValueFactory<>("c11")
        );

        timetable.getColumns().get(0).setVisible(false);
        timetable.getColumns().get(0).setVisible(true);
    }
    public void cellClicked(){

        timetable.getSelectionModel().setCellSelectionEnabled(true);

        TablePosition pos = timetable.getSelectionModel().getSelectedCells().get(0);
        row = pos.getRow();
        // Item here is the table view type:
        //Item item = tbvCitation.getItems().get(row);
        //int col = 2;
        TableColumn col = pos.getTableColumn();
        // this gives the value in the selected cell:
         data = (String) col.getCellObservableValue(row).getValue();
        System.out.println(data);
        //s = col.getColumns().indexOf(col);
        String title = col.getText();
        for(int i = 0; i < columns.size(); i++){
            if(columns.get(i).getText() == title)
                s = i;
        }
        //System.out.println("s: "+s);
    }
    public void onSelectDay(){

        d = l.indexOf(dayOfWeek.getValue());
    }

    public void onSelectTimeSlot(){
        ts = timeSlots.indexOf(timeSlot.getValue());

        AlgoDriver driver = new AlgoDriver();
        aRooms = driver.getAvailableRooms(ts, d);
        ArrayList<String> aRoomNames = new ArrayList<>();

        for(int i = 0; i < aRooms.size(); i++){
            aRoomNames.add(aRooms.get(i).getName());
        }
        availableRooms.setItems(FXCollections.observableList(aRoomNames));
    }


    public void availableRoomClicked(){
       // assignNewRoom();
        Room r = null;
        for(Room rm: aRooms)
            if(rm.getName().equalsIgnoreCase(availableRooms.getValue()))
                r = rm;
        //get Course
        AlgoDriver driver = new AlgoDriver();
        ArrayList<Room> rList = driver.getRooms();
        //get time and day (s and row)
        //switch with new room (ts and d)
        for(Room roomInList: rList){
            Clss[][] clss = roomInList.getDays();
                if(clss[row][s] != null)
                    if(clss[row][s].getC().getName().equalsIgnoreCase(course.getValue()))
                        if(clss[row][s].getC().getYear() == Integer.parseInt(year.getValue())){
                        r.getDays()[d][ts] = clss[row][s];
                        clss[row][s] = null;
                        break;
                    }
        }
        selectYear();
    }
    public void okButtonClicked(){
        //
    }

}
