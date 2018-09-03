import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import timetable.DbDriver;
import timetable.Lecturer;
import java.util.ArrayList;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RemoveLecturer implements Initializable{
    @FXML ComboBox<String> box;
    ArrayList<String> lecNameList = new ArrayList<>();
    ArrayList<Lecturer> list = new ArrayList<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DbDriver dbDriver = new DbDriver();
        list = dbDriver.getLecturers();
        for(Lecturer l : list)
            lecNameList.add(l.getName());
        ObservableList<String> observableList = FXCollections.observableList(lecNameList);
        box.setItems(observableList);
    }
    public void remove(){
        String cBoxVal = box.getValue();
        if(cBoxVal == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("you must select a lecturer to remove");
            alert.showAndWait();
        }else{
            DbDriver dbDriver = new DbDriver();
            boolean removed = dbDriver.removeLecturer("null");
            if(removed) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText(cBoxVal + " has been removed from database");
                alert.showAndWait();
                lecNameList.remove(cBoxVal);
                ObservableList<String> list = FXCollections.observableList(lecNameList);
                box.setItems(list);
                box.setValue(null);
            }
        }
    }
    public void back() throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("homeV2.fxml"));
        Stage stage = (Stage)box.getParent().getScene().getWindow();
        stage.setScene(new Scene(parent));
        stage.show();
    }

}
