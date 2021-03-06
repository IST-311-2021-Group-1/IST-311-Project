/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

/**
 * FXML Controller class
 *
 * @author alexamcinvaille
 */
public class ManagerRegistration {

    private DataManagement dataManagement;

    private PlayerList playerList;
    private Manager newManager;
    private StoreList storeList;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField verifyPasswordField;

    @FXML
    private TextField displayNameField;

    @FXML
    private TextField zipCodeField;

    @FXML
    private Button cancelButton;

    @FXML
    private Text usernameError;

    @FXML
    private Text passwordError;

    @FXML
    private Text displayNameError;

    @FXML
    private Text zipCodeError;

    @FXML
    private Text fieldError;

    @FXML
    private ChoiceBox storeChoice;

    public ManagerRegistration() {

    }

    public void loadPlayers() {
        playerList = dataManagement.loadPlayers();
    }

    //Loads store data and store choices
    public void loadStores() {
        storeList = dataManagement.loadStoreChoices();

        for (int i = 0; i < playerList.getPlayerArr().size(); i++) {
            for (int x = 0; x < storeList.getStoreArr().size(); x++) {
                if (storeList.getStoreArr().get(x).getManager() != null) {
                    if (storeList.getStoreArr().get(x).getManager().equals(playerList.getPlayerArr().get(i))) {
                        storeList.getStoreArr().remove(x);
                    }
                }
            }
        }

        storeChoice.setItems(FXCollections.observableArrayList(storeList.getStoreArr()));

    }

    private void register() {
        // Get the text from the entry fields
        String username = userNameField.getText();
        String password = passwordField.getText();
        String displayName = displayNameField.getText();
        String zipCode = zipCodeField.getText();
        Store store = (Store) storeChoice.getValue();

        // Make the new user object with the given data
        newManager = new Manager(username, password, displayName, zipCode, store);

        // Set the manager attribute for Store
        store.setManager(newManager);

        // And add the objects to the list of all players/stores
        playerList.getPlayerArr().add(newManager);
        storeList.getStoreArr().add(store);

        // And store them in the files
        dataManagement.savePlayers(playerList.getPlayerArr());
        dataManagement.saveStores(storeList.getStoreArr());
    }

    //Validates if all input fields are filled or valid
    //Method is WIP, cannot get validation
    private boolean validate() {
        boolean isValid = true;

        String username = userNameField.getText();
        String password = passwordField.getText();
        String confirmPassword = verifyPasswordField.getText();
        String displayName = displayNameField.getText();
        String zipCode = zipCodeField.getText();

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

        // Run a check to see if the zipcode is 5 digits
        if (zipCode.length() != 5) {
            zipCodeError.setVisible(true);
            isValid = false;
        }

        // Run a check to see if the fields are empty
        if (username.equals("") || password.equals("") || confirmPassword.equals("")
                || displayName.equals("") || zipCode.equals("") || storeChoice.getValue() == null) {
            fieldError.setVisible(true);
            isValid = false;
        }

        return isValid;
    }

    @FXML
    private void handleRegisterAction(ActionEvent event) throws IOException {
        boolean validateAccount = validate();

        if (validateAccount) {

            //Register user into playerlist
            register();

            //Load Navigation.FXML 
            FXMLLoader login = new FXMLLoader(getClass().getResource("../view/Navigation.FXML"));
            Parent root = login.load();

            //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
            Navigation navController = login.getController();

            //Load new scene into window
            Scene registrationScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(registrationScene);
            window.show();
        }
    }

    @FXML
    private void handleCancelAction(ActionEvent event) throws IOException {
        //Load Navigation.FXML
        FXMLLoader navigation = new FXMLLoader(getClass().getResource("../view/Navigation.FXML"));
        Parent root = navigation.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        Navigation navController = navigation.getController();

        //Load new scene into window
        Scene registrationScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registrationScene);
        window.show();
    }

    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }

}
