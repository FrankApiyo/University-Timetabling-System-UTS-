import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import timetable.DbDriver;
import timetable.Requirements;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class CheckRequirements implements Initializable {
    @FXML
    TableView<Requirements> table;

    @FXML
    TableColumn<Requirements, String> dep;

    @FXML
    TableColumn<Requirements, String> date;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //look in table to see if any entries else change string on table to no requirements received yet.
        DbDriver driver = new DbDriver();
        if(driver.checkRequirementsAvailable()){
            ArrayList<String> departments = driver.getDepartments();
            HashMap<String, Date> requirements = driver.getRequirementDates();

            //TODOne -- add the dates and requirments to table
            ArrayList<Requirements> list = new ArrayList<>();
            for(String s: departments){
                if(requirements.containsKey(s)) {
                    //add the key and date to table
                    list.add(new Requirements(s, requirements.get(s)));
                }
            }
            ObservableList<Requirements> data = FXCollections.observableArrayList(list);
            table.setItems(data);
            dep.setCellValueFactory(
                    new PropertyValueFactory<>("department")
            );
            date.setCellValueFactory(
                    new PropertyValueFactory<>("date")
            );
            table.getColumns().get(0).setVisible(false);
            table.getColumns().get(0).setVisible(true);
        }else{
            //TODO-- change the default string on table to:'requirements not yet available'
            System.out.println("no content found in table");
        }
    }
}
