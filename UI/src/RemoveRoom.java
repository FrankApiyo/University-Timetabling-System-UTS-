//import com.gluonhq.charm.glisten.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import timetable.DbDriver;


/**
 *
 * @author brianbett
 */
public class RemoveRoom implements Initializable{
    @FXML ComboBox<String> comboBox;

    public void remove(){
        String s = comboBox.getValue();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        //i used this to debug something
        //alert.setHeaderText(new Boolean(added).toString());
        alert.setContentText(s == null? "empty string" :s);
        alert.showAndWait();
    }
    public void backButt(ActionEvent event) throws IOException{
        Parent backBut = FXMLLoader.load(getClass().getResource("manageTimetable.fxml"));
        Scene backButScene = new Scene(backBut);

        Stage backWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        backWindow.setScene(backButScene);
        backWindow.show();
    }
    //i dint see the use for this.
    //@FXML private TextField textfield;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DbDriver dbDriver = new DbDriver();
        ArrayList<String> roomNames = new ArrayList<>();
        ArrayList<timetable.Room> roomList = dbDriver.getRooms();
        for(timetable.Room room : roomList){
            roomNames.add(room.getName());
        }
        ObservableList<String> list = FXCollections.observableList(roomNames);
        comboBox.setItems(list);
    }
}
