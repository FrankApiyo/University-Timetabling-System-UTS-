import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.gluonhq.charm.glisten.control.TextField;   
import javafx.fxml.FXML;


/**
 *
 * @author brianbett
 */
public class AddRoom implements Initializable{
    
    
    public void backButt(ActionEvent event) throws IOException{
        Parent backBut = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene backButScene = new Scene(backBut);
        
        Stage addRoomWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(backButScene);
        addRoomWindow.show();
    }
    @FXML private TextField textfield;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
