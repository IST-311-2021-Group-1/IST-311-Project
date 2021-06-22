package model;

import java.util.ArrayList;

public class Manager extends Player {

    private Store store;

    //Empty constructor
    public Manager() {
        super();
    }

    //Constructor with all attributes
    public Manager(String username, String password, String displayName, String zipCode, ArrayList hobbyArr, Store store) {
        super(username, password, displayName, zipCode, hobbyArr);
        this.store = store;
    }

    //Constructor without hobbyArr
    public Manager(String username, String password, String displayName, String zipCode, Store store) {
        super(username, password, displayName, zipCode);
        this.store = store;
    }

    public String toString() {
        return "Manager: " + super.getDisplayName() + " " + store;
    }

    //Getters & Setters
    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
