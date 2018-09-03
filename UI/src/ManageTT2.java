import com.jfoenix.controls.JFXTabPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageTT2 implements Initializable {
    @FXML Tab room_tab;
    @FXML Tab switch_room_tab;
    @FXML Tab lecturer_tab;
    @FXML JFXTabPane tabPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {


        room_tab.setContent(FXMLLoader.load(getClass().getResource("resources/rooms.fxml")));
        switch_room_tab.setContent(FXMLLoader.load(getClass().getResource("resources/switchRoom.fxml")));
        lecturer_tab.setContent(FXMLLoader.load(getClass().getResource("resources/lecturer.fxml")));}
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
