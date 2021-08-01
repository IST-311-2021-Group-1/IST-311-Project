/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Tournament;
import model.TournamentList;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
/**
 *
 * @author tomia
 */
public class ViewTournament 
{
    private Tournament tournament;
    private TournamentList tournamentList;
    private DataManagement dataManagement;
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
    public void loadTournamentDetails() {
        tournamentNameField.setText(tournament.getTournamentName());
        dateField.setText(tournament.getDate());
        numPlayerField.setText(String.valueOf(tournament.getMaxNumPlayers()));
        costField.setText(tournament.getCost());
    }
    
    public void setTournamentList(TournamentList tournamentList)
    {
        //this.tournamentList = tournamentList;
    }
    
    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }
}
