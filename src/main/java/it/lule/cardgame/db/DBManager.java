/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.lule.cardgame.db;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lele
 */
public class DBManager {
    private static DBManager _instance = null;
    
    private Map < String, User > userMap = new HashMap<>();
    private Map < String, User > onlineMap = new HashMap<>();
    
    public static DBManager getInstance() {
        if (_instance == null) {
            _instance = new DBManager();
            return _instance;
        } else {
            return _instance;
        }
    }

    private DBManager() {
        super();
        loadFakeUser();
    }
    
    public User login( String nickname, String password) throws DBException{
        if ( !userMap.containsKey(nickname)){
            throw new DBException(DBErrorCode.USER_NOT_EXISTS);
        }

        if ( !onlineMap.containsKey(nickname)){
            throw new DBException(DBErrorCode.USER_ALREADY_CONNECTED);
        }
        
        if ( userMap.containsKey(nickname) && 
                !userMap.get(nickname).getPassword().equals(password)){
            throw new DBException(DBErrorCode.WRONG_PASSWORD);
        }
        
        onlineMap.put(nickname, userMap.get(nickname));
        
        return userMap.get(nickname);

    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public Map<String, User> getOnlineMap() {
        return onlineMap;
    }

    @Deprecated
    private void loadFakeUser(){
        userMap.put("Paolino", new User("Paolino", "0001", 1));
        userMap.put("Lele", new User("Lele", "0002", 2));
        userMap.put("Luca", new User("Luca", "0003", 3));
        userMap.put("Luana", new User("Luana", "0004", 4));
        userMap.put("Monica", new User("Monica", "0005", 5));
    }
    
}

