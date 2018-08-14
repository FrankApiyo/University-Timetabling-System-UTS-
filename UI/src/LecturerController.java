import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LecturerController implements Initializable {
    @FXML JFXTextField reg_no_add;
    @FXML TextField add_name;
    @FXML JFXComboBox<String> add_department;
    @FXML JFXButton btn_register;

    @FXML JFXComboBox<String> reg_no_remove;
    @FXML JFXButton btn_remove;

    DbDriver db = new DbDriver();

    ArrayList<String> departments = new ArrayList<>();
    ArrayList<Lecturer> lecturers = new ArrayList<>();
    ArrayList<String> reg_no = new ArrayList<>();



    public void addLecturer(){
        DbDriver dbDriver = new DbDriver();
        boolean success = dbDriver.addLecturer(new Lecturer(add_name.getText(), add_department.getValue(), reg_no_add.getText()));
        if(success){
            reg_no_add.clear();
            add_name.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            //alert.setHeaderText("l");
            alert.setContentText("lecturer added to database");
            alert.showAndWait();
        }
    }

    public void removeLecturer(){
        boolean removed = db.removeLecturer(lecturers.get(reg_no.indexOf(reg_no_remove.getValue())));
        if(removed) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText(reg_no_remove.getValue()+ " has been removed from database");
            alert.showAndWait();
        }
    }
    
    
    public void initialize(URL url, ResourceBundle rb) {


        departments.addAll(db.getDepartments());
        add_department.getItems().addAll(departments);

        lecturers.addAll(db.getLecturers());
        for (Lecturer lec: lecturers){
            String reg = lec.getRegNo();
            reg_no.add(reg);
        }
        reg_no_remove.getItems().addAll(reg_no);

        btn_register.setOnAction(event -> {
            if (reg_no_add.getText() != ""
                    || add_name.getText()!=""
                    || add_department.getValue() != ""
                    ){addLecturer();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Failure");
                alert.setContentText("Please fill all fields");
                alert.showAndWait();
            }

        });
        btn_remove.setOnAction(event -> {
            removeLecturer();
        });

    }
}
