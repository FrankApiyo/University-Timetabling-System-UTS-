import com.gluonhq.charm.glisten.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author brianbett
 */
public class RemoveRoom implements Initializable{
    
    
    public void backButt(ActionEvent event) throws IOException{
        Parent backBut = FXMLLoader.load(getClass().getResource("manageTimetable.fxml"));
        Scene backButScene = new Scene(backBut);
        
        Stage backWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        backWindow.setScene(backButScene);
        backWindow.show();
    }
    @FXML private TextField textfield;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

