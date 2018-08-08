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
import timetable.AlgoDriver;

public class ManageTT implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void removeLecturer(ActionEvent event) throws  IOException{
        Parent parent = FXMLLoader.load(getClass().getResource("removeLecturer.fxml"));
        Stage stage = ((Stage)((Node)event.getSource()).getScene().getWindow());
        stage.setScene(new Scene(parent));
        //stage.show();
    }
    public void addLecturer(ActionEvent event)throws IOException{
        Parent addLec = FXMLLoader.load(getClass().getResource("addLecturer.fxml"));
        Scene addLecScene = new Scene(addLec);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(addLecScene);
        stage.show();
    }
    public void switchRButt(ActionEvent event) throws IOException{
        Parent switchBut = FXMLLoader.load(getClass().getResource("switchRoom.fxml"));
        Scene sRoomScene = new Scene(switchBut);
        
        Stage addRoomWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(sRoomScene);
        addRoomWindow.show();
    }
    
    public void backButt(ActionEvent event) throws IOException{
        Parent backBut = FXMLLoader.load(getClass().getResource("homeV2.fxml"));
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
    
     public void okButt(ActionEvent event) throws IOException {
         AlgoDriver driver  = new AlgoDriver();
         driver.generateTimetable();
        Parent okBut = FXMLLoader.load(getClass().getResource("displayTT.fxml"));
        Scene removeButScene = new Scene(okBut);

        Stage removeRoomWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
        removeRoomWindow.setScene(removeButScene);
        removeRoomWindow.show();
    }
}
