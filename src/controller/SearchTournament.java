/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollBar;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Player;
import model.PlayerList;
import javafx.scene.control.ListView;
import model.TournamentList;

/**
 * FXML Controller class
 *
 * @author vincenttse
 */
public class SearchTournament implements Initializable {

    private DataManagement dataManagement;
    private Player player;
    private TournamentList tournamentList;
    private ArrayList<String> tournamentData;
    
    private PlayerList playerList;
    @FXML
    private Button backButton;
    @FXML
    private Button loadButton;
    @FXML
    private ListView<String> listPanel;
    @FXML
    private ScrollBar scrollBar;
    @FXML
    private Button viewButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public SearchTournament(){
        tournamentList = new TournamentList();
        tournamentData = new ArrayList();
       // loadTournaments();
        
    }
    
    private void loadTournaments(){
        
        //ObservableList<String> data;
        //ListView<TournamentList> viewList = new ListView<>(TournamentList);
        
        
        //ObservableList<String> data;
        //FXCollections.observableArrayList(tournamentList.getTournamentArr());
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < tournamentList.getTournamentArr().size(); i++) {
            data.add(tournamentList.getTournamentArr().get(i).getTournamentName());
         }
       listPanel.setItems(FXCollections.observableArrayList(data));
    }
    
    @FXML
    void handleLoadButton(ActionEvent event) {
        loadTournaments();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {
        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/Navigation.FXML"));
        Parent root = login.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        Navigation navController = login.getController();
        navController.setPlayerList(playerList);
        navController.setPlayer(player);
        navController.setReturn();
        // navController.handleWindowAction(player.getUsername(), player.getPassword());

        //Load new scene into window
        Scene navScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(navScene);
        window.show();
    }
    
    @FXML
    void handleViewButton(ActionEvent event) throws IOException {
        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/ViewTournament.FXML"));
        Parent root = login.load();
        
        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        ViewTournament navController = login.getController();
        //navController.setPlayerList(playerList);
        //navController.setPlayer(player);
       // navController.setReturn();
        // navController.handleWindowAction(player.getUsername(), player.getPassword());

        //Load new scene into window
        Scene navScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(navScene);
        window.show();
    }

    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }
}
