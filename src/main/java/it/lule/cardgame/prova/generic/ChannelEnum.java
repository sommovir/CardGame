/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.generic;

/**
 *
 * @author lele
 */
public enum ChannelEnum {
    ALL_CONNECTED("AllConnected"),
    FIRST_CONNECTION("firstConnection");
    
    private String user;

    private ChannelEnum(String user) {
        this.user = user;
    }
    
    public String getChannelEnum(){
        return user;
    }
}
