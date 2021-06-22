package model;

import java.util.ArrayList;

public class StoreList {

    private ArrayList<Store> storeArr;

    public StoreList() {
        storeArr = new ArrayList<>();
        loadArr();

    }

    public StoreList(ArrayList storeArr) {
        this.storeArr = storeArr;
    }

    public void loadArr() {
        Store ChessStore = new Store("Chess Store", "123 Bluebird St", "67226", 30);
        Store GameStore = new Store("Game Store", "187 Yellow Ave", "13143", 50);
        Store CardStore = new Store("Card Store", "900 Sandpiper Ln", "39507", 40);
        
        storeArr = new ArrayList<>();
        storeArr.add(ChessStore);
        storeArr.add(GameStore);
        storeArr.add(CardStore);
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
