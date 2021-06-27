/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import model.*;
import view.*;
import java.awt.event.ActionListener;


/**
 *
 * @author tomia
 */
public class Registration implements ActionListener
{
    private Player newUser;
    private View view;
    private RegistrationUI registrationUI;
    
    
    public Registration()
    {
        registrationUI = new RegistrationUI();
        newUser = new Player();
        registrationUI.confirmationButton.addActionListener(this);
    }
    
    
    public void actionPerformed(ActionEvent b)
    {
        
        //action == registrationUI.getConfirmationButton()
    }
    
    
    
    //Validates if all input fields are filled or valid
    public boolean validate()
    {
        boolean isValid = false;
        
        
        
        
        
        return true;
    }
    
    
    public void register()
    {
        
    }
    
    public void updateRegistrationUI()
    {
        
    }
    
}
