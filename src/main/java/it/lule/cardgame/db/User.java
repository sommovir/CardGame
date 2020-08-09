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
public class User {
    private String nickName;
    private String password;
    private int coin;

    public User(String nickName, String password, int coin) {
        this.nickName = nickName;
        this.password = password;
        this.coin = coin;
    }

    public User() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
    
    
    
}
