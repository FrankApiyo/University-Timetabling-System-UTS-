
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;


/**
 *
 * @author brianbett
 */
public class DynamicView {
    
    public static void loadBorderCenter(BorderPane b, String resource) throws IOException{
        Parent parent = FXMLLoader.load(new DynamicView().getClass().getResource(resource));
        
        b.setCenter(parent);
    }
    public static void loadBorderCenter (BorderPane borderPane, Node node){
        borderPane.setCenter(node);
    }
    
}
