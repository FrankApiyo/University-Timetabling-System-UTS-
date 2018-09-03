/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import timetable.IEO;
import timetable.DbDriver;

public class IeoController implements Initializable {

    @FXML private JFXTextField tf_fname;
    @FXML private JFXTextField tf_lname;
    @FXML private JFXTextField tf_email;
    @FXML private JFXTextField tf_phone;
    @FXML private JFXComboBox<String> cbox_department;
    @FXML private JFXPasswordField pf_password;
    @FXML private JFXPasswordField pf_cpassword;
    @FXML private Text txt_message;
    @FXML JFXButton btn_add;
    DbDriver db = new DbDriver();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> departments = new ArrayList<>();
        departments.addAll(db.getDepartments());
        cbox_department.getItems().addAll(departments);
        btn_add.setOnAction(event -> {submitt();});
    }    

    private void submitt() {
        if(pf_password.getText().equals(pf_cpassword.getText())){
            String message = db.addIEO(new IEO(cbox_department.getValue(),
                    tf_email.getText(),
                    tf_phone.getText(),
                    tf_fname.getText(),
                    tf_lname.getText(),
                    pf_password.getText()));
            txt_message.setText(message);


        }
    }
}

