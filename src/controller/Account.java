/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Label;
import model.*;

public class Account {

    private DataManagement dataManagement;
    private Player player;
    private Manager manager;

    @FXML
    private AnchorPane editAccountPanes;
    @FXML
    private AnchorPane editPane;
    @FXML
    private Button editAccountButton;
    @FXML
    private Text usernameField;
    @FXML
    private Text passwordField;
    @FXML
    private Text displayNameField;
    @FXML
    private Text zipCodeField;
    @FXML
    private TitledPane editAccountPane;
    @FXML
    private AnchorPane accountPane;
    @FXML
    private Text storeField;
    @FXML
    private Label storeLabel;

    public Account() {

    }

//    Loads data for the player who is logged in
    @FXML
    public void loadPlayerData() {
        usernameField.setText(player.getUsername());
        passwordField.setText(player.getHiddenPassword());
        displayNameField.setText(player.getDisplayName());
        zipCodeField.setText(player.getZipCode());
        checkManager();
        if (player instanceof Manager) {
            storeField.setText(((Manager) player).getStore().toString());
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void checkManager() {
        storeField.setVisible(player instanceof Manager);
        storeLabel.setVisible(player instanceof Manager);
    }

    @FXML
    void handleEditAccountButton(ActionEvent event) throws IOException {
        //Load EditAccount.FXML 
        FXMLLoader editLoader = new FXMLLoader(getClass().getResource("../view/EditAccount.FXML"));
        AnchorPane newPane = editLoader.load();
        accountPane.getChildren().setAll(newPane);

        System.out.println("Current Player " + player);
        EditAccount editController = editLoader.getController();
        editController.setPlayer(player);
        editController.setDataManagement(dataManagement);
        editController.loadTextFields();

    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/Navigation.FXML"));
        Parent root = login.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        Navigation navController = login.getController();
        navController.setDataManagement(dataManagement);
        navController.setPlayer(player);
        navController.setReturn();

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
