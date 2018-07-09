/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    void OncheckReqClick(ActionEvent event) {

    }

    @FXML
    void OnDisplayTT(ActionEvent event) {

    }

    @FXML
    void OnGenerateTT(ActionEvent event) {

    }

    @FXML
    void OnManageTT(ActionEvent event) throws IOException {
        Parent manageTTBut = FXMLLoader.load(getClass().getResource("manageTimetable.fxml"));
        Scene manageTTScene = new Scene(manageTTBut);

        Stage addRoomWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(manageTTScene);
        addRoomWindow.show();
    }

    @FXML
    void OnReqRequirements(ActionEvent event) {

    }

    @FXML
    void OnSendTT(ActionEvent event) {

    }

    @FXML
    void OnLogOut(ActionEvent event) {

    }

    /**
     * When this button is pushed it changes scene to Add Rooms
     *
     * @param event
     * @throws java.io.IOException
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
