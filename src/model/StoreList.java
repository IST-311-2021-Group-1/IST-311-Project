package model;

import java.util.ArrayList;

public class StoreList {

    private ArrayList<Store> storeArr;

    public StoreList() {
        storeArr = createDefaultArr();

    }

    public StoreList(ArrayList storeArr) {
        this.storeArr = storeArr;
    }

    public ArrayList<Store> createDefaultArr() {
        ArrayList<Store> newArr = new ArrayList<>();
        PlayerList playerList = new PlayerList();
        
        Store ChessStore = new Store("Chess Store", "123 Bluebird St", "67226", 30, ((Manager)playerList.getPlayerArr().get(5)));
        Store GameStore = new Store("Game Store", "187 Yellow Ave", "13143", 50, ((Manager)playerList.getPlayerArr().get(4)));
        Store CardStore = new Store("Card Store", "900 Sandpiper Ln", "39507", 40, ((Manager)playerList.getPlayerArr().get(3)));
        Store HobbyStore = new Store("Hobby Store", "123 Lane", "67226", 30, null);
        Store ArcadeStore = new Store("Arcade Store", "345 Nextdoor St.", "13143", 40, null);
        Store VideoGameStore = new Store("Video Game Store", "789 Bottlecap Ave", "12345", 30, null);
        
        newArr.add(ChessStore);
        newArr.add(GameStore);
        newArr.add(CardStore);
        newArr.add(HobbyStore);
        newArr.add(ArcadeStore);
        newArr.add(VideoGameStore);
        
        return newArr;
    }

    public void addStore(Store store) {
        storeArr.add(store);
    }

    //Getters & Setters
    public ArrayList<Store> getStoreArr() {
        return storeArr;
    }

    public void setStoreArr(ArrayList<Store> storeArr) {
        this.storeArr = storeArr;
    }

}
