/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import model.*;
import view.*;
//import java.util.HashMap;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tomia
 */
public class Registration implements ActionListener
{
    private Player newUser;
    private View view;
    private RegistrationUI registrationUI;
    private PlayerList playerList;
    
    public Registration(PlayerList playerList)
    {
        // get the list all all players passed to it from navigation
        // and load it into the attribute
        this.playerList = playerList;
        
        // load the registration UI
        registrationUI = new RegistrationUI();
        
        // Hide all the error messages
        hideErrorMessages();
        
        // Hide the done button
        registrationUI.doneButton.setVisible(false);
        
        // Show the registration window
        registrationUI.setVisible(true);
        
        // Add all the action listeners to the buttons from the UI
        registrationUI.confirmationButton.addActionListener(this);
        registrationUI.doneButton.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object action = e.getSource();
        
        //need to fix register() and validate() methods
        if(action == registrationUI.confirmationButton)
        {
            if (validate()) {
                register();
                hideAllButDone();
            }
        }
        
        if(action == registrationUI.doneButton)
        {
            // close the window
            registrationUI.setVisible(false); 
            registrationUI.dispose(); 
        }
        

    }
    
    //Validates if all input fields are filled or valid
    //Method is WIP, cannot get validation
    private boolean validate()
    {
        boolean isValid = true;
        
        // Refresh all error messages to hidden before checking them
        hideErrorMessages();
        
        String username = registrationUI.getUserNameField().getText();
        String password = registrationUI.getPasswordField().getText();
        String confirmPassword = registrationUI.getConfirmPassField().getText();
        String displayName = registrationUI.getDisplayNameField().getText();
        String zipCode = registrationUI.getZipCodeField().getText();
        
        // Run a check for all errors.
        if (! password.equals(confirmPassword)) {
            registrationUI.getPassErrorLabel().setVisible(true);
            isValid = false;
        }
        
        // Run a check if the username already exists
        if (playerList.usernamesArr().contains(username)) {
            registrationUI.getUserErrorLabel().setVisible(true);
            isValid = false;
        }
        
        // Run a check if the display name already exists
        if (playerList.usernamesArr().contains(displayName)) {
            registrationUI.getDisplayErrorLabel().setVisible(true);
            isValid = false;
        }
        
        // Run a check to see if the fields are empty
        if (username.equals("") || password.equals("") || confirmPassword.equals("") || displayName.equals("") || zipCode.equals("")) {
            registrationUI.getEmptyErrorLabel().setVisible(true);
            isValid = false;
        }
        
        return isValid;
    }
    
    //adds a new user to the player list
    public void register()
    {
        // Get the text from the entry fields
        String username = registrationUI.getUserNameField().getText();
        String password = registrationUI.getPasswordField().getText();
        String displayName = registrationUI.getDisplayNameField().getText();
        String zipCode = registrationUI.getZipCodeField().getText();
        
        // Make the new user object with the given data
        newUser = new Player(username, password, displayName, zipCode);
        
        // And add that object to the list of all players.
        playerList.getPlayerArr().add(newUser);
    }

    private void hideErrorMessages() {
        registrationUI.getPassErrorLabel().setVisible(false);
        registrationUI.getUserErrorLabel().setVisible(false);
        registrationUI.getDisplayErrorLabel().setVisible(false);
        registrationUI.getEmptyErrorLabel().setVisible(false);
    }
    
    private void hideAllButDone() {
        // Hide Everything except the Done Button.
        registrationUI.doneButton.setVisible(true);
        registrationUI.confirmationButton.setVisible(false);
        
        hideErrorMessages();
        
        // Display a confirmation message
        registrationUI.getTitleLabel().setText("Your account has been created!");
        
        registrationUI.getUserNameField().setVisible(false);
        registrationUI.getPasswordField().setVisible(false);
        registrationUI.getConfirmPassField().setVisible(false);
        registrationUI.getDisplayNameField().setVisible(false);
        registrationUI.getZipCodeField().setVisible(false);
        
        registrationUI.getUserLabel().setVisible(false);
        registrationUI.getPassLabel().setVisible(false);
        registrationUI.getConfirmPassLabel().setVisible(false);
        registrationUI.getDisplayNameLabel().setVisible(false);
        registrationUI.getZipLabel().setVisible(false);
    }
}
