
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import timetable.GoogleMail;
import timetable.SendEmail;

/**
 * FXML Controller class
 *
 * @author brianbett
 */
public class HomeV2Controller implements Initializable {

    
    @FXML
    private BorderPane border_pane;
    @FXML
    private Button btn_request_req;
    @FXML
    private Button btn_check_req;
    @FXML
    private Button btn_display_timetable;
    @FXML
    private Button btn_generate_timetable;
    @FXML
    private Button btn_manage_timetable;
    @FXML
    private Button btn_send_timetable;
    @FXML
    private Button btn_show_ieo;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        border_pane.setStyle("-fx-background-color: #C5E1A5;");
         
    }    
    /**
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void show_request_req(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "resources/reqRequest.fxml");
    }
    
    /**
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void showCheckReq(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "resources/checkReq.fxml");
    }

    @FXML
    private void showReqReceived(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "resources/reqRequest.fxml");
        SendEmail.reqRequirements();
    }

    @FXML
    private void showDisplayTimetable(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "resources/displayTT.fxml");
    }

    @FXML
    private void showGenerateTimetable(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "resources/generateTimetable.fxml");
    }

    @FXML
    private void showManageTimetable(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "resources/manageTimetable.fxml");
    }

    @FXML
    private void showSendTimetable(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "resources/sendTT.fxml");
        
        SendEmail.sendTT();
    }

    @FXML
    private void showLogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("resources/login.fxml"));

        Stage addRoomWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(new Scene(root));
        addRoomWindow.show();
    }
    /**
     * 
     * @throws IOException 
     */
    @FXML
    private void showIEO(MouseEvent event) throws IOException{
        DynamicView.loadBorderCenter(border_pane, "resources/ieo.fxml");
    }
    
    

    @FXML
    private void menuDecoratorE(MouseEvent event) {
        btn_request_req.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE1(MouseEvent event) {
        btn_check_req.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE2(MouseEvent event) {
        btn_display_timetable.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE3(MouseEvent event) {
        btn_generate_timetable.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE4(MouseEvent event) {
        btn_manage_timetable.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE5(MouseEvent event) {
        btn_send_timetable.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE6(MouseEvent event) {
        btn_show_ieo.setStyle("-fx-background-color:#43a047");
    }
    
    
    @FXML
    private void menuDecoratorX(MouseEvent event) {
        btn_request_req.setStyle("-fx-background-color:#ffffff");
    }
    
    @FXML
    private void menuDecoratorX1(MouseEvent event) {
        btn_check_req.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX2(MouseEvent event) {
        btn_display_timetable.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX3(MouseEvent event) {
        btn_generate_timetable.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX4(MouseEvent event) {
        btn_manage_timetable.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX5(MouseEvent event) {
        btn_send_timetable.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX6(MouseEvent event) {
        btn_show_ieo.setStyle("-fx-background-color:#ffffff");
    }
    
    
    
}
