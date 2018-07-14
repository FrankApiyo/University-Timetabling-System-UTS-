
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
public class Controller implements Initializable {

    @FXML
    void OnReqRequirements(ActionEvent event) throws IOException {
        Parent reqReqBut = FXMLLoader.load(getClass().getResource("reqRequest.fxml"));
        Scene reqReqScene = new Scene(reqReqBut);

        Stage reqReqWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        reqReqWindow.setScene(reqReqScene);
        reqReqWindow.show();
    }

    @FXML
    void OnDisplayTT(ActionEvent event) throws IOException{
        Parent genTTBut = FXMLLoader.load(getClass().getResource("displayTT.fxml"));
        Scene genTTScene = new Scene(genTTBut);

        Stage genTTWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        genTTWindow.setScene(genTTScene);
        genTTWindow.show();

    }
/**
 * 
 * @param event
 * @throws IOException 
 */
    @FXML
    void OnGenerateTT(ActionEvent event)throws IOException {
        Parent genTTBut = FXMLLoader.load(getClass().getResource("generateTimetable.fxml"));
        Scene genTTScene = new Scene(genTTBut);

        Stage genTTWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        genTTWindow.setScene(genTTScene);
        genTTWindow.show();
    }
    /**
     * This Button sends user to the manage Timetable
     * @param event
     * @throws IOException 
     */
    @FXML
    void OnManageTT(ActionEvent event) throws IOException {
        Parent manageTTBut = FXMLLoader.load(getClass().getResource("manageTimetable.fxml"));
        Scene manageTTScene = new Scene(manageTTBut);

        Stage manageTWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        manageTWindow.setScene(manageTTScene);
        manageTWindow.show();
    }

    @FXML
    void OncheckReqClick(ActionEvent event) {

    }

    @FXML
    void OnSendTT(ActionEvent event) throws IOException {
        Parent sendTTBut = FXMLLoader.load(getClass().getResource("sendTT.fxml"));
        Scene sendTTScene = new Scene(sendTTBut);

        Stage sendTTWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sendTTWindow.setScene(sendTTScene);
        sendTTWindow.show();
    }

    @FXML
    void OnLogOut(ActionEvent event) {
        //Stage stage = (Stage) closeButton.getScene().getWindow();
        //stage.close();

    }

    /**
     * When this button is pushed it changes scene to Add Rooms
     *
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Stage stage = new Stage();
        stage.setTitle("Home");
    }

}
