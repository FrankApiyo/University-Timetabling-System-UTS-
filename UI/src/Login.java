import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Login implements Initializable {
    private String uName = "";
    private String pWd = "";
    @FXML
    JFXTextField username;
    @FXML
    JFXTextField password;
    @FXML
    Label wrong;
    @Override
    public void initialize(URL url, ResourceBundle  bundle){
        //for now use constants -- later these will be read from a file.
        uName = "Frankline";
        pWd = "Frankline";
    }
    public void login() throws IOException {
        if(username.getText().equals(uName) && password.getText().equals(pWd)){
            //start next scene.
            System.out.println("correct");
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage)username.getScene().getWindow();
            stage.setScene(scene);
        }else{
            //show warning.
            wrong.setVisible(true);
        }
    }
}
