package controller;

/**
 * This class is the main controller for the login and navigation for the
 * Tournament App. This is the core of the app that is always loaded upon
 * turning it on.
 *
 * @author Yaroslav 'Yasic' Naumenko
 */
import model.*;
import view.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import java.net.URL;

public class Navigation {

    private String userName, passWord;
    private PlayerList playerList;
    private Player player;
    private Manager manager;
    private Registration registration;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Account account;
    @FXML
    private AnchorPane navigationPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private GridPane homePane;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    Text errorLabel;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Text storeText;
    @FXML
    private Text inboxText;
    @FXML
    private Text accountText;
    @FXML
    private Text tournamentText;
    @FXML
    private GridPane loginPane;
    @FXML
    private Button tournamentButton;
    @FXML
    private Button accountButton;
    @FXML
    private Button storeAccountButton;
    @FXML
    private Button inboxButton;
    @FXML
    private Pane newPaneCenter;

    public Navigation() {
        // Loads the list of all user accounts.
        playerList = new PlayerList();
    }

    @FXML
    void handleLoginAction(ActionEvent event) {
        boolean confirmLogin = validateAccountInfo(userNameTextField.getText(), passwordTextField.getText());
        boolean validateRole = player instanceof Manager;

        if (confirmLogin) {
            if (validateRole) {
                loginPane.setVisible(false);
                homePane.setVisible(true);
            } else {
                loginPane.setVisible(false);
                homePane.setVisible(true);
                storeAccountButton.setVisible(false);
            }
        } else {
            errorLabel.setText("Please try again");
        }
    }

    void handleWindowAction(String username, String password) {
        boolean confirmLogin = validateAccountInfo(username, password);
        boolean validateRole = player instanceof Manager;

        if (confirmLogin) {
            if (validateRole) {
                loginPane.setVisible(false);
                homePane.setVisible(true);
            } else {
                loginPane.setVisible(false);
                homePane.setVisible(true);
                storeAccountButton.setVisible(false);
            }
        } else {
            errorLabel.setText("Please try again");
        }
    }

    @FXML
    void handleRegisterAction(ActionEvent event) throws IOException {
        //Load Navigation.FXML 
        FXMLLoader login = new FXMLLoader(getClass().getResource("../view/Register.FXML"));
        Parent root = login.load();

        //Load Navigation.java to set current (registration) playerList into its (navigation) playerList 
        Registration navController = login.getController();
        navController.setPlayerList(playerList);

        //Load new scene into window
        Scene registrationScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registrationScene);
        window.show();
    }

    void setPlayerList(PlayerList newPlayerList) {
        this.playerList = newPlayerList;
    }

    void setPlayer(Player newPlayer) {
        this.player = newPlayer;
    }

    boolean validateAccountInfo(String username, String password) {
        boolean isValid = false;

        // Grab the data the user input ...
        userName = username;
        passWord = password;

        // Grab the list of all username/password combinations ...
        HashMap<String, String> loginInfoHash = playerList.loginInfoHash();

        // ... and compare if the entered ones match any set
        if (loginInfoHash.containsKey(userName)) {
            if (loginInfoHash.get(userName).equals(passWord)) {
                isValid = true;

                // The following bit runs through the entire list of players
                // in playerList and as soon as it find the player object whose
                // name matches userName, it sets this object in an attribute
                // so we can call upon it to reference or update the user
                // from this moment forward.                 
                for (int i = 0; i < playerList.getPlayerArr().size(); i++) {

                    if (playerList.getPlayerArr().get(i).getUsername().equals(userName)) {
                        player = playerList.getPlayerArr().get(i);
                    }
                }
            }
        }

        return isValid;

    }

    @FXML
    void handleAccountAction(ActionEvent event) throws IOException {
        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("../view/Account.FXML"));
        Parent root = accountLoader.load();
        Account accountController = accountLoader.getController();
        accountController.setPlayerList(playerList);
        accountController.setPlayer(player);
        accountController.loadPlayerData();
        Scene registrationScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(registrationScene);
        window.show();
    }

    @FXML
    void handleInboxAction(ActionEvent event) throws IOException {
        FXMLLoader inboxLoader = new FXMLLoader(getClass().getResource("../view/Inbox.FXML"));
        Parent root = inboxLoader.load();
        Inbox inboxController = inboxLoader.getController();
        inboxController.setPlayerList(playerList);
        inboxController.setPlayer(player);
        Scene inboxScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(inboxScene);
        window.show();
    }

    @FXML
    void handleStoreAccountAction(ActionEvent event) throws IOException {
        FXMLLoader storeAccountLoader = new FXMLLoader(getClass().getResource("../view/StoreAccount.FXML"));
        Parent root = storeAccountLoader.load();
        StoreAccount storeAccountController = storeAccountLoader.getController();
        storeAccountController.setPlayerList(playerList);
        storeAccountController.setPlayer(player);
        Scene storeAccountScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(storeAccountScene);
        window.show();
    }

    @FXML
    void handleTournamentAction(ActionEvent event) throws IOException {
        FXMLLoader tournamentLoader = new FXMLLoader(getClass().getResource("../view/Tournament.FXML"));
        Parent root = tournamentLoader.load();
        Tournament tournamentController = tournamentLoader.getController();
        tournamentController.setPlayerList(playerList);
        tournamentController.setPlayer(player);
        Scene tournamentScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tournamentScene);
        window.show();
    }

}
