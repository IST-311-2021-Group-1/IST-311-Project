/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.*;

/**
 * FXML Controller class
 *
 * @author vincenttse
 */
public class Account implements Initializable {

    private Player player;
    private Navigation loginData;
    @FXML
    private Button editAccountButton;
    @FXML
    private Text usernameField;
    @FXML
    private Text passwordField;
    @FXML
    private Text displayNameField;
    @FXML
    private Text zipCodeField;
    @FXML
    private Text hobbiesField;

    public Account() {
        //player = new Player();
        //loadPlayerData();
    }

//    Loads data for the player who is logged in
    @FXML
    public void loadPlayerData() {
        usernameField.setText(player.getUsername());
        passwordField.setText(player.getPassword());
        displayNameField.setText(player.getDisplayName());
        zipCodeField.setText(player.getZipCode());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        System.out.println("Testing setPlayer: " + player);
    }

}
