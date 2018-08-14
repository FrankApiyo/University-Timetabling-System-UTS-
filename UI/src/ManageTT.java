import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTabPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import timetable.AlgoDriver;

public class ManageTT implements Initializable{

    @FXML JFXTabPane managett_tabpane;
    Tab lecturer_tab = new Tab("Lecturer");
    Tab room_tab = new Tab("Rooms");
    Tab switch_room_tab = new Tab("Switch Room");



    @Override
    public void initialize(URL url, ResourceBundle rb) {


        try{
        lecturer_tab.setContent(FXMLLoader.load(getClass().getResource("resources/lecturer.fxml")));
        lecturer_tab.setClosable(false);
        room_tab.setContent(FXMLLoader.load(getClass().getResource("resources/rooms.fxml")));
        room_tab.setClosable(false);
        switch_room_tab.setContent(FXMLLoader.load(getClass().getResource("resources/switchRoom.fxml")));
        switch_room_tab.setClosable(false);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        managett_tabpane.getTabs().add(lecturer_tab);
        managett_tabpane.getTabs().add(room_tab);
        managett_tabpane.getTabs().add(switch_room_tab);

    }

    public JFXTabPane getManagett_tabPane() {
        return managett_tabpane;
    }
}
