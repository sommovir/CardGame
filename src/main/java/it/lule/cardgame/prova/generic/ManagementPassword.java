/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.prova.generic;

import it.lule.cardgame.prova.errorcode.ErrorCode;
import java.util.Arrays;

/**
 * !!!!!!!!!!!!LEGGIMI!!!!!!!!!!!! Consiglieri di mettere questa classe come
 * libreria sia sul client che sul server per avere un doppio controllo
 * Valutiamo l'idea di renderlo statico per fare una cosa cosi
 * ManagementPassword.checkPasswordRegistration(.....)
 *
 * @author lele
 */
public class ManagementPassword {

    private int passwordLeng = 1;
    private String nickName;
    private char[] jPasswordField1;
    private char[] jPasswordField2;

    /**
     * Create new user
     * @param nickName
     * @param jPasswordField1
     * @param jPasswordField2 
     */
    public ManagementPassword(String nickName, char[] jPasswordField1, char[] jPasswordField2) {
        this.nickName = nickName;
        this.jPasswordField1 = jPasswordField1;
        this.jPasswordField2 = jPasswordField2;
    }

    /**
     * Check login password
     * @param nickName
     * @param jPasswordField1 
     */
    public ManagementPassword(String nickName, char[] jPasswordField1) {
        this.nickName = nickName;
        this.jPasswordField1 = jPasswordField1;
        // Unused !!!!!
        jPasswordField2 = new char[-1];
    }

    public ManagementPassword() {
    }

    /**
     * Check Password Registration
     * @return int
     */
    public int checkPasswordRegistration() {
        int value;
        
        value = isEmpty();
        if (value != -1) {
            return value;
        }

        value = isUpperCase();
        if (value != -1) {
            return value;
        }

        return value;        
    }
    
    /**
     * Check Password Registration
     * @return int
     */
    public int checkPasswordlogin() {
        int value;

        value = isEmpty();
        if (value != -1) {
            return value;
        }

        value = isLength();
        if (value != -1) {
            return value;
        }

        value = isEqual();
        if (value != -1) {
            return value;
        }

        value = isUpperCase();
        if (value != -1) {
            return value;
        }

        return value;
    }
    
    /**
     * Password or User are empty
     * @return int
     */
    private int isEmpty() {
        if ( nickName.isEmpty() || jPasswordField1.length == 0
                || jPasswordField2.length == 0 ) {
            return ErrorCode.PASSWORD_IS_EMPTY.getCode();
        }
        return -1;
    }

    /**
     * Password is length
     * @return int
     */
    private int isLength() {
        if (jPasswordField1.length <= passwordLeng) {
            return ErrorCode.PASSWORD_IS_LENGTH.getCode();
        }
        return -1;
    }

    /**
     * Password is equal
     * @return int
     */
    private int isEqual() {
        if (!Arrays.equals(jPasswordField1, jPasswordField2)) {
            return ErrorCode.PASSWORD_IS_EQUAL.getCode();
        }
        return -1;
    }

    /**
     * Password is Upper Case
     * @return int
     */
    private int isUpperCase() {
        if (isUpperCase(jPasswordField1) == false) {
            return ErrorCode.PASSWORD_IS_UPPER_CASE.getCode();
        }
        return -1;
    }

    private boolean isUpperCase(char[] jPasswordField1) {
        for (int i = 0; i < jPasswordField1.length; i++) {
            if (Character.isUpperCase(jPasswordField1[i])) {
                return true;
            }
        }
        return false;
    }

}
