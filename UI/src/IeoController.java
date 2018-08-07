/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import timetable.IEO;
import timetable.DbDriver;

public class IeoController implements Initializable {

    @FXML private JFXTextField tf_fname;
    @FXML private JFXTextField tf_lname;
    @FXML private JFXTextField tf_email;
    @FXML private JFXTextField tf_phone;
    @FXML private JFXTextField tf_department;
    @FXML private JFXPasswordField pf_password;
    @FXML private JFXPasswordField pf_cpassword;
    @FXML JFXButton btn_add;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btn_add.setOnAction(event -> {submitt();});
    }    

    private void submitt() {
        if(pf_password.getText().equals(pf_cpassword.getText())){
            DbDriver db = new DbDriver();
            boolean added = db.addIEO(new IEO(tf_department.getText(),
                    tf_email.getText(),
                    tf_phone.getText(),
                    tf_fname.getText(),
                    tf_lname.getText(),
                    pf_password.getText()));
            if (added){
                //TODO "Update UI to notify the admin"
            }

        }
    }
}

