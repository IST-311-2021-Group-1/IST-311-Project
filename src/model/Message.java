/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Yaroslav 'Yasic' Naumenko
 */
public class Message implements Serializable {
    
    private String sender;
    private String recipient;
    private String title;
    private String text;
    private LocalDateTime time;
    private boolean isRead;

    // Full Constructor
    public Message(String sender, String recipient, String title, String text, LocalDateTime time, boolean isRead) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.text = text;
        this.time = time;
        this.isRead = isRead;
    }
    
    // Constructor without isRead or time
    public Message(String sender, String recipient, String title, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.text = text;
        this.time = LocalDateTime.now();
        this.isRead = false;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "Message{" + "sender=" + sender + ", recipient=" + recipient + ", title=" + title + ", text=" + text + ", time=" + time + ", isRead=" + isRead + '}';
    }

}
