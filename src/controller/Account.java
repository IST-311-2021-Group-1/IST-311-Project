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
import model.*;

public class Account {

    private EditAccount editAccount;
    private Player player;
    private PlayerList playerList;
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
    private Text hobbiesField;
    @FXML
    private TitledPane editAccountPane;
    @FXML
    private AnchorPane accountPane;

    public Account() {
        usernameField = new Text();
        usernameField = new Text();
        usernameField = new Text();
        usernameField = new Text();
        player = new Player();

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
    
    public PlayerList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }
    @FXML
    void handleEditAccountButton(ActionEvent event) throws IOException {
        //Load EditAccount.FXML 
        FXMLLoader editLoader = new FXMLLoader(getClass().getResource("../view/EditAccount.FXML"));
        AnchorPane newPane = editLoader.load();
        accountPane.getChildren().setAll(newPane);
        
        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        System.out.println("Current Player " + player);
        EditAccount editController = editLoader.getController();
        editController.setPlayer(player);
        editController.loadTextFields();


    }

}
