package model;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerList {

    private ArrayList<Player> playerArr;

    public PlayerList() {
        playerArr = new ArrayList<>();
        loadArr();
    }

    public PlayerList(ArrayList playerArr) {
        this.playerArr = playerArr;
    }

    public void loadArr() {
        StoreList storeList = new StoreList();
        Player p1 = new Player("alexa_m", "password1234", "Alexa", "67226");
        Player p2 = new Player("tomi_a", "password1234", "Tomi", "28451");
        Player p3 = new Player("vincent_t", "password1234", "Vincent", "13143");
        Manager m1 = new Manager("yasic_n", "testPass", "Yasic", "39507", storeList.getStoreArr().get(2));
        Manager m2 = new Manager("will_m", "password1234", "Will", "13143", storeList.getStoreArr().get(1));
        Manager m3 = new Manager("peggy_f", "password1234", "Peggy", "67226", storeList.getStoreArr().get(0));

        playerArr.add(p1);
        playerArr.add(p2);
        playerArr.add(p3);
        playerArr.add(m1);
        playerArr.add(m2);
        playerArr.add(m3);

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

    //Getters & Setters
    public ArrayList<Player> getPlayerArr() {
        return playerArr;
    }

    public void setPlayerArr(ArrayList<Player> playerArr) {
        this.playerArr = playerArr;
    }

}
