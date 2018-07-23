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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import timetable.Course;
import timetable.Day;
import timetable.DbDriver;

/**
 *
 * @author brianbett
 */
public class DisplayTT implements Initializable {
    private ArrayList<Course> courses;
    @FXML public ComboBox<String> course;
    @FXML public ComboBox<Integer> year;

    @FXML
    private TableView<Day> timetable;

    @FXML
    private TableColumn<Day, String> dayColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //dayColumn.setCellValueFactory(new PropertyValueFactory<Day, String>("Day"));

        //timetable.getItems().setAll(getDays());
        DbDriver dbDriver = new DbDriver();
        courses = dbDriver.getCourses();
        Set<String> courseNames = new HashSet<>();
        //Set<Integer> courseYears = new HashSet<>();
        for(Course c: courses){
            courseNames.add(c.getName());
            //courseYears.add(c.getYear());
        }
        course.setItems(FXCollections.observableList(new ArrayList<>(courseNames)));
        //year.setItems(FXCollections.observableList(new ArrayList<>(courseYears)));
    }

    public void backButt(ActionEvent event) throws IOException {
        Parent backBut = FXMLLoader.load(getClass().getResource("home.fxml"));
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
    }
    /*
    private ObservableList<Day> getDays() {
        ObservableList<Day> days = FXCollections.observableArrayList();

        days.add(new Day("Monday"));
        days.add(new Day("Teusday"));
        days.add(new Day("Wednesday"));
        days.add(new Day("Thursday"));
        days.add(new Day("Friday"));

        return days;

    }
    */
}
