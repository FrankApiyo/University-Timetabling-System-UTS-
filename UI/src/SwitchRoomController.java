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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import timetable.*;
import timetable.Day;

public class SwitchRoomController implements Initializable {
    ArrayList<Room> aRooms = new ArrayList<>();
    private int d;
    private int s;
    private ArrayList<Course> courses;
    @FXML public ComboBox<String> dayOfWeek;
    @FXML public ComboBox<String> availableRooms;
    @FXML public ComboBox<String> course;
    @FXML public ComboBox<Integer> year;
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
        ArrayList<Integer> courseYears = new ArrayList<>();
        for(Course c : courses)
            if(c.getName().compareTo(courseName) == 0)
                courseYears.add(c.getYear());
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
        else courseYear = year.getValue();
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
        TablePosition pos = timetable.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        // Item here is the table view type:
        //Item item = tbvCitation.getItems().get(row);
        //int col = 2;
        TableColumn col = pos.getTableColumn();
        // this gives the value in the selected cell:
        String data = (String) col.getCellObservableValue(row).getValue();
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
        //add the available room list to the availableRooms combobox
        d = l.indexOf(dayOfWeek.getValue());

        AlgoDriver driver = new AlgoDriver();
        aRooms = driver.getAvailableRooms(s, d);
        ArrayList<String> aRoomNames = new ArrayList<>();
        for(int i = 0; i < aRooms.size(); i++){
            aRoomNames.add(aRooms.get(i).getName());
        }
        availableRooms.setItems(FXCollections.observableList(aRoomNames));
    }
    public void availableRoomClicked(){

    }
    public void okButtonClicked(){
        //
    }
}
