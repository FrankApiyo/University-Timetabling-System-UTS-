
import timetable.Day;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SwitchRoomController implements Initializable {

    @FXML
    private TableView<Day> timetable;

    @FXML
    private TableColumn<Day, String> dayColumn;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dayColumn.setCellValueFactory(new PropertyValueFactory<Day , String>("Day"));

        timetable.getItems().setAll(getDays());
    }

    public void backButt(ActionEvent event) throws IOException {
        Parent backBut = FXMLLoader.load(getClass().getResource("manageTimetable.fxml"));
        Scene backButScene = new Scene(backBut);

        Stage addRoomWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(backButScene);
        addRoomWindow.show();
    }

    private ObservableList<Day> getDays() {
        ObservableList<Day> days = FXCollections.observableArrayList();

        days.add(new Day("Monday"));
        days.add(new Day("Teusday"));
        days.add(new Day("Wednesday"));
        days.add(new Day("Thursday"));
        days.add(new Day("Friday"));

        return days;

    }

}
