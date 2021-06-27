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
        
        // Show the registration window
        registrationUI.setVisible(true);
        
        // Add all the action listeners to the buttons from the UI
        registrationUI.confirmationButton.addActionListener(this);
        
        // The followin is used for testing purposes ******************** REMOVE ***************** 
        System.out.println("B1 The number of users is " + this.playerList.getPlayerArr().size());
        
        //registrationUI.getPassErrorLabel().setVisible(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object action = e.getSource();
        
        //need to fix register() and validate() methods
        if(action == registrationUI.confirmationButton)
        {
            register();
        }
    }
    
    //Validates if all input fields are filled or valid
    //Method is WIP, cannot get validation
    private boolean validate()
    {
        boolean isValid = true;
        
        String password = newUser.getPassword();
        String confirmPassword = registrationUI.getPasswordField().getText();
        
        //checking to see if password matches
        //implement authentication for username and display name in next sprint
        
        
        do{
            if(password.equals(confirmPassword)){
                isValid = true;
            }
            
            else{
                isValid = false;
                registrationUI.getPassErrorLabel().setVisible(true);
            }
        }while(!(isValid));
        
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
        
        // The followin is used for testing purposes ******************** REMOVE ***************** 
        System.out.println("B2 The number of users is " + this.playerList.getPlayerArr().size());
    }

    private void hideErrorMessages() {
        
    }
}
