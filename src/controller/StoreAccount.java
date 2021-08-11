/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Manager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Player;
import model.PlayerList;
import java.io.IOException;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author vincenttse
 */
public class StoreAccount implements Initializable {

    private DataManagement dataManagement;
    private Player player;
    private PlayerList playerList;

    @FXML
    private AnchorPane storeAccountPane;

    @FXML
    private GridPane infoPane;
    @FXML
    private GridPane editPane;
    @FXML
    private Button backButton;
    @FXML
    private Button createButton;
    @FXML
    private Button editTournament;
    @FXML
    private Text storeAddressText;

    @FXML
    private Text storeNameText;

    @FXML
    private Text storeZipCodeText;

    @FXML
    private Text storePlayerCapacityText;

    @FXML
    private TextField editNameField;

    @FXML
    private TextField editAddressField;

    @FXML
    private TextField editZipCodeField;

    @FXML
    private TextField editPlayerCapacityField;

    public StoreAccount() {

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
    public void loadStore() {
        Manager currentManager = ((Manager) player);
        storeNameText.setText(currentManager.getStore().getName());
        storeAddressText.setText(currentManager.getStore().getAddress());
        storeZipCodeText.setText(currentManager.getStore().getZipCode());
        storePlayerCapacityText.setText(String.valueOf(currentManager.getStore().getPlayerCapacity()));
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

        //Load new scene into window
        Scene navScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(navScene);
        window.show();
    }

    @FXML
    void handleCreateButton(ActionEvent event) throws IOException {
        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/CreateTournament.FXML"));
        Parent root = login.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        CreateTournament navController = login.getController();
        navController.setDataManagement(dataManagement);
        navController.setPlayer(player);

        //Load new scene into window
        Scene navScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(navScene);
        window.show();
    }

    @FXML
    void handleEditButton(ActionEvent event) {
        infoPane.setVisible(false);
        editPane.setVisible(true);
    }

    @FXML
    void handleSaveAction(ActionEvent event) {
        Manager currentManager = ((Manager) player);
        currentManager.getStore().setName(editNameField.getText());
        currentManager.getStore().setAddress(editAddressField.getText());
        currentManager.getStore().setZipCode(editZipCodeField.getText());
        currentManager.getStore().setPlayerCapacity(Integer.parseInt(editPlayerCapacityField.getText()));
        loadStore();
        infoPane.setVisible(true);
        editPane.setVisible(false);
    }

    @FXML
    void handleCancelAction(ActionEvent event) {
        infoPane.setVisible(true);
        editPane.setVisible(false);
    }

    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }
}
