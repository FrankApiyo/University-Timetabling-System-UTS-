import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import timetable.DbDriver;
import timetable.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 *
 * @author brianbett
 */
public class AddRoom implements Initializable{

    @FXML private TextField roomName;
    @FXML private TextField capacity;

    @FXML private RadioButton isLabYes;
    @FXML private RadioButton isLabNo;
    @FXML private RadioButton disYes;
    @FXML private RadioButton disNo;

    private Room room;

    private ToggleGroup isLabToggle;
    private ToggleGroup disToggle;

    public void backButt(ActionEvent event) throws IOException{
        Parent backBut = FXMLLoader.load(getClass().getResource("resources/homeV2.fxml"));
        Scene backButScene = new Scene(backBut);

        Stage addRoomWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(backButScene);
        addRoomWindow.show();
    }
    @FXML private TextField textfield;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        isLabToggle = new ToggleGroup();
        isLabNo.setToggleGroup(isLabToggle);
        isLabYes.setToggleGroup(isLabToggle);

        disToggle  = new ToggleGroup();
        disNo.setToggleGroup(disToggle);
        disYes.setToggleGroup(disToggle);

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    public void submitt(ActionEvent event) throws IOException{
        /*
        Parent backBut = FXMLLoader.load(getClass().getResource(".fxml"));
        Scene backButScene = new Scene(backBut);

        Stage addRoomWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
        addRoomWindow.setScene(backButScene);
        addRoomWindow.show();
        */

        if(roomName.getText().length() == 0 || capacity.getText().length() == 0 || disToggle.getSelectedToggle() == null || isLabToggle.getSelectedToggle() == null){
            //TODO style this alert box.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Incomplete data");
            alert.setContentText("You must enter all fields!");

            alert.showAndWait();
        }else{
            String name = roomName.getText();
            int cap = Integer.parseInt(capacity.getText());

            boolean lab = false;
            if(isLabToggle.getSelectedToggle() == disYes)
                lab = true;

            boolean dF = false;
            if(disToggle.getSelectedToggle() == disYes)
                dF = true;
            DbDriver db = new DbDriver();
            //TODO update ui so that we are able to record board type
            boolean added = db.addRoom(new Room(name, cap, dF, lab, "WHITE"));

            if(added) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                //i used this to debug something
                //alert.setHeaderText(new Boolean(added).toString());
                alert.setContentText("Room added to database!");
                alert.showAndWait();
            }
            roomName.clear();
            capacity.clear();
            disToggle.selectToggle(null);
            isLabToggle.selectToggle(null);
        }

    }
}