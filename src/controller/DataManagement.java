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
    private String storeListFileName = "TournamentAppStores.ser";
    private ArrayList<Player> listOfPlayers;
    private ArrayList<Store> listOfStores;

    // Empty Constructor
    public DataManagement() {
        listOfPlayers = new ArrayList();
        listOfStores = new ArrayList();
    }

    public PlayerList loadPlayers() {

        // Try loading the plaers from the file
        readPlayerListFile();

        // If the file is not found or if it is empty...
        if (listOfPlayers.isEmpty() || listOfPlayers == null) {

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

    public void readPlayerListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(playerListFileName);
            in = new ObjectInputStream(fis);
            listOfPlayers = (ArrayList) in.readObject();
            in.close();
            if (!listOfPlayers.isEmpty()) {
                System.out.println("Player List Loaded!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void savePlayers(ArrayList<Player> listToSave) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(playerListFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listToSave);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public StoreList loadStores() {
        // Try loading the stores from the file
       readStoreListFile();

        // If the file is not found or if it is empty...
        if (listOfStores.isEmpty() || listOfStores == null) {

            // Create a new default list of stores
            StoreList defaultStoreList = new StoreList();
            listOfStores = defaultStoreList.getStoreArr();

            // Save it to (a new) file.
            saveStores(listOfStores);

            // And then load it from the newly created file.
            readStoreListFile();
        }

        return new StoreList(listOfStores);
    }
    
    public StoreList loadStoreChoices() {
        ArrayList<Store> storeList = new ArrayList();
        storeList = loadStores().getStoreArr();
            for (int i = 0; i < storeList.size(); i++) {
            if (storeList.get(i).getManager() != null) {
                storeList.remove(i);
            }
        }
            return new StoreList(storeList);
    }

    public void readStoreListFile() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(storeListFileName);
            in = new ObjectInputStream(fis);
            listOfStores = (ArrayList) in.readObject();
            in.close();
            if (!listOfStores.isEmpty()) {
                System.out.println("Store List Loaded!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void saveStores(ArrayList<Store> listToSave) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(storeListFileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(listToSave);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
