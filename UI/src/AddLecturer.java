import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import timetable.DbDriver;
import timetable.Lecturer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddLecturer implements Initializable {
    @FXML TextField regNo;
    @FXML TextField name;
    @FXML TextField department;

    public void register(){
        DbDriver dbDriver = new DbDriver();
        boolean success = dbDriver.addLecturer(new Lecturer(name.getText(), department.getText(), regNo.getText()));
        if(success){
            regNo.clear();
            name.clear();
            department.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            //alert.setHeaderText("l");
            alert.setContentText("lecturer added to database");
            alert.showAndWait();
        }
    }
    public void back()throws IOException {
        Parent backBut = FXMLLoader.load(getClass().getResource("resources/manageTimetable.fxml"));
        Scene backButScene = new Scene(backBut);

        Stage addRoomWindow = (Stage)regNo.getScene().getWindow();
        addRoomWindow.setScene(backButScene);
        addRoomWindow.show();
    }
    
    
    public void initialize(URL url, ResourceBundle rb) {

    }
}
