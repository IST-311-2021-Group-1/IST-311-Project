package controller;

/**
 * This class is the main controller for the login and navigation for the
 * Tournament App. This is the core of the app that is always loaded upon
 * turning it on.
 *
 * @author Yaroslav 'Yasic' Naumenko
 */
import model.*;
import view.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Navigation {

    private String userName, passWord;
    private PlayerList playerList;
    private Player user;
    private Registration registration;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane navigationPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private GridPane homePane;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    Text errorLabel;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Text storeText;
    @FXML
    private Text inboxText;
    @FXML
    private Text accountText;
    @FXML
    private Text tournamentText;
    @FXML
    private GridPane loginPane;

    public Navigation() {
        // Loads the list of all user accounts.
        playerList = new PlayerList();
    }

    @FXML
    void handleLoginAction(ActionEvent event) {
        boolean confirmLogin = validateAccountInfo();
        if (confirmLogin) {
            loginPane.setVisible(false);
            homePane.setVisible(true);
        
        } else {
            errorLabel.setText("Please try again");
        }
    }

    @FXML
    void handleRegisterAction(ActionEvent event) throws IOException {
        Parent registration = FXMLLoader.load(getClass().getResource("../view/Register.fxml"));
        Scene registrationScene = new Scene(registration);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registrationScene);
        window.show();
    }

    void setPlayerList(PlayerList newPlayerList) {
        this.playerList = newPlayerList;
    }
    
    private boolean validateAccountInfo() {
        boolean isValid = false;

        // Grab the data the user input ...
        userName = userNameTextField.getText();
        passWord = passwordTextField.getText();

        // Grab the list of all username/password combinations ...
        HashMap<String, String> loginInfoHash = playerList.loginInfoHash();

        // ... and compare if the entered ones match any set
        if (loginInfoHash.containsKey(userName)) {
            if (loginInfoHash.get(userName).equals(passWord)) {
                isValid = true;

                // The following bit runs through the entire list of players
                // in playerList and as soon as it find the player object whose
                // name matches userName, it sets this object in an attribute
                // so we can call upon it to reference or update the user
                // from this moment forward.                 
                for (int i = 0; i < playerList.getPlayerArr().size(); i++) {

                    if (playerList.getPlayerArr().get(i).getUsername().equals(userName)) {
                        user = playerList.getPlayerArr().get(i);
                    }
                }
            }
        }

        return isValid;

    }
}
