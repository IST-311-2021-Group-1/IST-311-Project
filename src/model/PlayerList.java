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
        Player p1 = new Player("Alexa", "password1234", "alexa_m", "67226");
        Player p2 = new Player("Tomi", "password1234", "tomi_a", "28451");
        Player p3 = new Player("Vincent", "password1234", "vincent_t", "13143");
        Manager m1 = new Manager("Yasic", "password1234", "yasic_n", "39507", storeList.getStoreArr().get(2));
        Manager m2 = new Manager("Will", "password1234", "will_m", "13143", storeList.getStoreArr().get(1));
        Manager m3 = new Manager("Peggy", "password1234", "peggy_f", "67226", storeList.getStoreArr().get(0));

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

    public HashMap loginInfoHash(String username, String password) {
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
