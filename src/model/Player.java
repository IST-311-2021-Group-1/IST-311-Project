
package model;

import java.io.Serializable;
import java.util.ArrayList;


public class Player implements Serializable {
    private String username;
    private String password;
    private String displayName;
    private String zipCode;
    
    //Empty constructor
    public Player() {
        
    }
    
    //Constructor with all attributes
    public Player(String username, String password, String displayName, String zipCode) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.zipCode = zipCode;
    }

    public String toString() {
        //Need to decide what to return here
        return "Player: " + displayName;
    }
    
    //Getters & Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getHiddenPassword() {
        String pw = "";
        for (int i = 0; i < password.length(); i++) {
        pw = pw.concat("*");
        }
        return pw;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
}
