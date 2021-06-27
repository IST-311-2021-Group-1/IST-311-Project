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
//will implement this in next sprint
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
    private NavigationUI navigationUI;
    
    public Registration()
    {
        registrationUI = new RegistrationUI();
        registrationUI.confirmationButton.addActionListener(this);
        playerList = new PlayerList();
        
        registrationUI.setVisible(true);
        registrationUI.getPassErrorLabel().setVisible(false);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object action = e.getSource();
        
        //need to fix register() and validate() methods
        if(action == registrationUI.confirmationButton)
        {
                register();
                navigationUI.setVisible(true);
            //}
            
            //else{
                //validate();
                //
            //}
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
        playerList.addPlayer(newUser); 
        
        /*
        ArrayList<String> registerInfo = new ArrayList<>();
        String username = registrationUI.getUserNameField().getText();
        String password = registrationUI.getPasswordField().getText();
        String confirmPassword = registrationUI.getConfirmPassField().getText();
        String displayName = registrationUI.getDisplayNameField().getText();
        String zipCode = registrationUI.getZipCodeField().getText();
        
        registerInfo.add(username);
        registerInfo.add(password);
        registerInfo.add(displayName);
        registerInfo.add(zipCode); 
        */        
    }
}
