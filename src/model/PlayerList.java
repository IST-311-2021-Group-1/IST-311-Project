package model;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerList {

    private ArrayList<Player> playerArr;

    public PlayerList() {
        playerArr = createDefaultArr();
    }

    public PlayerList(ArrayList playerArr) {
        this.playerArr = playerArr;
    }

    public ArrayList<Player> createDefaultArr() {
        ArrayList<Player> newArr = new ArrayList<>();
        
        StoreList storeList = new StoreList();
        
        Player p1 = new Player("alexa_m", "password1234", "Alexa", "67226");
        Player p2 = new Player("tomi_a", "password1234", "Tomi", "28451");
        Player p3 = new Player("vincent_t", "password1234", "Vincent", "13143");
        Manager m1 = new Manager("yasic_n", "testPass", "Yasic", "39507", storeList.getStoreArr().get(2));
        Manager m2 = new Manager("will_m", "password1234", "Will", "13143", storeList.getStoreArr().get(1));
        Manager m3 = new Manager("peggy_f", "password1234", "Peggy", "67226", storeList.getStoreArr().get(0));

        newArr.add(p1);
        newArr.add(p2);
        newArr.add(p3);
        newArr.add(m1);
        newArr.add(m2);
        newArr.add(m3);
        
        return newArr;
    }

    public void addPlayer(Player player) {
        playerArr.add(player);
    }

    public HashMap loginInfoHash() {
        HashMap<String, String> loginCredentials = new HashMap<String, String>();

        for (int i = 0; i < playerArr.size(); i++) {
            loginCredentials.put(playerArr.get(i).getUsername(), playerArr.get(i).getPassword());
        }

        return loginCredentials;
    }
    
    public ArrayList<String> usernamesArr() {
        ArrayList<String> allUserNames = new ArrayList<String>();

        for (int i = 0; i < playerArr.size(); i++) {
            allUserNames.add(playerArr.get(i).getUsername());
        }

        return allUserNames;
    }
    
    public ArrayList<String> displayNamesArr() {
        ArrayList<String> allDisplayNames = new ArrayList<String>();

        for (int i = 0; i < playerArr.size(); i++) {
            allDisplayNames.add(playerArr.get(i).getDisplayName());
        }

        return allDisplayNames;
    }

    //Getters & Setters
    public ArrayList<Player> getPlayerArr() {
        return playerArr;
    }

    public void setPlayerArr(ArrayList<Player> playerArr) {
        this.playerArr = playerArr;
    }

}
