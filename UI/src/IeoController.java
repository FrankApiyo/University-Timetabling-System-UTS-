/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import timetable.IEO;
import timetable.DbDriver;
import timetable.Room;

/**
 * FXML Controller class
 *
 * @author brianbett
 */
public class IeoController implements Initializable {

    @FXML
    private JFXTextField fname;
    @FXML
    private JFXTextField lname;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField phone;
    @FXML
    private JFXTextField department;
    @FXML
    private JFXPasswordField password;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    @FXML
    private void submitt(ActionEvent event) {
        if(lname.getText().length() == 0 ||
                fname.getText().length() == 0 ||
                department.getText().length() == 0 ||
                phone.getText().length() == 0 ||
                email.getText().length() == 0 || 
                password.getText().length() == 0){
            //TODO style this alert box.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Incomplete data");
            alert.setContentText("You must enter all fields!");

            alert.showAndWait();
        }else{
            DbDriver db = new DbDriver();
            
            //TODO update ui so that we are able to record board type
            boolean added = db.addIEO(new IEO(department.getText(), email.getText(), phone.getText(), fname.getText(), lname.getText(), password.getText()));

            if(added) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                //i used this to debug something
                //alert.setHeaderText(new Boolean(added).toString());
                alert.setContentText("Room added to database!");
                alert.showAndWait();
            }
            fname.clear();
            lname.clear();
            email.clear();
            phone.clear();
            department.clear();
            password.clear();
        }
    }
}
