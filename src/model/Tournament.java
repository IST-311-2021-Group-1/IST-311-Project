/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tomia
 */

//Tourney is the name of the Tournament object to avoid confusion with Tournament in controller package
public class Tournament {
    
    private String tournamentName;
    private String date;
    private PlayerList playerList;
    private String cost;
    
    public Tournament(String tournamentName, String date, PlayerList playerList, String cost) {
        this.tournamentName = tournamentName;
        this.date = date;
        this.playerList = playerList;
        this.cost = cost;
    }

    /**
     * @return the tournamentName
     */
    public String getTournamentName() {
        return tournamentName;
    }

    /**
     * @param tournamentName the tournamentName to set
     */
    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the playerList
     */
    public PlayerList getPlayerList() {
        return playerList;
    }

    /**
     * @param playerList the playerList to set
     */
    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }

    /**
     * @return the cost
     */
    public String getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(String cost) {
        this.cost = cost;
    }
}
