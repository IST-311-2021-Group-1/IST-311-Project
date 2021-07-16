

package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.*;
import view.*;

/**
 *
 * @author Yaroslav 'Yasic' Naumenko
 */
public class DataManagement {
    
    private String playerListFileName = "TournamentAppPlayers.ser";
    private ArrayList<Player> listOfPlayers;

    // Empty Constructor
    public DataManagement() {
        listOfPlayers = new ArrayList();
    }
    
    public PlayerList loadPlayers() {
     
        // Try loading the plaers from the file
        readPlayerListFile();
        
        // If the file is not found or if it is empty...
        if(listOfPlayers.isEmpty() || listOfPlayers == null){
            
            // Create a new default list of players
            PlayerList defaultPlayerList = new PlayerList();
            listOfPlayers = defaultPlayerList.getPlayerArr();
            
            // Save it to (a new) file.
            savePlayers(listOfPlayers);
            
            // And then load it from the newly crated file.
            readPlayerListFile();
        }
        
        return new PlayerList(listOfPlayers);
    }
    
    public void readPlayerListFile(){
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(playerListFileName);
            in = new ObjectInputStream(fis);
            listOfPlayers = (ArrayList)in.readObject();
            in.close();
            if(!listOfPlayers.isEmpty()){
                System.out.println("Player List Loaded!");
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public void savePlayers(ArrayList<Player> listToSave){
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(playerListFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listToSave);
            out.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
