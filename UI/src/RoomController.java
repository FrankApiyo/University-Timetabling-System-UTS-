import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import timetable.DbDriver;
import timetable.Room;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RoomController implements Initializable {
    //Add room fields
    @FXML
    JFXTextField add_room_name;
    @FXML
    JFXTextField capacity;
    @FXML
    JFXCheckBox cb_disability;
    @FXML
    JFXCheckBox cb_laboratory;
    @FXML
    JFXButton btn_add;
    @FXML
    JFXComboBox<String> cbox_board_type;

    //Remove room fields
    @FXML
    JFXComboBox<String> remove_room_name;
    @FXML
    JFXButton btn_remove;

    DbDriver dbDriver = new DbDriver();
    ArrayList<Room> rooms = dbDriver.getRooms();




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn_add.setOnAction(event -> {
            addRoom();
        });
        btn_remove.setOnAction(event -> {
            removeRoom();
        });
        cb_disability.setIndeterminate(false);
        cb_laboratory.setIndeterminate(false);
        cbox_board_type.getItems().addAll("White Board","Chalk Board");

        for (Room room:rooms) {
            remove_room_name.getItems().add(room.getName());
        }


    }
    void addRoom(){
        boolean isAdded = dbDriver.addRoom(new Room(add_room_name.getText(),Integer.parseInt(capacity.getText()),cb_disability.isSelected(),cb_laboratory.isSelected(),cbox_board_type.getValue()));
        if (isAdded){
            //Message room was added
        }
    }
    void removeRoom(){
        dbDriver.removeRoom(remove_room_name.getValue());
    }
}
