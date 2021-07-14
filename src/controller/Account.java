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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;


public class Account {

    private Player player;
    @FXML
    private Button editAccountButton;
    @FXML
    private Button backButton;
    @FXML
    private Text usernameField;
    @FXML
    private Text passwordField;
    @FXML
    private Text displayNameField;
    @FXML
    private Text zipCodeField;
    @FXML
    private Text hobbiesField;


    public Account() {
        usernameField = new Text();
        usernameField = new Text();
        usernameField = new Text();
        usernameField = new Text();

    }

//    Loads data for the player who is logged in
    @FXML
    public void loadPlayerData() {
        usernameField.setText(player.getUsername());
        passwordField.setText(player.getHiddenPassword());
        displayNameField.setText(player.getDisplayName());
        zipCodeField.setText(player.getZipCode());
        //Need to format string in Player
        //hobbiesField.setText(player.getHobbyArr());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @FXML
    void handleEditAccountButton(ActionEvent event) throws IOException {
        
    }
    
    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
            //Load HomeMenu.FXML
            FXMLLoader homeMenu = new FXMLLoader(getClass().getResource("../view/Navigation.FXML"));
            Parent root = homeMenu.load();

            //Load new scene into window
            Scene homeMenuScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(homeMenuScene);
            window.show();
    }

}
