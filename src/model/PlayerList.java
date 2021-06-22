
package model;

import java.util.ArrayList;


public class PlayerList {
    private ArrayList<Player> playerArr;
    
    public PlayerList() {
        
    }
    
    public PlayerList(ArrayList playerArr) {
        this.playerArr = playerArr;
    }

    
    
    public void loadArr() {
        //Is this the same as setPlayerArr?
    }
    
    public void addPlayer(Player player) {
        playerArr.add(player);
    }
    
    //Getters & Setters
    public ArrayList<Player> getPlayerArr() {
        return playerArr;
    }

    public void setPlayerArr(ArrayList<Player> playerArr) {
        this.playerArr = playerArr;
    }
    
    
    
}
