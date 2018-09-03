import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import timetable.DbDriver;
import timetable.Lecturer;

import java.net.URL;
import java.util.ResourceBundle;

public class LecturersController implements Initializable {
    @FXML JFXTextField reg_no_add;
    @FXML JFXTextField name;
    @FXML JFXComboBox<String> department;
    @FXML JFXButton btn_register;

    @FXML JFXButton btn_remove;
    @FXML JFXComboBox<String> reg_remove;

    DbDriver dbDriver = new DbDriver();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
        btn_register.setOnAction(event -> {
            addLecturer();
        });
        btn_remove.setOnAction(event -> {
            removeLecturer();
        });

    }
    private void load(){
        reg_no_add.clear();
        name.clear();
        department.getItems().clear();
        department.getItems().addAll(dbDriver.getDepartments());
        reg_remove.getItems().clear();
        for (Lecturer lec:dbDriver.getLecturers()){
            reg_remove.getItems().add(lec.getRegNo());

        }

    }

    private void removeLecturer() {
        if(dbDriver.removeLecturer(reg_remove.getValue())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(reg_remove.getValue()+" was removed");
            alert.showAndWait();
        }
        load();

    }

    private void addLecturer() {
        if (dbDriver.addLecturer(new Lecturer(name.getText(),
                department.getValue(), reg_no_add.getText()))){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(name.getText()+" was added");
            alert.showAndWait();
        }
        load();

    }


}
