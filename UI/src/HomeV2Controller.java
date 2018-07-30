
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author brianbett
 */
public class HomeV2Controller implements Initializable {

    
    @FXML
    private BorderPane border_pane;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    

    @FXML
    private void show_request_req(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "reqRequest.fxml");
    }

    @FXML
    private void showCheckReq(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "reqRequest.fxml");
    }

    @FXML
    private void showDisplayTimetable(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "displayTT.fxml");
    }

    @FXML
    private void showGenerateTimetable(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "generateTimetable.fxml");
    }

    @FXML
    private void showManageTimetable(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "manageTimetable.fxml");
    }

    @FXML
    private void showSendTimetable(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "sendTT.fxml");
    }

    @FXML
    private void showLogin(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "login.fxml");
    }
    
}
