/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Yaroslav 'Yasic' Naumenko
 */
public class MessageList {
    
    private ArrayList<Message> messageArr;
    
    public MessageList() {
        messageArr = new ArrayList<>();
        loadArr();
    }

    public MessageList(ArrayList<Message> messageArr) {
        this.messageArr = messageArr;
    }
    
    public void loadArr() {
        Message m1 = new Message("Vincent", "Yasic", "First message", "Hey, this is the first massage");
        Message m2 = new Message("Vincent", "Yasic", "Typo", "I had a typo in the last message, it should read 'message' not 'massage'");
        Message m3 = new Message("Vincent", "Peggy", "Reply", "Got it.");
        Message m4 = new Message("Vincent", "Peggy", "Message 2", "Hey look, its a message.");
        Message m5 = new Message("Tomi", "Peggy", "Title for message 3", "And another one. This one came from another user");
        

        messageArr.add(m1);
        messageArr.add(m2);
        messageArr.add(m3);
        messageArr.add(m4);
        messageArr.add(m5);
}

    public ArrayList<Message> getMessageArr() {
        return messageArr;
    }

    public void setMessageArr(ArrayList<Message> messageArr) {
        this.messageArr = messageArr;
    }
}
