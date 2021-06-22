
package tournamentapp;

import model.PlayerList;
import model.StoreList;


public class TournamentApp {


    public static void main(String[] args) {
        PlayerList playerList = new PlayerList();
        StoreList storeList = new StoreList();
        System.out.println("Player List: " + playerList.getPlayerArr());
        System.out.println("StoreList: " + storeList.getStoreArr());

    }
    
}
