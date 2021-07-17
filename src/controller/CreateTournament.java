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
import javafx.fxml.FXMLLoader;
import model.PlayerList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author tomia
*/

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import model.Player;

public class CreateTournament {
    
    private DataManagement dataManagement;
    private PlayerList playerList;
    private Player player;
    

    @FXML
    private Button createButton;
    
    @FXML
    private Button backButton;

    @FXML
    private TextField tourneyNameField;

    @FXML
    private TextField costField;
    
    @FXML
    private TextField playerListField;
    
    @FXML
    private TextField dateField;
    
    @FXML
    private Text createText;
    

    public PlayerList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }
    
    private void create() {
        String tournamentName = tourneyNameField.getText();
        String date = dateField.getText();
        String playerlist = playerListField.getText();
        String cost = costField.getText();
        
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
        //navController.handleWindowAction(player.getUsername(), player.getPassword());
        
        //Load new scene into window
        Scene registrationScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registrationScene);
        window.show();
    }
    
    @FXML
    void handleCreateButton(ActionEvent event) throws IOException {
            create();
            createText.setVisible(true);
            System.out.println("Tournament Created!");
        
    }
    
    public void setPlayer(Player newPlayer) {
        this.player = newPlayer;
    }
    
    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }

}


 /*
public class CreateTournament implements Initializable {
    
    
    
    @FXML
    private TextField tourneyNameField;

    @FXML
    private TextField dateField;
    
    @FXML
    private TextField numPlayerField;
    
    @FXML
    private TextField costField;
    
    @FXML
    private Button backButton;
    
    @FXML
    private Button createButton;
    
    
/*
    /**
     * Initializes the controller class.
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }   
    
     public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    private void create()
    {
        
    }
*/
  
    
    
 
