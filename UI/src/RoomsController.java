import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import timetable.DbDriver;
import timetable.Room;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomsController implements Initializable {

    @FXML JFXTextField add_room_name;
    @FXML JFXTextField capacity;
    @FXML JFXCheckBox cb_disability;
    @FXML JFXCheckBox cb_laboratory;
    @FXML JFXButton btn_add;
    @FXML JFXComboBox<String> board_type;
    @FXML JFXComboBox<String> remove_room_name;
    @FXML JFXButton btn_remove;

    DbDriver dbDriver = new DbDriver();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
        btn_add.setOnAction(event -> {
            addRoom();
        });
        btn_remove.setOnAction(event -> {
            removeRoom();
        });
    }

    private void removeRoom() {
        dbDriver.removeRoom(remove_room_name.getValue());
        load();

    }

    private void addRoom() {
        int cap = Integer.parseInt(capacity.getText());
        boolean isDisFrendly = cb_disability.isSelected();
        boolean isLab = cb_laboratory.isSelected();
        if (dbDriver.addRoom(new Room(add_room_name.getText(),
                cap,
                isDisFrendly,
                isLab,
                board_type.getValue()
                ))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(add_room_name.getText()+" was added");
            alert.showAndWait(); }
            load();

    }
    private void load(){
        add_room_name.clear();
        capacity.clear();
        cb_disability.setSelected(false);
        cb_laboratory.setSelected(false);
        board_type.getItems().clear();
        board_type.getItems().addAll("White Board","Chalk Board");
        remove_room_name.getItems().clear();
        for (Room room:dbDriver.getRooms()) {
            remove_room_name.getItems().add(room.getName());
        }

    }
}
