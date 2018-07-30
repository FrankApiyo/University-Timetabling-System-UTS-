
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Login implements Initializable {

    private String uName = "";
    private String pWd = "";
    @FXML
    JFXTextField username;
    @FXML
    JFXPasswordField password;
    @FXML
    Text login_text;

    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        //for now use constants -- later these will be read from a file.
        uName = "uts";
        pWd = "uts";
    }

    public void login() throws IOException {
        //System.out.println("login called");
        if (username.getText().equals(uName) && password.getText().equals(pWd)) {
            //start next scene.
            //System.out.println("correct");
            Parent root = FXMLLoader.load(getClass().getResource("homeV2.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) username.getScene().getWindow();
            stage.setScene(scene);
        } else {
            //show warning.
            login_text.setText("Incorrect Credentials");
        }
    }
}
