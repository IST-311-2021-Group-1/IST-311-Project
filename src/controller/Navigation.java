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

public class Navigation {

    private String userName, passWord;
    private PlayerList playerList;
    private Player player;
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
    private BorderPane homePane;
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
        boolean confirmLogin = validateAccountInfo();
        if (confirmLogin) {
            loginPane.setVisible(false);
            homePane.setVisible(true);
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

    private boolean validateAccountInfo() {
        boolean isValid = false;

        // Grab the data the user input ...
        userName = userNameTextField.getText();
        passWord = passwordTextField.getText();

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
        homePane.setCenter(accountLoader.load());
        account = accountLoader.getController();
        homePane.setMaxSize(50, 50);
        account.setPlayer(player);
        account.loadPlayerData();
    }

    @FXML
    void handleInboxAction(ActionEvent event) throws IOException {
        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("../view/Inbox.FXML"));
        homePane.setCenter(accountLoader.load());
    }

    @FXML
    void handleStoreAccountAction(ActionEvent event) throws IOException {
        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("../view/StoreAccount.FXML"));
        homePane.setCenter(accountLoader.load());
    }

    @FXML
    void handleTournamentAction(ActionEvent event) throws IOException {
        FXMLLoader accountLoader = new FXMLLoader(getClass().getResource("../view/Tournament.FXML"));
        homePane.setCenter(accountLoader.load());
    }

    //Added these methods to pass to Account screen in order to tell which player is logged in
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
