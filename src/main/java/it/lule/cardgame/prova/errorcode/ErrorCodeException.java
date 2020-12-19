/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.errorcode;

/**
 *
 * @author lele
 */
public class ErrorCodeException extends Exception{
    private ErrorCode errorCode;

    public ErrorCodeException(ErrorCode errorCode) {
        super("DBError: " + errorCode);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
    
}
