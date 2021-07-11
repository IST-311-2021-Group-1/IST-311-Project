package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import model.Player;
import model.PlayerList;

public class Registration {

    private PlayerList playerList;
    private Player newUser;
    @FXML
    private Button confirmButton;

    @FXML
    private TextField userNameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private TextField verifyPasswordInput;

    @FXML
    private TextField displayNameInput;

    @FXML
    private TextField zipcodeInput;

    @FXML
    private Button cancelButton;

    @FXML
    private Text usernameError;

    @FXML
    private Text passwordError;

    @FXML
    private Text displayNameError;

    @FXML
    private Text zipcodeError;

    @FXML
    private Text fieldError;

 
    public Registration () {
        playerList = new PlayerList();
        userNameInput = new TextField("");
        passwordInput = new TextField("");
        verifyPasswordInput = new TextField("");
        displayNameInput = new TextField("");
        zipcodeInput = new TextField("");
    }
    @FXML
    void handleCancelAction(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("../view/Navigation.fxml"));
        Scene loginScene = new Scene(login);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginScene);
        window.show();
    }

    @FXML
    void handleConfirmAction(ActionEvent event) throws IOException {
        boolean validateAccount = validate();
        
        if (validateAccount) {
            
            //Register user into playerlist
            register();
           
            //Load Navigation.FXML 
            FXMLLoader login = new FXMLLoader(getClass().getResource("../view/Navigation.FXML"));
            Parent root = login.load();
           
            //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
            Navigation navController = login.getController();
            navController.setPlayerList(playerList);
            
            //Load new scene into window
            Scene registrationScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(registrationScene);
            window.show();
        }
    }

    public void register() {
        // Get the text from the entry fields
        String username = userNameInput.getText();
        String password = passwordInput.getText();
        String displayName = displayNameInput.getText();
        String zipCode = zipcodeInput.getText();

        // Make the new user object with the given data
        newUser = new Player(username, password, displayName, zipCode);

        // And add that object to the list of all players.
        playerList.getPlayerArr().add(newUser);
    }

    //Validates if all input fields are filled or valid
    //Method is WIP, cannot get validation
    private boolean validate() {
        boolean isValid = true;

        String username = userNameInput.getText();
        String password = passwordInput.getText();
        String confirmPassword = verifyPasswordInput.getText();
        String displayName = displayNameInput.getText();
        String zipCode = zipcodeInput.getText();

        // Run a check for all errors.
        if (!password.equals(confirmPassword)) {
            passwordError.setVisible(true);
            isValid = false;
        }

        // Run a check if the username already exists
        if (playerList.usernamesArr().contains(username)) {
            usernameError.setVisible(true);
            isValid = false;
        }

        // Run a check if the display name already exists
        if (playerList.usernamesArr().contains(displayName)) {
            displayNameError.setVisible(true);
            isValid = false;
        }

        // Run a check to see if the fields are empty
        if (username.equals("") || password.equals("") || confirmPassword.equals("") || displayName.equals("") || zipCode.equals("")) {
            fieldError.setVisible(true);
            isValid = false;
        }

        return isValid;
    }
}
