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
public class DBException extends Exception{
    private DBErrorCode code;

    public DBException(DBErrorCode code) {
        super("DBError: " + code);
        this.code = code;
    }

    public DBErrorCode getCode() {
        return code;
    }
    
}
