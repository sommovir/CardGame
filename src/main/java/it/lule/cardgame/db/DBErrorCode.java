/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.db;

/**
 *
 * @author lele
 */
public enum DBErrorCode {
        USER_NOT_EXISTS(1),
        USER_ALREADY_CONNECTED(2),
        WRONG_PASSWORD(3);
        
        private int code;

    private DBErrorCode(int code) {
        this.code = code;
    }
        
    public int getCode(){
        return code;
    }
}
