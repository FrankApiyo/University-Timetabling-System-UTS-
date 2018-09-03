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

    @FXML JFXComboBox<String> cbox_department_remove;
    @FXML JFXButton btn_remove;

    ArrayList<String> departments = new ArrayList<>();
    DbDriver db = new DbDriver();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        load();
        btn_add.setOnAction(event -> {
            addIEO();});
        btn_remove.setOnAction(event -> {
            removeIEO();
        });
    }

    private void load(){
        tf_fname.clear();
        tf_lname.clear();
        tf_email.clear();
        tf_phone.clear();
        pf_password.clear();
        pf_cpassword.clear();

        departments.clear();
        cbox_department.getItems().clear();
        
        departments.addAll(db.getDepartments());
        cbox_department.getItems().addAll(departments);

        cbox_department_remove.getItems().clear();
        for (IEO ieo: db.getIEO()) {
            cbox_department_remove.getItems().add(ieo.getDepartment());
            ieo.toString();
        }

    }

    private void addIEO() {
        if(pf_password.getText().equals(pf_cpassword.getText())){
            String message = db.addIEO(new IEO(cbox_department.getValue(),
                    tf_email.getText(),
                    tf_phone.getText(),
                    tf_fname.getText(),
                    tf_lname.getText(),
                    pf_password.getText()));
            txt_message.setText(message);


        }
        load();
    }

    private void removeIEO(){
        db.removeIEO(cbox_department_remove.getValue());
        load();
    }
}

