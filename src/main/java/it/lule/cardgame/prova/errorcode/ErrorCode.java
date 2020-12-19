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
   
    public enum ErrorCode {
        DB_USER_NOT_EXISTS(1),
        DB_USER_ALREADY_CONNECTED(2),
        DB_WRONG_PASSWORD(3),
        DB_USER_ALREADY_EXISTS(4),
        
        PASSWORD_DO_NOT_MATCH(5),
        PASSWORD_IS_EMPTY(6),
        PASSWORD_IS_LENGTH(7),
        PASSWORD_IS_EQUAL(8),
        PASSWORD_IS_UPPER_CASE(9);
        
        private int code;

        private ErrorCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }



