
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author brianbett
 */
public class HomeV2Controller implements Initializable {

    
    @FXML
    private BorderPane border_pane;
    @FXML
    private Button btn;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    
    /**
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void show_request_req(MouseEvent event) throws IOException {
        DynamicView.loadBorderCenter(border_pane, "reqRequest.fxml");
    }
    
    /**
     * 
     * @param event
     * @throws IOException 
     */
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
    /**
     * 
     * @throws IOException 
     */
    @FXML
    private void showIEO(MouseEvent event) throws IOException{
        DynamicView.loadBorderCenter(border_pane, "ieo.fxml");
    }
    
    

    @FXML
    private void menuDecoratorE(MouseEvent event) {
        btn.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE1(MouseEvent event) {
        btn1.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE2(MouseEvent event) {
        btn2.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE3(MouseEvent event) {
        btn3.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE4(MouseEvent event) {
        btn4.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE5(MouseEvent event) {
        btn5.setStyle("-fx-background-color:#43a047");
    }
    @FXML
    private void menuDecoratorE6(MouseEvent event) {
        btn6.setStyle("-fx-background-color:#43a047");
    }
    
    
    @FXML
    private void menuDecoratorX(MouseEvent event) {
        btn.setStyle("-fx-background-color:#ffffff");
    }
    
    @FXML
    private void menuDecoratorX1(MouseEvent event) {
        btn1.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX2(MouseEvent event) {
        btn2.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX3(MouseEvent event) {
        btn3.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX4(MouseEvent event) {
        btn4.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX5(MouseEvent event) {
        btn5.setStyle("-fx-background-color:#ffffff");
    }
    @FXML
    private void menuDecoratorX6(MouseEvent event) {
        btn6.setStyle("-fx-background-color:#ffffff");
    }
    
    
    
}
