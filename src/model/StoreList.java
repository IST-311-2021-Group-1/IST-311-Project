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
        
        Store ChessStore = new Store("Chess Store", "123 Bluebird St", "67226", 30);
        Store GameStore = new Store("Game Store", "187 Yellow Ave", "13143", 50);
        Store CardStore = new Store("Card Store", "900 Sandpiper Ln", "39507", 40);
        
        newArr.add(ChessStore);
        newArr.add(GameStore);
        newArr.add(CardStore);
        
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
