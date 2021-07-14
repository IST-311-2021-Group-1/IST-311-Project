/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.*;

/**
 *
 * @author alexamcinvaille
 */
public class EditAccount {

    private Account account;
    private Player player;
    private PlayerList playerList;
    
    @FXML
    private Button backButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField usernameEdit;
    @FXML
    private TextField passwordEdit;
    @FXML
    private TextField displayNameEdit;
    @FXML
    private TextField zipCodeEdit;
    @FXML
    private Label editAccountLabel;
    
    public EditAccount() {
        
    }

    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    //Loads the data for the player logged in
    @FXML
    public void loadTextFields() {
        playerList = new PlayerList();
        usernameEdit.setText(player.getUsername());
        passwordEdit.setText(player.getHiddenPassword());
        displayNameEdit.setText(player.getDisplayName());
        zipCodeEdit.setText(player.getZipCode());
    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {

        this.backButton.getScene().getWindow().hide();
//        //Load Navigation.FXML
//        FXMLLoader navigationLoader = new FXMLLoader(getClass().getResource("../view/Navigation.FXML"));
//        Parent root = navigationLoader.load();
//
//        //Load new scene into window
//        Scene registrationScene = new Scene(root);
//        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        window.setScene(registrationScene);
//        window.show();
//        
//        //Load Account.FXML 
//        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("../view/Account.FXML"));
//        homePane.setCenter(accountLoader.load());
//        account = accountLoader.getController();
//        homePane.setMaxSize(50, 50);
//        account.setPlayer(player);
//        account.loadPlayerData();
    }
    
    @FXML 
    void handleSaveButton(ActionEvent event) {
        
        if (usernameEdit.getText().isEmpty() || passwordEdit.getText().isEmpty() ||
                displayNameEdit.getText().isEmpty() || zipCodeEdit.getText().isEmpty()) {
            editAccountLabel.setVisible(true);
            editAccountLabel.setText("Please fill in all fields");

        } else {
            editAccountLabel.setText("Saved!");
        player.setUsername(usernameEdit.getText());
        player.setPassword(passwordEdit.getText());
        player.setDisplayName(displayNameEdit.getText());
        player.setZipCode(zipCodeEdit.getText());
        }
        System.out.println("Info is now: " + player.getUsername());
    }
}
