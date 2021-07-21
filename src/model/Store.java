
package model;

import java.io.Serializable;


public class Store  implements Serializable {
    private String name;
    private String address;
    private String zipCode;
    private int playerCapacity;
    
    //Empty constructor
    public Store() {
        
    }
    
    
    //Constructor with all attributes
    public Store(String name, String address, String zipCode, int playerCapacity) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.playerCapacity = playerCapacity;
    }

    
    public String toString() {
        return name;
    }
    //Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getPlayerCapacity() {
        return playerCapacity;
    }

    public void setPlayerCapacity(int playerCapacity) {
        this.playerCapacity = playerCapacity;
    }
    
    
    
}
