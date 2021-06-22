
package model;

import java.util.ArrayList;


public class StoreList {
    private ArrayList<Store> storeArr;
    
    public StoreList() {
        
    }
    
    public StoreList(ArrayList storeArr) {
        this.storeArr = storeArr;
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
