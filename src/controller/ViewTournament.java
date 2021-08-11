/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import model.Tournament;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Player;
/**
 *
 * @author tomia
 */
public class ViewTournament 
{
    private Tournament tournament;
    private DataManagement dataManagement;
    private Player player;
    
    @FXML
    private Text tournamentNameField;

    @FXML
    private Text numPlayerField;

    @FXML
    private Text dateField;

    @FXML
    private Text costField;
    
    
    public ViewTournament()
    {
    }
    
    
    //Loading details for individual tournament
    @FXML
    public void loadTournamentDetails() {
        System.out.println("Tournament: " + tournament.getTournamentName());
        tournamentNameField.setText(tournament.getTournamentName());
        dateField.setText(tournament.getDate());
        numPlayerField.setText(String.valueOf(tournament.getMaxNumPlayers()));
        costField.setText("$" + tournament.getCost());
    }
    
    @FXML
    public void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader tournamentLoader = new FXMLLoader(getClass().getResource("../view/Tournament.FXML"));
        Parent root = tournamentLoader.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        SearchTournament tournController = tournamentLoader.getController();
        tournController.setDataManagement(dataManagement);
        tournController.setPlayer(player);
        

        //Load new scene into window
        Scene tournamentScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tournamentScene);
        window.show();
        

    }
    
    public void setTournament(Tournament tournament)
    {
        this.tournament = tournament;
    }
    
    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
}
