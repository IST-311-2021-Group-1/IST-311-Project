/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Player;
import model.PlayerList;
import java.io.IOException;
/**
 * FXML Controller class
 *
 * @author vincenttse
 */
public class StoreAccount implements Initializable {
    
    private DataManagement dataManagement;
    private Player player;
    
    private PlayerList playerList;
    @FXML
    private Button backButton;

    @FXML
    private Button createButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOW
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
    void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/Navigation.FXML"));
        Parent root = login.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        Navigation navController = login.getController();
        navController.setPlayerList(playerList);
        navController.setPlayer(player);
        navController.setReturn();
        // navController.handleWindowAction(player.getUsername(), player.getPassword());

        //Load new scene into window
        Scene navScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(navScene);
        window.show();
    }
    
    @FXML
    void handleCreateButton(ActionEvent event) throws IOException {
        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/CreateTournament.FXML"));
        Parent root = login.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        CreateTournament navController = login.getController();
        navController.setDataManagement(dataManagement);
        navController.setPlayer(player);
        //navController.setReturn();
        // navController.handleWindowAction(player.getUsername(), player.getPassword());

        //Load new scene into window
        Scene navScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(navScene);
        window.show();
    }
    

    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }
}
