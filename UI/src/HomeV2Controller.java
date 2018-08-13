
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import timetable.GoogleMail;

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
        try {
            GoogleMail.Send("franklineapiyo", "franklineapiyo1997", "franklineappy@gmail.com", "", "TIMETABLING DEPARTMENT REQUIREMENT SUBMISSION", "PLEASE JUST SUBMIT REQUIREMENTS");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void showCheckReq(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "checkReq.fxml");
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
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Stage addRoomWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(new Scene(root));
        addRoomWindow.show();
    }
    
    @FXML
    private void showIEO() throws IOException{
        DynamicView.loadBorderCenter(border_pane, "ieo.fxml");
    }
    
}
