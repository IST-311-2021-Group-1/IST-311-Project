/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author tomia
 */
public class TournamentList {
    
    
    private Tournament tournament;
    private ArrayList<Tournament> tournamentArr;
    private ArrayList<PlayerList> playerListArr;
    
    public TournamentList() {
        tournamentArr = createDefaultList();
    }

       
    public TournamentList(ArrayList<Tournament> tournamentArr) {
        this.tournamentArr = tournamentArr;
    }
    
    public ArrayList<Tournament> createDefaultList() {
        ArrayList<Tournament> newArr = new ArrayList<>();
        Tournament t1 = new Tournament("Warhammer 4K 2021 Invitational", "July 17, 2021", 14, playerListArr, "5");
        Tournament t2 = new Tournament("Warhammer 4K 2021 Finals", "July 18, 2021", 14, playerListArr, "6");
        Tournament t3 = new Tournament("Warhammer 4K 2021 Finals", "July 18, 2021", 14, playerListArr, "6");
        
        newArr.add(t1);
        newArr.add(t2);
        newArr.add(t3);
        
        return newArr;
    }
 
    
    public void addTournament(Tournament tournament){
         getTournamentArr().add(tournament);
    }

    /**
     * @return the tournamentArr
     */
    public ArrayList<Tournament> getTournamentArr() {
        return tournamentArr;
    }

    /**
     * @param tournamentArr the tournamentArr to set
     */
    public void setTournamentArr(ArrayList<Tournament> tournamentArr) {
        this.tournamentArr = tournamentArr;
    }
}
