/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Tournament;
import model.TournamentList;
import model.Store;
import model.Player;
import model.PlayerList;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;

/**
 *
 * @author vincenttse
 */
public class EditTournament {

    private DataManagement dataManagement;
    private TournamentList tournamentList;
    private ArrayList<String> tournamentData;
    private Player player;

    @FXML
    private Button refreshButton;
    @FXML
    private Button addTournament;
    @FXML
    private Button backButton2;
    @FXML
    private ListView<String> listPanel;
    @FXML
    private ScrollBar scrollSlider;

    public EditTournament() {
        tournamentList = new TournamentList();
        tournamentData = new ArrayList();
//        loadTournaments();
    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader storeLoader = new FXMLLoader(getClass().getResource("../view/StoreAccount.FXML"));
        Parent root = storeLoader.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        Store storeController = storeLoader.getController();
//        storeController.setDataManagement(dataManagement);
//        storeController.loadPlayerData();
//        storeController.setReturn();
        // navController.handleWindowAction(player.getUsername(), player.getPassword());

        //Load new scene into window
        Scene navScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(navScene);
        window.show();
    }

    @FXML
    void handleAddButton(ActionEvent event) {
        
    }

    @FXML
    void handleRefreshButton(ActionEvent event) {
//        ObservableList<String> data; 
        //FXCollections.observableArrayList(tournamentList.getTournamentArr());
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < tournamentList.getTournamentArr().size(); i++) {
            data.add(tournamentList.getTournamentArr().get(i).getTournamentName());
        }
        listPanel.setItems(FXCollections.observableArrayList(data));
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }

}
