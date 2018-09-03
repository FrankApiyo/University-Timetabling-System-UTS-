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
    ArrayList<String> roomNames;

    /**
     * 
     */
    public void remove(){
        String s = comboBox.getValue();


        if(s == null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning!");
            alert.setContentText("you must select a room to remove");
            alert.showAndWait();
        }else{
            DbDriver dbDriver = new DbDriver();
            dbDriver.removeRoom(s);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText(s+" has been removed from database");
            alert.showAndWait();
            roomNames.remove(s);
            ObservableList<String> list = FXCollections.observableList(roomNames);
            comboBox.setItems(list);
        }

    }
    
    /**
     * 
     * @param event
     * @throws IOException 
     */
    public void backButt(ActionEvent event) throws IOException{
        Parent backBut = FXMLLoader.load(getClass().getResource("resources/homeV2.fxml"));
        Scene backButScene = new Scene(backBut);

        Stage backWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        backWindow.setScene(backButScene);
        backWindow.show();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DbDriver dbDriver = new DbDriver();
        roomNames = new ArrayList<>();
        ArrayList<timetable.Room> roomList = dbDriver.getRooms();
        for(timetable.Room room : roomList){
            roomNames.add(room.getName());
        }
        ObservableList<String> list = FXCollections.observableList(roomNames);
        comboBox.setItems(list);
    }
}
