
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class Navigation implements ActionListener {
    
    private NavigationUI navigationUI;
    private View view;
    private PlayerList playerList;
    private Player user;
    
    
    public Navigation() {
        
        // Loads the list of all user accounts.
        playerList = new PlayerList();
        
        // Initiate the Navigation UI.
        navigationUI = new NavigationUI();
        
        // Hide the navigation portion of the UI so only the login portion
        // is visable.
        hideNavPortion();
        
        // Show the user the navigation page.
        navigationUI.setVisible(true);
        
        // Add all the action listeners to the buttons from the UI
        navigationUI.loginButton.addActionListener(this);
        navigationUI.registerButton.addActionListener(this);
        navigationUI.navButton1.addActionListener(this);
        navigationUI.navButton2.addActionListener(this);
        navigationUI.navButton3.addActionListener(this);
        navigationUI.navButton4.addActionListener(this);
    }
    
    /**
    * This method does all the actions for the various buttons on the
    * navigation page UI.
    * 
    * @param e the button action picked up by the program.
    */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object action = e.getSource();
        
        if (action == navigationUI.loginButton) {
            if (validateAccountInfo()) {
                // Hide the login portion and show the navigation portion
                showNavPortion();
                hideLoginPortion(); 
            }
            else {
                // Display the message letting the user know they incorrectly
                // entered in the username and password.
                navigationUI.getErrorLabel1().setVisible(true);
                navigationUI.getErrorLabel2().setVisible(true);
            }
        }
        
        
    }
    
    /**
    * This method hides the navigation buttons from the UI. This also hides the
    * error message in case they are visible. 
    */
    private void hideNavPortion() {
        navigationUI.navButton1.setVisible(false);
        navigationUI.navButton2.setVisible(false);
        navigationUI.navButton3.setVisible(false);
        navigationUI.navButton4.setVisible(false);
        navigationUI.getErrorLabel1().setVisible(false);
        navigationUI.getErrorLabel2().setVisible(false);
    }
    
    /**
    * This method shows the navigation buttons from the UI and updates the 
    * title text to reflect this.
    */
    private void showNavPortion() {
        navigationUI.navButton1.setVisible(true);
        navigationUI.navButton2.setVisible(true);
        navigationUI.navButton3.setVisible(true);
        navigationUI.navButton4.setVisible(true);
        
        // If the user is set, display the user name. Note the user should 
        // always be defined here so if the follow if clause is not executed, 
        // something went wrong. Including the check anyways just to avoid 
        // a null pointer exception. 
        navigationUI.getTitleLabel().setText("Welcome " + user.getDisplayName() + "."); 
    }
    
    /**
    * This method hides fields to enter the username and password, as well
    * as hiding the error message in case they are visible. 
    */
    private void hideLoginPortion() {
        navigationUI.loginButton.setVisible(false);
        navigationUI.registerButton.setVisible(false);
        navigationUI.getErrorLabel1().setVisible(false);
        navigationUI.getErrorLabel2().setVisible(false);
        navigationUI.getUserNameField().setVisible(false);
        navigationUI.getUserNameLabel().setVisible(false);
        navigationUI.getPasswordField().setVisible(false);
        navigationUI.getPassLabel().setVisible(false);
    }
    
    /**
    * This method checks if the username and password are valid.
    * 
    * @return true if they match the records, false otherwise.
    */
    private boolean validateAccountInfo() {
        boolean isValid = false;
        
        // Grab the data the user input ...
        String userName = navigationUI.getUserNameField().getText();
        String password = navigationUI.getPasswordField().getText();
        
        // Grab the list of all username/password combinations ...
        HashMap<String, String> loginInfoHash = playerList.loginInfoHash();
        
        // ... and compare if the entered ones match any set
        if (loginInfoHash.containsKey(userName)) {
            if (loginInfoHash.get(userName).equals(password)) {
                isValid = true;
                
                // The following bit runs through the entire list of players
                // in playerList and as soon as it find the player object whose
                // name matches userName, it sets this object in an attribute
                // so we can call upon it to reference or update the user
                // from this moment forward.                 
                for (int i = 0; i < playerList.getPlayerArr().size(); i++) {
                    
                    if (playerList.getPlayerArr().get(i).getUsername().equals(userName)) {
                        user = playerList.getPlayerArr().get(i);
                    }
                }
            } 
        }
        
        return isValid;
        
    }
    
}