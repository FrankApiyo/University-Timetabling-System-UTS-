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

public class ManageTT implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void switchRButt(ActionEvent event) throws IOException{
        Parent switchBut = FXMLLoader.load(getClass().getResource("switchRoom.fxml"));
        Scene sRoomScene = new Scene(switchBut);
        
        Stage addRoomWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(sRoomScene);
        addRoomWindow.show();
    }
    
    public void backButt(ActionEvent event) throws IOException{
        Parent backBut = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene backButScene = new Scene(backBut);
        
        Stage backWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        backWindow.setScene(backButScene);
        backWindow.show();
    }
    
    public void addRoomSceenButt(ActionEvent event) throws IOException {
        Parent addRoomBut = FXMLLoader.load(getClass().getResource("addRoom.fxml"));
        Scene addButScene = new Scene(addRoomBut);

        Stage addRoomWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(addButScene);
        addRoomWindow.show();
    }
    
    public void removeRoomButt(ActionEvent event) throws IOException {
        Parent removeRoomBut = FXMLLoader.load(getClass().getResource("removeRoom.fxml"));
        Scene removeButScene = new Scene(removeRoomBut);

        Stage removeRoomWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        removeRoomWindow.setScene(removeButScene);
        removeRoomWindow.show();
    }
}
