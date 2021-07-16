/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import model.*;

/**
 *
 * @author alexamcinvaille
 */
public class EditAccount {

    private DataManagement dataManagement;
    private Player player;
    
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
        //playerList = new PlayerList();
        usernameEdit.setText(player.getUsername());
        // So I am editin out the hidden password because when we save chanes, it saves
        // your password to be a set of asterisks instead of keeping it as it was.
        //passwordEdit.setText(player.getHiddenPassword());
        passwordEdit.setText(player.getPassword());
        displayNameEdit.setText(player.getDisplayName());
        zipCodeEdit.setText(player.getZipCode());
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
            editPlayerList(usernameEdit.getText(), passwordEdit.getText(), displayNameEdit.getText(), zipCodeEdit.getText());
            player.setUsername(usernameEdit.getText());
            player.setPassword(passwordEdit.getText());
            player.setDisplayName(displayNameEdit.getText());
            player.setZipCode(zipCodeEdit.getText());
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

    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }
}
