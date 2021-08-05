/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

/**
 * FXML Controller class
 *
 * @author vincenttse
 */
public class Inbox implements Initializable {

    private DataManagement dataManagement;
    private Player player;
    
    private ArrayList<Message> messageDisplayList;
    private Message messageToRead;
    
    private PlayerList playerList;    

    @FXML
    private Pane inboxPane;

    @FXML
    private Pane readPane;
        
    @FXML
    private Pane writePane;
    
    @FXML
    private TextField writeTo;

    @FXML
    private TextField writeTitle;

    @FXML
    private TextArea writeMessage;

    @FXML
    private Button sendButton;
    
    @FXML
    private Text statusMessage;
    
    @FXML
    private Text readTitle;

    @FXML
    private Text readSender;

    @FXML
    private Text readDate;

    @FXML
    private Text readMessage;
    
    @FXML
    private Button backButton;

    @FXML
    private ListView<String> listPanel;

    @FXML
    private ScrollBar scrollBar;

    @FXML
    private Button refreshButton;

    @FXML
    private Button readButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        navController.setDataManagement(dataManagement);
        navController.setPlayer(player);
        navController.setReturn();
        //navController.handleWindowAction(player.getUsername(), player.getPassword());

        //Load new scene into window
        Scene navScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(navScene);
        window.show();
    }
    
    @FXML
    void handleSendButton(ActionEvent event) {      
        boolean doWrite = true;
        
        // Check to make sure all fields are filled in
        if ((writeTo.getText().isEmpty()) || (writeTitle.getText().isEmpty()) || (writeMessage.getText().isEmpty())) {
            statusMessage.setText("You must fill in all fields.");
            doWrite = false;
        }
        
        // Check to make sure the recipient exists
        if (!validateRecipient(writeTo.getText())) {
            statusMessage.setText("The person you are trying to send the message to does not exist.");
            doWrite = false;
        }
        
        if (doWrite) {
            Message messageToAdd = new Message(player.getDisplayName(), writeTo.getText(), writeTitle.getText(), writeMessage.getText());
            MessageList allMessages = dataManagement.loadMessages();
            allMessages.getMessageArr().add(messageToAdd);
            dataManagement.saveMessages(allMessages.getMessageArr());
            statusMessage.setText("The message has been sent.");
            sendButton.setVisible(false);
        }
    
    }

    private boolean validateRecipient(String nameToTest) {
        // Create a list of all display names.
        ArrayList<String> allNames = new ArrayList<>();
        PlayerList allUsers = dataManagement.loadPlayers();
        for (Player currentPlayer : allUsers.getPlayerArr()) {
            allNames.add(currentPlayer.getDisplayName());
        }
        
        // return true if the name given to the method is on the list
        return allNames.contains(nameToTest);
    }
    
    @FXML
    void handleWriteButton(ActionEvent event) {
        setWritePane();
    }
    
    @FXML
    void handleReadButton(ActionEvent event) {
        // get the index of the selected message
        ObservableList selectedIndexList = listPanel.getSelectionModel().getSelectedIndices();
        
        // So long as the index is selected, set the message to read based
        // off the index.
        if (!selectedIndexList.isEmpty()) {
            int selectedIndex = (int)selectedIndexList.get(0);
            messageToRead = messageDisplayList.get(selectedIndex);
            
            setReadPane();
            readTitle.setText(messageToRead.getTitle());
            readSender.setText(messageToRead.getSender());
            readDate.setText(messageToRead.getTime().format(DateTimeFormatter.ISO_DATE));
            readMessage.setText(messageToRead.getText());
            
        }
        else {
            System.out.println("You must select a message to read.");
        }
        // System.out.println("The selected index is " + selectedIndex);
    }

    @FXML
    void handleRefreshButton(ActionEvent event) {
        refreshList();
    }
    
    @FXML
    void handleBackToIndex(ActionEvent event) {
        setInboxPane();
    }
    
    public void refreshList() {
        // We will create an array of all messages with the user as a recepient. 
        messageDisplayList = new ArrayList<>();
        
        // We get the list of all messages as well as the users display name.
        MessageList allMessages = dataManagement.loadMessages();
        String desiredRecipient = player.getDisplayName();
        
        // Then we loop throug the list of all messages, saving the ones whose
        // recipient matches the display name of the user
        for (Message currentMessage : allMessages.getMessageArr()) {
            if (currentMessage.getRecipient().equals(desiredRecipient)) {
                messageDisplayList.add(currentMessage);
            }
        }
        
        // Now add the titles of these messages to an arrayList of strings.
        ArrayList<String> titles = new ArrayList<>();
        for (Message currentMessage : messageDisplayList) {
            titles.add(currentMessage.getTitle());
        }
        
        // Add the titles to the list view.
        listPanel.setItems(FXCollections.observableArrayList(titles));
    }
    
    public void setInboxPane() {
        inboxPane.setVisible(true);
        readPane.setVisible(false);
        writePane.setVisible(false);
        refreshList();
    }
    
    public void setReadPane() {
        inboxPane.setVisible(false);
        readPane.setVisible(true);
        writePane.setVisible(false);
    }
    
    public void setWritePane() {
        inboxPane.setVisible(false);
        readPane.setVisible(false);
        writePane.setVisible(true);
    }

    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }


}
