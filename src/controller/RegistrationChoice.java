
package controller;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alexamcinvaille
 */
public class RegistrationChoice {

    private DataManagement dataManagement;
    @FXML
    private Button playerButton;
    
    @FXML
    private Button managerButton;
    
    
    public RegistrationChoice() {
        // Load the DataManagement Controller
        dataManagement = new DataManagement();}
    
    @FXML
    public void handleManagerButtonAction(ActionEvent event) throws IOException {
              
        FXMLLoader register = new FXMLLoader(getClass().getResource("../view/ManagerRegistration.FXML"));
        Parent root = register.load();
        ManagerRegistration navController = register.getController();
        navController.setDataManagement(dataManagement);
        navController.loadPlayers();
        navController.loadStores();
        Scene registrationScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registrationScene);
        window.show();
    }
    
    @FXML
    public void handlePlayerButtonAction(ActionEvent event) throws IOException {

        FXMLLoader register = new FXMLLoader(getClass().getResource("../view/Register.FXML"));
        Parent root = register.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        Registration navController = register.getController();
        navController.setDataManagement(dataManagement);
        navController.loadPlayers();

        //Load new scene into window
        Scene registrationScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registrationScene);
        window.show();
    }
}
