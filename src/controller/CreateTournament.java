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
import java.util.ArrayList;
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
import model.Tournament;
import model.TournamentList;

public class CreateTournament {
    
    private DataManagement dataManagement;
    private Tournament tournament;
    private TournamentList tournamentList;
    private ArrayList<PlayerList> playerListArr;
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
    private Text fieldError;
    
    @FXML
    private Text createText;
    

    public ArrayList<PlayerList> getPlayerListArr() {
        return playerListArr;
    }

    public void setPlayerListArr(ArrayList<PlayerList> playerList) {
        this.playerListArr = playerListArr;
    }
    
    private void create() {
        
        String tournamentName = tourneyNameField.getText();
        String date = dateField.getText();
        int maxNumPlayers = Integer.parseInt(playerListField.getText());
        //PlayerList playerList = null;
        String cost = costField.getText();
        
        tournament = new Tournament(tournamentName, date, maxNumPlayers, playerListArr, cost);
        tournamentList.getTournamentArr().add(tournament);
        
    }
    
    //
    private boolean validate() {
        boolean isValid = true;
        
        String tournamentName = tourneyNameField.getText();
        String date = dateField.getText();
        int maxNumPlayers = Integer.parseInt(playerListField.getText()); //NumberFormatException from this line
        String cost = costField.getText();
        
        //Checks that all fields are filled
        if (tournamentName.equals("") || date.equals("") || maxNumPlayers == 0 || cost.equals("")) {
            fieldError.setVisible(true);
            isValid = false;
        }
        
        return true;
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
         
        boolean validateInfo = validate();
        
        if(validateInfo) {
            create(); 
            //createText.setVisible(true);, this is commented because there is an issue that it displays when all fields aren't filled too
            System.out.println("Tournament Created!");
        }
        
        else {
            createText.setVisible(false);
        }
        
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
  
    
    
 
