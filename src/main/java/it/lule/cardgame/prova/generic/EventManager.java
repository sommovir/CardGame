/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.generic;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lele
 */
public class EventManager {
    private static EventManager instance = null;
    private List < ConnectionEvent > connectionEvents = new LinkedList<>();
    
    private EventManager() {

    }
    
    public static EventManager getInstance(){
        if ( instance == null  ){
            instance = new EventManager();
        }
        return instance;
    }

    public void addConnectionEvents(ConnectionEvent connectionEvent) {
        this.connectionEvents.add(connectionEvent);
    }
    
    public void userConnected(String nickName){
        for (ConnectionEvent connectionEvent : connectionEvents) {
            connectionEvent.userConnected(nickName);
        }
    }
    
    public void ackReceided(int error){
        for (ConnectionEvent connectionEvent : connectionEvents) {
            connectionEvent.ackReceided(error);
        }
    }
}
