/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.*;

/**
 *
 * @author alexamcinvaille
 */
public class EditAccount {

    private DataManagement dataManagement;
    private Player player;
    private StoreList storeList;

    private Account account;

    @FXML
    private Button backButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField usernameEdit;
    @FXML
    private TextField passwordEdit;
    @FXML
    private TextField displayNameEdit;
    @FXML
    private TextField zipCodeEdit;
    @FXML
    private Label editAccountLabel;
    @FXML
    private AnchorPane editAnchorPanes;
    @FXML
    private AnchorPane editAccountInnerPane;
    @FXML
    private Label storeChoice;
    @FXML
    private Label storeLabel;

    public EditAccount() {

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    //Loads the data for the player logged in
    @FXML
    public void loadTextFields() {
        usernameEdit.setText(player.getUsername());
        passwordEdit.setText(player.getPassword());
        displayNameEdit.setText(player.getDisplayName());
        zipCodeEdit.setText(player.getZipCode());
        if (player instanceof Manager) {
            storeLabel.setVisible(true);
            storeChoice.setVisible(true);
            storeList = dataManagement.loadStoreChoices();          
            storeChoice.setText(((Manager)player).getStore().toString());


        }
    }

    @FXML
    void handleBackButton(ActionEvent event) throws IOException {

        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("../view/Account.FXML"));
        AnchorPane newPane = accountLoader.load();
        editAnchorPanes.getChildren().setAll(newPane);

        Account accountController = accountLoader.getController();
        accountController.setPlayer(player);
        accountController.setDataManagement(dataManagement);
        accountController.loadPlayerData();
    }

    @FXML
    void handleSaveButton(ActionEvent event) {
        if (usernameEdit.getText().isEmpty() || passwordEdit.getText().isEmpty()
                || displayNameEdit.getText().isEmpty() || zipCodeEdit.getText().isEmpty()) {
            editAccountLabel.setVisible(true);
            editAccountLabel.setText("Please fill in all fields");

        } else {
            editAccountLabel.setText("Saved!");
            player.setUsername(usernameEdit.getText());
            player.setPassword(passwordEdit.getText());
            player.setDisplayName(displayNameEdit.getText());
            player.setZipCode(zipCodeEdit.getText());

            if (player instanceof Manager) {
                editManagerList(usernameEdit.getText(), passwordEdit.getText(), displayNameEdit.getText(), zipCodeEdit.getText(), ((Manager)player).getStore());
//                ((Manager) player).setStore((Store) storeChoice.getValue());
//                ((Store)storeChoice.getValue()).setManager((Manager)player);

            } else {
                editPlayerList(usernameEdit.getText(), passwordEdit.getText(), displayNameEdit.getText(), zipCodeEdit.getText());

            }
        }
    }

    private void editPlayerList(String usersname, String password, String displayname, String zipcode) {
        PlayerList playerList = dataManagement.loadPlayers();
        Player currentPlayer = new Player(usersname, password, displayname, zipcode);
        HashMap<String, String> loginInfoHash = playerList.loginInfoHash();

        if (loginInfoHash.containsKey(player.getUsername())) {
            for (int i = 0; i < playerList.getPlayerArr().size(); i++) {
                if (playerList.getPlayerArr().get(i).getUsername().equals(player.getUsername())) {
                    //System.out.println(player);
                    player = currentPlayer;

                    playerList.getPlayerArr().set(i, currentPlayer);
                    dataManagement.savePlayers(playerList.getPlayerArr());
                    //System.out.println(player);
                }
            }
        }
    }

    private void editManagerList(String username, String password, String displayName, String zip, Store store) {
        PlayerList playerList = dataManagement.loadPlayers();
        Player currentManager = new Manager(username, password, displayName, zip, store);
        HashMap<String, String> loginInfoHash = playerList.loginInfoHash();

        if (loginInfoHash.containsKey(player.getUsername())) {
            for (int i = 0; i < playerList.getPlayerArr().size(); i++) {
                if (playerList.getPlayerArr().get(i).getUsername().equals(player.getUsername())) {
                    //System.out.println(player);
                    player = currentManager;

                    playerList.getPlayerArr().set(i, currentManager);
                    dataManagement.savePlayers(playerList.getPlayerArr());
                }
            }
        }
    }

    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }
}
